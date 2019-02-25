package com.xf.controller;

import com.xf.common.CaptchaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

@Controller
@RequestMapping("/captcha")
public class CaptchaController {

	private Logger logger = LoggerFactory.getLogger(CaptchaController.class);

	/**
	 * 生成验证码
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/getCaptcha", method = RequestMethod.GET)
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
		logger.info("getCaptcha ## 验证码获取开始！！");
		try {
			//把校验码转为图像
			BufferedImage captcha = genCaptcha(response);
			response.setContentType("image/jpeg");
	        //输出图像
			ServletOutputStream outStream = response.getOutputStream();
			ImageIO.write(captcha, "jpeg", outStream);
			outStream.close();
		} catch (Exception ex) {
			logger.error("生成验证码失败", ex);
		}
		logger.info("getCaptcha ## 验证码获取结束！！");
    }
	
	public BufferedImage genCaptcha(HttpServletResponse response) {
		//生成一个校验码
		String captcha = CaptchaUtils.genCaptcha(4);
		BufferedImage image = CaptchaUtils.genCaptchaImg(captcha);
		return image;
	}
	
}
