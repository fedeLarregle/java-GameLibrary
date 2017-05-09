package com.puebla.TiledGame.manager;

/**
 * Singleton class in charge of checking for collisions between
 * 'Collidable' Objects {@link Collidable}
 * @author federico on 08/05/17.
 * @email fede.larregle@gmail.com
 */
public class Collisions {

    private static final Collisions instance;

    static {
        instance = new Collisions();
    }

    /**
     * Returns a static single instance of the Collisions (this) class
     * @return {@link Collisions}
     */
    public static Collisions getInstance() {
        return instance;
    }

    /**
     * Simple collision check method
     * Returns a boolean value representing if the two rectangles are colliding or not
     * @param collidable1
     * @param collidable2
     * @param <C>
     * @return boolean
     */
    public <C extends Collidable> boolean checkRectangleCollision(C collidable1, C collidable2) {
        boolean areColliding = false;
        if ( ( (collidable1.getX() >= collidable2.getX()) &&
                (collidable1.getX() <= collidable2.getX() + collidable2.getWidth()) ) &&
             ( (collidable1.getY() >= collidable2.getY()) &&
                (collidable1.getY() <= collidable2.getY() + collidable2.getHeight()) )
            ) {
            areColliding = true;
        }
        return areColliding;
    }
}
