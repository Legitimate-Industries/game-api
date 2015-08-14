package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import model.Actor;
import model.ActorWorld;

/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class SwingView {

    private ActorWorld world;
    //x and y are top left
    //width and height are width and height in pixels
    //zoom is ratio to scale view by, where larger numbers make it bigger
    private int x, y;
    private double zoom;

    private final static int DEFAULT_X = 0, DEFAULT_Y = 0;

    private final static double DEFAULT_ZOOM = 1.0;

    private ImagePool pool = new ImagePool();

    public SwingView(ActorWorld w) {
        this(w, DEFAULT_X, DEFAULT_Y, DEFAULT_ZOOM);
    }

    public SwingView(ActorWorld w, int x, int y, double zoom) {
        world = w;
        this.x = x;
        this.y = y;
        this.zoom = zoom;
    }

    public void paint(Graphics2D g, int width, int height) {
        double ratio = zoom;
        List<Actor> touching = touching(width, height);
        System.out.println(touching.size());
        touching.sort((Actor a, Actor b) -> {
            return a.priority() - b.priority();
        });
        for (Actor a : touching) {
            pool.add(a.getImage());
            Image i = pool.getScaled(a.getImage());
            g.drawImage(i,
                    (int) (a.getSwingX() * ratio) - x, (int) (a.getSwingY() * ratio) - y, null);

        }

    }

    List<Actor> touching(int width, int height) {
        List<Actor> l = new ArrayList<>();
        double ratio = 1 / zoom;
        double w = width * ratio;
        double h = height * ratio;
        Rectangle2D r = new Rectangle2D.Double(x * ratio, y * ratio, w, h);

        for (Actor a : world.actors()) {
            Rectangle2D r2 = new Rectangle2D.Double(a.getSwingX(),
                    a.getSwingY(), a.getWidth(), a.getHeight());
            if (r2.intersects(r)) {
                l.add(a);
            }
        }

        return l;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getZoom() {
        return zoom;
    }

    public void setZoom(double zoom) {
        this.zoom = zoom;
        pool.rescale(zoom);
    }

    int scale(double sf, double toScale) {
        return (int) (sf * toScale);
    }
}
