package cn.pzhuweb.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Random;

public class ImageUtil {
	private BufferedImage image = null;
	private String codes = "";
	
	public ImageUtil(String type) {
		if (type==null) {
			initImage();
		}else{
			initCNImage();
		}
	}
	private void initCNImage() {
		BufferedImage image = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, 100, 30);
		g.setColor(Color.black);
		g.setFont(new Font("宋体", Font.BOLD, 16));
		/*
		 * 中文GB2312表示（B0A1）开始是中文（区位码）一级汉字3755(0-3744)   40个区 每个区94个位
		 * 0--->  B0A1  176 161
		 * 1--->  B0A2  176 162
		 * 94-->  B1A1  177 161
		 */
		Random random = new SecureRandom();
		for (int i = 0; i < 4; i++) {
			byte[] bytes = new byte[2];
			int index = random.nextInt(3755);
			int h = index/94+Integer.valueOf("B0",16);//176
			int l = index%94+Integer.valueOf("A1",16);//161
			bytes[0] = Integer.valueOf(h).byteValue();//第一个字节
			bytes[1] = Integer.valueOf(l).byteValue();//第二个字节
			try {
				String temp = new String(bytes,"GB2312");
				this.codes+=temp;
			} catch (UnsupportedEncodingException e) {				
				e.printStackTrace();
				this.codes+="";
			}
		}
		System.out.println(this.codes);
		g.drawString(this.codes, 20, 25);
		this.image = mask(image);
	}
	private void initImage() {
		BufferedImage image = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, 100, 30);
		g.setColor(Color.black);
		g.setFont(new Font("Times New Roman", Font.BOLD, 24));
		char[] eles = "23456789qwertyupasdfghjkmnbvcxzQWERTYUPKJHGFDSAZXCVBNM".toCharArray();
		Random random = new SecureRandom();
		for (int i = 0; i < 4; i++) {
			this.codes+=eles[random.nextInt(eles.length)];
		}
		System.out.println(this.codes);
		g.drawString(this.codes, 20, 25);
		this.image = mask(image);
		
	}
	private BufferedImage mask(BufferedImage image) {
		Graphics g = image.getGraphics();
		int width = image.getWidth();
		int height = image.getHeight();
		Random random = new SecureRandom();
		g.setColor(Color.black);
		for (int i = 0; i < 5; i++) {
			int x1 = random.nextInt(width/4);
			int y1 = random.nextInt(height);
			int x2 = width*3/4+random.nextInt(width/4);
			int y2 = random.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}		
		return image;
	}
	public BufferedImage getImage() {
		return image;
	}
	public String getCodes() {
		return codes;
	}
	
	

}
