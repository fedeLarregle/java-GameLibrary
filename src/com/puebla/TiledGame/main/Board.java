package com.puebla.TiledGame.main;

/**
 * @author federico on 30/05/17.
 * @email fede.larregle@gmail.com
 */
public class Board extends ACanvas {

    private final static short SCALE;
    private final static int WIDTH;
    private final static int HEIGHT;

    static {
        SCALE = 25;
        WIDTH = SCALE * 10;
        HEIGHT = SCALE * 20;
    }

    public Board() {
        super(WIDTH, HEIGHT);
    }

    @Override
    public void drawImage() {

    }
}
