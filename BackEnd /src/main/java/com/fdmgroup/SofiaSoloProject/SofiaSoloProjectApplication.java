package com.fdmgroup.SofiaSoloProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.fdmgroup.SofiaSoloProject.security.RsaKeyProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class SofiaSoloProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SofiaSoloProjectApplication.class, args);
	}

}
