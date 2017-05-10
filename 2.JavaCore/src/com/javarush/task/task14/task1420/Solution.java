package com.javarush.task.task14.task1420;

/* 
НОД
*/

import javafx.collections.transformation.SortedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
        int x1=1,x2=1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        x1 = Integer.parseInt(reader.readLine());
        if(x1<=0) throw new Exception();
        x2 = Integer.parseInt(reader.readLine());
        if(x2<=0) throw new Exception();
        System.out.println(nodSolve(solveDelit(x1), solveDelit(x2)));
    }

    static List<Integer> solveDelit(int a)
    {
        List<Integer> del = new ArrayList<Integer>();
        for(int i = 1; i <=a; i++)
        {
            if(a%i == 0) del.add(i);
        }
        return del;
    }

    static int nodSolve(List<Integer> a, List<Integer> b)
    {
        int nod = 1;
        for(int i = 0; i < a.size(); i++){
            if (b.contains(a.get(a.size()-1-i))){
                nod = a.get(a.size()-1-i);
                break;
            }
        }
        return nod;
    }
}
