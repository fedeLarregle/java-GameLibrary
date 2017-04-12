package com.puebla.TiledGame.gameStates;

import java.awt.Graphics;

/**
 * Created by federico on 12/04/17.
 */
public interface GameState {

    public abstract void init();
    public abstract void update();
    public abstract void draw(Graphics graphics);
    public abstract void handleInput();
}
