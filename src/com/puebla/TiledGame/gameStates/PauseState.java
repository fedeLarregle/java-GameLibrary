package com.puebla.TiledGame.gameStates;

import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.manager.DrawController;
import com.puebla.TiledGame.manager.KeyController;

import java.awt.Graphics;

/**
 * Created by federico on 12/04/17.
 */
public class PauseState implements GameState {

    private Game game;
    private PlayState previousPlayState;
    private String[] pauseContent = {
            "PAUSED",
            "ARROWS TO MOVE",
            "ESCAPE TO RETURN"
    };

    public PauseState(Game game, PlayState playState) {
        this.game = game;
        this.previousPlayState = playState;
    }


    @Override
    public void init() {

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

        for (int i = 0; i < pauseContent.length; i++) {

            DrawController.drawTextContent(graphics, pauseContent[i], false, x, y);

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
