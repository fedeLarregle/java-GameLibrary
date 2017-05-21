package com.puebla.TiledGame.manager;

import java.awt.image.BufferedImage;

/**
 * @author federico on 21/05/17.
 * @email fede.larregle@gmail.com
 */
public class Animation {

    private final BufferedImage[] images;
    private final int numberImages;
    private int currentImage;
    private int frameCounter;

    public Animation(BufferedImage[] images) {
        this.images = images;
        this.numberImages = images.length;
        this.currentImage = 0;
        this.frameCounter = 0;
    }

    public void update() {
        frameCounter++;

        if ( !((frameCounter % 10) == 0) ) {
            return;
        }
        
        currentImage++;

        if ( currentImage == numberImages ) {
            currentImage = 0;
        }

    }

    public BufferedImage getImage() { return images[currentImage]; }
}
