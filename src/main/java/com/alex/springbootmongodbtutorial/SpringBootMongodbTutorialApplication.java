package com.alex.springbootmongodbtutorial;

import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
public class SpringBootMongodbTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbTutorialApplication.class, args);
	}

}
