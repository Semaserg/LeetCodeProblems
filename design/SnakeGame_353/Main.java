package LeetCode.design.SnakeGame_353;

public class Main {
    public static void main(String[] args) {
        SnakeGame game = new SnakeGame(3,3,new int[][]{{1,1}, {2,2}, {2,0}});

        System.out.println(game.move("R"));
        System.out.println(game.move("D"));
        System.out.println(game.move("R"));
        System.out.println(game.move("D"));
        System.out.println(game.move("L"));
        System.out.println(game.move("L"));
        System.out.println(game.move("L"));
        System.out.println(game.move("L"));
    }
}


