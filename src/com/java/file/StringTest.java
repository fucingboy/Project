package com.java.file;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName StringTest
 * @Description 把字符串变大写，输入e或exit则退出
 * @Author 思绪醉流往年
 * @Date 2020/2/27 12:07
 * @Version 1.0
 **/
public class StringTest {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            while (true){
                System.out.println("请输入字符串：");
                String s = bufferedReader.readLine();
                String upperCase = s.toUpperCase();
                if ("E".equals(upperCase)||"EXIT".equals(upperCase)){
                    break;
                }
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader!=null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
