package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.*;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        InputStreamReader reader= new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String file = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(fileInputStream);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
           list.add(Integer.parseInt(scanner.nextLine()));
        }
        list.stream().filter(a -> a%2==0).sorted(Comparator.comparingInt(a -> a)).forEach(System.out::println);


fileInputStream.close();
reader.close();


    }
}
