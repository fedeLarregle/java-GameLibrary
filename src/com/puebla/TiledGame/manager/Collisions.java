package com.puebla.TiledGame.manager;

/**
 * Singleton class in charge of checking for collisions between
 * 'CollidableRectangle' Objects {@link CollidableRectangle}
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
     * Simple collision detection method for two rectangle figures
     * Returns a boolean value representing if the two rectangles are colliding or not
     * @param rectangle1
     * @param rectangle2
     * @param <C>
     * @return boolean
     */
    public <C extends CollidableRectangle> boolean checkRectangleCollision(C rectangle1, C rectangle2) {
        boolean areColliding = false;
        if ( ( (rectangle1.getX() >= rectangle2.getX()) &&
                (rectangle1.getX() <= rectangle2.getX() + rectangle2.getWidth()) ) &&
             ( (rectangle1.getY() >= rectangle2.getY()) &&
                (rectangle1.getY() <= rectangle2.getY() + rectangle2.getHeight()) )
            ) {
            areColliding = true;
        }
        return areColliding;
    }

    /**
     * Simple collision detection method for two circle figures
     * Returns a boolean value representing if the two circles are colliding or not
     * @param circle1
     * @param circle2
     * @param <C>
     * @return boolean
     */
    public <C extends CollidableCircle> boolean checkCircleCollision(C circle1, C circle2) {

        int xDif = circle1.getX() - circle2.getX();
        int yDif = circle1.getY() - circle2.getY();
        int squaredDistance = ( xDif * xDif ) + ( yDif * yDif );

        return ( squaredDistance < (circle1.getR() + circle2.getR()) * (circle1.getR() + circle2.getR()) );
    }
}
