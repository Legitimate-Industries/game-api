package com.legitimateindustries.gameapi.test.walkingtest;
import java.awt.Insets;
import java.util.*;
import java.io.*;
import java.lang.reflect.Field;
import javax.swing.JFrame;
import com.legitimateindustries.gameapi.view.swing.SwingPanel;
import com.legitimateindustries.gameapi.view.swing.SwingView;
/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class WalkingTestMain {
    
    public static void main(String[] args) throws Exception{
        
        WalkingTest w = new WalkingTest(
                new File(
                        WalkingTestMain.class.getResource(
                                "resource/map1.map").toURI()));
        
        ;
        JFrame j = new JFrame("TEST");
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        SwingPanel sp = new SwingPanel(w.park,900,600);
        
        
        //reflection used here because new framework does not support
        //this code
        Class c = SwingPanel.class;
        Field f = c.getDeclaredField("view");
        f.setAccessible(true);
        WalkingPanel p = new WalkingPanel((SwingView)f.get(sp));
        
        
        j.add(p);
        p.addMouseWheelListener(p);
        p.addKeyListener(w);
        p.addKeyListener(p);
        p.setLayout(null);
        sp.setBounds(50, 50, 900, 600);
        p.add(sp);
        p.revalidate();
        
        j.setSize(1000+16,700+36);
        j.setVisible(true);
        new Thread(()->{
            while(true){
                try{
                    Thread.sleep(1000/60);
                    p.repaint();
                    sp.repaint();
                }catch(Exception e){
                    
                }
            }
        }).start();
        
    }
}
