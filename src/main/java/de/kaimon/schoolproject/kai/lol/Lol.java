package de.kaimon.schoolproject.kai.lol;

import sas.*;
import sas.Rectangle;

import java.awt.*;

public class Lol {

    private View view;
    private Rectangle background2;
    private Rectangle background;
    private Rectangle bottom;
    private Rectangle hole;
    private Sprite player;

    public Lol(){
        view = new View(600,400);
        background2 = new Rectangle(0,0,600,400);
        background = new Rectangle(10,10,580,380, Color.WHITE);
        bottom = new Rectangle(0,380,600,200,Color.GRAY);
        hole = new Rectangle(300,380,100,200,Color.white);
        player = new Sprite(new Circle(50,100, 20, Color.RED));
        boolean run = true;
        Text txt = new Text(100, 100, """
                    exit: Q
                    start: S""");
        while (run) {
            txt.setHidden(false);
            if (view.keyPressed('q')) run = false;
            if (view.keyPressed('s')) {
                txt.setHidden(true);
                game();
            }
            view.wait(10);
        }
    }

    private void game(){
        player.moveTo(100,100);
        boolean game = true;
        double g = 4.81;
        double fallv = 0;
        double v = 0;
        while (game){
            view.wait(10);
            
            if(hole.intersects(player)){
                view.keyBufferDelete();
            }

            if(!bottom.intersects(player) || hole.intersects(player)){
                fallv= fallv+g*0.01;
            } else {
                fallv = 0;
                player.moveTo(player.getShapeX(),341);
            }

            if(view.keyUpPressed()){
                if(bottom.intersects(player) && !hole.intersects(player)) {
                    fallv = -1;
                }
            }

            if(view.keyRightPressed()){
                v = 5;
            }

            if(view.keyLeftPressed()){
                v = -5;
            }

            if(!background.contains(player) && !bottom.intersects(player)){
                game = false;
            }

            if ((v > 0 && v < 0.01) || (v < 0 && v > -0.01)) v = 0;
            if (v != 0) v = v / 1.1;
            player.move(v,fallv*10);
        }
    }
}
