package de.kaimon.schoolproject.kai.roomsort;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.ComparableContent;

public class Raum implements ComparableContent<Raum> {

    private int number;
    private boolean belegt;

    public Raum(int number, boolean belegt){
        this.number = number;
        this.belegt = belegt;
    }

    public int getNumber() {
        return number;
    }

    public boolean isBelegt() {
        return belegt;
    }

    public void setBelegt(boolean belegt) {
        this.belegt = belegt;
    }

    @Override
    public boolean isGreater(Raum pContent) {
        if(pContent.getNumber() < this.number) return true;
        return false;
    }

    @Override
    public boolean isEqual(Raum pContent) {
        if(pContent.getNumber() == this.number) return true;
        return false;
    }

    @Override
    public boolean isLess(Raum pContent) {
        if(pContent.getNumber() > this.number) return true;
        return false;
    }
}
