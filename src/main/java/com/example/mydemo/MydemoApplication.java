package com.example.mydemo;

import Student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class MydemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MydemoApplication.class, args);
	}

	@GetMapping("/")
	public List<Student> hello (){
		return List.of(
				new Student(
                        20191844L,
						"Mohamed Taha",
						"mohamedtaha.9718@gmail.com",
						LocalDate.of(1999,01,30),
						25
				)
		);

	}

}
