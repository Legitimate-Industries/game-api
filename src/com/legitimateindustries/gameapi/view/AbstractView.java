package com.legitimateindustries.gameapi.view;

/**
 * The View, as well as follow this template, should also display
 * a reasonable representation of the ActorWorld's state that can
 * be modified using the control functions specified.
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public interface AbstractView {
    
    /*
        Paints the view again
    */
    public void redraw();
    
    /*
        Changes the zoom level. Valid numbers are within 0<z<a really large 
        number, where smaller numbers zoom out and larger numbers zoom in.
        @param z The level to set it to.
    */
    public void setZoom(double z);
    
    /*
        Returns the zoom level.
    */
    public double getZoom();
    
    /*
        Sets the x pan.
    @param change The amount to pan by.
    */
    public void panX(int pan);
    
    /*
        returns the x pan.
    */
    public int getXPan();
    
    /*
        Sets the y pan.
        @param change The amount to pan by.
    */
    public void panY(int pan);
    
    /*
        returns the y pan.
    */
    public int getYPan();
    
}
