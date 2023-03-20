package co.edu.unal.software_engineering.labs.pojo;

import co.edu.unal.software_engineering.labs.model.Association;

public class InscribedUserPOJO {
    private Integer associationId;
    private String username;
    private String role;
    private String period;
    private GradePOJO gradePOJO;

    public InscribedUserPOJO(Association association) {
        if (association.getGrade() != null) {
            this.gradePOJO = new GradePOJO(association.getGrade());
        } else {
            this.gradePOJO = null;
        }
        this.associationId = association.getId();
        this.username = association.getUser().getUsername();
        this.role = association.getRole().getRoleName();
        this.period = association.getPeriod().getPeriodName();
    }

    public Integer getAssociationId() {
        return associationId;
    }

    public void setAssociationId(Integer associationId) {
        this.associationId = associationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public GradePOJO getGradePOJO() {
        return gradePOJO;
    }

    public void setGradePOJO(GradePOJO gradePOJO) {
        this.gradePOJO = gradePOJO;
    }

}
