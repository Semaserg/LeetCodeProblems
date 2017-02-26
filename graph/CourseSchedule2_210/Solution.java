package LeetCode.graph.CourseSchedule2_210;

import java.util.*;

/*
210. Course Schedule II
https://leetcode.com/problems/course-schedule-ii/

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have
to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the
ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them.
If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have
finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished
both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency
matrices. Read more about how a graph is represented.

click to show more hints.

Hints:
This problem is equivalent to finding the topological order in a directed graph.
If a cycle exists, no topological ordering exists and therefore it will be impossible
 to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining
 the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
*/

// Great solutions
// https://discuss.leetcode.com/topic/15762/java-dfs-and-bfs-solution
// https://discuss.leetcode.com/topic/17273/18-22-lines-c-bfs-dfs-solutions
// Graph additional info
//        https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/describing-graphs
//        http://www.geeksforgeeks.org/detect-cycle-in-a-graph/ - detect cycle in direct graph - DFS
//        http://www.geeksforgeeks.org/detect-cycle-direct-graph-using-colors/ same idea with colors, DFS
//        http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/ - depth first graph traversal.
//        https://www.youtube.com/watch?v=W9cfpsPJwhc - topological sort via DFS
//        http://www.geeksforgeeks.org/topological-sorting/ - topological sort via DFS
//        http://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
public class Solution {
    // DFS topological sort
    // http://www.geeksforgeeks.org/topological-sorting/

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = makeGrapth(numCourses, prerequisites);
        //int[] indegrees = getIndegrees(numCourses, prerequisites);

        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for (int i=0; i<numCourses; i++) {
            if (!dfs(i, queue, graph, visited, recStack)) {
                return new int[]{};
            }
            // it works without in-degree calculation. We need indegree calculation for BFS (Khan alg), not fr DFS.
            // DFS is the postorder traversal in revers order.
            // The first vertex in topological sorting is always a vertex with in-degree as 0 (a vertex with no in-coming edges).
//            if (indegrees[i] == 0) {
//                boolean noCycles = dfs(i, queue, graph, visited, recStack);
//                if (!noCycles) return new int[]{};
//            }
        }

        int[] result = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            // here is no revense order because I'm building the graph in wrong way.
            // from and to need to be swapped.
            result[i] = queue.poll();
        }
        return result;
    }

    // return true if no cycles.
    private boolean dfs(int current, Queue<Integer> queue, List<Integer>[] graph, boolean[] visited, boolean[] recStack) {
        if (visited[current]) {
            return true;
        }

        visited[current] = true;
        recStack[current] = true;

        List<Integer> adjacentNodes = graph[current];
        for (int n : adjacentNodes) {
            // return false if cycle detected.
            if (!visited[n] && !dfs(n, queue, graph, visited, recStack)) return false;
            else if (recStack[n]) return false;
        }

        queue.add(current); // Postorder traversal
        recStack[current] = false;
        return true;
    }

    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = makeGrapth(numCourses, prerequisites);
        int[] indegrees = getIndegrees(numCourses, prerequisites);

        Stack<Integer> stack = new Stack<>(); // use stack size instead of counter.
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<numCourses; i++) {
            if (indegrees[i] == 0) {
                indegrees[i] = -1; // mark as visited
                queue.add(i);
                stack.push(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            List<Integer> adjacentNodes = graph[curr];
            for(int n : adjacentNodes) {
                indegrees[n]--;
                if (indegrees[n] == 0) {
                    queue.add(n);
                    stack.add(n);
                }
            }
        }

        if (stack.size() != numCourses) return new int[]{};

        int[] result = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            // here is I use reverse order because of the bug in building the graph
            // from and to need to be swapped.
            result[i] = stack.pop();
        }
        return result;
    }

    private List<Integer>[] makeGrapth(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i=0; i<numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
        }
        return graph;
    }

    private int[] getIndegrees(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        for (int[] edge : prerequisites) {
            int to = edge[1];
            indegrees[to]++;
        }
        return indegrees;
    }
}