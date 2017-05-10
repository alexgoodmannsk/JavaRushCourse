package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем Singleton pattern
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static
    {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String name = reader.readLine();
            if(name.equals(Planet.EARTH)) thePlanet = Earth.getInstance();
            else if(name.equals(Planet.SUN)) thePlanet = Sun.getInstance();
            else if(name.equals(Planet.MOON)) thePlanet = Moon.getInstance();
            else thePlanet = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
