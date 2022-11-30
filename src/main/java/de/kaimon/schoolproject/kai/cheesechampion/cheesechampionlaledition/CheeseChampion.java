package de.kaimon.schoolproject.kai.cheesechampion.cheesechampionlaledition;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.linear.Queue;
import org.jetbrains.annotations.NotNull;
import sas.*;
import sas.Rectangle;

import java.awt.*;

public class CheeseChampion {

    private int[] x = new int[9];
    private int[] y = new int[9];

    private View view;

    private Queue<Mouse> startQueue = new Queue<>();
    private Queue<Mouse> endQueue = new Queue<>();
    private Queue<Mouse> centerQueue = new Queue<>();

    private Rectangle background;
    private Rectangle start;
    private Rectangle fight;
    private Rectangle center;
    private Rectangle end;

    private Rectangle startFightWall;
    private Rectangle centerFightWall;
    private Rectangle endFightWall;

    private int endCounterX = 15;
    private int endCounterY = 15;

    public CheeseChampion(View view) {
        x[0] = x[3] = x[4] = y[4] = y[6] = y[8] = 15 + 55 + 55;
        y[0] = x[1] = y[1] = y[2] = x[5] = x[6] = 15 + 55;
        x[2] = y[3] = y[5] = x[7] = y[7] = x[8] = 15;

        this.view = view;
        setup();

        int mice = Tools.randomNumber(3,9);
        for (int i = mice - 1; i > 0; i--) {
            startQueue.enqueue(new Mouse(start.getShapeX()+x[i],start.getShapeY()+y[i]));
        }

        while (!startQueue.isEmpty()){
            if(centerQueue.isEmpty()){
                moveToInTime(startQueue.front().getMouse(),(int)start.getShapeX()+15+55+55,(int)start.getShapeY()+15+55,500);
                startFightWall.setColor(Color.WHITE);
                centerFightWall.setColor(Color.WHITE);
                moveToInTime(startQueue.front().getMouse(),(int)center.getShapeX()+15,(int)center.getShapeY()+15+55,1000);
                startFightWall.setColor(Color.GRAY);
                centerFightWall.setColor(Color.GRAY);
                centerQueue.enqueue(startQueue.front());
                startQueue.dequeue();
            } else if(!centerQueue.isEmpty()) {
                if (startQueue.front().getStrenght() == centerQueue.front().getStrenght()) {
                    moveToInTime(startQueue.front().getMouse(),(int)start.getShapeX()+15+55+55,(int)start.getShapeY()+15+55,500);
                    moveToInTime(centerQueue.front().getMouse(),(int)center.getShapeX()+15,(int)center.getShapeY()+15+55,500);
                    startFightWall.setColor(Color.WHITE);
                    centerFightWall.setColor(Color.WHITE);
                    moveToInTime(startQueue.front().getMouse(),(int)fight.getShapeX()+15,(int)start.getShapeY()+15+55,500);
                    moveToInTime(centerQueue.front().getMouse(),(int)fight.getShapeX()+15+55+55,(int)center.getShapeY()+15+55,500);
                    startFightWall.setColor(Color.GRAY);
                    centerFightWall.setColor(Color.GRAY);
                    view.wait(50);
                    centerFightWall.setColor(Color.WHITE);
                    moveToInTime(startQueue.front().getMouse(),(int)center.getShapeX()+15 + 55,(int)center.getShapeY()+15+55,500);
                    moveToInTime(centerQueue.front().getMouse(),(int)center.getShapeX()+15,(int)center.getShapeY()+15+55,500);
                    centerFightWall.setColor(Color.GRAY);
                    centerQueue.enqueue(startQueue.front());
                    startQueue.dequeue();
                    endFightWall.setColor(Color.GRAY);
                    centerFightWall.setColor(Color.GRAY);
                    startFightWall.setColor(Color.GRAY);
                } else if (startQueue.front().getStrenght() > centerQueue.front().getStrenght()) {
                    moveToInTime(startQueue.front().getMouse(),(int)start.getShapeX()+15+55+55,(int)start.getShapeY()+15+55,500);
                    moveToInTime(centerQueue.front().getMouse(),(int)center.getShapeX()+15,(int)center.getShapeY()+15+55,500);
                    startFightWall.setColor(Color.WHITE);
                    centerFightWall.setColor(Color.WHITE);
                    moveToInTime(startQueue.front().getMouse(),(int)fight.getShapeX()+15,(int)start.getShapeY()+15+55,500);
                    moveToInTime(centerQueue.front().getMouse(),(int)fight.getShapeX()+15+55+55,(int)center.getShapeY()+15+55,500);
                    startFightWall.setColor(Color.GRAY);
                    centerFightWall.setColor(Color.GRAY);
                    view.wait(50);
                    endFightWall.setColor(Color.WHITE);
                    centerFightWall.setColor(Color.WHITE);
                    moveToInTime(startQueue.front().getMouse(),(int)fight.getShapeX()+15+55,(int)start.getShapeY()+15+55,500);
                    moveToInTime(startQueue.front().getMouse(),(int)end.getShapeX()+15+55,(int)end.getShapeY()+15+55+55,500);
                    moveToInTime(startQueue.front().getMouse(),(int)end.getShapeX()+endCounterX,(int)end.getShapeY()+endCounterY,500);
                    if(endCounterX == 125){
                        endCounterX = 15;
                        endCounterY = endCounterY + 55;
                    } else {
                        endCounterX = endCounterX + 55;
                    }
                    moveToInTime(centerQueue.front().getMouse(),(int)center.getShapeX()+15,(int)center.getShapeY()+15+55,500);
                    endQueue.enqueue(startQueue.front());
                    startQueue.dequeue();
                    endFightWall.setColor(Color.GRAY);
                    centerFightWall.setColor(Color.GRAY);
                    startFightWall.setColor(Color.GRAY);
                } else if (startQueue.front().getStrenght() < centerQueue.front().getStrenght()) {
                    moveToInTime(startQueue.front().getMouse(),(int)start.getShapeX()+15+55+55,(int)start.getShapeY()+15+55,500);
                    moveToInTime(centerQueue.front().getMouse(),(int)center.getShapeX()+15,(int)center.getShapeY()+15+55,500);
                    startFightWall.setColor(Color.WHITE);
                    centerFightWall.setColor(Color.WHITE);
                    moveToInTime(startQueue.front().getMouse(),(int)fight.getShapeX()+15,(int)start.getShapeY()+15+55,500);
                    moveToInTime(centerQueue.front().getMouse(),(int)fight.getShapeX()+15+55+55,(int)center.getShapeY()+15+55,500);
                    startFightWall.setColor(Color.GRAY);
                    centerFightWall.setColor(Color.GRAY);
                    view.wait(50);
                    endFightWall.setColor(Color.WHITE);
                    centerFightWall.setColor(Color.WHITE);
                    moveToInTime(centerQueue.front().getMouse(),(int)fight.getShapeX()+15+55,(int)start.getShapeY()+15+55,500);
                    moveToInTime(centerQueue.front().getMouse(),(int)end.getShapeX()+15+55,(int)end.getShapeY()+15+55+55,500);
                    moveToInTime(centerQueue.front().getMouse(),(int)end.getShapeX()+endCounterX,(int)end.getShapeY()+endCounterY,500);
                    if(endCounterX == 125){
                        endCounterX = 15;
                        endCounterY = endCounterY + 55;
                    } else {
                        endCounterX = endCounterX + 55;
                    }
                    moveToInTime(startQueue.front().getMouse(),(int)center.getShapeX()+15,(int)center.getShapeY()+15+55,500);
                    endQueue.enqueue(centerQueue.front());
                    centerQueue.dequeue();
                    centerQueue.enqueue(startQueue.front());
                    startQueue.dequeue();
                    endFightWall.setColor(Color.GRAY);
                    centerFightWall.setColor(Color.GRAY);
                    startFightWall.setColor(Color.GRAY);
                }
            }
        }

        while(!centerQueue.isEmpty()){
            endFightWall.setColor(Color.WHITE);
            centerFightWall.setColor(Color.WHITE);
            moveToInTime(centerQueue.front().getMouse(),(int)fight.getShapeX()+15+55,(int)start.getShapeY()+15+55,500);
            moveToInTime(centerQueue.front().getMouse(),(int)end.getShapeX()+15+55,(int)end.getShapeY()+15+55+55,500);
            moveToInTime(centerQueue.front().getMouse(),(int)end.getShapeX()+endCounterX,(int)end.getShapeY()+endCounterY,500);
            if(endCounterX == 125){
                endCounterX = 15;
                endCounterY = endCounterY + 55;
            } else {
                endCounterX = endCounterX + 55;
            }
            endQueue.enqueue(centerQueue.front());
            centerQueue.dequeue();
            endFightWall.setColor(Color.GRAY);
            centerFightWall.setColor(Color.GRAY);
            startFightWall.setColor(Color.GRAY);
        }

        while (!endQueue.isEmpty()) {
            System.out.println(endQueue.front().getName() + " " + endQueue.front().getStrenght());
            view.remove(endQueue.front().getMouse());
            endQueue.dequeue();
        }

        end();
    }

