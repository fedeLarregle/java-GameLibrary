package com.puebla.TiledGame.model;

import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.manager.Collidable;
import com.puebla.TiledGame.tileMap.TileMap;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author federico on 06/05/17.
 * @email fede.larregle@gmail.com
 */
public class Diamond implements Entity, Collidable{

    private Game game;
    private TileMap tileMap;

    private double x;
    private double y;

    private final static double WIDTH;
    private final static double HEIGHT;


    static {
        WIDTH = 32;
        HEIGHT = 32;
    }

    public Diamond(Game game, TileMap tileMap) {
        this.game = game;
        this.tileMap = tileMap;
    }


    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics graphics) {

        graphics.setColor(Color.WHITE);
        graphics.fillOval(((int)x), ((int)y), ((int)WIDTH), ((int)HEIGHT));
    }

    @Override
    public int getX() {
        return ((int)this.x);
    }

    @Override
    public int getY() {
        return ((int)this.y);
    }

    @Override
    public int getWidth() {
        return ((int)WIDTH);
    }

    @Override
    public int getHeight() {
        return ((int)HEIGHT);
    }
}
