package de.kaimon.schoolproject.kai.trees.binaryserchtree.politikerranking;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.ComparableContent;

public class PoliticianName implements ComparableContent<PoliticianName> {

    private int fame;
    private String name;

    public PoliticianName(int fame, String name){
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
    public boolean isGreater(PoliticianName pContent) {
        if(pContent.getName().compareTo(this.getName()) < 0) return true;
        return false;
    }

    @Override
    public boolean isEqual(PoliticianName pContent) {
        if(pContent.getName().compareTo(this.getName()) == 0) return true;
        return false;
    }

    @Override
    public boolean isLess(PoliticianName pContent) {
        if(pContent.getName().compareTo(this.getName()) > 0) return true;
        return false;
    }
}
