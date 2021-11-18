package de.kaimon.schoolproject.kai.Mice;

import sas.Polygon;
import sas.Rectangle;
import sas.Shapes;
import sas.View;

import java.awt.*;

public class Start {

    public Start() {
        new View(800,600);
        new Rectangle(0,0,800,600, Color.GRAY);
        Polygon lal = new Polygon(0,300);
        lal.add(0,100);//links unten
        lal.add(800,100);//rechts unten
        lal.add(800,0);//rechts oben
        lal.add(480,0);//mitte-rechts unten
        lal.add(180,-250);//mitte-rechts oben
        lal.add(0,-250);//mitte-links oben
        lal.add(300,0);//mitte-links unten


    }
}
