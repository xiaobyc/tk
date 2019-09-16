package com.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CmsMigrateApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CmsMigrateApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		//此处的Application.class为带有@SpringBootApplication注解的启动类
		return builder.sources(CmsMigrateApplication.class);
	}
}
