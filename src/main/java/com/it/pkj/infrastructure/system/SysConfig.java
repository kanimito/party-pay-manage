package com.it.pkj.infrastructure.system;

import com.it.pkj.utils.JwtUtil;
import com.it.study.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;


/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: SSM-doctor @BelongsPackage:
 * com.it.study.infrastructure.system @Author: kanimito @CreateTime: 2024-08-13 11:50 @Description:
 * TODO @Version: 1.0
 */
@Configuration
public class SysConfig {
  @Value("${jwt.secret}")
  private String secret;

//  @Value("${jedis.host}")
//  private String host;
//
//  @Value("${jedis.port}")
//  private String port;

//  @Autowired
//  private JedisPool jedisPool;

  @Bean
  public JwtUtil jwtUtil() {
    return new JwtUtil(secret);
  }

  //    public WebConfig webConfig;

  /** 装配Redis操作工具 */
  @Bean
  public JedisUtil jedisUtil() {
    //        System.out.println(this.host);
    return new JedisUtil(this.host, Integer.parseInt(this.port), jedisPool);
  }

  //    @Bean
  //    public WebConfig webConfig(){
  //        return new WebConfig();
  //    }
}
