package com.puebla.TiledGame.gameStates;

import com.puebla.TiledGame.tileMap.TileMap;

import java.awt.Graphics;

/**
 * Created by federico on 12/04/17.
 */
public class PlayState implements GameState{

    private TileMap tileMap;

    public PlayState(TileMap tileMap) {
        this.tileMap = tileMap;
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics graphics) {
        tileMap.draw(graphics);
    }

    @Override
    public void handleInput() {

    }
}
