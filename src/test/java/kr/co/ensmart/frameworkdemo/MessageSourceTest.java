package kr.co.ensmart.frameworkdemo;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class MessageSourceTest {
	@Autowired
	private MessageSource messageSource;

	@Test
	void test() {
		log.info("system_name: {}", messageSource.getMessage("common.text.system_name", new String[] {}, Locale.getDefault()));
		log.info("hi: {}", messageSource.getMessage("main.text.hi", new String[] {}, Locale.getDefault()));
	}

}
