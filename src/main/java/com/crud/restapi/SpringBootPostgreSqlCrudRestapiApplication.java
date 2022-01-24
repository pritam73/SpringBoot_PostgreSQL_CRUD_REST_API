package com.crud.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootPostgreSqlCrudRestapiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPostgreSqlCrudRestapiApplication.class, args);
		System.err.println("::: SpringBootPostgreSqlCrudRestapiApplication Started ::: ");
	}

}
