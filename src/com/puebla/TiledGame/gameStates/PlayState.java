package com.puebla.TiledGame.gameStates;

import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.manager.Collisions;
import com.puebla.TiledGame.manager.KeyController;
import com.puebla.TiledGame.model.Camara;
import com.puebla.TiledGame.tileMap.TileMap;

import java.awt.Graphics;

/**
 * @author federico on 12/04/17.
 * @email fede.larregle@gmail.com
 */
public class PlayState< P extends PauseState, O extends GameOverState> implements GameState{

    private final TileMap tileMap;
    private final Game game;
    private P pauseImpl;
    private O gameOverImpl;
    private static final Collisions collisions;

    static {
        collisions = Collisions.getInstance();
    }

    public PlayState(Game game) {
        this.game = game;
        this.tileMap = game.getTileMap();
    }

    @Override
    public void update() {
        handleInput();
        /*enemy.update();
        if ( collisions.checkRectangleCollision(player, enemy) ) {
            player.gotHit();
            if ( player.isDead() ) {
                game.setGameState(new GameOverState(game));
            }
        }*/
        /* TODO check collision for circled player and enemy
        if ( collisions.checkCircleCollision(player, enemy) ) {
            player.gotHit();
            if ( player.isDead() ) {
                game.setGameState(new GameOverState(game));
            }
        }*/

    }

    public TileMap getTileMap() {
        return tileMap;
    }

    public Game getGame() {
        return game;
    }

    public P getPauseImpl() {
        return pauseImpl;
    }

    protected void setPauseImpl(P pauseImpl) {
        this.pauseImpl = pauseImpl;
    }

    public O getGameOverImpl() {
        return gameOverImpl;
    }

    protected void setGameOverImpl(O gameOverImpl) {
        this.gameOverImpl = gameOverImpl;
    }

    public static Collisions getCollisions() {
        return collisions;
    }

    @Override
    public void draw(Graphics graphics) {
        tileMap.draw(graphics);
    }

    @Override
    public void handleInput() {
        if (KeyController.isPressed(KeyController.P)) {
            game.setGameState(new PauseState(game, this));
        }
    }
}
