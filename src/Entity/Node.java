package Entity;

/**
 * @author Created by Darling
 * @version CreatedDate: 2018/4/21 at 21:38
 *一条贪吃蛇是由一个一个的节点组成的
 */

public class Node {
    private final int x;
    private final int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
