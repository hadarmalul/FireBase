package com.example.firebase;

public class Student {


    public String stuname, stuadd, stumom, studad, stuid, stupho, stuhomep, stumomp, studadp;


    public Student(){}
    public Student(String stuid, String stuname, String stuadd, String stumom, String studad, String stupho, String stuhomep, String stumomp, String studadp){
        this.stuid=stuid;
        this.stuadd=stuadd;
        this.stuname=stuname;
        this.stumom=stumom;
        this.studad=studad;
        this.stupho=stupho;
        this.stuhomep=stuhomep;
        this.stumomp=stumomp;
        this.studadp=studadp;
    }

    public String getStuhomep() {
        return stuhomep;
    }

    public void setStuhomep(String stuhomep) {
        this.stuhomep = stuhomep;
    }

    public String getStumom() {
        return stumom;
    }

    public void setStumom(String stumom) {
        this.stumom = stumom;
    }

    public String getStumomp() {
        return stumomp;
    }

    public void setStumomp(String stumomp) {
        this.stumomp = stumomp;
    }

    public String getStudad() {
        return studad;
    }

    public void setStudad(String studad) {
        this.studad = studad;
    }

    public String getStudadp() {
        return studadp;
    }

    public void setStudadp(String studadp) {
        this.studadp = studadp;
    }
}


