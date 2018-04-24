package entity;

import java.util.LinkedList;

/**
 * @author Created by Darling
 * @version CreatedDate: 2018/4/21 at 21:31
 */

public class Snake {

    private LinkedList<Node> body = new LinkedList<>();

    public Node eat(Node food) {
        // 如果food与头部相邻，则将food这个Node加入到body中，返回food
        if(isNeighbor(this.body.getFirst(), food)) {
            // 相邻情况下的处理
            body.addFirst(food);
            return food;
        }
        // 否则不做任何操作，返回null
        return null;
    }

    public Node move(Direction direction) {
        Node tail = this.body.getLast();
        Node nextStep;
        // 根据方向更新贪吃蛇的body
        switch (direction) {
            case UP:
                nextStep = new Node(getHead().getX(),getHead().getY() - 1);
                this.body.addFirst(nextStep);
                this.body.removeLast();
                break;
            case DOWN:
                nextStep = new Node(getHead().getX(),getHead().getY() + 1);
                this.body.addFirst(nextStep);
                this.body.removeLast();
                break;
            case LEFT:
                nextStep = new Node(getHead().getX() - 1,getHead().getY());
                this.body.addFirst(nextStep);
                this.body.removeLast();
                break;
            case RIGHT:
                nextStep = new Node(getHead().getX() + 1,getHead().getY());
                this.body.addFirst(nextStep);
                this.body.removeLast();
                break;
        }
        // 返回移动之前的尾部Node
        return tail;
    }

    public Node getHead() {
        return this.body.getFirst();
    }

    public Node addTail(Node area) {
        this.body.addLast(area);
        return area;
    }

    public LinkedList<Node> getBody() {
        return body;
    }

    public void setBody(LinkedList<Node> body) {
        this.body = body;
    }

    public boolean isNeighbor(Node a, Node b) {
        //横坐标相减为1或纵坐标相减为1
        return (Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()) == 1);
    }

}
