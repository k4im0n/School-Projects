package de.kaimon.schoolproject.kai;

import sas.View;
import sasio.Button;
import sasio.Textfield;

import java.awt.*;
import java.util.Scanner;

public class SetupCmd {

    private View view = new View(0,0);
    private Textfield textIn = new Textfield(10,10,200,20,"", view);
    private Button button = new Button(10,50,20,100,"Submit", Color.GRAY);
    private Scanner scanner = new Scanner(System.in);
    private final String outputExplanCmd =  "ext zum beenden\nspo für SlidePhysiksOnly\njpo für JumpPhysiksOnly\ncle für CheeseChampionLalEdition\ncto für CheeseChampionTrueOne\nccn für CheeseChampion Normal\nlol für lol\nbtt für binarytree traversion\npbs für Politicians BinarySearchTree\npbt für Politicians BinaryTree\nrso für Raum zuweisung\n\nMathematische Funktionen:\nfak+Fakultätzahl für Fakultät\nfib+WievielteZahl für Fibonachi\n\nConverter:\nmoc+IhrMorseCodeOderText für MorseConverter\n\nIhre Wahl:";

    public SetupCmd(){
        this(new String[]{});
    }

    public SetupCmd(String[] args) {
        String input = null;
        if(args.length > 0 && !args[0].equals("")) input = args[0];
        textIn.setHidden(true);
        button.setHidden(true);
        checkInput(input);
    }

    private void checkInput(String input){
        if(input != null){
            try {
                switch (input.trim().substring(0, 3)) {
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
                    case "ext" -> throw new Exception();
                    default -> throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e){
                System.out.println("bitte eine gültige eingabe");
            } catch (Exception e) {
                return;
            }
        }
        System.out.print(outputExplanCmd);
        checkInput(scanner.nextLine());
    }

    private String textinput(){
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
