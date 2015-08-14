package com.legitimateindustries.gameapi.test.walkingtest;

import java.util.*;
import java.io.*;
import java.awt.*;
import com.legitimateindustries.gameapi.model.Actor;
import net.phys2d.raw.Body;
import net.phys2d.raw.StaticBody;
import net.phys2d.raw.shapes.Box;
import javax.imageio.ImageIO;

/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class ParkActor extends Actor {

    private static Map<String, Image> images = new HashMap<>();

    static {
        InputStream tree = null, fence = null, pavement = null, grass = null;

        try {
            tree = ParkActor.class.getResourceAsStream("resource/tree.png");
            fence = ParkActor.class.getResourceAsStream("resource/fence.png");
            pavement = ParkActor.class.getResourceAsStream("resource/pavement.png");
            grass  = ParkActor.class.getResourceAsStream("resource/grass.png");
            
            images.put("TREE",ImageIO.read(tree));
            images.put("FENCE",ImageIO.read(fence));
            images.put("PAVEMENT",ImageIO.read(pavement));
            images.put("GRASS",ImageIO.read(grass));
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private Image image;

    public ParkActor(Image i) {
        super(parkBody());
        image = i;
    }

    @Override
    public Image getImage() {
        return image;
    }

    private static Body parkBody() {
        Body b = new StaticBody(new Box(35, 35));
        return b;
    }

    public static ParkActor derive(String s) {
        return new ParkActor(images.get(s));
    }

}
