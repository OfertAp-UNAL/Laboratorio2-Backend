package co.edu.unal.software_engineering.labs.controller;

import co.edu.unal.software_engineering.labs.pojo.CoursePOJO;
import co.edu.unal.software_engineering.labs.pojo.EnrolledCoursePOJO;
import co.edu.unal.software_engineering.labs.service.CourseService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/mis-cursos")
    public List<EnrolledCoursePOJO> getCoursesByUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return courseService.getCoursesByUser(username);
    }

    @GetMapping("/cursos")
    public List<CoursePOJO> getAllCourses() {
        return courseService.getAll();
    }

}