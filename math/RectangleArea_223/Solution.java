package LeetCode.math.RectangleArea_223;

/*
223. Rectangle Area
https://leetcode.com/problems/rectangle-area/

Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
Assume that the total area is never beyond the maximum possible value of int.
*/
public class Solution {
    // Good solution with max and min
    // https://discuss.leetcode.com/topic/15648/an-easy-to-understand-solution-in-java
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sq1 = getArea(A, B, C, D);
        int sq2 = getArea(E, F, G, H);
        if (sq1 == 0 || sq2 == 0) {
            return sq1 + sq2;
        }
        // if no intersection
        if (C < E || G < A || H < B || D < F) {
            return sq1 + sq2;
        }
        int w = Math.min(C,G) - Math.max(A,E);
        int h = Math.min(H,D) - Math.max(B,F);
        return sq1+sq2-w*h;
    }

    // My stupid solution
    // Time and space complexity O(1)
    public int computeArea1(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sq1 = getArea(A,B,C,D);
        int sq2 = getArea(E,F,G,H);
        if (sq1==0 || sq2==0) {
            return sq1+sq2;
        }
        // if no intersection
        if ((C<E || G<A) || // no crossing by x
                (H<B || D<F)) { // no crossing by y
            return sq1 + sq2;
        }
        // if first is bigger and contains second
        if (A<=E && E<=C && A<=G && G<=C && B<=F && F<=D && B<=H && H<=D) {
            return sq1;
        }
        // if second is bigger and contains first
        if (E<=A && A<=G && C<=A && C<=G && F<=B && B<=H && F<=D && D<=H) {
            return sq2;
        }
        int x1 = (E<=A && A<=G) ? A : E;
        int x2 = (E<=C && C<=G) ? C : G;
        int y1 = (B<=F && F<=D) ? F : B;
        int y2 = (B<=H && H<=D) ? H : D;
        int sq3 = getArea(x1,y1,x2,y2);
        return sq1+sq2-sq3;
    }

    private int getArea(int x1, int y1, int x2, int y2) {
        return (x2-x1) * (y2-y1);
    }
}