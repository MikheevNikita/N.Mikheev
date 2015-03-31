package com.company;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private String question = "";
    private List<String> answers = new ArrayList<>();
    private int rightAnswer;

    public String getQuestion() {
        return question;
    }
    public List<String> getAnswers() {
        return answers;
    }
    public int getRightAnswer() {
        return rightAnswer;
    }


    public Question(String rawQuestion){
        int index = 0;

        while (rawQuestion.charAt(index) != '?'){
            question += rawQuestion.charAt(index);
            index++;
        }
        if (rawQuestion.charAt(index-1) != '.') {
            question += "?";
        }
        index += 2;

        while(rawQuestion.charAt(index) != 'Ω' && index < rawQuestion.length()){
            String currAnswer = "";
            while (rawQuestion.charAt(index) != '|' && rawQuestion.charAt(index) != '*'){
                currAnswer += rawQuestion.charAt(index);
                index++;
            }
            answers.add(currAnswer);
            if (rawQuestion.charAt(index) != '*'){
                index++;
            }else{
                break;
            }
        }
        index++;
        rightAnswer = rawQuestion.charAt(++index);
    }

    public static void say(String str){
        System.out.print(str +"\n");
    }
}
