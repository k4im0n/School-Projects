package de.kaimon.schoolproject.kai.cheesechampion;

import sas.Tools;

public class Mouse {

    private int strenght;
    private int nummber;

    public Mouse(int nummber) {
        strenght = Tools.randomNumber(1,10);
        this.nummber = nummber;
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
