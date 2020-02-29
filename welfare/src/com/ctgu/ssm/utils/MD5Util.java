package com.ctgu.ssm.utils;
import java.security.MessageDigest;

/**
 *Title: MD5Util
 *Description: MD5盐值加密
 *
 * @author sss
 * @date 2019年6月11日下午12:09:41
 */
public class MD5Util {

    public static StringBuilder getPw(String pw, String salt) throws Exception {
        // 计算消息摘要
        MessageDigest m = MessageDigest.getInstance("MD5"); // 获取MD5实例
        // 看是否需要加盐
        if(salt != null) {
        	m.update(salt.getBytes("UTF8"));
        }
        m.update(pw.getBytes("UTF8"));
        byte s[] = m.digest();
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < s.length; i++) {
            result.append(Integer.toHexString((0x000000ff & s[i]) | 0xffffff00)
                    .substring(6)) ; 
        }
        // 返回加密后的密码：
        return result;
    }
	
	
}
