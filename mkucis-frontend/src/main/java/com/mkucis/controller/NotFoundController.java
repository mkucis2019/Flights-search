package com.mkucis.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class NotFoundController implements ErrorController {
	
	@RequestMapping(value = "/error", produces = "text/html; charset=UTF-8")
    public ModelAndView errorPage() {
		ModelAndView mv = new ModelAndView("error_msg");
		return mv;
    }

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
