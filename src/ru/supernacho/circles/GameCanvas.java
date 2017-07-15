package ru.supernacho.circles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by SuperNacho on 13.07.2017.
 */
public class GameCanvas extends JPanel {
    private long lastFrameTime;
    private final GameWindow gameWindow;

    GameCanvas(GameWindow gameWindow) {
        lastFrameTime = System.nanoTime();
        this.gameWindow = gameWindow;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 1e-9f;
        lastFrameTime = currentTime;
        gameWindow.onDrawFrame(this, g, deltaTime);
        System.out.println("FPS = " + 1f / deltaTime);


        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public int getRight() {
        return getWidth() - 1;
    }

    public int getLeft() {
        return 0;
    }

    public int getTop(){
        return 0;
    }

    public int getBottom(){
        return getHeight() - 1;
    }


}
