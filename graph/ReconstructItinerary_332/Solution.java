package LeetCode.graph.ReconstructItinerary_332;

import java.util.*;

/*
310. Minimum Height Trees
https://leetcode.com/problems/minimum-height-trees/

Given a list of airline tickets represented by pairs of departure and arrival airports
[from, to], reconstruct the itinerary in order. All of the tickets belong to a man who
departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has
the smallest lexical order when read as a single string. For example, the itinerary
["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.

Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
*/
// https://discuss.leetcode.com/topic/36383/share-my-solution
// https://discuss.leetcode.com/topic/36370/short-ruby-python-java-c
// In dfs and dfs1 we start our itinerary from the final point.
// So when we find the vertex with 0 out degree (no flights from there) - this is the final point.
// Then we back to the previous point and check adjacent vertex from it.
// This graph contains Eularian path (maybe Eularian cycle).
// Check algorithms to find the Eularian path (cycle) in directed and undirected graph.
public class Solution {
    Map<String, PriorityQueue<String>> flights = new HashMap<>();
    LinkedList<String> itinerary = new LinkedList<>();

    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0) return itinerary;
        for(String[] ticket : tickets) {
            String depature = ticket[0], arrival = ticket[1];
            flights.putIfAbsent(depature, new PriorityQueue<>());
            flights.get(depature).add(arrival);
        }
        dfs1("JFK");
        return itinerary;
    }

    void dfs(String depature) {
        PriorityQueue<String> arrivals = flights.get(depature);
        while (arrivals != null && !arrivals.isEmpty()) {
            String arrival = arrivals.poll(); // remove the arrival from graph
            dfs(arrival);
        }
        itinerary.addFirst(depature);
    }

    void dfs1(String departure) {
        Stack<String> stack = new Stack<>();
        stack.push(departure);
        while (!stack.isEmpty()) {
            String curr = stack.peek();
            PriorityQueue<String> arrivals = flights.get(curr);
            if (arrivals == null || arrivals.isEmpty()) {
                itinerary.addFirst(curr);
                stack.pop();
            } else {
                String next = arrivals.poll();
                stack.push(next);
            }
        }
    }
}

// My stupid solution
/*public class Solution {
    HashMap<String, LinkedList<String>> graph = new HashMap<>();
    ArrayList<String> result = new ArrayList<>();
    ArrayList<String> tail = new ArrayList<>();

    public List<String> findItinerary(String[][] tickets) {
        // fill graph
        for (String[] ticket : tickets) {
            if (!graph.containsKey(ticket[0])) {
                graph.put(ticket[0], new LinkedList<>());
            }
            graph.get(ticket[0]).add(ticket[1]);
        }

        // sort vertices
        for (String key : graph.keySet()) {
            Collections.sort(graph.get(key));
        }

        ArrayList<String> localRes = new ArrayList<>();
        HashSet<String> visited = new HashSet();
        String current = "JFK";
        dfs(current, visited, localRes);
        result.addAll(tail);
        return result;
    }

    private void dfs(String current, HashSet<String> visited, ArrayList<String> localRes) {
        localRes.add(current);

        // if cycle push localRes to result
        if (visited.contains(current)) {
            result.addAll(localRes);
            localRes.clear();
            return;
        }
        // if final destination we should add this list at the end
        if (!graph.containsKey(current) || graph.get(current).isEmpty()) {
            tail.addAll(localRes);
            localRes.clear();
            return;
        }

        visited.add(current);
        while (!graph.get(current).isEmpty()) {
            String nextCurrent = graph.get(current).removeFirst();
            dfs(nextCurrent, visited, localRes);
        }
    }
}*/