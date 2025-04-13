package com.it.pkj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.pkj.domain.SystemUser;
import com.it.pkj.service.SystemUserService;
import com.it.pkj.mapper.SystemUserMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【system_user】的数据库操作Service实现
* @createDate 2025-03-23 17:10:41
*/
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
    implements SystemUserService{

}




