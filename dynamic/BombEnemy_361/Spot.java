package LeetCode.dynamic.BombEnemy_361;

class Spot {
    public int up; // enemies that can be destroyed up + current cell enemy;
    public int bottom; // enemies that can be destroyed to the bottom;
    public int left; // enemies that can be destroyed to the left + current cell enemy;
    public int right; // enemies that can be destroyed to the right;
}