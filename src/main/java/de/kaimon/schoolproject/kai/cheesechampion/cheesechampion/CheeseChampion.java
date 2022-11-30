package de.kaimon.schoolproject.kai.cheesechampion.cheesechampion;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.linear.Queue;
import sas.Text;
import sas.Tools;
import sas.View;

public class CheeseChampion {

    private Queue<Mouse> start = new Queue<>();
    private Queue<Mouse> end = new Queue<>();
    private Queue<Mouse> center = new Queue<>();
    View view;
    Text text;

    public CheeseChampion(View view) {
        this.view = view;
        setup();
        run();
        end();
    }

    void setup(){
        view.setSize(200,40);
        text = new Text(10,10, "");
    }
    void run(){
        int mice = Tools.randomNumber(3,9);
        for (int i = 0; i < mice; i++) {
            start.enqueue(new Mouse(i+1));
        }

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
            text.setText(end.front().getName() + " " + end.front().getStrenght());
            end.dequeue();
        }
    }

    void end(){
        view.remove(text);
        view.setSize(0,0);
    }
}
