package co.edu.unal.software_engineering.labs.service;

import co.edu.unal.software_engineering.labs.model.Course;
import co.edu.unal.software_engineering.labs.model.User;
import co.edu.unal.software_engineering.labs.model.Association;

import co.edu.unal.software_engineering.labs.pojo.EnrolledCoursePOJO;
import co.edu.unal.software_engineering.labs.pojo.InscribedUserPOJO;
import co.edu.unal.software_engineering.labs.pojo.CoursePOJO;
import co.edu.unal.software_engineering.labs.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final UserService userService;
    private final AssociationService associationService;

    public CourseService(CourseRepository courseRepository, UserService userService,
            AssociationService associationService) {
        this.courseRepository = courseRepository;
        this.userService = userService;
        this.associationService = associationService;
    }

    public Course findById(Integer id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void save(Course course) {
        courseRepository.save(course);
    }

    public boolean isRightCourse(Course course) {
        return course.getId() == null && !course.getCourseName().trim().isEmpty() &&
                course.getDurationHours() != null;
    }

    public Course mapperCourseEntity(CoursePOJO coursePojo) {
        Course course = new Course();
        course.setCourseName(coursePojo.getCourseName());
        course.setDurationHours(coursePojo.getDurationHours());
        return course;
    }

    public List<CoursePOJO> getAll() {
        List<CoursePOJO> courses = new ArrayList<>();
        for (Course course : courseRepository.findAll()) {
            courses.add(new CoursePOJO(course));
        }
        return courses;
    }

    public List<EnrolledCoursePOJO> getCoursesByUser(String username) {
        User user = userService.findByUsername(username);
        List<Association> associations = associationService.getAssociationsByUser(user);
        List<EnrolledCoursePOJO> enrolledCourses = new ArrayList<>();
        for (Association association : associations) {
            enrolledCourses.add(new EnrolledCoursePOJO(association));
        }
        return enrolledCourses;
    }

    public List<InscribedUserPOJO> getInscribedByCourse(Integer courseId) {
        Course course = findById(courseId);
        List<InscribedUserPOJO> inscribedUsers = new ArrayList<>();
        for (Association association : course.getAssociations()) {
            inscribedUsers.add(new InscribedUserPOJO(association));
        }
        return inscribedUsers;
    }
}
