package co.edu.unal.software_engineering.labs.pojo;

import co.edu.unal.software_engineering.labs.model.Association;

public class UserGradePOJO {

    private CoursePOJO course;
    private GradePOJO grade;
    private PeriodPOJO period;

    public UserGradePOJO(Association association) {
        this.course = new CoursePOJO(association.getCourse());
        this.grade = new GradePOJO(association.getGrade());
        this.period = new PeriodPOJO(association.getPeriod());
    }

    public CoursePOJO getCourse() {
        return course;
    }

    public void setCourse(CoursePOJO course) {
        this.course = course;
    }

    public GradePOJO getGrade() {
        return grade;
    }

    public void setGrade(GradePOJO grade) {
        this.grade = grade;
    }

    public PeriodPOJO getPeriod() {
        return period;
    }

    public void setPeriod(PeriodPOJO period) {
        this.period = period;
    }
}
