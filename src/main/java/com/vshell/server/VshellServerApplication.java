package com.vshell.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ServletComponentScan
@Configuration
@EnableAutoConfiguration
@MapperScan("com.vshell.server.dao")
public class VshellServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VshellServerApplication.class, args);
	}
}
