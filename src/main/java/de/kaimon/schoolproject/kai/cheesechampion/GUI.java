package de.kaimon.schoolproject.kai.cheesechampion;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.linear.Queue;
import sas.*;
import sas.Rectangle;

import java.awt.*;

public class GUI {

    private int[] x = new int[9];
    private int[] y = new int[9];

    private Rectangle start;
    private Rectangle fight;
    private Rectangle center;
    private Rectangle end;

    private Rectangle startFight;
    private Rectangle centerFight;
    private Rectangle endFight;

    private Sprite[] mouse;

    public GUI(Queue<Mouse>  m,int miceNummber){
        mouse = new Sprite[miceNummber];
        Queue<Mouse> mice = m;
        x[0] = x[3] = x[4] = y[4] = y[6] = y[8] = 125;
        y[0] = x[1] = y[1] = y[2] = x[5] = x[6] = 70;
        x[2] = y[3] = y[5] = x[7] = y[7] = x[8] = 15;

        View view = new View(600, 400);
        new Rectangle(0,0,view.getWidth(),view.getHeight(), Color.GRAY);

        start = new Rectangle(10,210,180,180,Color.WHITE);
        fight = new Rectangle(210,210,180,180,Color.WHITE);
        center = new Rectangle(410,210,180,180,Color.WHITE);
        end = new Rectangle(210,10,180,180,Color.WHITE);

        startFight = new Rectangle(191, 275, 18.5,50, Color.WHITE);
        centerFight = new Rectangle(391, 275, 18.5,50, Color.WHITE);
        endFight = new Rectangle(275,191, 50,18.5, Color.WHITE);

        for (int i = 0; i < miceNummber; i++) {

            Sprite temp = new Sprite(new Circle(start.getShapeX()+x[i],start.getShapeY()+y[i],20, new Color(100,70,50)));
            temp.add(new Text(start.getShapeX() + x[i] + 15, start.getShapeY() + y[i], "" + mice.front().getNummber()));
            mice.dequeue();

            mouse[i] = temp;
        }
    }
}
