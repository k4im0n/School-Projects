package de.kaimon.schoolproject.kai;

import sas.View;
import sasio.Button;
import java.awt.*;

public class Setup {

    View view = new View(220,210);

    int width = 200;

    Button slidePhysiksOnly =           new Button(10, 10, width,30, "slidePhysiksOnly (1)", Color.GRAY);
    Button jumpPhysiksOnly =            new Button(10, 50, width,30,"jumpPhysiksOnly (2)", Color.GRAY);
    Button cheeseChampionLalEdition =   new Button(10, 90, width,30,"cheeseChampionLalEdition (3)", Color.GRAY);
    Button cheeseChampionTrueOne =      new Button(10,130, width,30,"cheeseChampionTrueOne (4)", Color.GRAY);
    Button ballJumpGame =               new Button(10,170, width,30,"ballJumpGame (5)", Color.GRAY);

    public Setup(){
        boolean exit = true;
        while (exit){
            if(slidePhysiksOnly.clicked() || view.keyPressed('1')) {
                show(false);
                new de.kaimon.schoolproject.kai.physiksonly.SlidePhysiksOnly(view);
                show(true);
            }
            else if(jumpPhysiksOnly.clicked() || view.keyPressed('2')) {
                show(false);
                new de.kaimon.schoolproject.kai.physiksonly.JumpPhysiksOnly(view);
                show(true);
            }
            else if(cheeseChampionLalEdition.clicked() || view.keyPressed('3')) {
                show(false);
                new de.kaimon.schoolproject.kai.cheesechampion.cheesechampionlaledition.CheeseChampion(view);
                show(true);
            }
            else if(cheeseChampionTrueOne.clicked() || view.keyPressed('4')) {
                show(false);
                new de.kaimon.schoolproject.kai.cheesechampion.cheesechampiontrueone.CheeseChampion(view);
                show(true);
            }
            else if(ballJumpGame.clicked() || view.keyPressed('5')) {
                show(false);
                new de.kaimon.schoolproject.kai.balljumpgame.BallJumpGame(view);
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
        ballJumpGame.setHidden(!show);
        if(show) view.setSize(220,250);
    }
}
