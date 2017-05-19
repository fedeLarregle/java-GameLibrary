package com.puebla.TiledGame.manager;

import java.awt.event.KeyEvent;

/**
 * Created by federico on 12/04/17.
 */
public class KeyController {

    public static final int NUMBER_KEYS = 13;

    public static boolean keyStates[] = new boolean[NUMBER_KEYS];
    public static boolean previousKeyStates[] = new boolean[NUMBER_KEYS];

    public static final int UP = 0;
    public static final int LEFT = 1;
    public static final int DOWN = 2;
    public static final int RIGHT = 3;

    public static final int Z = 4;
    public static final int X = 5;
    public static final int P = 6;
    public static final int ENTER = 7;
    public static final int ESCAPE = 8;

    public static final int W = 9;
    public static final int A = 10;
    public static final int S = 11;
    public static final int D = 12;

    public static void setKey(int keyCode, boolean state) {
        if ( keyCode == KeyEvent.VK_UP )  {
            keyStates[UP] = state;
        } else if ( keyCode == KeyEvent.VK_LEFT ) {
            keyStates[LEFT] = state;
        } else if ( keyCode == KeyEvent.VK_DOWN ) {
            keyStates[DOWN] = state;
        } else if ( keyCode == KeyEvent.VK_RIGHT ) {
            keyStates[RIGHT] = state;
        } else if ( keyCode == KeyEvent.VK_Z ) {
            keyStates[Z] = state;
        } else if ( keyCode == KeyEvent.VK_X ) {
            keyStates[X] = state;
        } else if ( keyCode == KeyEvent.VK_ENTER ) {
            keyStates[ENTER] = state;
        } else if ( keyCode == KeyEvent.VK_ESCAPE ) {
            keyStates[ESCAPE] = state;
        } else if ( keyCode == KeyEvent.VK_P ) {
            keyStates[P] = state;
        } else if ( keyCode == KeyEvent.VK_W ) {
            keyStates[W] = state;
        } else if ( keyCode == KeyEvent.VK_A ) {
            keyStates[A] = state;
        } else if ( keyCode == KeyEvent.VK_S ) {
            keyStates[S] = state;
        } else if ( keyCode == KeyEvent.VK_D ) {
            keyStates[D]= state;
        }
    }

    public static void update() {
        for (int i = 0; i < NUMBER_KEYS; i++) {
            /* We set the previous key state to the states that we have in keyStates, by now 'old' states */
            previousKeyStates[i] = keyStates[i];
        }
    }

    public static boolean isPressed(int keyCode) {
        return keyStates[keyCode];
    }

    public static boolean isPressedPreviousInMind(int keyCode) {
        return keyStates[keyCode] && !previousKeyStates[keyCode];
    }

}
