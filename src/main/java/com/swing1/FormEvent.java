package com.swing1;

import java.util.EventObject;

public class FormEvent extends EventObject {

    private String name;
    private String occupation;
    private int ageCategory;
    private String empCat;
    private String taxId;
    private boolean usCitizen;
    private String genderCommand;

    public FormEvent(Object source, String name, String occupation, int ageCategory, String empCat, boolean usCitizen,
            String taxId, String genderCommand) {
        super(source);
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.empCat = empCat;
        this.usCitizen = usCitizen;
        this.taxId = taxId;
        this.genderCommand = genderCommand;

    }

    public int getAgeCategory() {
        return ageCategory;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getTaxId() {
        return this.taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public boolean isUsCitizen() {
        return this.usCitizen;
    }

    public boolean getUsCitizen() {
        return this.usCitizen;
    }

    public void setUsCitizen(boolean usCitizen) {
        this.usCitizen = usCitizen;
    }

    public void setAgeCategory(int ageCategory) {
        this.ageCategory = ageCategory;
    }

    public String getEmpCat() {
        return this.empCat;
    }

    public void setEmpCat(String empCat) {
        this.empCat = empCat;
    }

    public String getGenderCommand() {
        return this.genderCommand;
    }

    public void setGenderCommand(String genderCommand) {
        this.genderCommand = genderCommand;
    }

}
