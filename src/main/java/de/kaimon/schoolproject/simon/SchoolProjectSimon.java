package de.kaimon.schoolproject.simon;

import de.kaimon.schoolproject.simon.cheesechampiongui.CheeseChampion;
import de.kaimon.schoolproject.simon.cheesechampiongui.Mouse;

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
