package de.kaimon.schoolproject.kai.politikerranking.binaryserchtree;

import sas.Tools;

public class Election {

    int politiciansCount = Tools.randomNumber(3,10);
    Politician politicians[] = new Politician[politiciansCount];

    public Election(){
        for (int i = 0; i < politicians.length; i++){
            politicians[i] = new Politician(Tools.randomNumber(0,100), "Politician Nr." + (i+1));
        }
    }
}
