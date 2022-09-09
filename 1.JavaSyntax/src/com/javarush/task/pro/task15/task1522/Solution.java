package com.javarush.task.pro.task15.task1522;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

/* 
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://javarush.ru/api/1.0/rest/projects");
        //напишите тут ваш код
        InputStream inputStream = url.openStream();
        byte [] arrayByte = inputStream.readAllBytes();
        String  line   = new String(arrayByte);
        System.out.println(line);

    }
}