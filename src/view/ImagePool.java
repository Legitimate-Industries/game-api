package view;

import java.util.*;
import java.awt.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class ImagePool {

    Map<Image, Image> scales;
    Map<Image, Boolean> rescaled;
    double currentFactor=1.0;

    public ImagePool() {
        scales = new ConcurrentHashMap<>();
        rescaled = new ConcurrentHashMap<>();
    }
    
    public void add(Image i){
        if(!scales.containsKey(i)){
            scale(currentFactor,i);
        }
    }
    
    public void rescale(double factor) {
        currentFactor=factor;
        for(Image i:rescaled.keySet()){
            rescaled.put(i, false);
        }
        new Thread(() -> {
            for (Image i : rescaled.keySet()) {
                if (!rescaled.get(i)) {
                    scale(factor,i);
                }
            }

        }).start();
    }
    
    private void scale(double factor, Image i){
        scales.put(i, i.getScaledInstance((int) (i.getWidth(null) * factor),
                            (int) (i.getHeight(null) * factor), Image.SCALE_FAST));
        rescaled.put(i,true);
    }
    
    public Image getScaled(Image i) {
        if(rescaled.get(i)){
            return scales.get(i);
        }
        scale(currentFactor,i);
        return scales.get(i);
    }

}
