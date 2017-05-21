package com.puebla.TiledGame.manager;

/**
 * @author federico on 19/05/17.
 * @email fede.larregle@gmail.com
 */
public class Movement {

    private static final Movement instance;

    static {
        instance = new Movement();
    }

    private Movement() {}

    public static Movement getInstance() { return instance; }

    public static double moveLeft(int deltaX, final int MOVE_SPEED, final int MAX_SPEED) {
        deltaX -= MOVE_SPEED;
        if ( deltaX < -MAX_SPEED ) {
            deltaX = -MAX_SPEED;
        }
        return deltaX;
    }

    public static double moveRight(int deltaX, final int MOVE_SPEED, final int MAX_SPEED) {
        deltaX += MOVE_SPEED;
        if ( deltaX > MAX_SPEED ) {
            deltaX = MAX_SPEED;
        }
        return deltaX;
    }

    public static double moveUp(int deltaY, final int MOVE_SPEED, final int MAX_SPEED) {
        deltaY -= MOVE_SPEED;
        if ( deltaY < -MAX_SPEED ) {
            deltaY = -MAX_SPEED;
        }
        return deltaY;
    }

    public static double moveDown(int deltaY, final int MOVE_SPEED, final int MAX_SPEED) {
        deltaY += MOVE_SPEED;
        if ( deltaY > MAX_SPEED ) {
            deltaY = MAX_SPEED;
        }
        return deltaY;
    }

    public static double stoppingToLeft(int deltaX, final int STOPPING_SPPED) {
        deltaX -= STOPPING_SPPED;
        if ( deltaX < 0 ) {
            deltaX = 0;
        }
        return deltaX;
    }

    public static double stoppingToRight(int deltaX, final int STOPPING_SPPED) {
        deltaX += STOPPING_SPPED;
        if ( deltaX > 0 ) {
            deltaX = 0;
        }
        return deltaX;
    }

    public static double stoppingToUp(int deltaY, final int STOPPING_SPPED) {
        deltaY -= STOPPING_SPPED;
        if ( deltaY < 0 ) {
            deltaY = 0;
        }
        return deltaY;
    }

    public static double stoppingToDown(int deltaY, final int STOPPING_SPPED) {
        deltaY += STOPPING_SPPED;
        if ( deltaY > 0 ) {
            deltaY = 0;
        }
        return deltaY;
    }
}
