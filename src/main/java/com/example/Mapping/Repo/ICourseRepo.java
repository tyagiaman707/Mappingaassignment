package com.example.Mapping.Repo;

import com.example.Mapping.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepo extends JpaRepository<Course, Integer> {
}