    private void moveToInTime(@NotNull Shapes s, int x, int y, int t) {
        int times = t/10;
        double xps = (x-s.getShapeX())/times;
        double yps = (y-s.getShapeY())/times;
        for (int i = 0; i < times; i++) {
            s.move(xps,yps);
            view.wait(10);
        }
    }

    private void setup(){
        view.setSize(600,400);

        background = new Rectangle(0,0,view.getWidth(),view.getHeight(), Color.GRAY);
        start = new Rectangle(10,210,180,180,Color.WHITE);
        fight = new Rectangle(210,210,180,180,Color.WHITE);
        center = new Rectangle(410,210,180,180,Color.WHITE);
        end = new Rectangle(210,10,180,180,Color.WHITE);
        startFightWall = new Rectangle(191, 275, 18.5,50, Color.GRAY);
        centerFightWall = new Rectangle(391, 275, 18.5,50, Color.GRAY);
        endFightWall = new Rectangle(275,191, 50,18.5, Color.GRAY);
    }

    private void end(){
        view.remove(background);
        view.remove(start);
        view.remove(fight);
        view.remove(center);
        view.remove(end);
        view.remove(startFightWall);
        view.remove(centerFightWall);
        view.remove(endFightWall);
        view.setSize(0,0);
    }
}
