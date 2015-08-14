package com.legitimateindustries.gameapi.test.walkingtest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.awt.event.KeyEvent.*;
import java.io.*;
import net.phys2d.math.ROVector2f;
import net.phys2d.raw.Body;

/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class WalkingTest implements KeyListener {

    Park park;

    public WalkingTest(File f) throws Exception {
        park = new Park(f);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        Body b = park.player.getBody();
        ROVector2f p = b.getPosition();
        if (code == VK_UP) {
            b.setPosition(p.getX(), p.getY() - 50);
        } else if (code == VK_DOWN) {
            b.setPosition(p.getX(), p.getY() + 50);
        } else if (code == VK_LEFT) {
            b.setPosition(p.getX() - 50, p.getY());
        } else if (code == VK_RIGHT) {
            b.setPosition(p.getX() + 50, p.getY());
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
