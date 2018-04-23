package controller;

import config.Settings;
import entity.Direction;
import entity.Grid;
import view.GameView;

import java.awt.event.KeyEvent;

/**
 * @author Created by Darling
 * @version CreatedDate: 2018/4/22 at 0:15
 */

public class GameController implements Runnable, KeyListener {

    private Grid grid;
    private GameView gameView;
    private boolean running;

    public GameController(Grid grid, GameView gameView, boolean running) {
        this(grid,gameView);
        this.running = running;
    }

    public GameController(Grid grid, GameView gameView) {
        this.grid = grid;
        this.gameView = gameView;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            grid.changeDirection(Direction.UP);
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            grid.changeDirection(Direction.DOWN);
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            grid.changeDirection(Direction.LEFT);
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            grid.changeDirection(Direction.RIGHT);
        }

        //repaint the canvas
        gameView.draw();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(Settings.DEFAULT_MOVE_INTERVAL);
            } catch (InterruptedException e) {
                break;
            }
            // 进入游戏下一步
            boolean isContinue = this.grid.nextRound();
            // 如果结束，则退出游戏
            if(!isContinue) {
                gameView.showGameOverMessage();
                running = false;
            } else {
                // 如果继续，则绘制新的游戏页面
                this.gameView.draw();
            }
        }
    }
    
}
