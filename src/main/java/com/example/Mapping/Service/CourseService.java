package com.example.Mapping.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.Mapping.Dto.CourseDTO;
import com.example.Mapping.Model.Course;
import com.example.Mapping.Model.Student;
import com.example.Mapping.Repo.ICourseRepo;
import com.example.Mapping.Repo.IStudentRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private ICourseRepo iCourseRepo;

    @Autowired
    private IStudentRepo iStudentRepo;

    @Autowired
    private StudentService studentService;

    public Course addCourse(Course course) {
        return iCourseRepo.save(course);
    }

    public List<Course> getCourse(String courseId) {
        List<Course> course ;
        if(courseId!=null) {
            course = new ArrayList<>();
            course.add(iCourseRepo.findById(Integer.parseInt(courseId)).get());
        }
        else {
            course=iCourseRepo.findAll();
        }
        return course;

    }

    public Course addCourseToStudent(CourseDTO course)  {
        List<Student> byStudent = studentService.getStudent(course.getStudentId());

        Optional<Course> optionalCourse = iCourseRepo.findById(Integer.parseInt(course.getCourseId()));
        if(optionalCourse.isPresent()){

            Course course1 = optionalCourse.get();
            List<Student> studentList = new ArrayList<>();

            studentList.addAll(byStudent);
            course1.setStudentList(studentList);
            Course save = iCourseRepo.save(course1);
            return save;
        }
        return null;
    }

    public void addStudentToCourse(String studentId, String courseId) {
        Optional<Course> optionalCourse = this.iCourseRepo.findById(Integer.valueOf(courseId));


        if(optionalCourse.isPresent()){

            List<Student> student = this.studentService.getStudent(studentId);

            Course course = optionalCourse.get();
            List<Student> studentList = course.getStudentList();
            studentList.addAll(student);
            iCourseRepo.save(course);

        }

    }}
