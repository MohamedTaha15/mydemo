package com.example.mydemo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {


    @Autowired
    private  StudentService studentService;



    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();

    }

    @PostMapping
    public void RegisterNewStudent(@RequestBody Student student){
        studentService.AddNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void DeleteStudent(@PathVariable("studentId") Long id){
        studentService.DeleteStudentById(id);
    }

    @PutMapping(path = "{studentid}")
    public void UpdateStudent(@PathVariable("studentid") Long id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.UpdateStudentNameAndEmail(id,name,email);
    }

    

}
