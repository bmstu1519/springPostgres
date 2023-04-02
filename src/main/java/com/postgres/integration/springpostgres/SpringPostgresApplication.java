package com.postgres.integration.springpostgres;

import com.postgres.integration.springpostgres.postgres.model.Tutorial;
import com.postgres.integration.springpostgres.postgres.repository.JdbcTutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringPostgresApplication implements CommandLineRunner {

	@Autowired
	JdbcTutorialRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringPostgresApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Tutorial newTutor = new Tutorial("First Tutorial", "Some description ...", true);
		repository.save(newTutor);
		List<Tutorial> getAllTutorials =  repository.findAll();

		getAllTutorials.forEach(System.out :: println);
	}

}
