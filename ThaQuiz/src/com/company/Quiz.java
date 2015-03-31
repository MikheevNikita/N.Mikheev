/* This class... Umm.. Basically, what it does is that it gets the src_lib.txt file from a public repository and
    reads it to get an accurate information about libraries of questions that it keeps to then randomly chose one
*/

package com.company;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Quiz {

    private List<String> quiz_lib;
    private String[] libs;
    private List<String> rawQuestions;
    private String[] questions;
    private List<Question> quiz;
    Scanner in = new Scanner(System.in);

    public List<Question> getQuiz(){
        return quiz;
    }


    public Quiz (URL src_lib){
        gitReader(src_lib, Convert.LIB);
        String link = "https://github.com/default/source/blob/master/";
        int index = randInt(libs.length);
        System.out.print(libs[index]);
        link += libs[index];
        try{
            URL quest = new URL(link);
            gitReader(quest, Convert.QUIZ);
        }catch(MalformedURLException e){
            System.err.print("Oops. It seems like we're having trouble with requested quiz library" +
                    " and we're working hard to fix it!");
        }
        quiz = new ArrayList<>();
        for (String str : questions){
            quiz.add(new Question(str));
        }
    }


    public void gitReader(URL source, Convert action){
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(source.openStream()));
            if(action == Convert.LIB){
                quiz_lib = new ArrayList<>();
            }else{
                rawQuestions = new ArrayList<>();
            }
            String inputLine;
            int count = 0;
            while ((inputLine = in.readLine()) != null) {
                if (count >= 433 && inputLine.startsWith("        <td id=" +'"' +"LC" )) {
                    if(action == Convert.LIB){
                        quiz_lib.add(inputLine);
                    }else{
                        rawQuestions.add(inputLine);
                    }
                }
                count++;
            }
            in.close();

            if(action == Convert.LIB){
                libs = deraw(Convert.LIB);
            }else{
                questions = deraw(Convert.QUIZ);
            }


        }catch(Exception e){
            e.getStackTrace();
        }
    }


    private String[] deraw(Convert action){

        if(action == Convert.LIB){
            String[] libs = new String[quiz_lib.size()];
            int index = -1;
            for (String str : quiz_lib){
                index++;
                libs[index] = "";
                int counter = 52;
                while (str.charAt(counter) != '<'){
                    libs[index] += str.charAt(counter);
                    counter++;
                }
            }
            return libs;
        }else{
            String[] questions = new String[rawQuestions.size()];
            int index = -1;
            for (String str : rawQuestions){
                index++;
                questions[index] = "";
                int counter = 52;
                while (str.charAt(counter) != '<'){
                    questions[index] += str.charAt(counter);
                    counter++;
                }
            }
            return questions;
        }

    }

    public static int randInt(int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt(max);

        return randomNum;
    }

}
