package com.puebla.TiledGame.gameStates.statesImpl;

import com.puebla.TiledGame.gameStates.WinState;
import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.manager.KeyController;

import java.awt.Graphics;

/**
 * @author federico on 23/05/17.
 * @email fede.larregle@gmail.com
 */
public class WinStateImpl extends WinState<MenuStateImpl> {

    private boolean movingUp;
    private boolean movingDown;
    private boolean selectingOption;

    public WinStateImpl(Game game, MenuStateImpl menu, String[] options) {
        super(game, menu, options);
        this.movingUp = false;
        this.movingDown = false;
        this.selectingOption = false;
    }

    @Override
    public void update() {
        handleInput();
    }

    @Override
    public void draw(Graphics graphics) {

    }

    @Override
    protected void selectOption() {
        if ( KeyController.isPressedPreviousInMind(KeyController.ENTER) ) {
            setSelectingOption(true);
        }
        if ( KeyController.isPressedPreviousInMind(KeyController.DOWN) &&
                currentOption < (options.length - 1) ) {
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
                currentOption < (options.length - 1)) ) {
            setMovinDown(false);
        }
        if ( !(KeyController.isPressedPreviousInMind(KeyController.UP) &&
                currentOption > 0) ) {
            setMovingUp(false);
        }
    }

    public void setSelectingOption(boolean selectingOption) { this.selectingOption = selectingOption; }

    public void setMovingUp(boolean movingUp) { this.movingUp = movingUp; }

    public void setMovinDown(boolean movingDown) { this.movingDown = movingDown; }

    @Override
    protected void toMenu() {
        game.setGameState(menu);
    }
}
