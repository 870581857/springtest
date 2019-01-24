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
import java.util.UUID;

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
    }
	
	public BufferedImage genCaptcha(HttpServletResponse response) {
		//生成一个校验码
		String captcha = CaptchaUtils.genCaptcha(4);
		//生成一个cookie ID，并塞进response里面
		String cookieId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
//		notFilterController.writeCookie("_jde_captcha", cookieId, CaptchaUtils.CAPTCHA_EXPIRED*60, response);
		//把校验码、是否已经通过校验（缺省不设置为0）保存到redis中，以cookie ID 为key
//		jedisTemplate.setex(CaptchaUtils.CAPTCHA+cookieId, captcha, CaptchaUtils.CAPTCHA_EXPIRED*60);
		//把校验码转为图像
		BufferedImage image = CaptchaUtils.genCaptchaImg(captcha);
		return image;
	}
	
}
