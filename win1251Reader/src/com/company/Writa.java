package com.company;

import java.io.*;
import java.nio.charset.Charset;

public class Writa {

    public Writa(String str){
        try {
            BufferedWriter writa = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("newFile"), Charset.forName("windows-1251")));
            writa.write(str);
            writa.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
