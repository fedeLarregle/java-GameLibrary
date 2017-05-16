package com.puebla.TiledGame.manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * @author federico on 12/04/17.
 * @email fede.larregle@gmail.com
 */
public class DrawController {

    public static void drawTextContent(Graphics graphics, final String text, boolean current, int x, int y) {
        Font font = null;

        /* Setting the font's size depending on if we are position in that option */
        if ( current ) {
            font = new Font("TimesRoman", Font.PLAIN, 50);
        } else {
            font = new Font("TimesRoman", Font.PLAIN, 30);
        }

        graphics.setColor(Color.WHITE);
        graphics.setFont(font);

        /* Setting the 'x' to center it taking in count the width of the text */
        x -= (graphics.getFontMetrics().stringWidth(text)) >> 1;

        graphics.drawString(text, x, y);

    }
}
