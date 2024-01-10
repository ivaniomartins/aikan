package com.aikan;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aikan.model.Tutor;
import com.aikan.repositories.TutorRepository;

@SpringBootApplication
public class AikanApplication implements CommandLineRunner{
	
	@Autowired
	private TutorRepository tutorRepository;

	public static void main(String[] args) {
		SpringApplication.run(AikanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tutor t1 = new Tutor(null, "Ivanio Martins", "092.348.134-64", "ivaniomartins1991@gmail.com", null);
		
		tutorRepository.saveAll(Arrays.asList(t1));
	}

}
