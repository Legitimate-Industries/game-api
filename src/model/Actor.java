package model;

import java.awt.Image;
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

}
