package de.kaimon.schoolproject.kai.cheesechampion;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.linear.Queue;
import sas.Tools;

public class CheeseChampion {

    private Queue<Mouse> start = new Queue<>();
    private Queue<Mouse> end = new Queue<>();
    private Queue<Mouse> center = new Queue<>();
    private GUI gui;

    public CheeseChampion() {
        int mice = Tools.randomNumber(3,9);
        for (int i = 0; i < mice; i++) {
            start.enqueue(new Mouse(i+1));
        }

        gui = new GUI(start, mice);

        while (!start.isEmpty()){
            if(center.isEmpty()){
                center.enqueue(start.front());
                start.dequeue();
            } else if(!center.isEmpty()) {
                if (start.front().getStrenght() == center.front().getStrenght()) {
                    center.enqueue(start.front());
                    start.dequeue();
                } else if (start.front().getStrenght() > center.front().getStrenght()) {
                    end.enqueue(start.front());
                    start.dequeue();
                } else if (start.front().getStrenght() < center.front().getStrenght()) {
                    end.enqueue(center.front());
                    center.dequeue();
                    center.enqueue(start.front());
                    start.dequeue();
                }
            }
        }

        while(!center.isEmpty()){
            end.enqueue(center.front());
            center.dequeue();
        }

        while (!end.isEmpty()) {
            System.out.println(end.front().getName() + " " + end.front().getStrenght());
            end.dequeue();
        }
    }
}
