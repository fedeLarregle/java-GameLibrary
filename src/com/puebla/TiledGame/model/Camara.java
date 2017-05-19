package com.puebla.TiledGame.model;

import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.tileMap.TileMap;


/**
 * @author federico on 16/05/17.
 * @email fede.larregle@gmail.com
 */
public class Camara {

    private final Game game;
    private final TileMap tileMap;
    private int x;
    private int y;
    private boolean movingLeft;
    private boolean movingRight;
    private boolean movingUp;
    private boolean movingDown;

    public Camara(Game game, TileMap tileMap) {
        this.game = game;
        this.tileMap = tileMap;
        this.x = tileMap.getX();
        this.y = tileMap.getY();
        this.movingDown = false;
        this.movingLeft = false;
        this.movingRight = false;
        this.movingUp = false;
    }

    public void move(Player player, Mode mode) {

        switch ( mode ) {
            /* The Camara will keep the player in the middle of the scene */
            case FOLLOW: {
                tileMap.setX( ((Game.WIDTH >>> 1) - player.getX()) );
                tileMap.setY( ((Game.HEIGHT >>> 1) - player.getY()) );
                break;
            }
            /* Camara will move only if we go 'off' the scene */
            case SCREEN: {
                if ( (player.getX() + player.getWidth()) > ( getX() + Game.WIDTH ) ) {
                    tileMap.setX(tileMap.getX() - Game.WIDTH );
                    setX(getX() + Game.HEIGHT);
                }
                if ( (player.getX() ) < getX() ) {
                    tileMap.setX(tileMap.getX() + Game.WIDTH );
                    setX(getX() - Game.HEIGHT);
                }

                if ( (( player.getY() + player.getHeight())) > ( getY() + Game.HEIGHT) ) {
                    tileMap.setY(tileMap.getY() - ( Game.HEIGHT >> 1) );
                    setY(getY() + Game.HEIGHT >> 1);
                }
                if ( (player.getY() - player.getHeight() ) < getY() ) {
                    tileMap.setY(tileMap.getY() + ( Game.HEIGHT >> 1) );
                    setY(getY() - Game.HEIGHT >> 1);
                }
                break;
            }
            /* Camara movement is made manually by user input (W Up - A Left - S Down - D Right) */
            case MANUAL: {
                if ( isMovingDown() ) {
                    tileMap.setY(tileMap.getY() - 2);
                }
                if ( isMovingLeft() ) {
                    tileMap.setX(tileMap.getX() + 2);
                }
                if ( isMovingRight() ) {
                    tileMap.setX(tileMap.getX() - 2);
                }
                if ( isMovingUp() ) {
                    tileMap.setY(tileMap.getY() + 2);
                }
                break;
            }
            default: {
                break;
            }
        }

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isMovingLeft() {
        return movingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public boolean isMovingUp() {
        return movingUp;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public boolean isMovingDown() {
        return movingDown;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }

    public enum Mode {
        FOLLOW, SCREEN, MANUAL
    }
}
