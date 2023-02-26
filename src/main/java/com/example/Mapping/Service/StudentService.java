package com.example.Mapping.Service;

import com.example.Mapping.Model.Student;
import com.example.Mapping.Repo.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private IStudentRepo iStudentRepo;

    public Student addStudent(Student student) {
        Student student2=iStudentRepo.save(student);
        return student2;
    }

    public List<Student> getStudent(String studentId) {
        List<Student> student ;
        if(studentId!=null) {
            student = new ArrayList<>();
            student.add(iStudentRepo.findById(Integer.parseInt(studentId)).get());

        }
        else {
            student=iStudentRepo.findAll();
        }
        return student;

    }}