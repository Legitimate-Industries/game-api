package com.legitimateindustries.gameapi.bridge;

import com.legitimateindustries.gameapi.controller.AbstractController;
import com.legitimateindustries.gameapi.model.AbstractModel;
import com.legitimateindustries.gameapi.view.AbstractView;

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
