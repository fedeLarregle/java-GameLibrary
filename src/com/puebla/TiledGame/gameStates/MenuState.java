package com.puebla.TiledGame.gameStates;

import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.manager.DrawController;
import com.puebla.TiledGame.manager.KeyController;
import com.puebla.TiledGame.tileMap.TileMap;

import java.awt.Graphics;

/**
 * Created by federico on 12/04/17.
 */
public class MenuState implements GameState {

    private Game game;
    private int currentOption;
    private String[] options = {
            "START",
            "QUIT"
    };

    public MenuState(Game game) {
        this.game = game;
        this.currentOption = 0;
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

        for (int i = 0; i < options.length; i++) {

            if ( i == getCurrentOption() ) {
                DrawController.drawTextContent(graphics, options[i], true, x, y);
            } else {
                DrawController.drawTextContent(graphics, options[i], false, x, y);
            }

            x = (game.WIDTH) >>> 1;
            y += 50;
        }

    }

    @Override
    public void handleInput() {
        if ( KeyController.isPressed(KeyController.DOWN) &&
                currentOption < (options.length - 1) ) {
            currentOption++;
        }
        if ( KeyController.isPressed(KeyController.UP) &&
                currentOption > 0 ) {
            currentOption--;
        }
        if ( KeyController.isPressed(KeyController.ENTER) ) {
            selectOption();
        }
    }

    private void selectOption() {
        if ( currentOption == 0 ) {
            game.setGameState(new PlayState(game, new TileMap(32)));
        }
        if ( currentOption == 1 ) {
            System.exit(0);
        }
    }

    public int getCurrentOption() { return this.currentOption; }
}
