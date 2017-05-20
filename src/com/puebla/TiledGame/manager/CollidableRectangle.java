package com.puebla.TiledGame.manager;

/**
 * @author federico on 08/05/17.
 * @email fede.larregle@gmail.com
 */
public interface CollidableRectangle extends Collidable {

    /**
     * {@inheritDoc}
     * @return
     */
    public int getX();

    /**
     * {@inheritDoc}
     * @return
     */
    public int getY();
    public int getWidth();
    public int getHeight();
}
