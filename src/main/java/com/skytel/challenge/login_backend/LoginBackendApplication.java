package com.skytel.challenge.login_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LoginBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginBackendApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/register")
						.allowedOrigins("http://localhost:4200")
						.allowedMethods("GET","POST", "PUT")
						.maxAge(3600);
			}
		};
	}
}
