package com.puebla.TiledGame.model;

import com.puebla.TiledGame.gameStates.GameOverState;
import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.manager.Collidable;
import com.puebla.TiledGame.manager.DrawController;
import com.puebla.TiledGame.tileMap.TileMap;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * @author federico on 13/04/17.
 * @email fede.larregle@gmail.com
 */
public class Player implements Entity, Collidable{

    private final TileMap tileMap;
    private final Game game;
    private final List<Diamond> diamons;

    private double x;
    private double y;
    private double deltaX;
    private double deltaY;

    private final static int WIDTH;
    private final static int HEIGHT;

    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

    private final static double MOVE_SPEED;
    private final static double MAX_SPEED;
    private final static double STOPPING_SPPED;

    private boolean topLeft;
    private boolean topRight;
    private boolean bottomLeft;
    private boolean bottomRight;

    private int counter;

    static {
        MOVE_SPEED = 0.3;
        MAX_SPEED = 3.0;
        STOPPING_SPPED = 0.3;
        WIDTH = 24;
        HEIGHT = 24;
    }

    public Player(Game game, TileMap tileMap) {

        this.game = game;
        this.tileMap = tileMap;
        this.diamons = new ArrayList<>();
        this.counter = 0;

    }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    @Override
    public int getX() { return ((int) this.x); }

    @Override
    public int getY() { return ((int) this.y); }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public void update() {
        if ( isLeft() ) {
            moveLeft();
        } else if ( isRight() ) {
            moveRight();
        } else if ( isUp() ) {
            moveUp();
        } else if ( isDown() ) {
            moveDown();
        } else {
            if ( deltaX > 0 ) {
                stoppingToLeft();
            } else if ( deltaX < 0 ) {
                stoppingToRight();
            } else if ( deltaY > 0 ) {
                stoppingToUp();
            } else if ( deltaY < 0 ) {
                stoppingToDown();
            }
        }

        int currentCol = tileMap.getCol((int) x);
        int currentRow = tileMap.getRow((int) y);

        double toX = x + deltaX;
        double toY = y + deltaY;

        double tempX = x;
        double tempY = y;

        /* Calculate if there's any corner if you move up or down */
        calculateCorners(x, toY);
        /* First checking if you move up */
        if ( deltaY < 0 ) {
            if ( topLeft || topRight ) {
                deltaY = 0;
                tempY = currentRow * tileMap.getTileSize() + (HEIGHT >>> 1);
            } else  {
                tempY += deltaY;
            }
        }
        /* Then we check for moving down */
        if ( deltaY > 0 ) {
            if ( bottomLeft || bottomRight ) {
                deltaY = 0;
                tempY = ( currentRow + 1 ) * tileMap.getTileSize() - (HEIGHT >>> 1);
            } else  {
                tempY += deltaY;
            }
        }

        /* Now we calculate if there's any corner when moving to the left or to the right */
        calculateCorners(toX, y);
        /* First moving to the left */
        if ( deltaX < 0 ) {
            if ( topLeft || bottomLeft ) {
                deltaX = 0;
                tempX = currentCol * tileMap.getTileSize() + (WIDTH >>> 1);
            } else  {
                tempX += deltaX;
            }
        }
        /* Now moving to the right */
        if ( deltaX > 0 ) {
            if ( topRight || bottomRight ) {
                deltaX = 0;
                tempX = (currentCol + 1) * tileMap.getTileSize() - (WIDTH >>> 1);
            } else {
                tempX += deltaX;
            }
        }
        /* Finally we assign the value to the x and y respectively of our player */
        x  = tempX;
        y  = tempY;

        /* Move the map in order for the player to be always on the center of the window */
        tileMap.setX((int) ((Game.WIDTH >>> 1) - x));
        tileMap.setY((int) ((Game.HEIGHT >>> 1) - y));
    }

    @Override
    public void draw(Graphics graphics) {

        int tileX = tileMap.getX();
        int tileY = tileMap.getY();

        graphics.setColor(Color.BLUE);
        graphics.fillRect(
                (int) (tileX + ( x - ( WIDTH >>> 1 ) )),
                (int) (tileY + ( y - ( HEIGHT >>> 1 ) )),
                WIDTH,
                HEIGHT
        );

        int counterXPosition = ((game.WIDTH >>> 1) + (game.WIDTH >>> 2));
        int counterYPosition = ((game.HEIGHT >>> 1) - (game.WIDTH >>> 2));

        graphics.setColor(Color.WHITE);
        DrawController.drawTextContent(
                graphics, String.valueOf("Points: " + counter), false, counterXPosition, counterYPosition
        );

    }

    public void moveLeft() {
        deltaX -= MOVE_SPEED;
        if ( deltaX < -MAX_SPEED ) {
            deltaX = -MAX_SPEED;
        }
    }

    public void moveRight() {
        deltaX += MOVE_SPEED;
        if ( deltaX > MAX_SPEED ) {
            deltaX = MAX_SPEED;
        }
    }

    public void moveUp() {
        deltaY -= MOVE_SPEED;
        if ( deltaY < -MAX_SPEED ) {
            deltaY = -MAX_SPEED;
        }
    }

    public void moveDown() {
        deltaY += MOVE_SPEED;
        if ( deltaY > MAX_SPEED ) {
            deltaY = MAX_SPEED;
        }
    }

    public void stoppingToLeft() {
        deltaX -= STOPPING_SPPED;
        if ( deltaX < 0 ) {
            deltaX = 0;
        }
    }

    public void stoppingToRight() {
        deltaX += STOPPING_SPPED;
        if ( deltaX > 0 ) {
            deltaX = 0;
        }
    }

    public void stoppingToUp() {
        deltaY -= STOPPING_SPPED;
        if ( deltaY < 0 ) {
            deltaY = 0;
        }
    }

    public void stoppingToDown() {
        deltaY += STOPPING_SPPED;
        if ( deltaY > 0 ) {
            deltaY = 0;
        }
    }

    private void calculateCorners(double x, double y) {

        int leftTile = tileMap.getCol((int) (x - (WIDTH >>> 1)));
        int rightTile = tileMap.getCol((int) (x + (WIDTH >>> 1) - 1));
        int topTile = tileMap.getRow((int) (y - (HEIGHT >>> 1)));
        int bottomTile = tileMap.getRow((int) (y + (HEIGHT >>> 1) - 1));

        topLeft = tileMap.getTile(topTile, leftTile) == 0;
        topRight = tileMap.getTile(topTile, rightTile) == 0;
        bottomLeft = tileMap.getTile(bottomTile, leftTile) == 0;
        bottomRight = tileMap.getTile(bottomTile, rightTile) == 0;

        if (tileMap.getTile(topTile, leftTile) == 3 || tileMap.getTile(topTile, rightTile) == 3 ||
                tileMap.getTile(bottomTile, leftTile) == 3 || tileMap.getTile(bottomTile, rightTile) == 3) {
            game.setGameState(new GameOverState(game));
        }

    }
}
