package com.it.pkj.infrastructure.alipay;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
@Configuration
@Data
public class AlipayConfig {

  // ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

  // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账 号
  @Value("${alipay.appId}")
  private String app_id;

  // 商户私钥，您的PKCS8格式RSA2私钥
  @Value("${alipay.appPrivateKey}")
  private String merchant_private_key;

  // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
  @Value("${alipay.alipayPublicKey}")
  private String alipay_public_key;

  // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
  @Value("${alipay.notifyUrl}")
  private String notify_url;

  // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
  @Value("${alipay.returnUrl}")
  private String return_url;

  // 签名方式
  @Value("${alipay.sign_type}")
  private String sign_type;

  // 字符编码格式
  @Value("${alipay.charset}")
  private String charset;

  // 支付宝网关
  @Value("${alipay.gatewayUrl}")
  private String gatewayUrl;

  // 支付宝网关
  @Value("${alipay.log_path}")
  private String log_path;

}
