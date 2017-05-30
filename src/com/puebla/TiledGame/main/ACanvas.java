package com.puebla.TiledGame.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * @author federico on 30/05/17.
 * @email fede.larregle@gmail.com
 */
public abstract class ACanvas extends Canvas {

    BufferedImage image;
    Graphics2D graphics;

    public ACanvas(int WIDTH, int HEIGHT) {
        super();
        setSize(WIDTH, HEIGHT);
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_3BYTE_BGR, null);
        graphics = ((Graphics2D)image.getGraphics());
    }

    public abstract void drawImage();

    private void draw() {
        Graphics graphics = getGraphics();
        graphics.drawImage(image, 0, 0, null);
        graphics.dispose();
    }

    public void run() {
        drawImage();
        draw();
    }
}
