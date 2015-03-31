package com.company;

import java.net.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        try{


            URL src_lib = new URL("https://github.com/default/source/blob/master/src_lib.txt");
            Quiz quiz = new Quiz(src_lib);

            int scores = 0;
            for (Question question : quiz.getQuiz()){
                System.out.print("\n\n");
                System.out.print(question.getQuestion() +"\n");
                int index = 1;
                for (String str : question.getAnswers()){
                    System.out.print(index +" " +str +" |");
                    index++;
                }
                System.out.print("\n");
                int answer = Integer.parseInt(in.nextLine());
                if (answer == question.getRightAnswer() - 47){
                    scores++;
                }
            }
            System.out.print("\n\nCongratulations! You've finished this quiz with your final score: "
                    +scores +"/" +quiz.getQuiz().size());

        }catch (MalformedURLException e){
            System.err.print("Something went wrong while trying to access the server and we" +
                    "are currently working on it. Please stay updated with our official website");
        }
    }
}
