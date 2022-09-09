package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        String fileName;
        String inputText = "";
        String [] text;
        String wordToCheck;
        String reversedWord;
        StringBuilder stringBuilder;
        List<Integer> list = new ArrayList<>();
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = console.readLine();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()){
                inputText += reader.readLine() + " ";
            }
        }
        text = inputText.split(" ");
        for (int i = 0; i < text.length; i++) {
            wordToCheck = text[i];
            for (int j = i+1; j < text.length; j++) {
                stringBuilder = new StringBuilder(wordToCheck);
                reversedWord = String.valueOf(stringBuilder.reverse());
                if (text[j].equals(reversedWord)) {if (!list.contains(i) && !list.contains(j)) {list.add(i); list.add(j); Pair pair = new Pair(wordToCheck, reversedWord); result.add(pair);}}
            }

        }


        for (Pair pair: result){
            System.out.println(pair);
        }



    }

    public static class Pair {
        String first;
        String second;
        public Pair() {}

        public Pair(String first, String second){
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
