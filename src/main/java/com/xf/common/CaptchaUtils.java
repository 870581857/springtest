package com.xf.common;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

public class CaptchaUtils {

	static char[] chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 
            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	
	//web登录相关：
	/** 验证码，Hash类型， 后面跟着cookie Id */
	public static final String CAPTCHA = "captcha:";
	/** 验证码，field，验证码内容*/
	public static final String CAPTCHA_CODE = "code";
	/** 验证码，field，验证码是否已经验证过 */
	public static final String CAPTCHA_CHECKED = "checked";
	/** 验证码失效时间，分钟 */
	public static final int CAPTCHA_EXPIRED = 2;

	
	public static String genCaptcha(int count) {
		StringBuilder captcha = new StringBuilder();
		for(int i=0; i<count; i++){
			char c = chars[ThreadLocalRandom.current().nextInt(chars.length)];//随机选取一个字母或数字
			captcha.append(c);
		}
		return captcha.toString();
	}
	
	public static BufferedImage genCaptchaImg(String captcha){
		ThreadLocalRandom r = ThreadLocalRandom.current();
		int count = captcha.length();
		int fontSize = 80; //code的字体大小
		int fontMargin = fontSize/4; //字符间隔
		int width = (fontSize+fontMargin)*count+fontMargin; //图片长度
		int height = (int) (fontSize*1.2); //图片高度，根据字体大小自动调整；调整这个系数可以调整字体占图片的比例
		int avgWidth = width/count;	//字符平均占位宽度
		int maxDegree = 26;	//最大旋转度数
		//背景颜色
		Color bkColor = new Color(247,240,240);
		//验证码的颜色
//		Color[] catchaColor = {Color.MAGENTA, Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.ORANGE, Color.PINK};
		Color[] catchaColor = {new Color(52,52,72),new Color(222,102,96),new Color(86,190,187),new Color(78,163,237),new Color(237,191,111)};
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		
		//填充底色为灰白
		g.setColor(bkColor);
		g.fillRect(0, 0, width, height);
		
		//画边框
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width-1, height-1);
		
		//画干扰字母、数字
		int dSize = fontSize/3; //调整分母大小以调整干扰字符大小
		Font font = new Font("Fixedsys", Font.PLAIN, dSize);
		g.setFont(font);
		int dNumber = width*height/dSize/dSize/5;//根据面积计算干扰字母的个数
		for(int i=0; i<dNumber; i++){
			char d_code = chars[r.nextInt(chars.length)];
			g.setColor(catchaColor[r.nextInt(catchaColor.length)]);
			g.drawString(String.valueOf(d_code), r.nextInt(width), r.nextInt(height));
		}
		//开始画验证码：
		// 创建字体   
		font = new Font("黑体", Font.ITALIC|Font.BOLD, fontSize);
		// 设置字体     
		g.setFont(font);
 
		for(int i=0; i<count; i++){
			char c = captcha.charAt(i);
			g.setColor(catchaColor[r.nextInt(catchaColor.length)]);//随机选取一种颜色
			
			//随机旋转一个角度[-maxDegre, maxDegree]
			int degree = r.nextInt(-maxDegree, maxDegree+1);
			
			//偏移系数，和旋转角度成反比，以避免字符在图片中越出边框
			double offsetFactor = 1-(Math.abs(degree)/(maxDegree+1.0));//加上1，避免出现结果为0
			
			g.rotate(degree * Math.PI / 180); //旋转一个角度
			int x = (int) (fontMargin + r.nextInt(avgWidth-fontSize)*offsetFactor); //横向偏移的距离
			int y = (int) (fontSize + r.nextInt(height-fontSize)*offsetFactor); //上下偏移的距离
			
			g.drawString(String.valueOf(c), x, y); //x,y是字符的左下角，偏离原点的距离！！！
			
			g.rotate(-degree * Math.PI / 180); //画完一个字符之后，旋转回原来的角度
			g.translate(avgWidth, 0);//移动到下一个画画的原点
			//System.out.println(c+": x="+x+" y="+y+" degree="+degree+" offset="+offsetFactor);
			
			//X、Y坐标在合适的范围内随机，不旋转：
			//g.drawString(String.valueOf(c), width/count*i+r.nextInt(width/count-fontSize), fontSize+r.nextInt(height-fontSize));
		}
		
		g.dispose();
		
		return image;
	}
}
