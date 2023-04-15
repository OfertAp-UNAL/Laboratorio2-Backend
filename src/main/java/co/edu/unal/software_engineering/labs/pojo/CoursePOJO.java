package co.edu.unal.software_engineering.labs.pojo;

import co.edu.unal.software_engineering.labs.model.Course;

public class CoursePOJO {

    private Integer id;
    private String courseName;
    private Integer durationHours;

    public CoursePOJO() {
    }

    public CoursePOJO(Course curso) {
        if (curso == null) {
            throw new NullPointerException("Course cannot be null");
        }
        this.courseName = curso.getCourseName();
        this.durationHours = curso.getDurationHours();
        this.id = curso.getId();
    }

    public Integer getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(Integer durationHours) {
        this.durationHours = durationHours;
    }
}