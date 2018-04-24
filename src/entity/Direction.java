package entity;

/**
 * @author Created by Darling
 * @version CreatedDate: 2018/4/21 at 21:31
 */

public enum Direction {
    UP(0),
    RIGHT(1),
    DOWN(2),
    LEFT(3);

    private final int directionCode;

    Direction(int directionCode) {
        this.directionCode = directionCode;
    }

    public int directionCode() {
        return directionCode;
    }

    //蛇不能往后走，所以，上下不兼容，左右不兼容，用方向编码进行计算
    public boolean compatibleWith(Direction newDirection) {
        return Math.abs(directionCode() - newDirection.directionCode()) != 2;
//        方法二：
//        return this.directionCode == newDirection.directionCode
//                || (this.directionCode + newDirection.directionCode) % 2 == 1;
    }
}
