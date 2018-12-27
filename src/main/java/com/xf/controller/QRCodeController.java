package com.xf.controller;

import com.xf.common.EncoderHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("qrcode")
public class QRCodeController{
 
	private final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(QRCodeController.class);

	@RequestMapping(value = "/getqrcode")
	protected void service(HttpServletRequest requset, HttpServletResponse response)
			throws ServletException, IOException {
		String content = "姓名:maysnow 电话:123687495";
		EncoderHandler encoder = new EncoderHandler();
		encoder.encoderQRCoder(content, response);
	}
 
}