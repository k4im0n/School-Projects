package de.kaimon.schoolproject.simon;

import de.kaimon.schoolproject.simon.cheesechampion.CheeseChampion;
import de.kaimon.schoolproject.simon.cheesechampion.Mouse;

public class SchoolProjectSimon {

    private final static CheeseChampion cheeseChampion = new CheeseChampion();

    public static void main(String[] args) {
        cheeseChampion.insertMouse(new Mouse());
        cheeseChampion.insertMouse(new Mouse());
        cheeseChampion.insertMouse(new Mouse());
        cheeseChampion.printInput();
        cheeseChampion.playSimulation();
        cheeseChampion.printOutput();
    }
}
