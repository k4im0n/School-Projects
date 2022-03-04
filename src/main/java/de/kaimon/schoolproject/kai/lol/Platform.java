package de.kaimon.schoolproject.kai.lol;

import sas.Rectangle;
import sas.Shapes;
import sas.Text;

import java.awt.*;

public class Platform {

    private Rectangle firstPlatformBody;
    private Rectangle firstPlatformTop;

    public Platform(int x1Pos, int y1Pos, int width, int height, Color color){
        if(height < 2 || width < 3){
            new Text(x1Pos,y1Pos, "height must be > 1");
            new Text(x1Pos,y1Pos-10, "width must be > 2");
        } else {
            firstPlatformBody = new Rectangle(x1Pos, y1Pos, width, height, color);
            firstPlatformTop = new Rectangle(x1Pos+1, y1Pos, width-2, 1, color);
        }
    }

    public boolean onTop(Shapes shape){
        return firstPlatformTop.intersects(shape);
    }

    public boolean atbody(Shapes shape){
        return firstPlatformBody.intersects(shape);
    }

    public int getYPos(){
        return (int) firstPlatformBody.getShapeY();
    }
}
