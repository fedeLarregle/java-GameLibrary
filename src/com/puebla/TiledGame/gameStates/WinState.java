package com.puebla.TiledGame.gameStates;

import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.manager.KeyController;

import java.awt.Graphics;

/**
 * @author federico on 23/05/17.
 * @email fede.larregle@gmail.com
 */
public abstract class WinState<G extends Game, M extends MenuState> implements GameState {

    protected final G game;
    protected final M menu;
    protected final String[] options;
    protected int currentOption;

    public WinState(final G game, final M menu, final String[] options) {
        this.game = game;
        this.menu = menu;
        this.options = options;
        this.currentOption = 0;
    }

    @Override
    public abstract void update();

    @Override
    public abstract void draw(Graphics graphics);

    @Override
    public void handleInput() {
        if ( KeyController.isPressedPreviousInMind(KeyController.DOWN) &&
                currentOption < (options.length - 1) ) {
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

    protected abstract void selectOption();

    protected abstract void toMenu();

    public int getCurrentOption() { return this.currentOption; }
}
