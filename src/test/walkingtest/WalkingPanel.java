package test.walkingtest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.awt.event.KeyEvent.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import view.swing.SwingView;

/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class WalkingPanel extends JPanel implements MouseWheelListener,KeyListener{

    SwingView view;

    public WalkingPanel(SwingView v) {
        setSize(1000, 700);
        view = v;

    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage buff = new BufferedImage(1000, 700, BufferedImage.TYPE_4BYTE_ABGR);
        paintBack(buff.getGraphics());
        paintUI(buff.getGraphics());
        g.drawImage(buff, 0, 0, null);
    }


    void paintBack(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1000, 700);
    }
    
    void paintUI(Graphics g) {
        g.setColor(Color.RED);

//        g.fillRect(100, 660, 25, 25);
//        g.fillRect(875, 660, 25, 25);
//
//        g.setColor(Color.WHITE);
//        g.setFont(g.getFont().deriveFont(20f));
//        g.drawString("+", 106, 679);
//        g.drawString("-", 884, 677);
        
        g.setColor(Color.MAGENTA);
        g.setFont(g.getFont().deriveFont(40f));
        g.drawRect(49,49,901,601);
        
        g.setColor(Color.GREEN);
        g.drawString("A WALK IN THE PARK",280,40);
        
        g.setColor(Color.CYAN);
        g.setFont(g.getFont().deriveFont(30f));
        g.drawString("A Zoom and Pan Test by Nathan Dias", 220, 680);
        
        g.setColor(Color.RED);
        g.setFont(g.getFont().deriveFont(12f));
        g.drawString("ZOOM LEVEL: "+(100*view.getZoom())+"%", 15, 15);
        
    }
    
    
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        //positive is down
        view.setZoom(view.getZoom()-.5*e.getWheelRotation());
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == VK_A) {
            view.setX((int)(view.getX()-50*view.getZoom()));
        } else if (code == VK_D) {
            view.setX((int)(view.getX()+50*view.getZoom()));
        } else if (code == VK_W) {
            view.setY((int)(view.getY()-50*view.getZoom()));
        } else if (code == VK_S) {
            view.setY((int)(view.getY()+50*view.getZoom()));
        }
        if(code==VK_MINUS){
            view.setZoom(view.getZoom()/2);
        }
        if(code==VK_EQUALS&&e.isShiftDown()){
            view.setZoom(view.getZoom()*2);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    
}
