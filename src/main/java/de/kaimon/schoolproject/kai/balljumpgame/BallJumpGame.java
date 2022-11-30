package de.kaimon.schoolproject.kai.balljumpgame;

import sas.*;
import sas.Rectangle;
import sasio.Button;
import java.awt.*;

public class BallJumpGame {

    private View view;
    private Rectangle background2;
    private Rectangle background;
    private Text startKnopf;
    private Text exitKnopf;
    private Rectangle bottom;
    private Rectangle hole;
    private Sprite player;
    private Platform platform1;
    private Platform platform2;
    private Platform platform3;
    private Platform falldor;


    public BallJumpGame(View view){
        this.view = view;
        setup();
        game();
        end();
    }

    private void game(){
        boolean run = true;
        while (run) {
            exitKnopf.setHidden(false);
            startKnopf.setHidden(false);
            if (view.keyPressed('q')) run = false;
            if (view.keyPressed('s')) {
                startKnopf.setHidden(true);
                exitKnopf.setHidden(true);
                player.moveTo(50,341);
                boolean game = true;
                double g = 4.81;
                double fallv = 0;
                double v = 0;
                while (game){
                    if(view.keyEnterPressed()){
                        view.keyBufferDelete();
                        while (!view.keyEnterPressed())view.wait(10);
                        view.keyBufferDelete();
                    }
                    view.wait(10);

                    if(platform1.atbody(player) || platform1.onTop(player) ||
                            platform2.atbody(player) || platform2.onTop(player) ||
                            platform3.atbody(player) || platform3.onTop(player)||
                            falldor.atbody(player) || falldor.onTop(player)){
                        fallv = 0;
                    }

                    if(hole.intersects(player))view.keyBufferDelete();
                    if((!bottom.intersects(player) && !platform1.onTop(player) && !platform2.onTop(player) && !platform3.onTop(player))|| hole.intersects(player))fallv= fallv+g*0.01;
                    else {
                        fallv = 0;
                        if (player.intersects(bottom) && (!falldor.atbody(player) || !falldor.onTop(player))) player.moveTo(player.getShapeX(), bottom.getShapeY()-39);
                        else if(platform1.onTop(player) && (!falldor.atbody(player) || !falldor.onTop(player)))player.moveTo(player.getShapeX(), platform1.getYPos()-39);
                        else if(platform2.onTop(player) && (!falldor.atbody(player) || !falldor.onTop(player)))player.moveTo(player.getShapeX(), platform2.getYPos()-39);
                        else if(platform3.onTop(player) && (!falldor.atbody(player) || !falldor.onTop(player)))player.moveTo(player.getShapeX(), platform3.getYPos()-39);
                    }
                    if(view.keyUpPressed()) if((bottom.intersects(player) || platform1.onTop(player) || platform2.onTop(player) || platform3.onTop(player))&& !hole.intersects(player) && (!falldor.atbody(player) || !falldor.onTop(player))) fallv = -1;
                    if(view.keyRightPressed()) if(!falldor.atbody(player) || !falldor.onTop(player)) v = 5;
                    if(view.keyLeftPressed()) if(!falldor.atbody(player) || !falldor.onTop(player)) v = -5;
                    if(!background.contains(player) && !bottom.intersects(player))game = false;
                    if ((v > 0 && v < 0.01) || (v < 0 && v > -0.01)) v = 0;
                    if (v != 0) v = v / 1.1;
                    player.move(v,fallv*10);
                }
            }
            view.wait(10);
        }
    }

    private void setup(){
        view.setSize(600,400);
        background2 = new Rectangle(0,0,600,400);
        background = new Rectangle(10,10,580,380, Color.WHITE);
        startKnopf = new Text(20,20, "Start: S", Color.gray);
        exitKnopf = new Text(20,50, "Exit: Q", Color.gray);
        bottom = new Rectangle(0,380,600,200,Color.GRAY);
        hole = new Rectangle(300,380,100,200,Color.white);
        platform1 = new Platform(200,285,200,5, Color.gray);
        platform2 = new Platform(90,185,20,5, Color.gray);
        platform3 = new Platform(200,85,50,5, Color.gray);
        falldor = new Platform(10,285,190,5, Color.RED);
        player = new Sprite(new Circle(50,341, 20, Color.RED));
    }

    private void end(){
        view.remove(background2);
        view.remove(background);
        view.remove(startKnopf);
        view.remove(exitKnopf);
        view.remove(bottom);
        view.remove(hole);
        view.remove(platform1.getSprite());
        view.remove(platform2.getSprite());
        view.remove(platform3.getSprite());
        view.remove(falldor.getSprite());
        view.remove(player);
        view.setSize(220,410);
    }
}
