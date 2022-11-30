package de.kaimon.schoolproject.kai.physiksonly;

import sas.*;
import java.awt.Color;

public class SlidePhysiksOnly{
    View view;
    Rectangle background;
    Rectangle iceCream;
    Rectangle left;
    Rectangle top;
    Rectangle right;
    Rectangle bottom;
    Circle player;
    boolean run = true;
    double a = 0.7;
    double x = 0;
    double y = 0;

    public SlidePhysiksOnly(View view){
        this.view = view;
        setup();
        game();
        end();
    }

    private void setup(){
        view.setSize(600,400);
        background = new Rectangle(0,0,600,400,new Color(50,0,50));
        iceCream = new Rectangle(300,0,300,300, new Color(146, 170, 236));
        left = new Rectangle(-10,-10,10,420);
        top = new Rectangle(-10,-10,620,10);
        right = new Rectangle(600,-10,10,420);
        bottom = new Rectangle(-10,400,620,10);
        player = new Circle(290,190,10,new Color(150,0,150));
    }

    void game() {
        while (run) {
            if (iceCream.contains(player)) a = 0.981;
            else a = 0.9;
            if (!player.intersects(left) && !player.intersects(top) && !player.intersects(right) && !player.intersects(bottom)) {
                if (view.keyPressed('w')) y = -5;
                if (view.keyPressed('a')) x = -5;
                if (view.keyPressed('s')) y = 5;
                if (view.keyPressed('d')) x = 5;
            } else {
                player.move(-x, -y);
                x = 0;
                y = 0;
            }
            if (x > 0.0001 || x < -0.0001) x *= a;
            else x = 0;
            if (y > 0.0001 || y < -0.0001) y *= a;
            else y = 0;
            player.move(x, y);
            view.wait(10);
            if (view.keyPressed('0')) run = false;
        }
    }

    void end(){
        view.remove(background);
        view.remove(iceCream);
        view.remove(left);
        view.remove(right);
        view.remove(top);
        view.remove(bottom);
        view.remove(player);
        view.setSize(0,0);
    }
}
