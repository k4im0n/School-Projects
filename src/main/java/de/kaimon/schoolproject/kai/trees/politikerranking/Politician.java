package de.kaimon.schoolproject.kai.trees.politikerranking;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.ComparableContent;

public class Politician {

    private int fame;
    private String name;

    public Politician(int fame, String name){
        this.name = name;
        this.fame = fame;
    }

    public int getFame() {
        return fame;
    }

    public String getName() {
        return name;
    }
}
