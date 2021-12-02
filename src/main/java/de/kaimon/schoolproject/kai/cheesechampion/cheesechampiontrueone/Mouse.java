package de.kaimon.schoolproject.kai.cheesechampion.cheesechampiontrueone;

import sas.Circle;
import sas.Sprite;
import sas.Text;
import sas.Tools;

import java.awt.*;

public class Mouse {

    private int strenght;
    private int nummber;
    private Sprite maus;

    public Mouse(int nummber) {
        strenght = Tools.randomNumber(1,10);
        this.nummber = nummber;
        maus = new Sprite();
        maus.add(new Circle(-100, 235,25, Color.GRAY));
        maus.add(new Text(-90,270,"Nr. " + nummber));
        maus.add(new Text(-90,240,"S: " + strenght));
    }

    public Sprite getMaus() {
        return maus;
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
}
