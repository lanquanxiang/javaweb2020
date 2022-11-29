package cn.pzhuweb.util;

import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.mail.SimpleEmail;

import cn.pzhuweb.pojo.Message;

public class EmailUtil {
	public static Message sendEmail(String email) {
		SimpleEmail simpleEmail = new SimpleEmail();
		simpleEmail.setHostName("smtp.qq.com");
		simpleEmail.setSslSmtpPort("465");
		simpleEmail.setAuthentication("pzhlan@qq.com", "授权码");
		try {
			simpleEmail.addTo(email);
			simpleEmail.setFrom("pzhlan@qq.com", "Admin");
			simpleEmail.setSubject("Java Web验证码");
			String code = randomCode();
			simpleEmail.setMsg("你的邮箱验证码是："+ code);
			simpleEmail.send();
			
			return new Message(true, code);
		} catch (Exception e) {
			return new Message(false, "邮件发送失败!");
		}
		
	}

	private static String randomCode() {
		char[] eles = "23456789qwertyupkjhgfdsazxcvbnmQWERTYUPKJHGFDSAZXCVBNM".toCharArray();
		Random random = new SecureRandom();
		String code = "";
		for (int i = 0; i < 10; i++) {
			char ele = eles[random.nextInt(eles.length)];
			code+=ele;
		}
		return code;
	}

}
