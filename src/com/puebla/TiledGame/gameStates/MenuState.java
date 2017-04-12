package com.puebla.TiledGame.gameStates;

import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.manager.KeyController;

import java.awt.Color;
import java.awt.Font;
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
    public void init() {

    }

    @Override
    public void update() {
        handleInput();
    }

    @Override
    public void draw(Graphics graphics) {
        int x = (game.WIDTH) >>> 1;
        int y = (game.HEIGHT - 50) >>> 1;
        Font font = null;
        for (int i = 0; i < options.length; i++) {
            System.out.println("Current option: " + currentOption);

            graphics.setColor(Color.WHITE);
            /* Setting the font size depending on which option we are currently on */
            if ( currentOption == i ) {
                System.out.println("START");
                font = new Font("TimesRoman", Font.PLAIN, 50);
            } else {
                font = new Font("TimesRoman", Font.PLAIN, 30);
            }

            graphics.setFont(font);
            x -= (graphics.getFontMetrics().stringWidth(options[i])) >> 1;
            graphics.drawString(options[i], x, y);

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
            game.setGameState(new PlayState());
        }
        if ( currentOption == 1 ) {
            System.exit(0);
        }
    }
}
