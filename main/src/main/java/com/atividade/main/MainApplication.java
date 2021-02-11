package com.atividade.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.atividade.main.controller.BookController;

@SpringBootApplication
public class MainApplication {
	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(MainApplication.class, args);
		//exemplo();

	}

	public static void exemplo() {
		BookController controller = context.getBean(BookController.class);
	}

}
