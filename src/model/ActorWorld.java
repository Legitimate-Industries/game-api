package model;

import java.util.*;
import net.phys2d.raw.World;

/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class ActorWorld {
    
    World world;
    Set<Actor> actors;
    
    
    public ActorWorld(World w){
        world = w;
        actors = new HashSet<>();
        
        
    }
    
    public Set<Actor> actors(){
        return actors;
    }
    
    
    public void addActor(Actor a){
        world.add(a.getBody());
        actors.add(a);
    }
    
    public World getWorld(){
        return world;
    }
    
    
}
