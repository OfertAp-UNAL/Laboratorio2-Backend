package co.edu.unal.software_engineering.labs.service;

import co.edu.unal.software_engineering.labs.model.Grade;
import co.edu.unal.software_engineering.labs.model.User;
import co.edu.unal.software_engineering.labs.model.Association;
import co.edu.unal.software_engineering.labs.repository.GradeRepository;
import co.edu.unal.software_engineering.labs.pojo.GradePOJO;
import co.edu.unal.software_engineering.labs.pojo.UserGradePOJO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService {

    private final GradeRepository gradeRepository;
    private final UserService userService;
    private final AssociationService associationService;

    public GradeService(GradeRepository gradeRepository, UserService userService,
            AssociationService associationService) {
        this.gradeRepository = gradeRepository;
        this.userService = userService;
        this.associationService = associationService;
    }

    public Grade findById(Integer id) {
        return gradeRepository.findById(id).orElse(null);
    }

    public Grade mapperGradeEntity(GradePOJO gradePojo) {
        Grade grade = new Grade();
        grade.setApproved(gradePojo.getApproved());
        grade.setNote(gradePojo.getNote());
        return grade;
    }

    public boolean isRightGrade(Grade grade) {
        return grade.getId() == null && grade.getNote() != null && grade.getApproved() != null
                && grade.getNote() >= 0 && grade.getNote() <= 5;
    }

    public void save(Grade grade) {
        gradeRepository.save(grade);
    }

    public List<UserGradePOJO> getGradesByUser(String username) {
        User user = userService.findByUsername(username);
        List<Association> associations = associationService.getAssociationsByUser(user);
        List<UserGradePOJO> userGrades = new ArrayList<>();
        for (Association association : associations) {
            userGrades.add(new UserGradePOJO(association));
        }
        return userGrades;
    }
}
