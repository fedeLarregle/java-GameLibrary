package com.puebla.TiledGame.manager;

/**
 * @author federico on 10/05/17.
 * @email fede.larregle@gmail.com
 */
public interface CollidableCircle extends Collidable {

    /**
     * {@inheritDoc}
     * @return
     */
    int getX();

    /**
     * {@inheritDoc}
     * @return
     */
    int getY();

    /**
     * Returns the radius of the Collidable Circle
     * @return int
     */
    int getR();
}
