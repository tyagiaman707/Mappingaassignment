package com.example.Mapping.Controller;

import com.example.Mapping.Model.Student;
import com.example.Mapping.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        Student student2=studentService.addStudent(student);
        return student2;
    }

    @GetMapping("/student")
    public List<Student> getStudent(@Nullable @RequestParam String studentId)  {
        List<Student> student = studentService.getStudent(studentId);
        return student;
    }}

