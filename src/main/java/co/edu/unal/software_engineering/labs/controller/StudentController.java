package co.edu.unal.software_engineering.labs.controller;

import co.edu.unal.software_engineering.labs.model.*;
import co.edu.unal.software_engineering.labs.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private AssociationService associationService;

    private UserService userService;

    private CourseService courseService;

    private PeriodService periodService;

    public StudentController(UserService userService, CourseService courseService, PeriodService periodService,
            AssociationService associationService) {
        this.userService = userService;
        this.courseService = courseService;
        this.periodService = periodService;
        this.associationService = associationService;
    }

}