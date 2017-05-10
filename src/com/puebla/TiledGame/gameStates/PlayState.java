package com.puebla.TiledGame.gameStates;

import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.manager.Collisions;
import com.puebla.TiledGame.manager.KeyController;
import com.puebla.TiledGame.model.Enemy;
import com.puebla.TiledGame.model.Player;
import com.puebla.TiledGame.tileMap.TileMap;

import java.awt.Graphics;

/**
 * @author federico on 12/04/17.
 * @email fede.larregle@gmail.com
 */
public class PlayState implements GameState{

    private final TileMap tileMap;
    private final Game game;
    private final Player player;
    private final Enemy enemy;
    private static final Collisions collisions;

    static {
        collisions = Collisions.getInstance();
    }

    public PlayState(Game game, TileMap tileMap) {
        this.game = game;
        this.tileMap = tileMap;
        this.player = new Player(game, tileMap);
        this.player.setX(50);
        this.player.setY(50);
        this.enemy = new Enemy(game, tileMap, player);
        this.enemy.setX(80);
        this.enemy.setY(50);
    }

    @Override
    public void update() {
        handleInput();
        player.update();
        enemy.update();
        if ( collisions.checkRectangleCollision(player, enemy) ) {
            game.setGameState(new GameOverState(game));
        }
    }

    @Override
    public void draw(Graphics graphics) {
        tileMap.draw(graphics);
        player.draw(graphics);
        enemy.draw(graphics);
    }

    @Override
    public void handleInput() {

        if (KeyController.isPressed(KeyController.P)) {
            game.setGameState(new PauseState(game, this));
        }
        if (KeyController.isPressed(KeyController.LEFT)) {
            player.setLeft(true);
        }
        if (KeyController.isPressed(KeyController.RIGHT)) {
            player.setRight(true);
        }
        if (KeyController.isPressed(KeyController.UP)) {
            player.setUp(true);
        }
        if (KeyController.isPressed(KeyController.DOWN)) {
            player.setDown(true);
        }

        if (!(KeyController.isPressed(KeyController.LEFT))) {
            player.setLeft(false);
        }
        if (!(KeyController.isPressed(KeyController.RIGHT))) {
            player.setRight(false);
        }
        if (!(KeyController.isPressed(KeyController.UP))) {
            player.setUp(false);
        }
        if (!(KeyController.isPressed(KeyController.DOWN))) {
            player.setDown(false);
        }

    }
}
