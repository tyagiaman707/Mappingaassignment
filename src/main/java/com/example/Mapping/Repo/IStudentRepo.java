package com.example.Mapping.Repo;

import com.example.Mapping.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepo extends JpaRepository<Student,Integer> {
}
