package com.puebla.TiledGame.gameStates;

import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.manager.DrawController;
import com.puebla.TiledGame.manager.KeyController;

import java.awt.Graphics;

/**
 * @author federico on 12/04/17.
 * @email fede.larregle@gmail.com
 */
public class PauseState implements GameState {

    private final Game game;
    private PlayState previousPlayState;
    private final static String[] PAUSE_CONTENT;

    static {
        PAUSE_CONTENT = new String[]{
                "PAUSED",
                "ARROWS TO MOVE",
                "ESCAPE TO RETURN"
        };
    }

    public PauseState(Game game, PlayState playState) {
        this.game = game;
        this.previousPlayState = playState;
    }


    @Override
    public void update() {
        handleInput();
    }

    @Override
    public void draw(Graphics graphics) {

        /* Setting the initial x and y position */
        int x = (game.WIDTH) >>> 1;
        int y = (game.HEIGHT - 50) >>> 1;

        for (int i = 0; i < PAUSE_CONTENT.length; i++) {

            DrawController.drawTextContent(graphics, PAUSE_CONTENT[i], false, x, y);

            x = (game.WIDTH) >>> 1;
            y += 50;
        }
    }

    @Override
    public void handleInput() {
        if ( KeyController.isPressed(KeyController.ESCAPE) ) {
            game.setGameState(previousPlayState);
        }
    }
}
