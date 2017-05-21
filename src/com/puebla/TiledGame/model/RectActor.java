package com.puebla.TiledGame.model;

import com.puebla.TiledGame.gameStates.GameOverState;
import com.puebla.TiledGame.main.Game;
import com.puebla.TiledGame.manager.CollidableRectangle;
import com.puebla.TiledGame.manager.Collisions;
import com.puebla.TiledGame.manager.DrawController;
import com.puebla.TiledGame.manager.Movement;
import com.puebla.TiledGame.tileMap.TileMap;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * @author federico on 13/04/17.
 * @email fede.larregle@gmail.com
 */
public class RectActor extends Actor implements CollidableRectangle {

    private final static Movement MOVEMENT;
    private final List<Diamond> diamons;

    private int health;
    private int counter;

    static {
        MOVEMENT = Movement.getInstance();
    }

    public RectActor(Game game, TileMap tileMap, int x, int y) {
        super(game, tileMap, x, y);
        this.diamons = new ArrayList<>();
        this.counter = 0;
        this.health = 50;

    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void gotHit() { this.health--; }

    public boolean isDead() { return ( this.health == 0 ); }

    @Override
    public void update() {
        if ( isLeft() ) {
            deltaX = MOVEMENT.moveLeft(deltaX, MOVE_SPEED, MAX_SPEED);
        } else if ( isRight() ) {
            deltaX = MOVEMENT.moveRight(deltaX, MOVE_SPEED, MAX_SPEED);
        } else if ( isUp() ) {
            deltaY = MOVEMENT.moveUp(deltaY, MOVE_SPEED, MAX_SPEED);
        } else if ( isDown() ) {
            deltaY = MOVEMENT.moveDown(deltaY, MOVE_SPEED, MAX_SPEED);
        } else {
            if ( deltaX > 0 ) {
                deltaX = MOVEMENT.stoppingToLeft(deltaX, STOPPING_SPPED);
            } else if ( deltaX < 0 ) {
                deltaX = MOVEMENT.stoppingToRight(deltaX, STOPPING_SPPED);
            } else if ( deltaY > 0 ) {
                deltaY = MOVEMENT.stoppingToUp(deltaY, STOPPING_SPPED);
            } else if ( deltaY < 0 ) {
                deltaY = MOVEMENT.stoppingToDown(deltaY, STOPPING_SPPED);
            }
        }

        int currentCol = tileMap.getCol((int) x);
        int currentRow = tileMap.getRow((int) y);

        double toX = x + deltaX;
        double toY = y + deltaY;

        double tempX = x;
        double tempY = y;

        /* Calculate if there's any corner if you move up or down */
        topLeft = Collisions.getInstance().checkTopLeftCorners(tileMap, ((int)x), ((int)toY), this);
        topRight = Collisions.getInstance().checkTopRightCorners(tileMap, ((int)x), ((int)toY), this);
        Collisions.getInstance().checkDeathWallCollision(tileMap, game, ((int)x), ((int)toY), this);

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
        bottomLeft = Collisions.getInstance().checkBottomLeftCorners(tileMap, ((int)x), ((int)toY), this);
        bottomRight = Collisions.getInstance().checkBottomRightCorners(tileMap, ((int)x), ((int)toY), this);

        if ( deltaY > 0 ) {
            if ( bottomLeft || bottomRight ) {
                deltaY = 0;
                tempY = ( currentRow + 1 ) * tileMap.getTileSize() - (HEIGHT >>> 1);
            } else  {
                tempY += deltaY;
            }
        }

        /* Now we calculate if there's any corner when moving to the left or to the right */
        topLeft = Collisions.getInstance().checkBottomLeftCorners(tileMap, ((int)toX), ((int)y), this);
        bottomLeft = Collisions.getInstance().checkBottomRightCorners(tileMap, ((int)toX), ((int)y), this);
        Collisions.getInstance().checkDeathWallCollision(tileMap, game, ((int)toX), ((int)y), this);
        /* First moving to the left */
        if ( deltaX < 0 ) {
            if ( topLeft || bottomLeft ) {
                deltaX = 0;
                tempX = currentCol * tileMap.getTileSize() + (WIDTH >>> 1);
            } else  {
                tempX += deltaX;
            }
        }

        topRight = Collisions.getInstance().checkBottomRightCorners(tileMap, ((int)toX), ((int)y), this);
        bottomRight = Collisions.getInstance().checkTopRightCorners(tileMap, ((int)toX), ((int)y), this);
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
        //tileMap.setX((int) ((Game.WIDTH >>> 1) - x));
        //tileMap.setY((int) ((Game.HEIGHT >>> 1) - y));
    }

    @Override
    public void draw(Graphics graphics) {

        int tileX = tileMap.getX();
        int tileY = tileMap.getY();

        graphics.setColor(Color.YELLOW);
        graphics.fillRect(
                (int) (tileX + ( x - ( WIDTH >>> 1 ) )),
                (int) (tileY + ( y - ( HEIGHT >>> 1 ) )),
                WIDTH,
                HEIGHT
        );

        int counterXPosition = ((game.WIDTH >>> 1) + (game.WIDTH >>> 2));
        int counterYPosition = ((game.HEIGHT >>> 1) - (game.WIDTH >>> 2) - (game.WIDTH >>> 3) );

        graphics.setColor(Color.WHITE);

        DrawController.drawTextContent(
                graphics, String.valueOf("Health: " + health), false, counterXPosition, counterYPosition
        );

        counterYPosition += (game.WIDTH >>> 3);

        DrawController.drawTextContent(
                graphics, String.valueOf("Points: " + counter), false, counterXPosition, counterYPosition
        );



    }

}
