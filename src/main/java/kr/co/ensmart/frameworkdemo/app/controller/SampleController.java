package kr.co.ensmart.frameworkdemo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SampleController {
	@Autowired
	private MessageSource messageSource;

	@GetMapping("/main")
	public String viewMain() {
		log.info("system_name: {}", messageSource.getMessage("common.text.system_name", new String[] {}, LocaleContextHolder.getLocale()));
		log.info("hi: {}", messageSource.getMessage("main.text.hi", new String[] {}, LocaleContextHolder.getLocale()));

		return "/home";
	}

}
