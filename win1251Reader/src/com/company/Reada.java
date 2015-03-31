package com.company;

import java.io.*;
import java.nio.charset.Charset;

public class Reada {
    private BufferedReader reader;

    public Reada(String str){

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(str), Charset.forName("windows-1251")));
            String line;
            while ((line = reader.readLine()) != null){
                System.out.print(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
