package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class SwingPanel extends JPanel{
    
    SwingView view;
    public SwingPanel(SwingView s,int width, int height){
        setSize(width,height);
        view=s;
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
}
