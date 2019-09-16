package com.tk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = {"com.tk.*.dao"})
public class TkMigrateApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TkMigrateApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		//此处的Application.class为带有@SpringBootApplication注解的启动类
		return builder.sources(TkMigrateApplication.class);
	}
}
