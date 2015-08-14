package com.legitimateindustries.gameapi.view.swing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import com.legitimateindustries.gameapi.model.actorworld.ActorWorld;
import com.legitimateindustries.gameapi.view.AbstractView;

/**
 * An implementation of AbstractView using Swing and outputting using a JPanel.
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class SwingPanel extends JPanel implements AbstractView{
    
    SwingView view;
    public SwingPanel(ActorWorld w,int width, int height){
        setSize(width,height);
        view=new SwingView(w);
    }
    
    @Override
    public void addNotify(){
        super.addNotify();
        requestFocus();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        BufferedImage b = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        view.paint((Graphics2D)b.getGraphics(), b.getWidth(), b.getHeight());
        g.drawImage(b, 0, 0, null);
    }

    @Override
    public void redraw() {
        repaint();
    }

    @Override
    public void setZoom(double z) {
        view.setZoom(z);
    }

    @Override
    public double getZoom() {
        return view.getZoom();
    }

    @Override
    public void panX(int pan) {
        view.setX(pan);
    }

    @Override
    public int getXPan() {
        return view.getX();
    }

    @Override
    public void panY(int pan) {
        view.setY(pan);
    }

    @Override
    public int getYPan() {
        return view.getY();
    }
}
