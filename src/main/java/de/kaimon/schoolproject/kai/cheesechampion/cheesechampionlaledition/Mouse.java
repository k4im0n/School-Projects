package de.kaimon.schoolproject.kai.cheesechampion.cheesechampionlaledition;

import sas.Circle;
import sas.Sprite;
import sas.Text;
import sas.Tools;

import java.awt.*;

public class Mouse {

    private int strenght;
    private int nummber;
    private Sprite mouse;

    public Mouse(double x, double y) {
        strenght = Tools.randomNumber(1,10);
        this.nummber = nummber;
        mouse = new Sprite(new Circle(x,y,20, new Color(100,70,50)));
        mouse.add(new Text(x + 15, y, "" + strenght));
    }

    public String getName(){
        return "Maus";
    }

    public int getStrenght() {
        return strenght;
    }

    public int getNummber() {
        return nummber;
    }

    public Sprite getMouse() {
        return mouse;
    }
}
