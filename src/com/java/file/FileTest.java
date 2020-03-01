package com.java.file;

import com.sun.org.apache.xpath.internal.operations.String;
import jdk.nashorn.internal.ir.IfNode;
import org.junit.Test;

import javax.xml.transform.Source;
import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @ClassName FileTest
 * @Description TODO
 * @Author 思绪醉流往年
 * @Date 2020/2/20 22:50
 * @Version 1.0
 **/
public class FileTest {
    @Test
    public void test1() throws IOException {
        File file = new File("hello.txt");
        boolean newFile = file.createNewFile();
        if (newFile){
            System.out.println("创建成功");
        }else {
            System.out.println("创建失败");
        }

        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.length());
        long l = file.lastModified();
        System.out.println(Instant.ofEpochMilli(l));
        System.out.println(file.listFiles());
        System.out.println(file.list());

        System.out.println();
        System.out.println("是否为目录\t"+file.isDirectory());
        System.out.println("是否为文件\t"+file.isFile());
        System.out.println("是否存在\t"+file.exists());
        System.out.println("是否可读\t"+file.canRead());
        System.out.println("是否可写\t"+file.canWrite());
        System.out.println("是否隐藏\t"+file.isHidden());
    }

    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            //1.实例化File类，指明要操作的类
            File file=new File("hello.txt");
            //2.提供具体的流
            fr = new FileReader(file);
            //3.数据的读入,如果到达文件末尾，则返回-1
//        int data = fr.read();
//        while (data!=-1){
//            System.out.print((char)data);
//            data=fr.read();
//        }

            //方式二
            int data;
            while ((data=fr.read())!=-1){
                System.out.println((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
            try {
                if (fr!=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @Test
    public void testFileReader1() {
//1.File类实例化
        FileReader fr=null;
        try {
            File file = new File("hello.txt");
            //2.FileReader流实例化
            fr=new FileReader(file);
            //3.读入操作
            char[] cbuffer = new char[5];
            int len;
            while ((len=fr.read(cbuffer))!=-1) {
                //方式一
                for (int i=0;i<len;i++){
                    System.out.print(cbuffer[i]);
            }
                //方式二
//                String str = new String(cbuffer);
//                System.out.println(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr!=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void testFileWrite() throws IOException {
        File file=new File("hello.txt");

        FileWriter fw = new FileWriter(file,true);

        fw.write("you are a pig".toCharArray());
        fw.write("\tI have a dream\t");

        fw.close();
    }
    @Test
    public void FileReaderWriter(){
        FileReader fr= null;
        FileWriter fw= null;
        try {
            File file1 = new File("hello.txt");
            File file2 = new File("hello2.txt");

            fr = new FileReader(file1);
            fw = new FileWriter(file2);

            char[] cbffer=new char[5];
            int len;
            while ((len=fr.read(cbffer))!=-1){
                fw.write(cbffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (fr!=null)
                fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw!=null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
