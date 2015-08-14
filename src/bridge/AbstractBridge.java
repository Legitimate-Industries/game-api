package bridge;

import controller.AbstractController;
import model.AbstractModel;
import view.AbstractView;

/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 * @param <Model> An implementation of AbstractModel
 * @param <View> An implementation of AbstractView
 * @param <Controller> An implementation of AbstractController
 */
public abstract class AbstractBridge<Model extends AbstractModel,
        View extends AbstractView,Controller extends AbstractController> {
    
    public abstract Model model();
    
    public abstract View view();
    
    public abstract Controller controller();
    
    
    
}
