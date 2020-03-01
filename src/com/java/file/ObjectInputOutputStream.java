package com.java.file;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName ObjectInpuStream
 * @Description TODO
 * @Author 思绪醉流往年
 * @Date 2020/2/27 21:23
 * @Version 1.0
 **/
public class ObjectInputOutputStream {
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("object.dat");

            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(new String("我爱北京天安门"));

            objectOutputStream.flush();

            objectOutputStream.writeObject(new Person("sb",10));

            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream!=null)
                    objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testObjectInputStream() {
        ObjectInputStream objectInputStream=null;
        try {
            File file = new File("object.dat");
            FileInputStream fileInputStream = new FileInputStream(file);

            objectInputStream = new ObjectInputStream(fileInputStream);

            Object object = objectInputStream.readObject();
            String str=(String)object;

            Person p=(Person)objectInputStream.readObject();
            System.out.println(str);
            System.out.println(p);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream!=null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void testRandomFile(){
        RandomAccessFile randomAccessFile1 = null;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile1 = new RandomAccessFile(new File("hello.txt"),"r");
            randomAccessFile2 = new RandomAccessFile(new File("hello5.txt"),"rw");

            byte[] buffer=new byte[1024];
            int len;
            while((len = randomAccessFile1.read(buffer))!=-1){

                randomAccessFile2.seek(3);
                randomAccessFile2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (randomAccessFile1!=null)
                    randomAccessFile1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (randomAccessFile2!=null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    /*
    使用RandomAccessFile实现插入数据的效果
     */
    @Test
    public void testindex() throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile("hello.txt","rw");

        randomAccessFile.seek(3);

        //保存指针3后面的所有数据到StringBuilder中
        StringBuilder stringBuilder = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while ((len=randomAccessFile.read(buffer))!=-1){
            stringBuilder.append(new String(buffer,0,len));
        }
//调回指针
        randomAccessFile.seek(3);
        randomAccessFile.write("xyz".getBytes());
//将StringBuilder中数据再写入,这个时候不用再调回指针了，让其处于最后状态
        randomAccessFile.write(stringBuilder.toString().getBytes());

        randomAccessFile.close();
    }
}
