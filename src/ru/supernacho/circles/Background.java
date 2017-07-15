package ru.supernacho.circles;

import java.awt.*;


/**
 * Created by SuperNacho on 15.07.2017.
 */
public class Background extends Sprite {
    private int frame = 0;

    @Override
    void update(GameCanvas gameCanvas, float deltaTime) {

    }

    @Override
    void render(GameCanvas gameCanvas, Graphics g) {
         frame++;
         g.setColor(new Color((int) Math.abs(Math.sin(Math.toRadians(frame/3)) * 255),
                 (int) Math.abs(Math.sin(Math.toRadians(frame/7)) * 255),
                 (int) Math.abs(Math.sin(Math.toRadians(frame/5)) * 255)));
         g.fillRect(gameCanvas.getLeft(), gameCanvas.getTop(), gameCanvas.getRight(), gameCanvas.getBottom());

    }
}
