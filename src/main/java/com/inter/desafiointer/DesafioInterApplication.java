package com.inter.desafiointer;

import org.modelmapper.internal.util.Assert;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioInterApplication {

	public static void main(String[] args) {
		Assert.isTrue(args == null || args.length == 0);
		SpringApplication.run(DesafioInterApplication.class, args);
	}

}
