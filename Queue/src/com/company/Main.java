package com.company;


import java.io.File;

public class Main {

    public static void main(String[] args) {
	// write your code here

        File file = new File("/usr/lib");
        System.out.println(file.exists());
    }
}
