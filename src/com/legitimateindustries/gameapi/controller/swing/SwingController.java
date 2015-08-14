package com.legitimateindustries.gameapi.controller.swing;

import com.legitimateindustries.gameapi.controller.AbstractController;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import com.legitimateindustries.gameapi.view.swing.SwingPanel;

/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class SwingController implements AbstractController{
    
    SwingPanel panel;
    
    public SwingController(SwingPanel sp){
        panel=sp;
    }
    
    public void addMouseListener(MouseListener m){
        panel.addMouseListener(m);
    }
    
    public void addMouseMotionListener(MouseMotionListener m){
        panel.addMouseMotionListener(m);
    }
    
    public void addMouseWheelListener(MouseWheelListener m){
        panel.addMouseWheelListener(m);
    }
    
    public void addKeyListener(KeyListener k){
        panel.addKeyListener(k);
    }
    
}
