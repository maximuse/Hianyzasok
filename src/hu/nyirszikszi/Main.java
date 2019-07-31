package hu.nyirszikszi;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Hianyzasok> list = Actions.fileToList("szeptember.csv");

        System.out.println("2. feladat: " + Actions.task2(list));

        System.out.println("3. feladat:");
        Actions.task3();

        System.out.println("4. feladat: " + Actions.task4(list));

        System.out.println("5. feladat: " + Actions.task5(list));

        System.out.println("6. feladat: " + Actions.task6(list, "osszesites.csv"));
    }
}