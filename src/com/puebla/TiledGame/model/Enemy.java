package com.puebla.TiledGame.model;

import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.manager.CollidableRectangle;
import com.puebla.TiledGame.tileMap.TileMap;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author federico on 29/04/17.
 * @email fede.larregle@gmail.com
 */
public class Enemy implements Entity, CollidableRectangle {

    private Game game;
    private TileMap tileMap;
    private RectActor playerToSeek;

    private double x;
    private double y;
    private double deltaX;
    private double deltaY;

    private final static int WIDTH;
    private final static int HEIGHT;

    private final static double MOVE_SPEED;
    private final static double MAX_SPEED;
    private final static double STOPPING_SPPED;

    static {
        MOVE_SPEED = 0.10;
        MAX_SPEED = 2.0;
        STOPPING_SPPED = 0.4;
        WIDTH = 16;
        HEIGHT = 16;
    }

    public Enemy(Game game, TileMap tileMap, RectActor playerToSeek) {
        this.game = game;
        this.tileMap = tileMap;
        this.playerToSeek = playerToSeek;
    }

    public void moveRight() {
        deltaX += MOVE_SPEED;
        if ( deltaX > MAX_SPEED ) {
            deltaX = MAX_SPEED;
        }
        this.x += deltaX;
    }

    public void moveLeft() {
        deltaX -= MOVE_SPEED;
        if ( deltaX < -MAX_SPEED ) {
            deltaX = -MAX_SPEED;
        }
        this.x += deltaX;
    }

    public void moveUp() {

        deltaY -= MOVE_SPEED;
        if ( deltaY < -MAX_SPEED ) {
            deltaY = -MAX_SPEED;
        }
        this.y += deltaY;
    }

    public void moveDown() {

        deltaY += MOVE_SPEED;
        if ( deltaY > MAX_SPEED ) {
            deltaY = MAX_SPEED;
        }
        this.y += deltaY;
    }

    public void stoppingToLeft() {
        deltaX -= STOPPING_SPPED;
        if ( deltaX < 0 ) {
            deltaX = 0;
        }
        this.x += deltaX;
    }

    public void stoppingToRight() {
        deltaX += STOPPING_SPPED;
        if ( deltaX > 0 ) {
            deltaX = 0;
        }
        this.x += deltaX;
    }

    public void stoppingToUp() {
        deltaY -= STOPPING_SPPED;
        if ( deltaY < 0 ) {
            deltaY = 0;
        }
        this.y += deltaY;
    }

    public void stoppingToDown() {
        deltaY += STOPPING_SPPED;
        if ( deltaY > 0 ) {
            deltaY = 0;
        }
        this.y += deltaY;
    }

    @Override
    public void update() {

        if ( ((this.playerToSeek.getX() - this.getX()) > 0) ) {
            this.moveRight();
        } else if ( ((this.playerToSeek.getX() - this.getX()) < 0) ) {
            this.moveLeft();
        }
        if ( (this.playerToSeek.getY() - this.getY()) > 0 ) {
            this.moveDown();
        } else if ( (this.playerToSeek.getY() - this.getY()) < 0 ) {
            this.moveUp();
        }
        else {
            if (deltaX > 0) {
                stoppingToLeft();
            } else if (deltaX < 0) {
                stoppingToRight();
            } else if (deltaY > 0) {
                stoppingToUp();
            } else if (deltaY < 0) {
                stoppingToDown();
            }
        }

    }

    @Override
    public void draw(Graphics graphics) {

        int tileX = tileMap.getX();
        int tileY = tileMap.getY();

        graphics.setColor(new Color(178,34,34));
        graphics.fillRect(
                ((int)(tileX + ( x - ( WIDTH >>> 1 ) ))),
                ((int)(tileY + ( y - ( HEIGHT >>> 1 ) ))),
                WIDTH,
                HEIGHT);
    }

    @Override
    public int getX() {
        return ((int)x);
    }

    @Override
    public int getY() {
        return ((int)y);
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
