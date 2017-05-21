package com.puebla.TiledGame.model;

import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.tileMap.TileMap;

import java.awt.Graphics;

/**
 * @author federico on 20/05/17.
 * @email fede.larregle@gmail.com
 */
public abstract class Enemy<A extends Actor> implements Entity {

    protected Game game;
    protected TileMap tileMap;
    protected A actorToSeek;

    protected double x;
    protected double y;
    protected double deltaX;
    protected double deltaY;

    protected final static int WIDTH;
    protected final static int HEIGHT;

    protected final static double MOVE_SPEED;
    protected final static double MAX_SPEED;
    protected final static double STOPPING_SPPED;

    static {
        MOVE_SPEED = 0.10;
        MAX_SPEED = 2.0;
        STOPPING_SPPED = 0.4;
        WIDTH = 16;
        HEIGHT = 16;
    }

    public Enemy(Game game, TileMap tileMap, A actorToSeek, int x, int y) {
        this.game = game;
        this.tileMap = tileMap;
        this.actorToSeek = actorToSeek;
        this.x = x;
        this.y = y;
    }

    @Override
    public abstract void update();

    @Override
    public abstract void draw(Graphics graphics);

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public TileMap getTileMap() {
        return tileMap;
    }

    public void setTileMap(TileMap tileMap) {
        this.tileMap = tileMap;
    }

    public A getActorToSeek() {
        return actorToSeek;
    }

    public void setActorToSeek(A actorToSeek) {
        this.actorToSeek = actorToSeek;
    }

    public int getX() {
        return ((int)x);
    }

    public void setX(double x) {
        this.x = x;
    }

    public int getY() {
        return ((int)y);
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(double deltaX) {
        this.deltaX = deltaX;
    }

    public double getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(double deltaY) {
        this.deltaY = deltaY;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public static double getMoveSpeed() {
        return MOVE_SPEED;
    }

    public static double getMaxSpeed() {
        return MAX_SPEED;
    }

    public static double getStoppingSpped() {
        return STOPPING_SPPED;
    }
}
