package bridge.swing;

import bridge.AbstractBridge;
import controller.swing.SwingController;
import model.actorworld.ActorWorld;
import net.phys2d.raw.World;
import view.swing.SwingPanel;

/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class SwingBridge extends AbstractBridge<ActorWorld,SwingPanel,SwingController>{
    
    private ActorWorld model;
    private SwingPanel view;
    private SwingController controller;
    
    public SwingBridge(World world, int viewWidth, int viewHeight){
        model = new ActorWorld(world);
        view=new SwingPanel(model, viewWidth, viewHeight);
        controller = new SwingController(view);
    }
    
    
    @Override
    public ActorWorld model() {
        return model;
    }

    @Override
    public SwingPanel view() {
        return view;
    }

    @Override
    public SwingController controller() {
        return controller;
    }
    
}
