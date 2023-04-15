package co.edu.unal.software_engineering.labs.pojo;

import co.edu.unal.software_engineering.labs.model.Period;

public class PeriodPOJO {

    private Integer id;
    private String periodName;

    public PeriodPOJO() {
    }

    public PeriodPOJO(Period periodo) {
        if (periodo == null) {
            throw new NullPointerException("Period cannot be null");
        }
        this.periodName = periodo.getPeriodName();
        this.id = periodo.getId();
    }

    public Integer getId() {
        return id;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }
}