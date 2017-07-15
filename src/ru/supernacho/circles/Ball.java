package ru.supernacho.circles;

import java.awt.*;

/**
 * Created by SuperNacho on 13.07.2017.
 */
public class Ball extends Sprite {

    private float vx = 150f + (float) (Math.random()* 200f);
    private float vy = 150f + (float) (Math.random()* 200f);
    private Color color = new Color((int) (Math.random()*256f),(int)(Math.random()*256f),(int)(Math.random()*256f));
    private static int ballCount = 0;

    Ball() {
        halfHeight = 20f + (float) (Math.random()*50f);
        halfWidth = halfHeight;
        ballCount++;
    }

    @Override
    void update(GameCanvas gameCanvas, float deltaTime) {
        x += vx * deltaTime;
        y += vy * deltaTime;

        if (getLeft() < gameCanvas.getLeft()){
            setLeft(gameCanvas.getLeft());
            vx = -vx;
        }

        if (getRight() > gameCanvas.getRight()){
            setRight(gameCanvas.getRight());
            vx = -vx;
        }
        if (getTop() < gameCanvas.getTop()){
            setTop(gameCanvas.getTop());
            vy = -vy;
        }
        if (getBottom() > gameCanvas.getBottom()){
            setBottom(gameCanvas.getBottom());
            vy = -vy;
        }

    }

    public static int getBallCount() {
        return ballCount;
    }

    @Override
    void render(GameCanvas gameCanvas, Graphics g) {
        g.setColor(color);
       g.fillOval((int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight());
    }
}
