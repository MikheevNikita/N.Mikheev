package com.company;

public class Faculty{

    private Student[] students = new Student[1];
    MedicineQueue med = new MedicineQueue();

    public void addStudent(Student newbie){
        Student[] temp = new Student[size()];
        for (int index = 0; index < size(); index++){
            temp[index] = students[index];
        }
        students = new Student[temp.length + 1];
        for (int index = 0; index < temp.length; index++){
            students[index] = temp[index];
        }
        students[size() - 1] = newbie;
    }

    public void sendToCheck(int index) throws QueueOverloadException{
        try{
            med.add(students[index]);
        }catch (QueueOverloadException e){
            e.message();
        }
    }



    public int size(){
        return students.length;
    }

    public Student[] getStudents(){
        return students;
    }
}
