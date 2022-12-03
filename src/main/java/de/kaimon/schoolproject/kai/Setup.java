package de.kaimon.schoolproject.kai;

import sas.View;
import sasio.Button;
import sasio.Textfield;

import java.awt.*;
import java.io.IOException;

public class TempSetup {

    int vWidth = 220;
    int vHeight = 530;

    View view = new View(vWidth,vHeight);

    int width = 200;

    Button slidePhysiksOnly =           new Button(10, 10, width,30, "slidePhysiksOnly", Color.GRAY);
    Button jumpPhysiksOnly =            new Button(10, 50, width,30,"jumpPhysiksOnly", Color.GRAY);
    Button cheeseChampionLalEdition =   new Button(10, 90, width,30,"cheeseChampionLalEdition", Color.GRAY);
    Button cheeseChampionTrueOne =      new Button(10,130, width,30,"cheeseChampionTrueOne", Color.GRAY);
    Button cheeseChampion =             new Button(10,170, width,30,"cheeseChampion", Color.GRAY);
    Button fakultaet =                  new Button(10,210, width,30,"fakultaet", Color.GRAY);
    Button fibonachi =                  new Button(10,250, width,30,"fibonachi", Color.GRAY);
    Button ballJumpGame =               new Button(10,290, width,30,"ballJumpGame", Color.GRAY);
    Button binaryTreeTransversion =     new Button(10,330, width,30,"binaryTreeTransversion", Color.GRAY);
    Button morseConverter =             new Button(10,370, width,30,"morseConverter", Color.GRAY);
    Button politikerBinarySearch =      new Button(10,410, width,30,"politiker ranking BinarySearch", Color.GRAY);
    Button politikrRanking =            new Button(10,450, width,30,"politikrRanking", Color.GRAY);
    Button roomSort =                   new Button(10,490, width,30,"roomSort", Color.GRAY);

    Textfield textIn = new Textfield(10,10,200,20,"", view);
    Button button = new Button(10,40,200,20,"Submit", Color.GRAY);

    public TempSetup() throws IOException {
        textIn.setHidden(true);
        button.setHidden(true);
        boolean exit = true;
        while (exit){
            view.wait(10);
            if(slidePhysiksOnly.clicked()) {
                show(false);
                new de.kaimon.schoolproject.kai.physiksonly.SlidePhysiksOnly(view);
                show(true);
            }
            else if(jumpPhysiksOnly.clicked()) {
                show(false);
                new de.kaimon.schoolproject.kai.physiksonly.JumpPhysiksOnly(view);
                show(true);
            }
            else if(cheeseChampionLalEdition.clicked()) {
                show(false);
                new de.kaimon.schoolproject.kai.cheesechampion.cheesechampionlaledition.CheeseChampion(view);
                show(true);
            }
            else if(cheeseChampionTrueOne.clicked()) {
                show(false);
                new de.kaimon.schoolproject.kai.cheesechampion.cheesechampiontrueone.CheeseChampion(view);
                show(true);
            }
            else if(cheeseChampion.clicked()){
                show(false);
                new de.kaimon.schoolproject.kai.cheesechampion.cheesechampion.CheeseChampion(view);
                show(true);
            }
            else if(fakultaet.clicked()){
                show(false);
                new de.kaimon.schoolproject.kai.fackultet.FackUltet(textinput(),view);
                show(true);
            }
            else if(fibonachi.clicked()){
                show(false);
                new de.kaimon.schoolproject.kai.fibonachi.Fibonachi(textinput(), view);
                show(true);
            }
            else if(ballJumpGame.clicked()) {
                show(false);
                new de.kaimon.schoolproject.kai.balljumpgame.BallJumpGame(view);
                show(true);
            }
            else if(binaryTreeTransversion.clicked()){
                show(false);
                new de.kaimon.schoolproject.kai.trees.treetraversionen.Traversion(view, new int[]{5, 13, 10, 18, 30, 20, 15, 36, 39, 38, 49, 55, 51, 47, 33});
                show(true);
            }
            else if(morseConverter.clicked()){
                show(false);
                new de.kaimon.schoolproject.kai.trees.treeconverter.MorseConverter(textinput(), view);
                show(true);
            }
            else if(politikerBinarySearch.clicked()){
                show(false);
                new de.kaimon.schoolproject.kai.trees.binaryserchtree.politikerranking.Start();
                show(true);
            }
            else if(politikrRanking.clicked()){
                show(false);
                new de.kaimon.schoolproject.kai.trees.politikerranking.Start();
                show(true);
            }
            else if(roomSort.clicked()){
                show(false);
                new de.kaimon.schoolproject.kai.roomsort.Manage();
                show(true);
            }
            else if(view.keyPressed('0')) {
                exit = false;
            }
            view.keyBufferDelete();
        }
    }

    public void show(boolean show){
        slidePhysiksOnly.setHidden(!show);
        jumpPhysiksOnly.setHidden(!show);
        cheeseChampionLalEdition.setHidden(!show);
        cheeseChampionTrueOne.setHidden(!show);
        cheeseChampion.setHidden(!show);
        fakultaet.setHidden(!show);
        fibonachi.setHidden(!show);
        ballJumpGame.setHidden(!show);
        binaryTreeTransversion.setHidden(!show);
        morseConverter.setHidden(!show);
        politikerBinarySearch.setHidden(!show);
        politikrRanking.setHidden(!show);
        roomSort.setHidden(!show);
        if(show) view.setSize(vWidth,vHeight);
    }

    private String textinput() throws IOException{
        view.setSize(220,70);
        textIn.setHidden(false);
        button.setHidden(false);
        textIn.setActivated(true);
        boolean loll = true;
        while (loll){
            if(button.clicked()){
                view.setSize(0,0);
                textIn.setHidden(true);
                button.setHidden(true);
                loll = false;
                return textIn.getText();
            }
            view.wait(10);
        }
        return "";
    }
}
