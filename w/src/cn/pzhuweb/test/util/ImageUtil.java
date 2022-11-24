package cn.pzhuweb.test.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Random;


public class ImageUtil {
	private BufferedImage image = null;
	private String ans = "";
	
	public ImageUtil(String type) {
		if (type==null) {
			init();
		}else{
			initCN();
		}		
	}

	private void initCN() {
		BufferedImage image = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, 100, 30);
		g.setColor(Color.black);
		g.setFont(new Font("宋体", Font.BOLD, 18));
		
		Random random = new SecureRandom();	
		for (int i = 0; i < 4; i++) {
			byte[] bytes = new byte[2];
			int index = random.nextInt(3755);
			int h = index/94 + Integer.valueOf("B0", 16);
			int l = index%94 + Integer.valueOf("A1", 16);
			bytes[0] = Integer.valueOf(h).byteValue();
			bytes[1] = Integer.valueOf(l).byteValue();
			try {
				this.ans += new String(bytes,"GB2312");
			} catch (UnsupportedEncodingException e) {				
				e.printStackTrace();
				this.ans +="";
			}
		}
		System.out.println(this.ans);
		g.drawString(ans, 10, 25);
		this.image = mask(image);		
	}

	private void init() {
		BufferedImage image = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, 100, 30);
		g.setColor(Color.black);
		g.setFont(new Font("Times New Roman", Font.BOLD, 24));
		char[] eles="23456789qwertyupkjhgfdsazxcvbnmQWERTYUPKJHGFDSAZXCVBNM".toCharArray();
		
		Random random = new SecureRandom();		
		for (int i = 0; i < 4; i++) {
			this.ans+=eles[random.nextInt(eles.length)];
		}
		System.out.println(this.ans);
		g.drawString(ans, 10, 25);
		this.image = mask(image);
	}

	private BufferedImage mask(BufferedImage image) {
		Graphics g = image.getGraphics();
		g.setColor(Color.black);
		int width = image.getWidth();
		int height = image.getHeight();
		Random random = new SecureRandom();	
		for (int i = 0; i < 10; i++) {
			int x1 = random.nextInt(width/3);
			int y1 = random.nextInt(height);
			int x2 = width*2/3+random.nextInt(width/3);
			int y2 = random.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}
		return image;
	}

	public BufferedImage getImage() {
		return image;
	}

	public String getAns() {
		return ans;
	}
	
	
	
	
}
