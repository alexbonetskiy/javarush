package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        byte[][] test = a;
        int lengthX = a.length;
        int lengthY = a[0].length;
        int startX ;
        int endX ;
        int startY ;
        int endY ;
        int count =0;
        for (int i = 0; i < lengthX; i++) {
            for (int j = 0; j < lengthY; j++) {
                if (test[i][j] == 1)
                {startX = i; startY = j;
                    endX =startX;
                    for (int k = startX; k <lengthX ; k++) {

                        if (test[k][j]==0) break;
                        endX++;

                    }
                    endY = startY;
                    for (int k = startY; k <lengthY ; k++) {

                        if (test[i][k]==0) break;
                        endY++;

                    }
                    for (int k = startX; k <endX ; k++) {
                        for (int l = startY; l <endY ; l++) {
                            test [k][l]=0;
                        }

                    }

                  count++;
                }

            }
        }

        return count;
    }


}

