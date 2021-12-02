package de.kaimon.schoolproject.kai.cheesechampion.cheesechampiontrueone;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.linear.Queue;
import de.kaimon.schoolproject.implementations.datenstrukturklassen.linear.Stack;
import sas.*;
import sas.Polygon;
import sas.Rectangle;

import java.awt.*;

public class CheeseChampion {

    private View view;
    private Rectangle border;
    private Rectangle background;
    private Polygon way;
    private int[] winPos = new int[2];
    private Queue<Mouse> start = new Queue<>();
    private Queue<Mouse> end = new Queue<>();
    private Stack<Mouse> center = new Stack<>();

    public CheeseChampion() {
        winPos[0] = 400;
        winPos[1] = 235;
        view = new View(620,420);
        border = new Rectangle(0,0,620,420,Color.BLUE);
        background = new Rectangle(10,10,600,400, Color.BLACK);
        way = new Polygon(10,210, Color.WHITE);
        way.add(-11,0);
        way.add(-11,100);
        way.add(621,100);
        way.add(621,0);
        way.add(450,0);
        way.add(239,-211);
        way.add(89,-211);
        way.add(300,0);

        int mice = Tools.randomNumber(3,9);
        for (int i = 0; i < mice; i++) {
            start.enqueue(new Mouse(i+1));
        }

        while (!start.isEmpty()){
            if(center.isEmpty()){
                while (start.front().getMaus().getShapeX() < 550) {
                    start.front().getMaus().move(2,0);
                    view.wait(10);
                }
                start.front().getMaus().moveTo(550,235);
                center.push(start.front());
                start.dequeue();
            } else if(!center.isEmpty()) {
                if (start.front().getStrenght() < center.top().getStrenght()) {
                    while (start.front().getMaus().getShapeX() < 250){
                        start.front().getMaus().move(2,0);
                        view.wait(10);
                    }
                    while (center.top().getMaus().getShapeX() > 400) {
                        center.top().getMaus().move(-2,0);
                        view.wait(10);
                    }
                    center.top().getMaus().moveTo(400,235);
                    while (center.top().getMaus().getShapeY() > -100){
                        center.top().getMaus().move(-2,-2);
                        view.wait(10);
                    }
                    while (start.front().getMaus().getShapeX() < 550){
                        start.front().getMaus().move(2);
                        view.wait(10);
                    }
                    start.front().getMaus().moveTo(550,235);
                    end.enqueue(center.top());
                    center.pop();
                    center.push(start.front());
                    start.dequeue();
                } else {
                    while (start.front().getMaus().getShapeX() < 250){
                        start.front().getMaus().move(2,0);
                        view.wait(10);
                    }
                    while (start.front().getMaus().getShapeX() < 550){
                        start.front().getMaus().move(2);
                        center.top().getMaus().move(2);
                        view.wait(10);
                    }
                    start.front().getMaus().moveTo(550,235);
                    center.top().getMaus().moveTo(700,235);
                    center.push(start.front());
                    start.dequeue();
                }
            }
        }

        while(!center.isEmpty()){

            while (center.top().getMaus().getShapeX() > 400) {
                center.top().getMaus().move(-2,0);
                view.wait(10);
            }
            center.top().getMaus().moveTo(400,235);
            while (center.top().getMaus().getShapeY() > -100){
                center.top().getMaus().move(-2,-2);
                view.wait(10);
            }

            end.enqueue(center.top());
            center.pop();


            if(!center.isEmpty()) {
                while (center.top().getMaus().getShapeX() > 550) {
                    center.top().getMaus().move(-2, 0);
                    view.wait(10);
                }
                center.top().getMaus().moveTo(550, 235);
            }
        }
        int i = 0;
        while (!end.isEmpty()) {
            end.front().getMaus().moveTo(20 + i,20);
            end.dequeue();
            i = i + 80;
        }
    }
}
