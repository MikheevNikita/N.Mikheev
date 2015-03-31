package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Corrector {

    public Corrector(String directory){
        try {
            List<String> list = new ArrayList<String>();
            BufferedReader reada = new BufferedReader(new InputStreamReader(new FileInputStream(directory)));
            BufferedWriter writa = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("correctedC.txt")));
            String read;
            while ((read = reada.readLine()) != null){
                list.add(read);
            }
            reada.close();
            int index = -1;
            for (String str : list){
                index++;
                if (str.equals("{")){
                  list.remove(index);
                    index--;
                    list.set(index, (list.get(index) + "{"));
                }
            }
            for (String str : list){
                writa.write(str);
            }
            writa.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
