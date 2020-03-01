package com.java.file;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;

/**
 * @ClassName FileInputOutputStreamTest
 * @Description TODO
 * @Author 思绪醉流往年
 * @Date 2020/2/25 14:20
 * @Version 1.0
 **/
public class FileInputOutputStreamTest {
    public void copyFile(String OldPath,String NewPath){
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        try {
            File f1 =new File(OldPath);
            File f2=new File(NewPath);

            inputStream = new FileInputStream(f1);
            outputStream = new FileOutputStream(f2);

            bufferedInputStream= new BufferedInputStream(inputStream);
            bufferedOutputStream= new BufferedOutputStream(outputStream);

            //方式一
            byte[] bytes = new byte[1024];
            int len;
            while ((len=bufferedInputStream.read(bytes))!=-1){
                bufferedOutputStream.write(bytes,0,len);
            }
           //方式二
//            String str;
//            bufferedInputStream.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedInputStream!=null)
                    bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            if (bufferedOutputStream!=null)
                bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testFileInputStream(){
        long start = System.currentTimeMillis();
        String OldPath="C:/Users/ACER/Desktop/OUT_20191222_193008.mp4";
        String NewPath="C:/Users/ACER/Desktop/OUT_20191222_193009.mp4";

        copyFile(OldPath,NewPath);

        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
    @Test
    public void testBufferedReaderTest() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("hello2.txt")));
            bufferedWriter = new BufferedWriter(new FileWriter(new File("hello4.txt")));
            //方式一：
            char[] chars = new char[10];
            int len;
            while ((len=bufferedReader.read(chars))!=-1){

                    bufferedWriter.write(chars,0,len);

            }
            //方式二：
//            String str;
//            while ((str=bufferedReader.readLine())!=null){
//                bufferedWriter.write(str);
//                bufferedWriter.newLine();
//            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader!=null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter!=null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Test
    public void testInputStreamReader() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("hello.txt");

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");

        char[] chars = new char[20];
        int len;
        while ((len=inputStreamReader.read(chars))!=-1){
//            for (int i=0;i<len;i++){
//                System.out.println(chars[i]);
//            }
            String s = new String(chars,0,len);
            System.out.println(s);
        }
    }

    @Test
    public void testOutputStreamWriter() throws IOException {
        File file1 = new File("hello.txt");
        File file2 = new File("hello-gbk.txt");

        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

        char[] chars = new char[10];
        int len;
        while((len=inputStreamReader.read(chars))!=-1){
            outputStreamWriter.write(chars,0,len);
        }
        inputStreamReader.close();
        outputStreamWriter.close();
    }
}
