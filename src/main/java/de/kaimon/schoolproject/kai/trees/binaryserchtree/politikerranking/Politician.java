package de.kaimon.schoolproject.kai.trees.binaryserchtree.politikerranking;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.ComparableContent;

public class PoliticianFame implements ComparableContent<PoliticianFame> {

    private int fame;
    private String name;

    public PoliticianFame(int fame, String name){
        this.name = name;
        this.fame = fame;
    }

    public int getFame() {
        return fame;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isGreater(PoliticianFame pContent) {
        if(pContent.getFame() < this.getFame()) return true;
        return false;
    }

    @Override
    public boolean isEqual(PoliticianFame pContent) {
        if(pContent.getFame() == this.getFame()) return true;
        return false;
    }

    @Override
    public boolean isLess(PoliticianFame pContent) {
        if(pContent.getFame() > this.getFame()) return true;
        return false;
    }
}
