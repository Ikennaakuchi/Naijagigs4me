package com.naijagis4me.v1;

import com.naijagis4me.v1.config.jwt.RSAKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(RSAKeyProperties.class)
@SpringBootApplication
public class Naijagigs4meV1Application {

	public static void main(String[] args) {
		SpringApplication.run(Naijagigs4meV1Application.class, args);
	}

}
