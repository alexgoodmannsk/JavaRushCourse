package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        int N = a.length;
        int x = 0;
        int y = 0;
        int x1 = 0;
        int y1 = 0;
        for(int i=0; i<N; i++){
            for (int j = 0; j<N; j++){
                if(a[i][j]==1){
                    x=i;
                    y=j;
                    x1 = i;
                    y1 = j;
                    while (x1<N){
                        if(a[x1][y1]==1) x1++;
                        else break;
                    }
                    x1--;
                    while (y1<N){
                        if(a[x][y1]==1) y1++;
                        else break;
                    }
                    y1--;
                    for (int k = x; k < x1+1; k++) {
                        for (int l = y; l <y1+1 ; l++) {
                            a[k][l] = 2;
                        }
                    }
                    count++;
                }
            }
        }

        return count;
    }
}
