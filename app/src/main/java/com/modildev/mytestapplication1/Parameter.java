package com.modildev.mytestapplication1;

public class Parameter {
    private int id;
    private int iparameter;
    private String sparameter;

    public Parameter(int id, int iparameter, String sparameter) {
        this.id = id;
        this.iparameter = iparameter;
        this.sparameter = sparameter;
    }

    public Parameter(int iparameter, String sparameter) {
        this.iparameter = iparameter;
        this.sparameter = sparameter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIparameter() {
        return iparameter;
    }

    public void setIparameter(int iparameter) {
        this.iparameter = iparameter;
    }

    public String getSparameter() {
        return sparameter;
    }

    public void setSparameter(String sparameter) {
        this.sparameter = sparameter;
    }
}
