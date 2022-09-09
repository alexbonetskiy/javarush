package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        int [] letters;
        int startX;
        int startY;
        int endX;
        int endY;
        int index = 0;
        int lengthX = crossword.length;
        int lengthY = crossword[0].length;
        int x;
        int y;
        List<Word> list = new ArrayList<>();
        Word result;
        for (int i = 0; i < words.length; i++) {
            letters = new int [words[i].length()];
            for (int j = 0; j < words[i].length(); j++) {
                letters[j] = words[i].charAt(j);
            }
            for (int j = 0; j < lengthX ; j++) {
                for (int k = 0; k < lengthY; k++) {
                    if(crossword[j][k]== letters [index]){ index++; startX = j; startY = k;
                        x = startX-1; y= startY-1;
                        while (x>=0 && y>=0){
                            if (crossword[x][y] == letters[index]) {
                                if (index == words[i].length()-1) {result = new Word(words[i]); result.setStartPoint(startY,startX); result.setEndPoint(y,x); list.add(result); index = 0; break;}
                                index++;
                                x--; y--;
                            } else break;}
                        x=startX; y=startY+1;
                        while (y<lengthY){
                            if (crossword[x][y] == letters[index]) {
                                if (index == words[i].length()-1) {result = new Word(words[i]); result.setStartPoint(startY,startX); result.setEndPoint(y,x); list.add(result); index = 0; break;}
                                index++;
                                y++;
                            } else break;
                        }




                    }

                }

            }

        }

        System.out.println(list);
        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}





