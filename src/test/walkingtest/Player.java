package test.walkingtest;

import java.awt.Image;
import javax.imageio.ImageIO;


/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class Player extends ParkActor{
    
    static Image PLAYER_IMAGE=null;
    
    static{
        try{
            PLAYER_IMAGE = ImageIO.read(Player.class.getResourceAsStream("resource/player.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Player(int x,int y){
        super(PLAYER_IMAGE);
        this.getBody().setPosition(x*50+25, y*50+25);
    }
    
    @Override
    public int priority(){
        return 10;
    }
}
