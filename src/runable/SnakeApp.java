package runable;

import config.Settings;
import controller.GameController;
import entity.Grid;
import view.GameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

/**
 * @author Created by Darling
 * @version CreatedDate: 2018/4/21 at 21:31
 *
 * 改进策略
 *
 * 积分功能：可以创建得分规则的类（模型类的一部分）， 在GameController的run()方法中计算得分
 * 变速功能：比如加速功能，减速功能，可以在GameController的keyPressed()方法中针对特定的按键设置每一次移动之间的时间间隔，将Thread.sleep(Settings.DEFAULT_MOVE_INTERVAL);替换为动态的时间间隔即可
 * 更漂亮的游戏界面：修改GameView中的drawXXX方法，比如可以将食物渲染为一张图片，Graphics有drawImage方法
 * 可以在游戏界面上增加更多的组件，比如积分的Label和启动结束的按钮等
 * */

public class SnakeApp implements Runnable{

    private Grid grid;
    private GameView gameView;
    private GameController gameController;

    public void run() {
        //初始化grid
        grid = new Grid(400,400);

        JFrame window = new JFrame("贪吃蛇");
        //画出棋盘和贪吃蛇

        Container contentPane = window.getContentPane();

        gameView = new GameView(grid);

        gameView.init();

        gameView.getCanvas().setPreferredSize(new Dimension(Settings.DEFAULT_GRID_WIDTH, Settings.DEFAULT_GRID_HEIGHT));

        contentPane.add(gameView.getCanvas(),BorderLayout.CENTER);
        window.pack();
        // 设置窗口为大小不可变化
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);

        gameController = new GameController(grid, gameView);
        window.addKeyListener((KeyListener) gameController);
        new Thread(gameController).start();

    }

    public static void main(String[] args) {
        //EDT（Event Dispatching Thread）是Java GUI应用中的一个线程，这个线程管理着所有SWING GUI事件和整个UI界面。
        // 我们对UI相关的修改都应该放到EDT中。
        SwingUtilities.invokeLater(new SnakeApp());
    }

}
