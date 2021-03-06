package com.company;

import java.nio.file.NotDirectoryException;

public class Main {

    public static void main(String directory) throws NotDirectoryException{
        if (directory == null){
            throw new NotDirectoryException("Directory was not provided");
        }
        Corrector corrector = new Corrector(directory);
    }
}
