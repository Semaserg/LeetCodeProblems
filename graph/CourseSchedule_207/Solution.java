package LeetCode.graph.CourseSchedule_207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
207. Course Schedule
https://leetcode.com/problems/course-schedule/

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to
finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0,
and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
Read more about how a graph is represented.

click to show more hints.

Hints:
This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists,
 no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic
 concepts of Topological Sort.
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
    // DFS, time complexity O(E+V), E = num of edges, V - num of vertices.
    // Space complexity O(E+V) - to hold graph + O(V) - visited, +  O(V) -recStack +
    // O(E) - max for recursion stack => O(2E + 3V) = O(E + V).
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        List<Integer>[] graph = makeGraph(numCourses, prerequisites);
        for (int i=0; i<numCourses; i++) {
            if (hasCycle(i, visited, recStack, graph)) return false;
        }
        return true;
    }


    private boolean hasCycle(int current, boolean[] visited, boolean[] recStack, List<Integer>[] graph) {
        if (visited[current]) return false;

        visited[current] = true;
        recStack[current] = true;

        List<Integer> adjacentNodes = graph[current];
        for (int n : adjacentNodes) {
            if (!visited[n] && hasCycle(n, visited, recStack, graph)) return true;
            else if (recStack[n]) return true;
        }

        recStack[current] = false;
        return false;
    }

    // BFS solution
    // http://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
    // time complexity O(E+V), space complexity O(E+V) - to hold the graph + O(V) - for the queue of vertices =>
    // O(E+2V) => O(E+V).
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = makeGraph(numCourses, prerequisites);
        int[] indegrees = getIndegrees(numCourses, prerequisites);

        Queue<Integer> q = new LinkedList<>();
        int count = 0; // counter of visited vertices.

        // push all the vertices with no incoming edges to the q.
        for (int i=0; i<numCourses; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
                indegrees[i] = -1; // mark vertices as visited.
                count++;
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> adjacentNOdes = graph[curr];
            for (int n : adjacentNOdes) {
                indegrees[n]--;
                if (indegrees[n] == 0) {
                    q.add(n);
                    count++;
                }
            }
        }
        return numCourses == count;
    }

    private int[] getIndegrees(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        for(int[] edge : prerequisites) {
            //int from = edge[0];
            int to = edge[1];
            indegrees[to]++;
        }
        return indegrees;
    }

    private List<Integer>[] makeGraph(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i=0; i<numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to); // add edge
        }
        return graph;
    }
}