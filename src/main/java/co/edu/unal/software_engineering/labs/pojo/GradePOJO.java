package co.edu.unal.software_engineering.labs.pojo;

import co.edu.unal.software_engineering.labs.model.Grade;

public class GradePOJO {

    private Boolean approved;
    private Float note;

    public GradePOJO() {
    }

    public GradePOJO(Grade grade) {
        if (grade == null) {
            throw new NullPointerException("Grade cannot be null");
        }
        this.approved = grade.getApproved();
        this.note = grade.getNote();
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }
}