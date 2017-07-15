package ru.supernacho.circles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GameWindow extends JFrame {

    private static final int POS_X = 600;
    private static final int POS_Y= 200;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameWindow();
            }
        });
    }

    private Sprite[] sprites = new Sprite[10];
    private Sprite[] tmpSprites;


    private GameWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        GameCanvas gameCanvas = new GameCanvas(this);
        gameCanvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                extendSpritesArray();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        add(gameCanvas);
        createBalls();
        setVisible(true);
    }

    private void createBalls() {
        sprites[0] = new Background(); // Добавляем Фон в массив, чтоб избежать дублирования кода в методах draw, update;
        for (int i = 1; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }
//Метод расширяющий массив и добавляющий новый мяч в конец масива
    private void extendSpritesArray(){
        tmpSprites = sprites;
        sprites = new Sprite[Ball.getBallCount()+1];
        for (int i = 0; i < tmpSprites.length; i++) {
            sprites[i] = tmpSprites[i];
        }
        sprites[sprites.length-1] = new Ball();
        tmpSprites = null;
    }

    void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime) {
        update(gameCanvas, deltaTime);
        draw(gameCanvas, g);
    }

    private void update(GameCanvas gameCanvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(gameCanvas, deltaTime);
        }
    }

    private void draw(GameCanvas gameCanvas, Graphics g){

        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(gameCanvas, g);
        }

    }

}
