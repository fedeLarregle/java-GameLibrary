package com.puebla.TiledGame.main;

import com.puebla.TiledGame.manager.GameLogic;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by federico on 12/04/17.
 */
public class Game extends Canvas implements Runnable, KeyListener {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 480;

    private Thread thread;
    public boolean isRunning;

    public final int FRAMES_PER_SECOND = 30;
    public final long TIME_PER_FRAME = 1_000 / FRAMES_PER_SECOND;

    private JFrame frame;
    private BufferedImage image;


    public Game() {

        Dimension size = new Dimension(WIDTH, HEIGHT);
        setPreferredSize(size);
        setFocusable(true);
        requestFocus();

        frame = new JFrame();
        addKeyListener(this);
    }

    public synchronized void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    @Override
    public void run() {

        GameLogic.gameLoop(thread, this);
    }

    public void update () {}

    public void draw() {

        BufferStrategy bufferStrategy = getBufferStrategy();
        if ( bufferStrategy == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        graphics.drawImage(image, 0, 0, WIDTH, HEIGHT, null);

        graphics.dispose();
        bufferStrategy.show();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public static void main (String... args) {

        Game game = new Game();
        game.frame.setResizable(false);
        game.frame.setTitle("Tiled Game");
        game.frame.add(game);

        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);

        game.start();
    }


}
