package com.example.Mapping.Controller;

import com.example.Mapping.Dto.CourseDTO;
import com.example.Mapping.Model.Course;
import com.example.Mapping.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/course")
    public Course addCourse(@RequestBody Course course){
        Course course1 =  courseService.addCourse(course);
        return course1;
    }

    @GetMapping("/course")
    public List<Course> getCourse(@Nullable @RequestParam String courseId) {
        return  courseService.getCourse(courseId);
    }

    @PostMapping("/student")
    public Course addCourseToStudent(@RequestBody CourseDTO course){
        Course course1 =  courseService.addCourseToStudent(course);
        return course1;
    }

    @PostMapping("course/student/add")
    public String addStudentToCourse(@RequestParam(value = "studentId",required = true)String studentId,
                                     @RequestParam(value="courseId",required = true)String courseId)  {
        this.courseService.addStudentToCourse(studentId,courseId);
        return "student added to course";
    }}