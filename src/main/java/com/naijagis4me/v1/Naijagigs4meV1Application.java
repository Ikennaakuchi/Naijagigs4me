package com.naijagis4me.v1;

import com.naijagis4me.v1.config.jwt.RSAKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(RSAKeyProperties.class)
public class Naijagigs4meV1Application {
	public static void main(String[] args) {
		SpringApplication.run(Naijagigs4meV1Application.class, args);
	}

}
