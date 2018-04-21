package view;

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

    public void drawSnake(Graphics graphics, Snake snake) {

    }

    public void drawFood(Graphics graphics, Node squreArea) {

    }

    public void drawGridBackground(Graphics graphics) {

    }

    private void drawSquare(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
//        int size = Settings.DEFAULT_NODE_SIZE;
//        graphics.fillRect(squareArea.getX() * size, squareArea.getY() * size,size,size);
    }

    private void drawCycle(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
//        int size = Settings.DEFAULT_NODE_SIZE;
//        graphics.fillOval(squareArea.getX() * size, squareArea.getY() * size,size,size);
    }

    public void showGameOverMessage() {
        JOptionPane.showMessageDialog(null, "游戏结束","游戏结束",JOptionPane.INFORMATION_MESSAGE);
    }

}
