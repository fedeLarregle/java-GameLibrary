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

    public Camara(Game game, TileMap tileMap, int x, int y) {
        this.game = game;
        this.tileMap = tileMap;
        this.x = x;
        this.y = y;
    }

    public void move(Player player, Mode mode) {

        switch ( mode ) {
            case FOLLOW: {
                break;
            }
            case SCREEN: {
                break;
            }
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
