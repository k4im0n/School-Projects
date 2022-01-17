package de.kaimon.schoolproject.kai.lol;

import sas.*;
import sas.Rectangle;

import java.awt.*;

public class Lol {

    private View view;
    private Rectangle background2;
    private Rectangle background;
    private Rectangle bottom;
    private Sprite player;

    public Lol(){
        view = new View(600,400);
        background2 = new Rectangle(0,0,600,400);
        background = new Rectangle(10,10,580,380, Color.WHITE);
        bottom = new Rectangle(0,380,600,200,Color.GRAY);
        player = new Sprite(new Circle(50,100, 20, Color.RED));
        boolean game = true;
        double a = 4.81;
        double v = 0;
        while (game){
            view.wait(10);
            if(!bottom.intersects(player)){
                v= v+a*0.01;
            } else {
                v = 0;
                player.moveTo(player.getShapeX(),340);
            }
            if(view.keyUpPressed()){
                view.keyBufferDelete();
                if(bottom.intersects(player)) {
                    v = -1;
                }
            }
            if(view.keyRightPressed()){
                player.move(10,0);
            }
            if(view.keyLeftPressed()){
                player.move(-10,0);
            }
            if(!background.contains(player) && !bottom.intersects(player)){
                game = false;
            }
            player.move(0,v*10);
        }
        new Text(100,100,"GAME OVER!");
    }
}
