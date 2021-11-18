package de.kaimon.schoolproject.simon.cheesechampiongui;

import sas.*;

import java.awt.Color;

public class GUI {

    private final View window;

    public GUI() {
        this.window = new View();
        this.window.setSize(800, 600);
        this.window.setName("CheeseChampion - By Simon Oberzier");
        this.window.setBackgroundColor(Color.WHITE);
        drawMap();
    }

    private void drawMap() {
        new Rectangle(0, 240, 800, 60, Color.BLACK);
        Rectangle rectangle = new Rectangle(200, 0, 60, 345, Color.BLACK);
        rectangle.turn(200, 0, -30);
    }
}
