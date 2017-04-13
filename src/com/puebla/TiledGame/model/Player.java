package com.puebla.TiledGame.model;

import com.puebla.TiledGame.tileMap.TileMap;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Created by federico on 13/04/17.
 */
public class Player {

    private double x;
    private double y;
    private double deltaX;
    private double deltaY;

    private int width;
    private int height;

    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

    private double moveSpeed;
    private double maxSpeed;
    private double stoppingSpeed;

    private TileMap tileMap;

    public Player(TileMap tileMap) {

        this.tileMap = tileMap;
        width = 24;
        height = 24;
        moveSpeed = 0.3;
        maxSpeed = 3.0;
        stoppingSpeed = 0.3;

    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void update() {
        if ( isLeft() ) {
            System.out.println("player is trying to move to the left");
            moveLeft();
        } else if ( isRight() ) {
            moveRight();
        } else if ( isUp() ) {
            moveUp();
        } else if ( isDown() ) {
            moveDown();
        } else {
            if ( deltaX > 0 ) {
                stoppingToLeft();
            } else if ( deltaX < 0 ) {
                stoppingToRight();
            } else if ( deltaY > 0 ) {
                stoppingToUp();
            } else if ( deltaY < 0 ) {
                stoppingToDown();
            }
        }

        x += deltaX;
        y += deltaY;
    }

    public void draw(Graphics graphics) {

        int tileX = tileMap.getX();
        int tileY = tileMap.getY();

        graphics.setColor(Color.BLUE);
        graphics.fillRect(
                (int) (tileX + ( x - ( width >>> 1 ) )),
                (int) (tileY + ( y - ( height >>> 1 ) )),
                width,
                height
        );
    }

    public void moveLeft() {
        deltaX -= moveSpeed;
        if ( deltaX < -maxSpeed ) {
            deltaX = -maxSpeed;
        }
    }

    public void moveRight() {
        deltaX += moveSpeed;
        if ( deltaX > maxSpeed ) {
            deltaX = maxSpeed;
        }
    }

    public void moveUp() {
        deltaY -= moveSpeed;
        if ( deltaY < -maxSpeed ) {
            deltaY = -maxSpeed;
        }
    }

    public void moveDown() {
        deltaY += moveSpeed;
        if ( deltaY > maxSpeed ) {
            deltaY = maxSpeed;
        }
    }

    public void stoppingToLeft() {
        deltaX -= stoppingSpeed;
        if ( deltaX < 0 ) {
            deltaX = 0;
        }
    }

    public void stoppingToRight() {
        deltaX += stoppingSpeed;
        if ( deltaX > 0 ) {
            deltaX = 0;
        }
    }

    public void stoppingToUp() {
        deltaY -= stoppingSpeed;
        if ( deltaY < 0 ) {
            deltaY = 0;
        }
    }

    public void stoppingToDown() {
        deltaY += stoppingSpeed;
        if ( deltaY > 0 ) {
            deltaY = 0;
        }
    }
}
