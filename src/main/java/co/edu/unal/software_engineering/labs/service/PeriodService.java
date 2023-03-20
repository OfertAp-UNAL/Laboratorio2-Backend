package co.edu.unal.software_engineering.labs.service;

import co.edu.unal.software_engineering.labs.model.Period;
import co.edu.unal.software_engineering.labs.pojo.PeriodPOJO;
import co.edu.unal.software_engineering.labs.repository.PeriodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class PeriodService {

    private PeriodRepository periodRepository;

    public PeriodService(PeriodRepository periodRepository) {
        this.periodRepository = periodRepository;
    }

    public Period mapperPeriodEntity(PeriodPOJO coursePojo) {
        Period period = new Period();
        period.setPeriodName(coursePojo.getPeriodName());
        return period;
    }

    public boolean isRightPeriod(Period period) {
        return period.getId() == null && !period.getPeriodName().trim().isEmpty();
    }

    public Period findById(Integer id) {
        return periodRepository.findById(id).orElse(null);
    }

    public void save(Period period) {
        periodRepository.save(period);
    }

    public List<PeriodPOJO> getAll() {
        List<PeriodPOJO> periods = new ArrayList<>();

        for (Period period : periodRepository.findAll()) {
            periods.add(new PeriodPOJO(period));
        }
        return periods;
    }
}
