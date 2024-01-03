package com.example.mydemo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mohamed = new Student(
                    20191844L,
                    "Mohamed Taha",
                    "mohamedtaha.9718@gmail.com",
                    LocalDate.of(1999, Month.JANUARY,30)
            );

            Student ahmed = new Student(
                    20191854L,
                    "Ahmed Taha",
                    "Ahmed.9718@gmail.com",
                    LocalDate.of(1994, Month.JANUARY,30)
            );

            Student mostafa = new Student(
                    20191864L,
                    "Mostafa Taha",
                    "mostafa.9718@gmail.com",
                    LocalDate.of(1989, Month.JANUARY,30)
            );

            repository.saveAll(List.of(mohamed,ahmed,mostafa));

        };
    }

}
