package com.company;
import java.lang.Comparable;import java.lang.Override;import java.lang.String;

public class Student implements Comparable<Student>{
    private String name;
    private int age;
    private double grade;
    final double STEP = 0.01;

    void init(String name, int age, double grade){
        this.age = age;
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Student student){
        if(this.grade - student.getGrade() - STEP > 0){
            return 1;
        }else if(this.grade - student.getGrade() - STEP == 0){
            return 0;
        }else{
            return -1;
        }
    }
}

