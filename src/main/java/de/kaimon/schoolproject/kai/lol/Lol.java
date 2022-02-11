package src.main.java.de.kaimon.schoolproject.kai.lol;

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
    private Sprite player;
    private Button left;
    private Button right;
    private Button up;
    private Button pause;
    private Platform platform1;
    private Platform platform2;
    private Platform platform3;
    private Platform falldor;


    public Lol(){
        view = new View(600,400);
        background2 = new Rectangle(0,0,600,400);
        background = new Rectangle(10,10,580,380, Color.WHITE);
        bottom = new Rectangle(0,380,600,200,Color.GRAY);
        hole = new Rectangle(300,380,100,200,Color.white);
        platform1 = new Platform(200,285,200,5, Color.gray);
        platform2 = new Platform(90,185,20,5, Color.gray);
        platform3 = new Platform(200,85,50,5, Color.gray);
        falldor = new Platform(10,285,190,5, Color.RED);
        player = new Sprite(new Circle(50,341, 20, Color.RED));
        boolean run = true;
        Button startKnopf = new Button(20,20, 50,20,"Start: S", Color.gray);
        Button exitKnopf = new Button(20,50, 50,20,"Exit: Q", Color.gray);
        left = new Button(0,340,60,60,"<", Color.gray);
        right = new Button(60,340,60,60,">", Color.gray);
        up  = new Button(540,340,60,60,"^", Color.gray);
        pause = new Button(550,20,30,30, "||", Color.GRAY);
        pause.setHidden(true);
        left.setHidden(true);
        right.setHidden(true);
        up.setHidden(true);
        while (run) {
            exitKnopf.setHidden(false);
            startKnopf.setHidden(false);
            pause.setHidden(true);
            if (view.keyPressed('q') || exitKnopf.clicked()) run = false;
            if (view.keyPressed('s') || startKnopf.clicked()) {
                startKnopf.setHidden(true);
                exitKnopf.setHidden(true);
                pause.setHidden(false);
                game();
            }
            view.wait(10);
        }
    }

    private void game(){
        player.moveTo(50,341);
        boolean game = true;
        double g = 4.81;
        double fallv = 0;
        double v = 0;
        while (game){
            if(view.keyEnterPressed() || pause.clicked()){
                view.keyBufferDelete();
                while (!view.keyEnterPressed() || !pause.clicked()){
                    view.wait(10);
                }
                view.keyBufferDelete();
            }
            view.wait(10);

            if(platform1.atbody(player) || platform1.onTop(player) ||
                    platform2.atbody(player) || platform2.onTop(player) ||
                    platform3.atbody(player) || platform3.onTop(player)||
                    falldor.atbody(player) || falldor.onTop(player)){
                fallv = 0;
            }

            if(hole.intersects(player)){
                view.keyBufferDelete();
            }

            if((!bottom.intersects(player) && !platform1.onTop(player) && !platform2.onTop(player) && !platform3.onTop(player))|| hole.intersects(player)){
                fallv= fallv+g*0.01;
            } else {
                fallv = 0;
                if (player.intersects(bottom) && (!falldor.atbody(player) || !falldor.onTop(player))) {
                    player.moveTo(player.getShapeX(), bottom.getShapeY()-39);
                }else if(platform1.onTop(player) && (!falldor.atbody(player) || !falldor.onTop(player))){
                    player.moveTo(player.getShapeX(), platform1.getYPos()-39);
                }else if(platform2.onTop(player) && (!falldor.atbody(player) || !falldor.onTop(player))){
                    player.moveTo(player.getShapeX(), platform2.getYPos()-39);
                }else if(platform3.onTop(player) && (!falldor.atbody(player) || !falldor.onTop(player))){
                    player.moveTo(player.getShapeX(), platform3.getYPos()-39);
                }
            }

            if(view.keyUpPressed() || up.clicked()){
                if((bottom.intersects(player) || platform1.onTop(player) || platform2.onTop(player) || platform3.onTop(player))&& !hole.intersects(player) && (!falldor.atbody(player) || !falldor.onTop(player))) {
                    fallv = -1;
                }
            }

            if(view.keyRightPressed() || up.clicked()){
                if(!falldor.atbody(player) || !falldor.onTop(player)) {
                    v = 5;
                }
            }

            if(view.keyLeftPressed() || up.clicked()){
                if(!falldor.atbody(player) || !falldor.onTop(player)) {
                    v = -5;
                }
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
