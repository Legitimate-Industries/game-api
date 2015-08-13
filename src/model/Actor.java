package model;

import java.awt.Image;
import java.awt.Rectangle;
import net.phys2d.raw.Body;

/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public abstract class Actor {

    private Body body;

    public Actor(Body b) {
        body = b;
    }

    public Image getImage() {
        return null;
    }
    
    public Body getBody(){
        return body;
    }
    
    public int getX(){
        return (int)body.getPosition().getX();
    }
    
    public int getSwingX(){
        return getX()-(getWidth()/2);
    }
    
    public int getY(){
        return (int)body.getPosition().getY();
    }
    
    public int getSwingY(){
        return getY()-(getHeight()/2);
    }
    
    public int getWidth(){
        return (int)body.getShape().getBounds().getWidth();
    }
    
    public int getHeight(){
        return (int)body.getShape().getBounds().getHeight();
    }
    
    public Rectangle.Double getRect(){
        return new Rectangle.Double(getSwingX(),getSwingY(),getWidth(),getHeight());
    }
    
    

}
