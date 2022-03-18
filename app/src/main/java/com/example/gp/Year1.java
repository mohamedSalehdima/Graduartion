package com.example.gp;

public class Year1 {
    @Override
    public String toString() {
        return "Year1{" +
                "Math1='" + Math1 + '\'' +
                ", dataStructure='" + dataStructure + '\'' +
                ", physics='" + physics + '\'' +
                ", english='" + english + '\'' +
                ", electronics='" + electronics + '\'' +
                ", reportWriting='" + reportWriting + '\'' +
                '}';
    }

    String Math1,dataStructure,physics,english,electronics,reportWriting;

    public String getMath1() {
        return Math1;
    }

    public void setMath1(String math1) {
        Math1 = math1;
    }

    public String getDataStructure() {
        return dataStructure;
    }

    public void setDataStructure(String dataStructure) {
        this.dataStructure = dataStructure;
    }

    public String getPhysics() {
        return physics;
    }

    public void setPhysics(String physics) {
        this.physics = physics;
    }

    public String getEnglish() {
        return english;
    }

    public Year1(String math1, String dataStructure, String physics, String english, String electronics, String reportWriting) {
        Math1 = math1;
        this.dataStructure = dataStructure;
        this.physics = physics;
        this.english = english;
        this.electronics = electronics;
        this.reportWriting = reportWriting;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getElectronics() {
        return electronics;
    }

    public void setElectronics(String electronics) {
        this.electronics = electronics;
    }

    public String getReportWriting() {
        return reportWriting;
    }

    public void setReportWriting(String reportWriting) {
        this.reportWriting = reportWriting;
    }
}
