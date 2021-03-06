package view;
import config.Settings;
import entity.Grid;
import entity.Node;
import entity.Snake;

import javax.swing.*;
import java.awt.*;

/**
 * @author Created by Darling
 * @version CreatedDate: 2018/4/21 at 23:42
 */

public class GameView {

    private JPanel canvas;

    private final Grid grid;

    public GameView(Grid grid) {
        this.grid = grid;
    }

    public void init() {
        canvas = new JPanel(){
            @Override
            public void paintComponent(Graphics graphics){
                drawGridBackground(graphics);
                drawSnake(graphics, grid.getSnake());
                drawFood(graphics, grid.getFood());
          }
        };

    }
    public JPanel getCanvas() {
        return canvas;
    }

    public void draw() {
        canvas.repaint();
    }

    private void drawSnake(Graphics graphics, Snake snake) {
     for(int i = 0; i < snake.getBody().size(); i++){
         drawSquare(graphics, snake.getBody().get(i), new Color(255, 255, 255));
     }
    }

    private void drawFood(Graphics graphics, Node squareArea) {
        drawCycle(graphics,squareArea,new Color(0,255,0));
    }

    private void drawGridBackground(Graphics graphics) {
        graphics.setColor(new Color(255,0,0));
        for(int i = 0; i < Settings.DEFAULT_GRID_WIDTH; i++){
            for(int j = 0; j < Settings.DEFAULT_GRID_HEIGHT; j++){
                graphics.fillRect(i,j,Settings.DEFAULT_NODE_SIZE,Settings.DEFAULT_NODE_SIZE);
            }
        }
    }

    private void drawSquare(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
        int size = Settings.DEFAULT_NODE_SIZE;
        graphics.fillRect(squareArea.getX(), squareArea.getY(),size,size);
    }

    private void drawCycle(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
        int size = Settings.DEFAULT_NODE_SIZE;
        graphics.fillRect(squareArea.getX(), squareArea.getY(),size,size);
//        graphics.fillOval(squareArea.getX(), squareArea.getY(),size,size);
    }

    public void showGameOverMessage() {
        JOptionPane.showMessageDialog(null, "游戏结束","游戏结束",JOptionPane.INFORMATION_MESSAGE);
    }
}
