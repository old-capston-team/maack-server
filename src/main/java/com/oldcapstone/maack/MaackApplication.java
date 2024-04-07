package com.oldcapstone.maack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MaackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaackApplication.class, args);
	}

}
