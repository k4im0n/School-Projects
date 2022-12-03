package de.kaimon.schoolproject.kai;

import jdk.jfr.ContentType;
import sas.Text;
import sas.View;
import sasio.Button;
import sasio.Textfield;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SetupCmd {

    View view = new View(0,0);
    Textfield textIn = new Textfield(10,10,200,20,"", view);
    Button button = new Button(10,50,20,100,"Submit", Color.GRAY);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public SetupCmd() throws IOException {
        textIn.setHidden(true);
        button.setHidden(true);
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
                case "fak" -> new de.kaimon.schoolproject.kai.fackultet.FackUltet(textinput(),view);
                case "fib" -> new de.kaimon.schoolproject.kai.fibonachi.Fibonachi(textinput(), view);
                case "lol" -> new de.kaimon.schoolproject.kai.balljumpgame.BallJumpGame(view);
                case "btt" -> new de.kaimon.schoolproject.kai.trees.treetraversionen.Traversion(view, new int[]{5, 13, 10, 18, 30, 20, 15, 36, 39, 38, 49, 55, 51, 47, 33});
                case "moc" -> new de.kaimon.schoolproject.kai.trees.treeconverter.MorseConverter(textinput(), view);
                case "pbs" -> new de.kaimon.schoolproject.kai.trees.binaryserchtree.politikerranking.Election("name", view);
                case "pbt" -> new de.kaimon.schoolproject.kai.trees.politikerranking.Election("name", view);
                case "rso" -> new de.kaimon.schoolproject.kai.roomsort.Manage();
                case "ext" -> exit = false;
                default -> System.out.println("bitte eine gültige eingabe");
            }
        }
    }

    private String textinput() throws IOException {
        view.setSize(600,600);
        textIn.deleteText();
        textIn.setHidden(false);
        button.setHidden(false);
        textIn.setActivated(true);
        boolean exit = false;
        while (!exit){
            if(button.clicked() || textIn.enterPressed()){
                view.setSize(0,0);
                textIn.setHidden(true);
                button.setHidden(true);
                return textIn.getText();
            }
            if(view.keyPressed('0')) exit = true;
            view.wait(10);
        }
        return "";
    }
}
