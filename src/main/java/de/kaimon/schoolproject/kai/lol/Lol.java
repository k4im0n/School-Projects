package de.kaimon.schoolproject.kai.lol;

import sas.*;
import sas.Rectangle;
import sasio.Button;

import java.awt.*;

public class Lol {

    private View view;
    private Rectangle background2;
    private Rectangle background;
    private Rectangle bottom;
    private Rectangle hole;
    private Rectangle platformtop;
    private Sprite platform;
    private Sprite player;
    private Button left;
    private Button right;
    private Button up;

    public Lol(){
        view = new View(600,400);
        background2 = new Rectangle(0,0,600,400);
        background = new Rectangle(10,10,580,380, Color.WHITE);
        bottom = new Rectangle(0,380,600,200,Color.GRAY);
        hole = new Rectangle(300,380,100,200,Color.white);
        platformtop = new Rectangle(200, 285, 200, 5, Color.GRAY);
        platform = new Sprite(new Rectangle(200, 285, 200, 20, Color.GRAY));
        platform.add(platformtop);
        player = new Sprite(new Circle(50,100, 20, Color.RED));
        boolean run = true;
        Button knopf = new Button(100,100, 20,20,"Start", Color.gray);
        left = new Button(0,340,60,60,"<", Color.gray);
        right = new Button(60,340,60,60,">", Color.gray);
        up  = new Button(540,340,60,60,"^", Color.gray);
        Text txt = new Text(100, 100, """
                    exit: Q
                    start: S""");
        while (run) {
            txt.setHidden(false);
            knopf.setHidden(false);
            if (view.keyPressed('q')) run = false;
            if (view.keyPressed('s')|| knopf.clicked()) {
                knopf.setHidden(true);
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

            if(player.intersects(platform)){
                fallv = 0;
            }

            if(hole.intersects(player)){
                view.keyBufferDelete();
            }

            if((!bottom.intersects(player) )|| hole.intersects(player)){
                fallv= fallv+g*0.01;
            } else {
                fallv = 0;
                player.moveTo(player.getShapeX(), 341);
            }

            if(view.keyUpPressed() || up.clicked()){
                if((bottom.intersects(player) || player.intersects(platformtop))&& !hole.intersects(player)) {
                    fallv = -1;
                }
            }

            if(view.keyRightPressed() || up.clicked()){
                v = 5;
            }

            if(view.keyLeftPressed() || up.clicked()){
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
