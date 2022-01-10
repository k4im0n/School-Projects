package de.kaimon.schoolproject.kai;

class Meldung {
    private int autobahn;
    private String richtung;
    private int laenge;
    private int zeitbedarf;

    public Meldung (int pAutobahn, String pRichtung, int pZeitbedarf){
        autobahn = pAutobahn;
        richtung = pRichtung;
        zeitbedarf = pZeitbedarf;
    }

    public int getAutobahn (){
        return autobahn;
    }

    public String getRichtung (){
        return richtung;
    }

    public int getZeitbedarf (){
        return zeitbedarf;
    }

}
