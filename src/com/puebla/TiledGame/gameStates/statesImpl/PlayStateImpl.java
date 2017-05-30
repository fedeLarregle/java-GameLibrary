package com.puebla.TiledGame.gameStates.statesImpl;

import com.puebla.TiledGame.gameStates.PauseState;
import com.puebla.TiledGame.gameStates.PlayState;
import com.puebla.TiledGame.main.GameImpl;
import com.puebla.TiledGame.manager.KeyController;
import com.puebla.TiledGame.model.Camara;
import com.puebla.TiledGame.model.RectActor;
import com.puebla.TiledGame.model.RectEnemy;

import java.awt.Graphics;

/**
 * @author federico on 23/05/17.
 * @email fede.larregle@gmail.com
 */
public class PlayStateImpl extends PlayState<GameImpl, PauseStateImpl, GameOverStateImpl>{

    private final RectActor player;
    private final RectEnemy enemy;
    private final Camara camara;

    public PlayStateImpl(GameImpl game,
                         RectActor player,
                         RectEnemy enemy,
                         Camara camara) {
        super(game);
        this.player = player;
        this.enemy = enemy;
        this.camara = camara;
    }

    @Override
    public void update() {
        super.update();
        handleInput();
        player.update();
        enemy.update();
        if ( getCollisions().checkRectangleCollision(player, enemy) ) {
            player.gotHit();
            if ( player.isDead() ) {
                getGame().setGameState(new GameOverStateImpl(getGame()));
            }
        }
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
    }

    @Override
    public void handleInput() {
        if (KeyController.isPressed(KeyController.P)) {
            getGame().setGameState(new PauseState(getGame(), this));
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
        if (KeyController.isPressed(KeyController.W)) {
            camara.setMovingUp(true);
        }
        if (KeyController.isPressed(KeyController.A)) {
            camara.setMovingLeft(true);
        }
        if (KeyController.isPressed(KeyController.S)) {
            camara.setMovingDown(true);
        }
        if (KeyController.isPressed(KeyController.D)) {
            camara.setMovingRight(true);
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
        if (!(KeyController.isPressed(KeyController.W))) {
            camara.setMovingUp(false);
        }
        if (!(KeyController.isPressed(KeyController.A))) {
            camara.setMovingLeft(false);
        }
        if (!(KeyController.isPressed(KeyController.S))) {
            camara.setMovingDown(false);
        }
        if (!(KeyController.isPressed(KeyController.D))) {
            camara.setMovingRight(false);
        }
    }
}
