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
    public Collisions getInstance() {
        return instance;
    }
}
