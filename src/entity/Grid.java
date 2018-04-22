package entity;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author Created by Darling
 * @version CreatedDate: 2018/4/21 at 21:31
 */
//游戏网格
public class Grid {

	//是否被贪吃蛇覆盖
	private final boolean status[][];
	private final int width;
	private final int height;
	private Snake snake;
	//食物位置
	private Node food;
	// 初始方向默认设置为向左
	private Direction snakeDirection = Direction.LEFT;

	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		status = new boolean[width][height];
		//所有格子填充为false,boolean数组默认值为false
//		for(int i = 0; i < width; i++) {
//			Arrays.fill(status[i],false);
//		}
		initSnake();
		createFood();
	}

	private void initSnake() {
		this.snake = new Snake();
		// 设置Snake的Body
        LinkedList<Node> body = new LinkedList<>();
        int x = width / 2; //最左边的X为棋盘水平中间位置
        int y = height / 2; //Y坐标为棋盘垂直中间位置
        for (int i = 0; i < width / 3; i++ ){//贪吃蛇的长度为棋盘宽度的三分之一
            body.add(new Node(x, y));//贪吃蛇为水平放置，即包含的所有Node的Y坐标相同
            status[x][y] = true;// 更新棋盘覆盖状态
            x++;
        }
        this.snake.setBody(body);
    }

	/**
	 *生成的X坐标和Y坐标必须在有效的范围之内，不能超过棋盘大小
	 *食物的位置不能和贪吃蛇的位置重叠
	 * */
    private void createFood() {
		int x, y;
		// 使用Random设置x和y
		Random random = new Random();
		//食物的位置不能和贪吃蛇的位置重叠
		do {
			x = random.nextInt(this.width);
			y = random.nextInt(this.height);
			food = new Node(x,y);
		} while (this.snake.getBody().contains(food));
    }

    public Snake getSnake() {
        return snake;
    }

    public Node getFood() {
        return food;
    }

	/**由Grid类来驱动Snake的move操作
	 *每一次移动可以认为是游戏的下一步
	 **/
	public boolean nextRound() {

//		按当前方向移动贪吃蛇
//
//		if (头部的位置是否有效) {
//			if (头部原来是食物) {
//				把原来move操作时删除的尾部添加回来
//				创建一个新的食物
//			}
//			更新棋盘状态并返回游戏是否结束的标志
//		}
		return false;
	}

	/**
	 * 用户修改贪吃蛇行进方向的方法
	 * */
	public void changeDirection(Direction newDirection) {
		if (snakeDirection.compatibleWith(newDirection)) {
			snakeDirection = newDirection;
		}
	}

}
