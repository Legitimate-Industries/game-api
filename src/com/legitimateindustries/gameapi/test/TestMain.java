package com.legitimateindustries.gameapi.test;
import com.legitimateindustries.gameapi.model.actorworld.ActorWorld;
import com.legitimateindustries.gameapi.view.swing.SwingView;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.phys2d.math.Vector2f;
import net.phys2d.raw.Body;
import net.phys2d.raw.World;
import net.phys2d.raw.shapes.Box;
/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class TestMain {
    
    
    public static void main(String[] args){
        
        World w = new World(new Vector2f(10,100), 10);
        
        ActorWorld world = new ActorWorld(w);
        
        //View v = new SwingView(world);
        
        SwingView v = new SwingView(world,0,0,.2);
        
        Body b = new Body(new Box(50, 50),5);
        b.setPosition(50, 50);
        
        SquareActor s = new SquareActor(Color.BLUE,b,50,50);
        
        world.addActor(s);
        
        
        TempFrame f = new TempFrame();
        TempPanel p = new TempPanel(v);
        p.setSize(1000,700);
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1100,800);
        f.setVisible(true);
        
        new Thread(()->{
            while(true){
                try{
                    Thread.sleep(20);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                p.repaint();
            }
        }).start();
        
        new Thread(()->{
            while(true){
                try{
                    Thread.sleep(1000/60);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                w.step();
            }
        }).start();
    }
}
class TempFrame extends JFrame{
    
    public TempFrame(){
        super("TEMPFRAME");
    }
    
    @Override
    public void addNotify(){
        super.addNotify();
        requestFocus();
    }
    

    
    
}
class TempPanel extends JPanel{
    SwingView view;
    public TempPanel(SwingView v){
        view = v;
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("("+e.getX()+" , "+e.getY()+")");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
        
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        BufferedImage b = new BufferedImage(1000,700,BufferedImage.TYPE_4BYTE_ABGR);
        view.paint((Graphics2D)b.getGraphics(), 1000, 700);
        g.drawImage(b, 0, 0, null);
    }
    
    @Override
    public void addNotify(){
        super.addNotify();
        requestFocus();
    }
}