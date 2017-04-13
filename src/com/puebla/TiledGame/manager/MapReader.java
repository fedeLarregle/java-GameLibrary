package com.puebla.TiledGame.manager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by federico on 12/04/17.
 */
public class MapReader {

    public static String file = MapReader.class.getClassLoader().getResource("map/map").getFile();

    public static int[][] readMap() {
        int[][] map = null;
        int mapWidth = 0, mapHeight = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            /* Reads first two lines of map file that contains width and height */
            mapWidth = Integer.parseInt(bufferedReader.readLine());
            mapHeight = Integer.parseInt(bufferedReader.readLine());
            map = new int[mapHeight][mapWidth];
            String delimiter = " ";
            /* We populate the map with each number per line */
            for ( int row = 0; row < mapHeight; row++ ) {
                String line = bufferedReader.readLine();
                String[] tokens = line.split(delimiter);
                for ( int col = 0; col < mapWidth; col++ ) {
                    map[row][col] = Integer.parseInt(tokens[col]);
                }
            }
        } catch (FileNotFoundException fnot) {
            fnot.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return map;
    }
}
