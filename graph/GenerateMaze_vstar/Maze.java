package LeetCode.graph.GenerateMaze_vstar;

import java.util.Random;

/**
 * Maze generator via dfs
 * http://algs4.cs.princeton.edu/41graph/Maze.java.html
 * https://en.wikipedia.org/wiki/Maze_generation_algorithm
 */
public class Maze {
    private final Random rnd;
    private final int size;
    private final int enterX;
    private final int enterY;
    private final int exitX;
    private final int exitY;

    private boolean[][] north;
    private boolean[][] east;
    private boolean[][] south;
    private boolean[][] west;
    private boolean[][] visited;
    private boolean done;

    Maze(int size) {
        StdDraw.enableDoubleBuffering();
        this.size = size;
        this.enterX = 1;
        this.enterY = 1;
        this.exitX = this.size/2;
        this.exitY = this.size/2;
        this.rnd = new Random();
        init();
    }

    private void init() {
        north = initWallArr();
        east = initWallArr();
        south = initWallArr();
        west = initWallArr();
        visited = initVisitedArr();
    }

    private boolean[][] initWallArr() {
        boolean[][] arr = new boolean[size+2][size+2];
        for (int i=0; i<size+2; i++) {
            for (int j=0; j<size+2; j++) {
                arr[i][j] = true;
            }
        }
        return arr;
    }

    private boolean[][] initVisitedArr() {
        boolean[][] arr = new boolean[size+2][size+2];
        for (int i=0; i<size+2; i++) {
            for (int j=0; j<size+2; j++) {
                if (i==0 || j == 0 || i == size+1 || j == size+1) { // if border set visited == true.
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }
        return arr;
    }

    private boolean unvisited(int x, int y, Direction direction) {
        switch (direction) {
            case NORTH:
                return !visited[x][y-1];
            case EAST:
                return !visited[x+1][y];
            case SOUTH:
                return !visited[x][y+1];
            case WEST:
                return !visited[x-1][y];
            default:
                throw new RuntimeException("wrong direction");
        }
    }

    private void removeWall(int x, int y, Direction direction) {
        switch (direction) {
            case NORTH:
                north[x][y] = false;
                south[x][y-1] = false;
                break;
            case EAST:
                east[x][y] = false;
                west[x+1][y] = false;
                break;
            case SOUTH:
                south[x][y] = false;
                north[x][y+1] = false;
                break;
            case WEST:
                west[x][y] = false;
                east[x-1][y] = false;
                break;
            default:
                throw new RuntimeException("wrong direction");

        }
    }

    private void generate(int x, int y) {
        System.out.println(String.format("X = %1$d; Y = %2$d;", x, y));
        visited[x][y] = true;
        while ( unvisited(x, y, Direction.NORTH) ||
                unvisited(x, y, Direction.EAST) ||
                unvisited(x, y, Direction.SOUTH) ||
                unvisited(x, y, Direction.WEST)) {

            // trick to select random unvisited direction
            while (true) {
                int next = rnd.nextInt(4);
                if (next == 0 && unvisited(x, y, Direction.NORTH)) {
                    removeWall(x, y, Direction.NORTH);
                    generate(x, y-1);
                    break;
                }
                else if (next == 1 && unvisited(x, y, Direction.EAST)) {
                    removeWall(x, y, Direction.EAST);
                    generate(x+1, y);
                    break;
                }
                else if (next == 2 && unvisited(x, y, Direction.SOUTH)) {
                    removeWall(x, y, Direction.SOUTH);
                    generate(x, y+1);
                    break;
                }
                else if (next == 3 && unvisited(x, y, Direction.WEST)) {
                    removeWall(x, y, Direction.WEST);
                    generate(x-1, y);
                    break;
                }
            }
        }
    }

    public void generate() {
        generate(1, 1);
    }

    public void draw() {
        StdDraw.setXscale(0, size+2);
        StdDraw.setYscale(0, size+2);
        drawMaze();
    }

    // draw the maze
    public void drawMaze() {
        drawRedPoint(enterX, enterY);
        drawRedPoint(exitX, exitY);

        StdDraw.setPenColor(StdDraw.BLACK);
        for (int x = 1; x <= size; x++) {
            for (int y = 1; y <= size; y++) {
                if (south[x][y]) StdDraw.line(x, y, x+1, y);
                if (north[x][y]) StdDraw.line(x, y+1, x+1, y+1);
                if (west[x][y])  StdDraw.line(x, y, x, y+1);
                if (east[x][y])  StdDraw.line(x+1, y, x+1, y+1);
            }
        }
        StdDraw.show();
        StdDraw.pause(1000);
    }

    public void solve() {
        visited = initVisitedArr();
        done = false;
        solve(1, 1);
    }

    private void solve(int x, int y) {
        if (x ==0 || y == 0 || x == size+1 || y == size+1) return; // if border
        if (done || visited[x][y]) return;

        visited[x][y] = true;
        moveForward(x, y);

        if (x == exitX && y == exitY) done = true;

        if (canGo(x, y, Direction.NORTH)) solve(x, y-1);
        if (canGo(x, y, Direction.EAST)) solve(x+1, y);
        if (canGo(x, y, Direction.SOUTH)) solve(x, y+1);
        if (canGo(x, y, Direction.WEST)) solve(x-1, y);

        if (done) return;

        moveBackward(x, y);
    }

    private boolean canGo(int x, int y, Direction dir) {
        switch (dir) {
            case NORTH:
                return !north[x][y];
            case EAST:
                return !east[x][y];
            case SOUTH:
                return !south[x][y];
            case WEST:
                return !west[x][y];
        }
        return false;
    }

    private void drawRedPoint(int x, int y) {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(x + 0.5, y + 0.5, 0.375);
    }

    private void moveForward(int x, int y) {
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledCircle(x + 0.5, y + 0.5, 0.25);
        StdDraw.show();
        StdDraw.pause(30);
    }

    private void moveBackward(int x, int y) {
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledCircle(x + 0.5, y + 0.5, 0.25);
        StdDraw.show();
        StdDraw.pause(30);
    }
}
