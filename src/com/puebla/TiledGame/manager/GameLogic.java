package com.puebla.TiledGame.manager;

import com.puebla.TiledGame.main.Game;

/**
 * Created by federico on 12/04/17.
 */
public class GameLogic {

    public static void gameLoop(Thread thread, Game game) {

        long waitTime;
        long startTime;
        long UDTimeMillis;

        while ( game.isRunning ) {
            startTime = System.nanoTime();
            game.update();
            game.draw();
            UDTimeMillis = (startTime - System.nanoTime()) / 1_000_000;
            waitTime = game.TIME_PER_FRAME - UDTimeMillis;

            if ((waitTime) > 0) {
                try {
                    thread.sleep(waitTime);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }

    }

}
