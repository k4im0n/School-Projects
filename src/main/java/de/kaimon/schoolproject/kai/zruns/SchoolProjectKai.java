package src.main.java.de.kaimon.schoolproject.kai.zruns;

import de.kaimon.schoolproject.kai.trees.treeconverter.MorseConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SchoolProjectKai {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = true;
        while (exit){

            System.out.print("""
                exit zum beenden
                cle für CheeseChampionLalEdition
                cto für CheeseChampionTrueOne
                cc für CheeseChampion
                fak für Fakultät
                fib für Fibonachi
                lol für lol
                btt für binarytree traversion
                moc für MorseConverter
                btc für BynaryConverter
                Ihre Wahl: """
            );



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
                    new de.kaimon.schoolproject.kai.trees.treetraversionen.Traversion();
                case "moc":
                    new MorseConverter();
                case "btc":
                    new de.kaimon.schoolproject.kai.trees.treeconverter.BinaryConverter();
                case "exit":
                    exit = false;
                    break;
                default:
                    System.out.println("bitte eine gültige eingabe");
            }
        }
    }
}
