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

    public static double moveLeft(double deltaX, final double MOVE_SPEED, final double MAX_SPEED) {
        deltaX -= MOVE_SPEED;
        if ( deltaX < -MAX_SPEED ) {
            deltaX = -MAX_SPEED;
        }
        return deltaX;
    }

    public static double moveRight(double deltaX, final double MOVE_SPEED, final double MAX_SPEED) {
        deltaX += MOVE_SPEED;
        if ( deltaX > MAX_SPEED ) {
            deltaX = MAX_SPEED;
        }
        return deltaX;
    }

    public static double moveUp(double deltaY, final double MOVE_SPEED, final double MAX_SPEED) {
        deltaY -= MOVE_SPEED;
        if ( deltaY < -MAX_SPEED ) {
            deltaY = -MAX_SPEED;
        }
        return deltaY;
    }

    public static double moveDown(double deltaY, final double MOVE_SPEED, final double MAX_SPEED) {
        deltaY += MOVE_SPEED;
        if ( deltaY > MAX_SPEED ) {
            deltaY = MAX_SPEED;
        }
        return deltaY;
    }

    public static double stoppingToLeft(double deltaX, final double STOPPING_SPPED) {
        deltaX -= STOPPING_SPPED;
        if ( deltaX < 0 ) {
            deltaX = 0;
        }
        return deltaX;
    }

    public static double stoppingToRight(double deltaX, final double STOPPING_SPPED) {
        deltaX += STOPPING_SPPED;
        if ( deltaX > 0 ) {
            deltaX = 0;
        }
        return deltaX;
    }

    public static double stoppingToUp(double deltaY, final double STOPPING_SPPED) {
        deltaY -= STOPPING_SPPED;
        if ( deltaY < 0 ) {
            deltaY = 0;
        }
        return deltaY;
    }

    public static double stoppingToDown(double deltaY, final double STOPPING_SPPED) {
        deltaY += STOPPING_SPPED;
        if ( deltaY > 0 ) {
            deltaY = 0;
        }
        return deltaY;
    }
}
