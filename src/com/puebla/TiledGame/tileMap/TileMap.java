package com.puebla.TiledGame.tileMap;


import com.puebla.TiledGame.manager.MapReader;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Created by federico on 12/04/17.
 */
public class TileMap {

    private int x;
    private int y;

    private int tileSize;
    private int[][] map;
    private int mapWidth;
    private int mapHeight;

    public TileMap(final int tileSize) {

        this.tileSize = tileSize;
        this.map = MapReader.readMap();
        mapHeight = map.length;
        mapWidth = map.length;

    }

    public void draw(Graphics graphics) {

        for (int row = 0; row < mapHeight; row++) {
            for (int col = 0; col < mapWidth; col++) {

                int point = map[row][col];

                if ( point == 0 ) {
                    /* If we found a 0 in the txt map file we paint with a brown color */
                    graphics.setColor(new Color(139,69,19));
                }
                if ( point == 1 ) {
                    /* If we found a 1 in the txt map file we paint with a black color */
                    graphics.setColor(Color.BLACK);
                }

                graphics.fillRect(x + col * tileSize, y + row * tileSize, tileSize, tileSize);
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCol(int x) {
        return x / tileSize;
    }

    public int getRow(int y) {
        return y / tileSize;
    }

    public int getTileSize() { return this.tileSize; }

    public int getTile(int row, int col) {
        return map[row][col];
    }
}
