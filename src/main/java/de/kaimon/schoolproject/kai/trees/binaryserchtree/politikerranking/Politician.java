package de.kaimon.schoolproject.kai.trees.binaryserchtree.politikerranking;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.ComparableContent;

public class Politician implements ComparableContent<Politician> {

    private int fame;
    private String name;
    private boolean sortByFame;

    public Politician(int fame, String name, boolean sortByFame){
        this.sortByFame = sortByFame;
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
    public boolean isGreater(Politician pContent) {
        if(sortByFame && pContent.getFame() < this.getFame()) return true;
        else if(pContent.getName().compareTo(this.getName()) < 0) return true;
        return false;
    }

    @Override
    public boolean isEqual(Politician pContent) {
        if(sortByFame && pContent.getFame() == this.getFame()) return true;
        else if(pContent.getName().compareTo(this.getName()) == 0) return true;
        return false;
    }

    @Override
    public boolean isLess(Politician pContent) {
        if(pContent.getFame() > this.getFame()) return true;
        else if(sortByFame && pContent.getName().compareTo(this.getName()) > 0) return true;
        return false;
    }

    public String print(){
        return getName() + ", Fame: " + getFame();
    }
}
