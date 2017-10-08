package LeetCode.design.SnakeGame_353;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Design a Snake_3 game that is played on a device with screen size = width x height.
 * Play the game online if you are not familiar with the game.

 The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

 You are given a list of food's positions in row-column order. When a snake eats the
 food, its length and the game's score both increase by 1.

 Each food appears one by one on the screen. For example, the second food will
 not appear until the first food was eaten by the snake.

 When a food does appear on the screen, it is guaranteed that it will not appear
 on a block occupied by the snake.

 Example:
 Given width = 3, height = 2, and food = [[1,2],[0,1]].

 Snake_3 snake = new Snake_3(width, height, food);

 Initially the snake appears at position (0,0) and the food at (1,2).

 |S| | |
 | | |F|

 snake.move("R"); -> Returns 0

 | |S| |
 | | |F|

 snake.move("D"); -> Returns 0

 | | | |
 | |S|F|

 snake.move("R"); -> Returns 1 (Snake_3 eats the first food and right after that, the second food appears at (0,1) )

 | |F| |
 | |S|S|

 snake.move("U"); -> Returns 1

 | |F|S|
 | | |S|

 snake.move("L"); -> Returns 2 (Snake_3 eats the second food)

 | |S|S|
 | | |S|

 snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 */
public class SnakeGame {
    private LinkedList<Point> snake = new LinkedList<>();
    private int columns = 0;
    private int rows = 0;
    private int score = 0;
    private Queue<Point> food = new LinkedList<>();

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        // input validation
        this.columns = width;
        this.rows = height;
        for(int[] p : food) {
            this.food.offer(new Point(p[0], p[1]));
        }
        // init snake
        snake.add(new Point(0,0));
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        Point head = snake.getFirst();
        Point nextHead = new Point(head.row, head.col);
        switch (direction) {
            case "U":
                nextHead.row--;
                break;
            case "L":
                nextHead.col--;
                break;
            case "R":
                nextHead.col++;
                break;
            case "D":
                nextHead.row++;
                break;
        }
        snake.addFirst(nextHead);
        if (isFood(nextHead)) {
            removeNextFood();
            score++;
        } else {
            snake.removeLast();
        }
        return (isBodyCrash() || isBoundaryCrash()) ? -1 : score;
    }

    private boolean isBoundaryCrash() {
        Point head = snake.getFirst();
        boolean isCrash = head.col<0 || head.col>=this.columns || head.row<0 || head.row>=this.rows;
        return isCrash;
    }

    private boolean isBodyCrash() {
        Point head = snake.getFirst();
        for (int i=1; i<snake.size(); i++) {
            Point bodyItem = snake.get(i);
            if (bodyItem.equals(head)) {
                return true;
            }
        }
        return false;
    }

    private boolean isFood(Point point) {
        if (food.isEmpty()) return false;
        return food.peek().equals(point);
    }

    private void removeNextFood() {
        this.food.remove();
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */

class Point {
    int row;
    int col;
    Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object point) {
        Point p = (Point)point;
        return this.row == p.row && this.col == p.col;
    }
}