package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import model.Actor;
import model.ActorWorld;
import net.phys2d.math.ROVector2f;
import net.phys2d.raw.shapes.AABox;

/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class View {

    private ActorWorld world;
    //x and y is top left
    //width and height are width and height in pixels
    //zoom is ratio to scale view by
    private int x, y;
    private double zoom;

    private final static int DEFAULT_X = 0, DEFAULT_Y = 0;

    private final static double DEFAULT_ZOOM = 1.0;

    public View(ActorWorld w) {
        this(w, DEFAULT_X, DEFAULT_Y,  DEFAULT_ZOOM);
    }

    public View(ActorWorld w, int x, int y, double zoom) {
        world = w;
        this.x = x;
        this.y = y;
        this.zoom = zoom;
    }

    public void paint(Graphics2D g, int paintX, int paintY, int width, int height) {
        final double RATIO = zoom;
        List<Actor> touching = touchingActors(width,height);
        //System.out.println(touching.size());
        g.setColor(Color.WHITE);
        g.fillRect(paintX, paintY, width, height);
        
        for(Actor a:touching){
            g.drawImage(a.getImage().getScaledInstance(
                    (int)(a.getWidth()*RATIO), (int)(a.getHeight()*RATIO), 
                    Image.SCALE_DEFAULT),
                    (int)(a.getSwingX()*RATIO), 
                    (int)(a.getSwingY()*RATIO),null);
            //g.drawImage(a.getImage(),100,100,null);
        }
        
        
    }
    
    List<Actor> touchingActors(int width, int height){
        final double RATIO = 1/zoom;
        List<Actor> list = new ArrayList<>();
        Rectangle.Double r = new Rectangle.Double(x, y, width*RATIO, height*RATIO);
        
        for (Actor a : world.actors()) {
            Rectangle.Double aRect = a.getRect();
            if(r.intersects(aRect)){
                list.add(a);
            }
        }
        return list;
    }

}
