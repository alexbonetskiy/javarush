package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;
        String inputText = "";
        String [] text;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = console.readLine();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()){
                inputText += reader.readLine() + " ";
            }
        }
        text = inputText.split(" ");
        StringBuilder result = getLine(text);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        int j = 1;
        boolean flag = false;
        List<String> duplicate = Arrays.asList(words);
        List<Integer> list = new ArrayList<>();
        List <String> strings = new ArrayList<>();
        List <String> banned = new ArrayList<>();
        char lastChar = words[0].charAt(words[0].length()-1);
        StringBuilder stringBuilder =  new StringBuilder();
        if (words.length == 0) return stringBuilder;
        stringBuilder.append(words[0]).append(" ");
        System.out.println(words[0].charAt(0));
        int i = 0;
        int word = words[0].charAt(words[0].length()-1);
        System.out.println(word);
        list.add(0);
        strings.add(words[0]);
        while(list.size()< words.length){
            if (i == words.length){
                for (int k = 0; k <strings.size() ; k++) {
                    for (int l = 0; l < words.length; l++) {
                        if (strings.get(k).charAt(0) == words[l].charAt(0) && !strings.get(k).equals(words[l]) && !banned.contains(words[l]) && !banned.contains(strings.get(k)) ) {
                            for (int m = k; m < strings.size(); m++) {
                                banned.add(words[l]);
                                banned.add(strings.get(k));
                                list.remove((Object)duplicate.indexOf(strings.get(k)));
                                strings.remove(m);
                                strings.add(words[l]);
                                lastChar = words[l].charAt(words[l].length()-1);
                                flag = true;
                                break;
                            }
                        }
                    }
                }
                if (flag){
                stringBuilder = new StringBuilder();
                for (int k = 0; k < strings.size(); k++) {
                    stringBuilder.append(strings.get(k)).append(" ");
                    i=0; flag = false;}
                }

            } if (i==words.length)
            {list.clear(); strings.clear(); banned.clear(); stringBuilder = new StringBuilder(); list.add(j); strings.add(words[j]); stringBuilder.append(words[j]).append(" "); lastChar = words[j].charAt(words[j].length()-1);  j++; i = 0; }
            if ( lastChar ==((words[i].charAt(0)) +32)  && !list.contains(i)) {
                stringBuilder.append(words[i]).append(" ");
                lastChar = words[i].charAt(words[i].length()-1);
                list.add(i); strings.add(words[i]); i = 0; continue;
            }
            i++;

        }

    return stringBuilder;
    }


}
