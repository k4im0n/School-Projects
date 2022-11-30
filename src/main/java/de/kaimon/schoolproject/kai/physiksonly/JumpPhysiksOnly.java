package de.kaimon.schoolproject.kai.physiksonly;

import sas.*;
import sas.Rectangle;

import java.awt.*;

public class JumpPhysiksOnly {

    View view;
    Rectangle background;
    Rectangle floor;
    Circle player;
    double a = 0.0981;
    double v = 0;
    double t = 0;
    boolean game = true;

    public JumpPhysiksOnly(View view){
        this.view = view;
        setup();
        double y = 0;
        double t = 0;
        double x = 0;
        while(game){
            if(!background.contains(player)) player.move(-x,0);
            if(!player.intersects(floor)){
                t += 0.001;
                y = y + a*t;
            } else {
                player.moveTo(player.getShapeX(), 361);
                t = 0;
                y = 0;
            }
            if(view.keyPressed('o')){
                t = 0;
                y = 0;
                player.moveTo(100,100);
            }
            if(view.keyPressed('w') && player.intersects(floor)) y = -1;
            x = 0;
            if(view.keyPressed('a')) x -= 1;
            if(view.keyPressed('d')) x += 1;
            player.move(x,y);
            view.wait(1);
            if(view.keyPressed('0')) game = false;
        }
        end();
    }

    void setup(){
        view.setSize(600,400);
        background = new Rectangle(0,0,600,400, new Color(50,0,50));
        floor = new Rectangle(0,380,600,500, Color.BLACK);
        player = new Circle(290,190,10,new Color(150,0,150));
    }

    void end(){
        view.remove(background);
        view.remove(floor);
        view.remove(player);
        view.setSize(0,0);
    }
}
