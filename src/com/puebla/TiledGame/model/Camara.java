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

    public Camara(Game game, TileMap tileMap) {
        this.game = game;
        this.tileMap = tileMap;
        this.x = 0;
        this.y = 0;
    }

    public void move(Player player, Mode mode) {

        switch ( mode ) {
            /* The Camara will keep the player in the middle of the scene */
            case FOLLOW: {
                System.out.println(((Game.WIDTH >>> 1) - player.getX()));
                System.out.println(((Game.HEIGHT >>> 1) - player.getY()));
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
                    break;
                }
                if ( (player.getY() - player.getHeight() ) < getY() ) {
                    tileMap.setY(tileMap.getY() + ( Game.HEIGHT >> 1) );
                    setY(getY() - Game.HEIGHT >> 1);
                    break;
                }
                break;
            }
            /* TODO the Camara will be moved manually by user keyboard input */
            case MANUAL: {
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

    public enum Mode {
        FOLLOW, SCREEN, MANUAL
    }
}
