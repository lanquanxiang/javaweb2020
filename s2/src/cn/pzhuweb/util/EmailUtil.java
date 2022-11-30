package cn.pzhuweb.util;

import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.mail.SimpleEmail;

import cn.pzhuweb.pojo.Message;

public class EmailUtil {
	
	public static Message sendEmail(String email){
		SimpleEmail simpleEmail = new SimpleEmail();
		
		simpleEmail.setHostName("smtp.qq.com");
		simpleEmail.setSSLOnConnect(true);
		simpleEmail.setSmtpPort(465);
		simpleEmail.setAuthentication("pzhlan@qq.com", "授权码");
		try {
			simpleEmail.addTo(email);
			simpleEmail.setFrom("pzhlan@qq.com");
			simpleEmail.setSubject("邮箱登录验证码");
			String code = randomCode();
			simpleEmail.setMsg("你的登录验证码是："+code);
			simpleEmail.send();
			return new Message(true, code);
		} catch (Exception e) {
			return new Message(true, "邮件发送失败!");
		}
	}

	private static String randomCode() {
		char[] eles = "0123456789qwertyupasdfghjkmnbvcxzQWERTYUPKJHGFDSAZXCVBNM".toCharArray();
		Random random = new SecureRandom();
		String codes="";
		for (int i = 0; i < 10; i++) {
			codes+=eles[random.nextInt(eles.length)];
		}
		return codes;
	}
	

}
