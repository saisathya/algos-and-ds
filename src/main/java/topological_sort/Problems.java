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

    /**
     * Given a directed graph with N nodes, and a list of edges going from U -> V,
     * determine if the graph has a cycle.
     * Return true if the graph does not have a cycle
     */
    public static boolean problem2(int n, int[][] edges){
        if(n <= 0 || edges == null)
            throw new IllegalArgumentException();

        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for(int i = 0; i < n; i++){
            adjList.put(i, new HashSet<>());
            inDegree.put(i, 0);
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            inDegree.put(edge[1], inDegree.get(edge[1]) + 1);
        }
        LinkedList<Integer> q = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : inDegree.entrySet()){
            if(entry.getValue() == 0)
                q.offer(entry.getKey());
        }
        int count = 0;
        while(!q.isEmpty()){
            int i = q.poll();
            count++;
            Set<Integer> set = adjList.get(i);
            for(int j : set){
                inDegree.put(j, inDegree.get(j) - 1);
                if(inDegree.get(j) ==  0)
                    q.offer(j);
            }
        }

        return count == n;
    }

    /**
     * Given n tasks, and a list of prerequisites for each tasks,
     * determine all the ways to complete the tasks
     */
    public static List<List<Integer>> problem3(int n, int[][] edges){
        if(n <= 0 || edges == null)
            throw new IllegalArgumentException();

        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for(int i = 0; i < n; i++){
            adjList.put(i, new HashSet<>());
            inDegree.put(i, 0);
        }

        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            inDegree.put(edge[1], inDegree.get(edge[1]) + 1);
        }
        return problem3_helper(n, adjList, inDegree, new ArrayList<List<Integer>>(), new ArrayList<>(), new HashSet<>());
    }

    public static List<List<Integer>> problem3_helper(int n, Map<Integer, Set<Integer>> adjList, Map<Integer, Integer> inDegree, List<List<Integer>> output,
                                              List<Integer> curr, Set<Integer> used){
        if(used.size() == n) {
            output.add(curr);
            return output;
        }
        for(Map.Entry<Integer, Integer> entry : inDegree.entrySet()){
            if(entry.getValue() == 0 && used.add(entry.getKey())){
                List<Integer> nCurr = new ArrayList<>(curr);
                nCurr.add(entry.getKey());
                Map<Integer, Integer> nInDegree = new HashMap<>(inDegree);
                Set<Integer> neighbors = new HashSet<>(adjList.get(entry.getKey()));
                for(int i : neighbors)
                    nInDegree.put(i, nInDegree.get(i) - 1);

                problem3_helper(n, adjList, nInDegree, output, nCurr, used);
                used.remove(entry.getKey());
            }
        }
        return output;
    }
}
