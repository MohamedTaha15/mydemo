package com.example.mydemo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();

        /*List.of(
               *//* *//*
        );*/

    }

    public void AddNewStudent(Student student){

        Optional<Student> studentByEmail = studentRepository.findByEmail(student.getEmail());
        if (studentByEmail.isPresent()){
            throw new IllegalStateException("Email already exists");
        }
        studentRepository.save(student);

        /*System.out.println(student);*/
    }

    public void DeleteStudentById(Long id){
        Optional<Student> deleteStudent = studentRepository.findById(id);
        if (deleteStudent.isEmpty()){
            throw new IllegalStateException("Invalid Id, Student with id: " + id + " does not exist");
        }
        studentRepository.deleteById(id);

    }

    @Transactional
    public void UpdateStudentNameAndEmail(Long id,
                                          String name, String email){
        Optional<Student> updatestudent = studentRepository.findById(id);
        if (updatestudent.isEmpty()){
            throw new IllegalStateException("Invalid Id, Student with id: " + id + " does not exist");
        }

        Student updatestudent1 = studentRepository.findStudentById(id);

        if (name != null && !Objects.equals(updatestudent1.getName(), name)){
            updatestudent1.setName(name);

        }

        if (email != null && !Objects.equals(updatestudent1.getEmail(), email)){
            Optional<Student> studentemail = studentRepository.findByEmail(email);
            if (studentemail.isPresent()){
                throw new IllegalStateException("Student with email: "+ email + " already exists");
            }
            updatestudent1.setEmail(email);
        }

        studentRepository.save(updatestudent1);

    }
}
