package cn.pzhuweb.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Random;

public class ImageUtil {
	private String code;
	private BufferedImage image;
	
	public ImageUtil(String type) {
		if (type==null) {
			initImage();//在构造方法中对验证码进行初始化
		}else{
			initCNImage();
		}
		
	}
	private void initCNImage() {
		BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, 80, 30);
		graphics.setColor(Color.black);
		graphics.setFont(new Font("New Times Roman", Font.BOLD, 16));
		
		Random random = new SecureRandom();
		
		this.code = "";
		for (int i = 0; i < 4; i++) {
			int index = random.nextInt(3755);//随机一级汉字的索引
			int h = index/94+Integer.valueOf("B0", 16);
			int l = index%94+Integer.valueOf("A1", 16);
			byte[] bytes = new byte[2];
			bytes[0] = Integer.valueOf(h).byteValue();
			bytes[1] = Integer.valueOf(l).byteValue();
			String temp="";
			try {
				temp = new String(bytes, "GB2312");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				temp="";
			}			
			code+=temp;
			
		}
		System.out.println(code);
		graphics.drawString(code, 5, 24);
		
		for (int i = 0; i < 5; i++) {
			int x1 = random.nextInt(20);
			int y1 = random.nextInt(30);
			int x2 = random.nextInt(20)+60;
			int y2 = random.nextInt(30);
			graphics.drawLine(x1, y1, x2, y2);
		}	
		
		this.image = image;
		
	}
	public String getCode() {
		return code;
	}	
	public BufferedImage getImage() {
		return image;
	}	
	private void initImage(){
		BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, 80, 30);
		graphics.setColor(Color.black);
		graphics.setFont(new Font("New Times Roman", Font.BOLD, 16));
		char[] eles = "23456789qwertyupkjhgfdsazxcvbnmQWERTYUPKJHGFDSAZXCVBNM".toCharArray();
		Random random = new SecureRandom();
		this.code = "";
		for (int i = 0; i < 4; i++) {
			char ele = eles[random.nextInt(eles.length)];
			code+=ele;
		}
		System.out.println(code);
		graphics.drawString(code, 20, 24);
		
		for (int i = 0; i < 5; i++) {
			int x1 = random.nextInt(20);
			int y1 = random.nextInt(30);
			int x2 = random.nextInt(20)+60;
			int y2 = random.nextInt(30);
			graphics.drawLine(x1, y1, x2, y2);
		}	
		
		this.image = image;
	}
	
	
	
}
