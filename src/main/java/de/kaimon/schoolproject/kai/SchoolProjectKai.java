package de.kaimon.schoolproject.kai;

import de.kaimon.schoolproject.kai.cheesechampion.cheesechampiontrueone.CheeseChampion;
import de.kaimon.schoolproject.kai.fackultät.FackUltät;
import de.kaimon.schoolproject.kai.fibonachi.Fibonachi;
import de.kaimon.schoolproject.kai.fibonachi.FindFibonachi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SchoolProjectKai {

    public static void main(String[] args) throws IOException {

        new FindFibonachi(8);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = true;
        while (exit){

            System.out.println("exit zum beenden");
            System.out.println("cle für CheeseChampionLalEdition");
            System.out.println("cto für CheeseChampionTrueOne");
            System.out.println("cc für CheeseChampion");
            System.out.println("fak für Fakultät");
            System.out.println("fib für Fibonachi");
            System.out.println("lol für lol");
            System.out.println("btt für binarytree traversion");
            System.out.print("Ihre Wahl: ");



            String input = reader.readLine();
            switch (input) {
                case "cle":
                    new de.kaimon.schoolproject.kai.cheesechampion.cheesechampionlaledition.CheeseChampion();
                    break;
                case "cto":
                    new de.kaimon.schoolproject.kai.cheesechampion.cheesechampiontrueone.CheeseChampion();
                    break;
                case "cc":
                    new de.kaimon.schoolproject.kai.cheesechampion.cheesechampion.CheeseChampion();
                    break;
                case "fak":
                    System.out.print("Fakultät Zahl: ");
                    new de.kaimon.schoolproject.kai.fackultät.FackUltät(Integer.parseInt(reader.readLine()));
                    break;
                case "fib":
                    System.out.print("Fibonachi Zahl: ");
                    new de.kaimon.schoolproject.kai.fibonachi.Fibonachi(Integer.parseInt(reader.readLine()));
                    break;
                case "lol":
                    new de.kaimon.schoolproject.kai.lol.Lol();
                    break;
                case "btt":
                    new de.kaimon.schoolproject.kai.treetraversionen.Traversion();
                case "exit":
                    exit = false;
                    break;
                default:
                    System.out.println("bitte eine gültige eingabe");
            }
        }
    }
}
