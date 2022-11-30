package de.kaimon.schoolproject.kai.automaten;


public class DEATester {

    private int zPos;
    private int zFehler, zZustand;
    private boolean zEndzustand;

    public DEATester () {
        zPos = 0;
        zZustand = 0;
        zFehler = 0;
        zEndzustand = false;
    }

    public int pruefe(String zEingabe) {
    /* Zustand 0   Start S
       Zustand 1   gerade
       Zustand 2   ungerade
    */
        zFehler = -1; zPos = 0;
        zZustand = 0; // Startzustand
        zEndzustand = false;

        while ((zFehler == -1) &&(zPos < zEingabe.length())) {

            switch (zZustand) {
                case 0 :
                    switch (zEingabe.charAt(zPos)) {
                        case  '0' : zZustand =1;  break;
                        case  '1' : zZustand =2;  break;
                        default:
                            zFehler = zPos;
                    } // end of switch
                    break;
                case 1 :
                    switch (zEingabe.charAt(zPos)) {
                        case  '0' : zZustand =1;  break;
                        case  '1' : zZustand =2;  break;
                        default:
                            zFehler = zPos;
                    } // end of switch
                    break;
                case 2 :
                    switch (zEingabe.charAt(zPos)) {
                        case  '0' : zZustand =2;  break;
                        case  '1' : zZustand =1;  break;
                        default:
                            zFehler = zPos;
                    } // end of switch
                    break;

                default: zFehler = zPos;
            } // end of switch
            zPos++;
        } // end of while

        zEndzustand = (zZustand == 1) ;
        if (!zEndzustand) { zFehler = zFehler + 101; }
        
        return zFehler;
    }
}
