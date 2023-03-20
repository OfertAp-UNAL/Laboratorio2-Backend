package co.edu.unal.software_engineering.labs.controller;

import co.edu.unal.software_engineering.labs.service.CourseService;
import co.edu.unal.software_engineering.labs.pojo.CoursePOJO;
import co.edu.unal.software_engineering.labs.model.Course;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
public class TeacherController {

    public final CourseService courseService;

    public TeacherController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping(value = { "/profesor/crear-curso" }, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCourse(@RequestBody CoursePOJO coursePOJO) {

        Course course = new Course();
        course.setCourseName(coursePOJO.getCourseName());
        course.setDurationHours(coursePOJO.getDurationHours());

        courseService.save(course);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
