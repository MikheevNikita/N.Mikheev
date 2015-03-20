package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws WrongInitializingException{
        Scanner in = new Scanner(System.in);
        say("Define an amount of Students -> ");
        int size = in.nextInt();
        Student[] students = new Student[size];
        for (int index = 0; index < size; index++){
            say("\n Tell me about Student " +(index+1) +" : Name, Age, Grade \n");
            try {
                String name = in.nextLine();
                int age = in.nextInt();
                double grade = in.nextDouble();
                if (name != null || age <= 0 || grade < 0){
                    throw new WrongInitializingException();
                }
                students[index].initialize(name, age, grade);
            }catch (WrongInitializingException e){
                e.message();
            }
        }
        Item[] linkedList = new Item[size+1];
    }


    public static void say(String str){
        System.out.print(str);
    }
}
