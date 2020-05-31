package com.example.firebase;

public class Grades {

    public String stugid, studname, quarter, subject, grade;

    public Grades(){}
    public Grades (String stugID, String studname, String quarter, String subject, String grade){

        this.stugid = stugID;
        this.studname = studname;
        this.quarter = quarter;
        this.subject = subject;
        this.grade = grade;
    }



    public String getStugID() {
        return stugid;
    }

    public void setStugID(String stugID) {
        this.stugid = stugID;
    }

    public String getStudname() {
        return studname;
    }

    public void setStudname(String studname) {
        this.studname = studname;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
