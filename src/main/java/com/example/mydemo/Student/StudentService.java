package com.example.mydemo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();

        /*List.of(
               *//* new Student(
                        20191844L,
                        "Mohamed Taha",
                        "mohamedtaha.9718@gmail.com",
                        LocalDate.of(1999, Month.JANUARY,30),
                        25
                )*//*
        );*/

    }
}
