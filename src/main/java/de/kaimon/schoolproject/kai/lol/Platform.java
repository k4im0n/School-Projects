package de.kaimon.schoolproject.kai.lol;

import sas.Rectangle;
import sas.Shapes;
import sas.Text;

import java.awt.*;

public class Platform {

    private Rectangle platformBody;
    private Rectangle platformTop;

    public Platform(int xPos, int yPos, int width, int height, Color color){
        if(height < 2 || width < 3){
            new Text(xPos,yPos, "height must be > 1");
            new Text(xPos,yPos-10, "width must be > 2");
        } else {
            platformBody = new Rectangle(xPos, yPos, width, height, color);
            platformTop = new Rectangle(xPos+1, yPos, width-2, 1, color);
        }
    }

    public boolean onTop(Shapes shape){
        return platformTop.intersects(shape);
    }

    public boolean atbody(Shapes shape){
        return platformBody.intersects(shape);
    }
    public int getYPos(){
        return (int) platformBody.getShapeY();
    }
}
