package com.puebla.TiledGame.model;

import com.puebla.TiledGame.gameStates.GameOverState;
import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.tileMap.TileMap;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author federico on 29/04/17.
 * @email fede.larregle@gmail.com
 */
public class Enemy implements Entity{

    private double x;
    private double y;
    private double deltaX;
    private double deltaY;

    private int width;
    private int height;

    private double moveSpeed;
    private double maxSpeed;
    private double stoppingSpeed;

    private Game game;
    private TileMap tileMap;
    private Player playerToSeek;

    public Enemy(Game game, TileMap tileMap, Player playerToSeek) {
        this.game = game;
        this.tileMap = tileMap;
        this.playerToSeek = playerToSeek;
        this.width = 24;
        this.height = 24;
        this.moveSpeed = 0.15;
        this.maxSpeed = 2.5;
        this.stoppingSpeed = 0.4;
    }

    public void moveRight() {
        deltaX += moveSpeed;
        if ( deltaX > maxSpeed ) {
            deltaX = maxSpeed;
        }
        this.x += deltaX;
    }

    public void moveLeft() {
        deltaX -= moveSpeed;
        if ( deltaX < -maxSpeed ) {
            deltaX = -maxSpeed;
        }
        this.x += deltaX;
    }

    public void moveUp() {

        deltaY -= moveSpeed;
        if ( deltaY < -maxSpeed ) {
            deltaY = -maxSpeed;
        }
        this.y += deltaY;
    }

    public void moveDown() {

        deltaY += moveSpeed;
        if ( deltaY > maxSpeed ) {
            deltaY = maxSpeed;
        }
        this.y += deltaY;
    }

    public void stoppingToLeft() {
        deltaX -= stoppingSpeed;
        if ( deltaX < 0 ) {
            deltaX = 0;
        }
        this.x += deltaX;
    }

    public void stoppingToRight() {
        deltaX += stoppingSpeed;
        if ( deltaX > 0 ) {
            deltaX = 0;
        }
        this.x += deltaX;
    }

    public void stoppingToUp() {
        deltaY -= stoppingSpeed;
        if ( deltaY < 0 ) {
            deltaY = 0;
        }
        this.y += deltaY;
    }

    public void stoppingToDown() {
        deltaY += stoppingSpeed;
        if ( deltaY > 0 ) {
            deltaY = 0;
        }
        this.y += deltaY;
    }

    @Override
    public void update() {

        /* Checking for player enemy collision */
        if (  ((this.getX() - playerToSeek.getX()) >= 0 && ((this.getX() - playerToSeek.getX()) < width)) &&
        ((this.getY() - playerToSeek.getY()) >= 0 && ((this.getY() - playerToSeek.getY()) < height)) ) {
            game.setGameState(new GameOverState(game));
        }

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
                ((int)(tileX + ( x - ( width >>> 1 ) ))),
                ((int)(tileY + ( y - ( height >>> 1 ) ))),
                width,
                height);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
