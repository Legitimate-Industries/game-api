package test.walkingtest;
import java.awt.Insets;
import java.util.*;
import java.io.*;
import javax.swing.JFrame;
import view.SwingPanel;
import view.SwingView;
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
        
        SwingView s = new SwingView(w.park);
        s.setZoom(1);
        WalkingPanel p = new WalkingPanel(s);
        j.add(p);
        p.addMouseWheelListener(p);
        p.addKeyListener(w);
        p.addKeyListener(p);
        p.setLayout(null);
        SwingPanel sp = new SwingPanel(s,900,600);
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
