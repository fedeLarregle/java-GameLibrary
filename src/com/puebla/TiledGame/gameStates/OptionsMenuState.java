package com.puebla.TiledGame.gameStates;

import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.manager.DrawController;
import com.puebla.TiledGame.manager.KeyController;
import com.puebla.TiledGame.model.Camara;

import java.awt.Graphics;

/**
 * @author federico on 18/05/17.
 * @email fede.larregle@gmail.com
 */
public class OptionsMenuState implements GameState{

    private final static String[] OPTIONS;
    private final Game game;
    private int currentOption;

    private boolean movingUp;
    private boolean movingDown;
    private boolean selectingOption;

    static {
        OPTIONS = new String[] {
                "FOLLOW PLAYER",
                "SCENE BY SCENE",
                "MANUAL"

        };
    }

    public OptionsMenuState(Game game) {
        this.game = game;
        this.currentOption = 0;
        this.movingDown = false;
        this.movingUp = false;
        this.selectingOption = false;
    }

    @Override
    public void update() {
        handleInput();
        if ( selectingOption ) { selectOption(); }
        if ( movingUp ) { currentOption--; }
        if ( movingDown ) { currentOption++; }
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
        if ( KeyController.isPressedPreviousInMind(KeyController.ENTER) ) {
            setSelectingOption(true);
        }
        if ( KeyController.isPressedPreviousInMind(KeyController.DOWN) &&
                currentOption < (OPTIONS.length - 1) ) {
            setMovinDown(true);
        }
        if ( KeyController.isPressedPreviousInMind(KeyController.UP) &&
                currentOption > 0 ) {
            setMovingUp(true);
        }
        if ( !(KeyController.isPressedPreviousInMind(KeyController.ENTER)) ) {
            setSelectingOption(false);
        }
        if ( !(KeyController.isPressedPreviousInMind(KeyController.DOWN) &&
                currentOption < (OPTIONS.length - 1)) ) {
            setMovinDown(false);
        }
        if ( !(KeyController.isPressedPreviousInMind(KeyController.UP) &&
                currentOption > 0) ) {
            setMovingUp(false);
        }
    }

    private void selectOption() {
        if ( currentOption == 0 ) {
            game.getCamara().setMode(Camara.Mode.FOLLOW);
            game.setGameState(new MenuState(game));
        }
        if ( currentOption == 1 ) {
            game.getCamara().setMode(Camara.Mode.SCREEN);
            game.setGameState(new MenuState(game));
        }
        if ( currentOption == 2 ) {
            game.getCamara().setMode(Camara.Mode.MANUAL);
            game.setGameState(new MenuState(game));
        }

    }

    public void setSelectingOption(boolean selectingOption) { this.selectingOption = selectingOption; }

    public void setMovingUp(boolean movingUp) { this.movingUp = movingUp; }

    public void setMovinDown(boolean movingDown) { this.movingDown = movingDown; }

    public int getCurrentOption() { return this.currentOption; }
}
