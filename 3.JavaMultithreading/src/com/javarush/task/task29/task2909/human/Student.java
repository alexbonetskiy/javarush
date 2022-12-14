package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {
    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;


    public int getCourse() {
        return course;
    }


    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }



    public void live() {
        learn();
    }

    public void learn() {
    }

    public void incAverageGrade (double delta) {
        double averageGrade = this.getAverageGrade();
        averageGrade += delta;
        this.setAverageGrade(averageGrade);
    }


    public void setAverageGrade (double value) {
        this.averageGrade = value;

    }

    public void setCourse (int course){
        this.course = course;
    }


    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String getPosition() {
        return "Студент";
    }
}