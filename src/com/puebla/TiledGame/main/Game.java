package com.puebla.TiledGame.main;

import com.puebla.TiledGame.gameStates.GameState;
import com.puebla.TiledGame.gameStates.MenuState;
import com.puebla.TiledGame.manager.GameLogic;
import com.puebla.TiledGame.manager.KeyController;
import com.puebla.TiledGame.model.Camara;
import com.puebla.TiledGame.tileMap.TileMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * @author federico on 12/04/17.
 * @email fede.larregle@gmail.com
 */
public class Game extends JPanel implements Runnable, KeyListener {

    public static final Game game;
    public static final JFrame frame;
    public static final Board board;

    public static final int WIDTH;
    public static final int HEIGHT;
    public static final short BOARD_X;
    public static final short BOARD_Y;

    public final static int FRAMES_PER_SECOND;
    public final static long TIME_PER_FRAME;

    private static final Thread thread;

    public boolean isRunning;

    private BufferedImage image;

    private GameState gameState;
    private TileMap tileMap;
    private Camara camara;

    static {
        game = new Game();
        frame = new JFrame();
        board = new Board();

        thread = new Thread(game);
        WIDTH = 480;
        HEIGHT = 480;
        BOARD_X = 10;
        BOARD_Y = 10;
        FRAMES_PER_SECOND = 30;
        TIME_PER_FRAME = 1_000 / FRAMES_PER_SECOND;
    }


    public Game() {
        super();
        setBackground(Color.BLACK);
        setLayout(null);
        Dimension size = new Dimension(WIDTH, HEIGHT);
        setPreferredSize(size);
        setFocusable(true);
        requestFocus();

        gameState = new MenuState(this);
        tileMap = new TileMap(16);
        camara = new Camara(this, tileMap, Camara.Mode.FOLLOW);
        addKeyListener(this);
    }

    public synchronized void start() {
        isRunning = true;
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

        GameLogic.gameLoop(thread, game);
    }

    public void update () {
        gameState.update();
        KeyController.update();
    }

    public void draw() {
        /*
        BufferStrategy bufferStrategy = getBufferStrategy();
        if ( bufferStrategy == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        gameState.draw(graphics);
        graphics.drawImage(image, 0, 0, WIDTH, HEIGHT, null);

        graphics.dispose();
        bufferStrategy.show();
        */
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        KeyController.setKey(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        KeyController.setKey(e.getKeyCode(), false);
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Camara getCamara() { return this.camara; }

    public TileMap getTileMap() { return this.tileMap; }

    public static void main (String... args) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game);

        frame.setLocationRelativeTo(null);
        board.setLocation(BOARD_X, BOARD_Y);
        game.add(board);
        frame.setVisible(true);

        game.start();
    }


}
