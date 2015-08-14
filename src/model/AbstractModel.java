package model;

import java.util.Set;
import net.phys2d.raw.World;

/**
 * The Model, as well as follow this template, should also store the actors
 * stably and have a definable internal structure.
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public interface AbstractModel {
    
    //return a Set that shows all the actors inside but is not the backing
    //one(needs to be a clone).
    public Set<Actor> actors();
    
    
    //add the actor to the world
    public void addActor(Actor a);
    
    //return the world
    public World getWorld();
    
}
