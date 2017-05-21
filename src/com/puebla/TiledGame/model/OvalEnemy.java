package com.puebla.TiledGame.model;

import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.manager.CollidableCircle;
import com.puebla.TiledGame.tileMap.TileMap;

import java.awt.Color;
import java.awt.Graphics;

/**
 * TODO I need to make a super class abstract or not like 'RectEnemy' to
 * @author federico on 19/05/17.
 * @email fede.larregle@gmail.com
 */
public class OvalEnemy extends Enemy<OvalActor> implements CollidableCircle {

    private double r;


    public OvalEnemy(Game game, TileMap tileMap, OvalActor ovalActor, int x, int y) {
        super(game, tileMap, ovalActor, x, y);
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

        if ( ((this.actorToSeek.getX() - this.getX()) > 0) ) {
            this.moveRight();
        } else if ( ((this.actorToSeek.getX() - this.getX()) < 0) ) {
            this.moveLeft();
        }
        if ( (this.actorToSeek.getY() - this.getY()) > 0 ) {
            this.moveDown();
        } else if ( (this.actorToSeek.getY() - this.getY()) < 0 ) {
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
        graphics.fillOval(
                ((int)(tileX + ( x - ( WIDTH >>> 1 ) ))),
                ((int)(tileY + ( y - ( HEIGHT >>> 1 ) ))),
                WIDTH,
                HEIGHT);
    }

    @Override
    public int getR() {
        return ((int) r);
    }

}
