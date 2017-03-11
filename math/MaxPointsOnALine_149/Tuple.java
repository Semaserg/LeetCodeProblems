package LeetCode.math.MaxPointsOnALine_149;

/**
 * Created by Sergii on 10.03.2017.
 */
public class Tuple {
    int first = 0;
    int second = 0;

    public Tuple(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int hashCode() {
        return (this.first + "-" + this.second).hashCode();
    }

    @Override
    public  boolean equals(Object o) {
        boolean isTuple = o instanceof Tuple;
        if (!isTuple) return false;
        Tuple t = (Tuple)o;
        return this.first == t.first && this.second == t.second;
    }
}
