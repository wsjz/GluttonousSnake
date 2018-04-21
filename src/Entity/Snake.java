package Entity;

import java.util.LinkedList;

/**
 * @author Created by Darling
 * @version CreatedDate: 2018/4/21 at 21:31
 */

public class Snake {

    private LinkedList<Node> body = new LinkedList<>();

//    public Node eat(Node food) {
//        if(isNeighbor(this.body.getFirst(), food)) {
//
//        }
//    }
//
//    public Node move(Direction direction) {
//
//    }

    public Node getHead() {
        return this.body.getFirst();
    }

//    public Node addTail(Node area) {
//        this.body.addLast(area);
//    }

    public LinkedList<Node> getBody() {
        return body;
    }


    private boolean isNeighbor(Node a, Node b) {
        //横坐标相减为1或纵坐标相减为1
        return (Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()) == 1);
    }

}
