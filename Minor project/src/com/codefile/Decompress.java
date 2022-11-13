package com.codefile;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Decompress {
    public static void method(File file) throws IOException {
        String fileDirectory = file.getParent(); //to get the directory path from Main
        System.out.println(fileDirectory);

        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzipis = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(fileDirectory+"\\Decompress.txt");

        byte[] buffer = new byte[1024];
        int len;
        while((len=gzipis.read(buffer))!= -1){
            fos.write(buffer,0,len);
        }

        gzipis.close();
        fis.close();
        fos.close();
    }
    public static void main(String[] args) throws IOException {
        File path = new File("C:\\Users\\Nandan\\Desktop\\Projects\\Minor project\\Compressed.gz");
        method(path);
    }
}
