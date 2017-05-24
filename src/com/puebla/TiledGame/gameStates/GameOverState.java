package com.puebla.TiledGame.gameStates;

import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.manager.DrawController;
import com.puebla.TiledGame.manager.KeyController;
import com.puebla.TiledGame.tileMap.TileMap;

import java.awt.Graphics;

/**
 * @author federico on 12/04/17.
 * @email fede.larregle@gmail.com
 */
public class GameOverState implements GameState {

    private final Game game;
    private int currentOption;
    private final static String[] OPTIONS;

    static {
        OPTIONS = new String[]{
                "QUIT",
                "NEW GAME"
        };
    }

    public GameOverState(Game game) {
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

        for (int i = 0; i < OPTIONS.length; i++) {

            if ( i == getCurrentOption() ) {
                DrawController.drawTextContent(graphics, OPTIONS[i], true, x, y);
            } else {
                DrawController.drawTextContent(graphics, OPTIONS[i], false, x, y);
            }

            x = (game.WIDTH) >>> 1;
            y += 50;
        }
    }

    @Override
    public void handleInput() {
        if ( KeyController.isPressedPreviousInMind(KeyController.DOWN) &&
                currentOption < (OPTIONS.length - 1) ) {
            currentOption++;
        }
        if ( KeyController.isPressedPreviousInMind(KeyController.UP) &&
                currentOption > 0 ) {
            currentOption--;
        }
        if ( KeyController.isPressedPreviousInMind(KeyController.ENTER) ) {
            selectOption();
        }
    }

    private void selectOption() {
        if ( currentOption == 0 ) {
            System.exit(0);
        }
        if ( currentOption == 1 ) {
            game.setGameState(new PlayState(game));
        }
    }

    public int getCurrentOption() { return this.currentOption; }
}
