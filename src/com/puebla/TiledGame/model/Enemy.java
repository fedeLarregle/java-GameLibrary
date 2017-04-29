package com.puebla.TiledGame.model;

import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.tileMap.TileMap;

import java.awt.Graphics;

/**
 * Created by federico on 29/04/17.
 */
public class Enemy implements Entity{

    private double x;
    private double y;
    private double deltaX;
    private double deltaY;

    private int width;
    private int height;

    private Game game;
    private TileMap tileMap;
    private Player playerToSeek;

    public Enemy(Game game, TileMap tileMap, Player playerToSeek) {
        this.game = game;
        this.tileMap = tileMap;
        this.playerToSeek = playerToSeek;
        this.width = 24;
        this.height = 24;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics graphics) {

    }
}
