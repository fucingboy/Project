package com.java.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName FileUtilsTest
 * @Description TODO
 * @Author 思绪醉流往年
 * @Date 2020/2/29 21:54
 * @Version 1.0
 **/
public class FileUtilsTest {
    public static void main(String[] args) {
        File file1 = new File("java06\\hello.txt");
        File file2 = new File("java06\\hello5.txt");
        try {
            FileUtils.copyFile(file1,file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
