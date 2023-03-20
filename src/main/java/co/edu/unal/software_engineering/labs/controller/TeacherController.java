package co.edu.unal.software_engineering.labs.controller;

import co.edu.unal.software_engineering.labs.service.AssociationService;
import co.edu.unal.software_engineering.labs.service.CourseService;
import co.edu.unal.software_engineering.labs.service.GradeService;
import co.edu.unal.software_engineering.labs.service.PeriodService;

import co.edu.unal.software_engineering.labs.pojo.PeriodPOJO;
import co.edu.unal.software_engineering.labs.pojo.CoursePOJO;
import co.edu.unal.software_engineering.labs.pojo.GradePOJO;
import co.edu.unal.software_engineering.labs.pojo.InscribedUserPOJO;

import co.edu.unal.software_engineering.labs.model.Course;
import co.edu.unal.software_engineering.labs.model.Period;
import co.edu.unal.software_engineering.labs.model.Grade;
import co.edu.unal.software_engineering.labs.model.Association;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
public class TeacherController {

    public final CourseService courseService;
    public final AssociationService associationService;
    public final PeriodService periodService;
    public final GradeService gradeService;

    public TeacherController(CourseService courseService, PeriodService periodService, GradeService gradeService,
            AssociationService associationService) {
        this.courseService = courseService;
        this.periodService = periodService;
        this.gradeService = gradeService;
        this.associationService = associationService;
    }

    @PostMapping(value = { "/profesor/crear-curso" })
    public ResponseEntity<Void> createCourse(@RequestBody CoursePOJO coursePojo) {
        Course course = courseService.mapperCourseEntity(coursePojo);
        if (!courseService.isRightCourse(course)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        courseService.save(course);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = { "/profesor/crear-periodo" })
    public ResponseEntity<Void> createPeriodo(@RequestBody PeriodPOJO periodPOJO) {
        Period period = periodService.mapperPeriodEntity(periodPOJO);
        if (!periodService.isRightPeriod(period)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        periodService.save(period);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = { "/profesor/asignar-nota/asociacion/{assocId}" })
    public ResponseEntity<Void> asignarNota(@PathVariable Integer assocId, @RequestBody GradePOJO gradePOJO) {
        Association association = associationService.findById(assocId);
        Grade grade = gradeService.mapperGradeEntity(gradePOJO);
        if (!gradeService.isRightGrade(grade)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        grade.setAssociation(association);
        gradeService.save(grade);
        association.setGrade(grade);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = { "/profesor/ver-inscritos/curso/{courseId}" })
    public List<InscribedUserPOJO> getGradesByCourse(@PathVariable Integer courseId) {
        return courseService.getInscribedByCourse(courseId);
    }
}
