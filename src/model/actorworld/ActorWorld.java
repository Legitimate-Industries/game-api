package model.actorworld;

import java.util.*;
import model.AbstractModel;
import model.Actor;
import net.phys2d.raw.World;

/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class ActorWorld implements AbstractModel{
    
    World world;
    Set<Actor> actors;
    
    
    public ActorWorld(World w){
        world = w;
        actors = new HashSet<>();
        
        
    }
    
    @Override
    public Set<Actor> actors(){
        Set<Actor> s = new HashSet<>();
        for(Actor a:actors)
            s.add(a);
        return s;
    }
    
    @Override
    public void addActor(Actor a){
        world.add(a.getBody());
        actors.add(a);
    }
    
    public World getWorld(){
        return world;
    }
    
    
}
