package com.company;

public class Bracket {
    private char c;
    private char associated;

    public Bracket(char c){
        switch (c){
            case '(':
                this.c = c;
                associated = ')';
                break;
            case '{':
                this.c = c;
                associated = '}';
                break;
            case '[':
                this.c = c;
                associated = ']';
                break;
            default:
                this.c = 'Ü';
        }
    }

    public char getC(){
        return c;
    }

    public char getAssociated(){
        return associated;
    }




}
