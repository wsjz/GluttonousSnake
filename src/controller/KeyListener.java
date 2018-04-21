package controller;

import java.awt.event.KeyEvent;
import java.util.EventListener;

/**
 * @author Created by Darling
 * @version CreatedDate: 2018/4/22 at 0:13
 */

public interface KeyListener extends EventListener {
    //按下某个键时会调用该方法
    void keyPressed(KeyEvent e);
    //释放某个键时会调用该方法
    void keyReleased(KeyEvent e);
    //键入某个键时会调用该方法
    void keyTyped(KeyEvent e);
}
