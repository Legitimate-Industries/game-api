package com.legitimateindustries.gameapi.test.walkingtest;

import java.io.File;
import java.util.*;
import com.legitimateindustries.gameapi.model.actorworld.ActorWorld;
import net.phys2d.math.Vector2f;
import net.phys2d.raw.World;

/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class Park extends ActorWorld{
    
    Player player = null;
    
    public Park(File f)throws Exception{
        super(new World(new Vector2f(), 10));
        Scanner y0 = new Scanner(f);
        while(y0.hasNextLine()){
            String[] line = y0.nextLine().split(" ");
            if(!line[0].equals("PLAYER")){
                ParkActor p = ParkActor.derive(line[0]);
                p.getBody().setPosition(Integer.valueOf(line[1])*50+25, 
                        Integer.valueOf(line[2])*50+25);
                addActor(p);
            } else{
                Player p = new Player(Integer.valueOf(line[1]),
                        Integer.valueOf(line[2]));
                player=p;
                addActor(p);
            }        
        }
        
    }
    
}
