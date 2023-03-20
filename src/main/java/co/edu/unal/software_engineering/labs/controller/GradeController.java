package co.edu.unal.software_engineering.labs.controller;

import co.edu.unal.software_engineering.labs.pojo.UserGradePOJO;
import co.edu.unal.software_engineering.labs.service.GradeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@RestController
public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping("/mis-notas")
    public List<UserGradePOJO> getGradeByUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return gradeService.getGradesByUser(username);
    }

}