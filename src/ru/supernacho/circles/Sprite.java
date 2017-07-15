package ru.supernacho.circles;

import java.awt.*;

/**
 * Created by SuperNacho on 13.07.2017.
 */
public abstract class Sprite {
    protected float posX;
    protected float posY;
    protected float halfWidth;
    protected float halfHeight;

    float x; //центр спрайта
    float y; //центр спрайта

    float getLeft(){
        return x - halfWidth;
    }
    void setLeft(float left){
        x = left + halfWidth;
    }
    float getRight(){
        return x + halfWidth;
    }
    void setRight(float right) {
        x = right - halfWidth;
    }
    float getTop(){
        return y - halfHeight;
    }
    void setTop(float top) {
        y = top + halfHeight;
    }
    float getBottom() {
        return y + halfHeight;
    }
    void setBottom(float bottom){
        y = bottom - halfHeight;
    }
    float getWidth(){
        return 2f*halfWidth;
    }
    float getHeight(){
        return 2f*halfHeight;
    }
    abstract void update(GameCanvas gameCanvas, float deltaTime);
    abstract void render(GameCanvas gameCanvas, Graphics g);

}
