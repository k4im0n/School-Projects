package de.kaimon.schoolproject.kai;

import sas.View;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SetupCmd {

    View view = new View(0,0);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public SetupCmd() throws IOException {
        boolean exit = true;
        while (exit){

            System.out.print("""
                ext zum beenden
                spo für SlidePhysiksOnly
                jpo für JumpPhysiksOnly
                cle für CheeseChampionLalEdition
                cto für CheeseChampionTrueOne
                ccn für CheeseChampion Normal
                lol für lol
                btt für binarytree traversion
                pbs für Politicians BinarySearchTree
                pbt für Politicians BinaryTree
                rso für Raum zuweisung
                
                Mathematische Funktionen:
                fak+Fakultätzahl für Fakultät
                fib+WievielteZahl für Fibonachi
                
                Converter:
                moc+IhrMorseCodeOderText für MorseConverter
                
                Ihre Wahl:""" + " "
            );



            String input = reader.readLine();
            switch (input.substring(0, 3)) {
                case "spo" -> new de.kaimon.schoolproject.kai.physiksonly.SlidePhysiksOnly(view);
                case "jpo" -> new de.kaimon.schoolproject.kai.physiksonly.JumpPhysiksOnly(view);
                case "cle" -> new de.kaimon.schoolproject.kai.cheesechampion.cheesechampionlaledition.CheeseChampion(view);
                case "cto" -> new de.kaimon.schoolproject.kai.cheesechampion.cheesechampiontrueone.CheeseChampion(view);
                case "ccn" -> new de.kaimon.schoolproject.kai.cheesechampion.cheesechampion.CheeseChampion(view);
                case "fak" -> new de.kaimon.schoolproject.kai.fackultet.FackUltet(input, view);
                case "fib" -> new de.kaimon.schoolproject.kai.fibonachi.Fibonachi(input, view);
                case "lol" -> new de.kaimon.schoolproject.kai.balljumpgame.BallJumpGame(view);
                case "btt" -> new de.kaimon.schoolproject.kai.trees.treetraversionen.Traversion(view, new int[]{5, 13, 10, 18, 30, 20, 15, 36, 39, 38, 49, 55, 51, 47, 33});
                case "moc" -> new de.kaimon.schoolproject.kai.trees.treeconverter.MorseConverter(input, view);
                case "pbs" -> new de.kaimon.schoolproject.kai.trees.binaryserchtree.politikerranking.Start();
                case "pbt" -> new de.kaimon.schoolproject.kai.trees.politikerranking.Start();
                case "rso" -> new de.kaimon.schoolproject.kai.roomsort.Manage();
                case "ext" -> exit = false;
                default -> System.out.println("bitte eine gültige eingabe");
            }
        }
    }
}
