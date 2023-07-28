package com.practice.Ayush;

import com.practice.Ayush.model.Student;
import com.practice.Ayush.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class AyushApplication implements CommandLineRunner {

	@Autowired
	StudentRepo studentRepo;


	public static void main(String[] args) {

		SpringApplication.run(AyushApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(".........SERVER IS UP.........");
	}

	private void getStudentBySchool()
	{
		List<Student> list = studentRepo.getStudentBySchool("Consultadd");
	}
}
