package com.ctgu.ssm.utils;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092500593267";
	
	// 商户私钥，您的PKCS8格式RSA2私钥,官方有密钥生产工具,下载地址在下方
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC+VYkWSYcgpVsXD77R9xSob0cNuBb+9OB0JLR5otg07LwP940P1qk1AD5d17vieSIzeA75lqVXVT9lGIvEcOH0YNlxsMLNGfFnlOOMS64m0cSj2vnCE0S6dzx2+Ol47QBZaBs2sytooj+Mt6Gsff+1Ks0m1Gh0EJaaRpkL+yoQNTYyrsXhTkc2NWK0fx+HUe3PNHFfhCndYtpCtVLJJZHz4asH7tHV/4RF+hQuvrxAl71uBSA2/9oRt0j0K/WCygGzJVisG+8Ur2Xvw37+NkInGTlPOZKALbEuUOPjXO4XQQM3eh97hwY5r5D/ef4oA+t732L8rcf+kSv1EI/P2hEbAgMBAAECggEAfGlAwFazgv1S+1IJcwlEcYy7LxaDwYejJ4fOiCuPk5iinPU9OXshA0nzejfH0hNH7ciuUSrNTLamR5ix02fN6oVb3Nqjmpk4mHJUAqJ9ZVZ8aHZ8BwW9SP0jgsjVI3wXXFmWYDzhRPW5AGwPu8ZoXK1rh9QTqrolFxbKd3BnYEunEcu/6f3GHJ5IEHBSXaH8kEHy+zvMxwJKq4kXGkTs5Yjd4BjFsG8yjRmNwF8hcizWSAA9R6oupW9uUbxw2uctBSkPiR/STGDPj0m7+6I4Xjl6Y84GiEsNhX3x/eKpkXyIclTwrgkz2KVVgvThFmKlz1TpPo8wmw+Uqq8xqa3J4QKBgQDm5if1kZfxSTlWWOGQfc01ViL3KuWnTmMXD3yZMmwO+kEgp1mfDVDMULqzqmiF7AznDe5HgOuwgqmietRIbny0xvxcUiWpLpnztfxTjOG898VHu8X8DqdgFGoc6TFj/waqoz6UOBl6pujo8C9rrRaJCL0sbgThqWEJeVR7M12r6QKBgQDTBniUovW3bYap3nnFBlAtrD5itnkZo5kSolc/HtJssZ4hN8A6FFJJr+Cj7Tv3epJpiQ6/U2TuoDEpQgAKW08ClDqNELAncaD2WsH/s78JWPUpG/oOwyvaah1UTHrI1G9/OgXEEMCKZyf08fuOpeJmRkYBhHZMyKrMvPIW7LwmYwKBgC3qBngmg3hPfz9UXUZGPdAlWL6doR0r0Th8s+IizKoNyXWc0Y13MGHwi6++axp2Xfp0IrXFRRjMYr8UfbIJhnLMPtJ841BJHAQCZDKZCSpyeqBRDoWYxF+ur4sgM9oWlFTKMV936FkjZ50qZcObn6eQPU3gcsgMzmb74Xi+NhpBAoGBAJ3/0VaQsOM2yUX0gj3HnU6lEUy9jOxqdljiXeqvvCOP1XLPmEikIHx1h/+Ux3pjNq535SfRW9fi7wwSE4+tj/nBXBl0rj/KLxdlGq3GOjnYdi7ieJaHARWWsAEHBkPJ8vVSTzDezhqSY/NdHtlOULX81bubHywcbu2+ZpBNjg47AoGBAKtqpNAPhs/8eYYa/veJb7STkIIGM7QnCV6pbY7WYtWadm92KRyrZLKKYCopjvm/jya+rEgCB2vAOomEQ3jQ499509ehjctrUv6fijeaZZE7XkD8DfW3JFPQFLA5gBPHnILzEsqnn6+CyCupL2n1TdOAG3osq3wimsHjpdecM63d";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyRW22fi+VLWHdvk3a/LLFUUhqqhUFgizcTBmtHMbX51PwIUXFRaf7ycQ1DOTQECJSElAqP120Rh4ig7a0UY56haU1wCOMR1eOJc20QldVE3clGRKDYmBssdTlKEIkas04L3jux5LtX97iGBqUAW+edSFAqVmIQ/zPcLCty1YY+6iFwEmc95vsOGp7AtZGSZxdiqAG98K0R9YW9Ez839GTW5xsqyxlpxFdamVKGuG2dfOfFl6h9jgP/Xq4R2EagdaFq50uTpM+blFyCQeclRLQzpiXhz/x48BecigOppgLm62Vbqhl4K2DAHL1YkqIQ9zxhif5i1/HRuzpL1j9yKlUQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/welfare/alipay/alipayNotifyNotice.action";
	public static String notify_url2 = "http://localhost:8080/welfare/alipay/alipayNotifyNotice2.action";
															  
	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/welfare/alipay/alipayReturnNotice.action";
	public static String return_url2 = "http://localhost:8080/welfare/alipay/alipayReturnNotice2.action";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关      //注意：沙箱测试环境，正式环境为：https://openapi.alipay.com/gateway.do          
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

