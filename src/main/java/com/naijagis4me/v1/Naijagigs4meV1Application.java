package com.naijagis4me.v1;

import com.naijagis4me.v1.config.jwt.RSAKeyProperties;
import com.naijagis4me.v1.enums.Role;
import com.naijagis4me.v1.models.Person;
import com.naijagis4me.v1.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
@EnableConfigurationProperties(RSAKeyProperties.class)
public class Naijagigs4meV1Application {
	@Autowired
	PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(Naijagigs4meV1Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(PersonRepository personRepository) {
		return args -> {
			personRepository.save(Person.builder()
							.firstName("John")
							.lastName("Mackie")
							.otherNames("Klein")
							.gender("MALE")
							.phoneNumber("9055869586")
							.verificationStatus(true)
							.email("admin@gmail.com")
							.password(passwordEncoder.encode("password"))
							.role(Role.SUPERADMIN)
					.build());
		};
	}

}
