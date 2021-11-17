package de.kaimon.schoolproject.simon.cheesechampiongui;

import sas.Tools;

public class Mouse {

    private int strenght;

    public Mouse() {
        this.strenght = Tools.randomNumber(0, 99);
    }

    public Mouse(int strenght) {
        this.strenght = strenght;
    }

    public 

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public void setRandomStrenght() {
        this.strenght = Tools.randomNumber(0, 99);
    }

    public void setRandomStrenght(int start, int end) {
        this.strenght = Tools.randomNumber(start, end);
    }

    @Override
    public String toString() {
        return "Mouse{strenght=" + strenght + '}';
    }
}
