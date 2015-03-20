// The task is to get a line with three different types of brackets and ensure if it's correct with help of a stack

package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        say("Now give the programm a line to work with \n");
        String line = in.nextLine();
        if (line.length() == 0){
            line = "!";
        }
        char[] chars = new char[line.length()];
        chars = line.toCharArray();
        MyStack<Bracket> stack = new MyStack();
        for (int index = 0; index < chars.length; index++){
            if (stack.size() != 0 && stack.peek().getAssociated() == chars[index]){
                stack.pop();
                continue;
            }
            Bracket possibleBracket = new Bracket(chars[index]);
            if (possibleBracket.getC() != 'Ü'){
                stack.push(possibleBracket);
            }
        }
        if (stack.size() == 0){
            say("Your line is fine, dem brackets are good");
        }else{
            say("Nope, there's some kind of mistake in your line, check again");
        }
    }

    public static void say(String str){
        System.out.print(str);
    }
}
