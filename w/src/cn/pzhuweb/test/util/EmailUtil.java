package cn.pzhuweb.test.util;

import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.mail.SimpleEmail;

import cn.pzhuweb.test.pojo.Message;

public class EmailUtil {
	
	public static Message sendEmail(String email){
		SimpleEmail simpleEmail = new SimpleEmail();
		simpleEmail.setHostName("smtp.qq.com");
		simpleEmail.setSmtpPort(465);
		simpleEmail.setSSLOnConnect(true);
		simpleEmail.setAuthentication("pzhlan@qq.com", "wauwaprzeefybhhe");
		
		try {
			simpleEmail.addTo(email);
			simpleEmail.setFrom("pzhlan@qq.com");
			simpleEmail.setSubject("验证码");
			String code = randomCode();
			simpleEmail.setMsg("你的验证码是："+code);
			simpleEmail.send();		
			return new Message(true, code);
		} catch (Exception e) {
			return new Message(false, "邮件发送失败!");
		}
		
	}

	private static String randomCode() {
		String code = "";
		char[] eles="23456789qwertyupkjhgfdsazxcvbnmQWERTYUPKJHGFDSAZXCVBNM".toCharArray();		
		Random random = new SecureRandom();		
		for (int i = 0; i < 10; i++) {
			code+=eles[random.nextInt(eles.length)];
		}
		return code;
	}

}
