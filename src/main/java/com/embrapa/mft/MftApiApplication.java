package com.embrapa.mft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.embrapa.mft.config.property.MftApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(MftApiProperty.class)
public class MftApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MftApiApplication.class, args);
	}

}
