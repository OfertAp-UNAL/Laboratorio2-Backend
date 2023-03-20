package co.edu.unal.software_engineering.labs.controller;

import co.edu.unal.software_engineering.labs.pojo.PeriodPOJO;
import co.edu.unal.software_engineering.labs.service.PeriodService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PeriodController {

    private final PeriodService periodService;

    public PeriodController(PeriodService periodService) {
        this.periodService = periodService;
    }

    @GetMapping("/periodos")
    public List<PeriodPOJO> getAllCourses() {
        return this.periodService.getAll();
    }

}