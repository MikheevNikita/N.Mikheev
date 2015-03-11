package com.company;
import java.util.Scanner;

public class BinaryMult {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long numOne = in.nextLong();
        long numTwo = in.nextLong();
        long num1 = numOne;
        long num2 = numTwo;

        long a = numOne >> (32);
        long b = num1 - a;
        long c = numTwo >> (32);
        long d = num2 - c;

        System.out.println(((a*c)<<32)+((a*d + c*d)<<16)+b*d);
    }
}
