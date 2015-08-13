package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import model.Actor;
import net.phys2d.raw.Body;
import net.phys2d.raw.shapes.Box;

/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class SquareActor extends Actor{
    
    Color color;
    
    int width,height;
    
    public SquareActor(Color c,int swingX,int swingY, int width, int height){
        super(new Body(new Box(width, height)),5);
        getBody().setPosition(swingX+width/2, swingY+height/2);
        color=c;
        this.width=width;
        this.height=height;
    }
    
    public SquareActor(Color c,Body b,int width, int height){
        super(b);
        color=c;
        this.width=width;
        this.height=height;
        
    }
    
    @Override
    public Image getImage(){
        BufferedImage b = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g = b.getGraphics();
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        return b;
    }
}
