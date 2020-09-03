package topological_sort;

import java.util.*;

public class Problems {
    /**
     * Given a directed graph with N nodes, and a list of edges going from U -> V,
     * find the topological ordering
     */
    public static int[] problem1(int n, int[][] edges){
        if(n <= 0 || edges == null)
            throw new IllegalArgumentException();

        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for(int i = 0; i < n; i++){
            adjList.put(i, new HashSet<>());
            inDegree.put(i, 0);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            inDegree.put(edge[1], inDegree.get(edge[1]) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : inDegree.entrySet()){
            if(entry.getValue() == 0)
                q.offer(entry.getKey());
        }

        int[] output = new int[n];
        int idx = 0;
        while(!q.isEmpty()){
            int i = q.poll();
            output[idx++] = i;
            Set<Integer> neighbors = adjList.get(i);
            for(int j : neighbors){
                inDegree.put(j, inDegree.get(j) - 1);
                if(inDegree.get(j) == 0)
                    q.offer(j);
            }
        }
        return output;
    }
}
