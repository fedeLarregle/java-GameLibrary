package com.puebla.TiledGame.model;

import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.tileMap.TileMap;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author federico on 06/05/17.
 * @email fede.larregle@gmail.com
 */
public class Diamond implements Entity{

    private double x;
    private double y;
    private final double width;
    private final double height;

    private Game game;
    private TileMap tileMap;

    public Diamond(Game game, TileMap tileMap) {
        this.game = game;
        this.tileMap = tileMap;
        this.width = 32;
        this.height = 32;
    }


    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics graphics) {

        graphics.setColor(Color.WHITE);
        graphics.fillOval(((int)x), ((int)y), ((int)width), ((int)height));
    }
}
