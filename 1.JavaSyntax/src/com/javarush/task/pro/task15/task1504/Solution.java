package com.javarush.task.pro.task15.task1504;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;





/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        try (Scanner scanner = new Scanner(System.in);
        InputStream is = Files.newInputStream(Path.of(scanner.nextLine()));
        OutputStream os = Files.newOutputStream(Path.of(scanner.nextLine()))){
        byte[] array = is.readAllBytes();
        for (int i = 0; i <array.length-1 ; i=i+2) {
            byte a = array[i+1];
            array[i+1]=array[i];
            array[i] = a; }
        os.write(array);
            }

}}

