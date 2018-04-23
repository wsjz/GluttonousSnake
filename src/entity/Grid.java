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
		//TODO:可优化
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
     *
     * 头部不能是边界
     * 头部不能碰到自身，否则游戏结束
	 **/
	public boolean nextRound() {

        //按当前方向移动贪吃蛇
        Node tail = this.snake.move(this.snakeDirection);
        int x = snake.getHead().getX();
        int y = snake.getHead().getY();
		if (x >= 0 && x < width && y >= 0 && y < height
                || !snake.getBody().contains(snake.getHead())) {//当前头部的位置是否有效
            if (snake.getHead().equals(food)) { //头部原来是食物，那移动后就不删除尾部
				//把原来move操作时删除的尾部添加回来
                snake.addTail(tail);
				//创建一个新的食物
                createFood();
                status[x][y] = true;//头部覆盖了棋盘
                return true;
            }
			//更新棋盘状态并返回游戏是否结束的标志
            status[x][y] = true;
            status[tail.getX()][tail.getY()] = false;
            //游戏继续
            return true;
        }
        //头部覆盖到了边界或自身，游戏结束
		return false;
	}

	/**
	 * 外部（如GameController）修改贪吃蛇行进方向的方法
	 * */
	public void changeDirection(Direction newDirection) {
		if (snakeDirection.compatibleWith(newDirection)) {
			snakeDirection = newDirection;
		}
	}

}
