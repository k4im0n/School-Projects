package de.kaimon.schoolproject.simon.politiciantree;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.ComparableContent;

public class Politician implements ComparableContent<Politician> {

    private final String name;
    private final String surname;
    private final int fame;
    private CompareType compareType;

    public Politician(String name, String surname, int fame) {
        this.name = name;
        this.surname = surname;
        this.fame = fame;
    }

    public Politician(String name, String surname, int fame, CompareType compareType) {
        this.name = name;
        this.surname = surname;
        this.fame = fame;
        this.compareType = compareType;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getFame() {
        return fame;
    }

    public CompareType getCompareType() {
        return compareType;
    }

    public void setCompareType(CompareType compareType) {
        this.compareType = compareType;
    }

    @Override
    public boolean isGreater(Politician pContent) {
        if (this.compareType == null) return false;
        return switch (this.compareType) {
            case FAME -> this.fame > pContent.fame;
            case NAME -> this.name.compareTo(pContent.name) > 0;
            case SURNAME -> this.surname.compareTo(pContent.surname) > 0;
            case FULL_NAME -> (this.name + this.surname).compareTo(pContent.name + pContent.surname) > 0;
        };
    }

    @Override
    public boolean isEqual(Politician pContent) {
        if (this.compareType == null) return false;
        return switch (this.compareType) {
            case FAME -> this.fame == pContent.fame;
            case NAME -> this.name.equals(pContent.name);
            case SURNAME -> this.surname.equals(pContent.surname);
            case FULL_NAME -> (this.name + this.surname).equals(pContent.name + pContent.surname);
        };
    }

    @Override
    public boolean isLess(Politician pContent) {
        if (this.compareType == null) return false;
        return switch (this.compareType) {
            case FAME -> this.fame < pContent.fame;
            case NAME -> this.name.compareTo(pContent.name) < 0;
            case SURNAME -> this.surname.compareTo(pContent.surname) < 0;
            case FULL_NAME -> (this.name + this.surname).compareTo(pContent.name + pContent.surname) < 0;
        };
    }

    @Override
    public String toString() {
        return "Politician{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fame=" + fame +
                '}';
    }
}
