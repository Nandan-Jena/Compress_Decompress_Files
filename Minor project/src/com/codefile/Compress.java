package com.codefile;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class Compress {
    public static void method(File file) throws IOException {
        String fileDirectory = file.getParent(); //to get the directory path from Main
        System.out.println(fileDirectory);
        FileInputStream fis = new FileInputStream(file); //reads the file
        FileOutputStream fos = new FileOutputStream(fileDirectory+ "\\Compressed.gz");  //get the output
        GZIPOutputStream gzipos= new GZIPOutputStream(fos);  //compress the output file

        byte[] buffer = new byte[1024];
        int len;
        while((len= fis.read(buffer))!=-1){  //run the file until we don't read any input from the file
            gzipos.write(buffer,0,len);
        }
        fis.close();
        gzipos.close();
        fos.close();

    }
    public static void main(String[] args) throws IOException {
        File path = new File("C:\\Users\\Nandan\\Desktop\\Projects\\Minor project\\Compressed.gz");
        method(path);
    }
}
