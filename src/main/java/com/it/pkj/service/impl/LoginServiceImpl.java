package com.it.pkj.service.impl;

import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.pkj.common.CodeEnum;
import com.it.pkj.common.exception.BusinessException;
import com.it.pkj.common.vo.SysUserVo;
import com.it.pkj.domain.SystemUser;
import com.it.pkj.mapper.SystemUserMapper;
import com.it.pkj.service.LoginService;
import com.it.pkj.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: partyPayManage
 * @BelongsPackage: com.it.pkj.service.impl
 * @Author: kanimito
 * @CreateTime: 2025-03-22  21:48
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class LoginServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements LoginService {
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    // 注入redis
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    // 注入jwt
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private SystemUserMapper systemUserDao;
    /**
     * 登录
     * @param userVo
     * @return
     */
    @Override
    public String login(SysUserVo userVo) {
        QueryWrapper<SystemUser> queryWrapper = new QueryWrapper<>();
        // 1. 检验是否存在该用户
        queryWrapper.eq("username", userVo.getUsername());
        List<SystemUser> userList = baseMapper.selectList(queryWrapper);
        if (userList == null || userList.size() == 0) {
            throw new BusinessException(CodeEnum.ValidateError, "用户不存在");
        }
        // 2. 校验密码是否正确
        SystemUser user = userList.get(0);


        if(!user.getPassword().equals(MD5.create().digestHex16(userVo.getPassword()))){
            throw new BusinessException(CodeEnum.ValidateError, "密码错误");
        }
        user.setLoggedIn(true);
        // 2. 生成jwt的token
        String tid = UUID.randomUUID().toString().replaceAll("-","");
        String token = jwtUtil.generateToken(tid, user);
        // 3. 保存token到redis中
        redisTemplate.opsForValue().set(tid,token);
        // 3.1 保存token到redis中，设置过期时间
        redisTemplate.expire(tid,30, TimeUnit.MINUTES);

        // 4. 返回token
        return token;
    }

    /**
     * 注册
     * @param userVo
     */
    @Override
    public void register(SysUserVo userVo) {
        QueryWrapper<SystemUser> queryWrapper = new QueryWrapper<>();
        // 1. 检验是否存在该用户
        queryWrapper.eq("username", userVo.getUsername());
        List<SystemUser> userList = baseMapper.selectList(queryWrapper);
        // 2. 存入数据库
        if (userList.size() > 0) {
            throw new BusinessException(CodeEnum.ValidateError, "用户已存在");
        }
        SystemUser user = new SystemUser();
        user.setUsername(userVo.getUsername());
        // 密码加密
        String mPassword = MD5.create().digestHex16(userVo.getPassword());
        user.setPassword(mPassword);
        // 类型
        user.setUserType(userVo.getUserType());
        baseMapper.insert(user);
    }

    @Override
    public void logout(String token) {
        try {
            // 从 Redis 中删除用户的 token 信息
            String redisKey = token;
            Boolean result = redisTemplate.delete(redisKey);
            if (result != null && result) {
                logger.info("Token {} 已从 Redis 中移除", token);
                // 根据 token 从 Redis 中获取用户 ID
                String userIdKey = token;
                Object userIdObj = redisTemplate.opsForValue().get(userIdKey);
                if (userIdObj != null) {
                    String userId = userIdObj.toString();
                    // 从 Redis 中删除 token 与用户 ID 的映射关系
                    redisTemplate.delete(userIdKey);
                    // 更新数据库中用户的登录状态
                    SystemUser user = systemUserDao.selectById(userId);
                    if (user != null) {
                        user.setLoggedIn(false);
                        systemUserDao.updateById(user);
                        logger.info("用户 {} 登出，数据库登录状态已更新", userId);
                    }
                }
            } else {
                logger.warn("Token {} 不存在于 Redis 中，无需移除", token);
            }
        } catch (Exception e) {
            logger.error("登出操作出现异常: ", e);
        }
    }

}
