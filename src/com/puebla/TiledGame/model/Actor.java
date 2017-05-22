package com.puebla.TiledGame.model;

import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.tileMap.TileMap;

import java.awt.Graphics;

/**
 * @author federico on 20/05/17.
 * @email fede.larregle@gmail.com
 */
public abstract class Actor implements Entity{

    protected final Game game;
    protected final TileMap tileMap;

    protected double x;
    protected double y;
    protected double deltaX;
    protected double deltaY;

    protected final static double MOVE_SPEED;
    protected final static double MAX_SPEED;
    protected final static double STOPPING_SPPED;

    protected final static int WIDTH;
    protected final static int HEIGHT;

    protected boolean left;
    protected boolean right;
    protected boolean up;
    protected boolean down;

    protected boolean topLeft;
    protected boolean topRight;
    protected boolean bottomLeft;
    protected boolean bottomRight;

    static {
        MOVE_SPEED = 0.3;
        MAX_SPEED = 3.0;
        STOPPING_SPPED = 0.3;
        WIDTH = 16;
        HEIGHT = 16;
    }

    public Actor(final Game game, final TileMap tileMap, int x, int y) {
        this.game = game;
        this.tileMap = tileMap;
        this.x = x;
        this.y = y;
    }

    @Override
    public abstract void update();

    @Override
    public abstract void draw(Graphics graphics);

    public boolean isBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(boolean bottomRight) {
        this.bottomRight = bottomRight;
    }

    public boolean isBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(boolean bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public boolean isTopRight() {
        return topRight;
    }

    public void setTopRight(boolean topRight) {
        this.topRight = topRight;
    }

    public boolean isTopLeft() {
        return topLeft;
    }

    public void setTopLeft(boolean topLeft) {
        this.topLeft = topLeft;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public int getHeight() {
        return HEIGHT;
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

    public static double getMoveSpeed() {
        return MOVE_SPEED;
    }

    public static double getMaxSpeed() {
        return MAX_SPEED;
    }

    public static double getStoppingSpped() {
        return STOPPING_SPPED;
    }

    public int getWidth() {
        return WIDTH;
    }

    public Game getGame() {
        return game;
    }

    public TileMap getTileMap() {
        return tileMap;
    }
}
