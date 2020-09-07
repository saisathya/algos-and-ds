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

    /**
     * You are given a dictionary of words that is sorted in custom lexicographical order
     * Your job is to return the order of the alphabets in this language
     */
    public static String problem4(String[] words){
        if(words == null || words.length <= 2)
            throw new IllegalArgumentException();
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for(String s : words){
            for(char c : s.toCharArray()){
                adjList.put(c, new ArrayList<>());
                inDegree.put(c, 0);
            }
        }

        for(int i = 1; i < words.length; i++){
            String word1 = words[i - 1], word2 = words[i];
            int length = Math.min(word1.length(), word2.length());
            for(int j = 0; j < length; j++){
                char parent = word1.charAt(j), child = word2.charAt(j);
                if(parent != child){
                    adjList.get(parent).add(child);
                    inDegree.put(child, inDegree.get(child) + 1);
                    break;
                }
            }
        }
        LinkedList<Character> q = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry : inDegree.entrySet()){
            if(entry.getValue() == 0)
                q.offer(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char c = q.poll();
            sb.append(c);
            List<Character> chars = adjList.get(c);
            for(char ch : chars){
                inDegree.put(ch, inDegree.get(ch) - 1);
                if(inDegree.get(ch) == 0)
                    q.offer(ch);
            }
        }
        return sb.toString();
    }

    /**
     * You are given a list of numbers and a list of valid sequences. The sequences [v1, v2] indicate that v2 can only occur
     * after v1 in the list of numbers given. Return true if the sequences yield a unique list
     */
    public static boolean problem5(int[] list, int[][] seqs){
        if(list == null || seqs == null)
            throw new IllegalArgumentException();

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for(int i : list){
            adjList.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }

        for(int[] seq : seqs){
            adjList.get(seq[0]).add(seq[1]);
            inDegree.put(seq[1], inDegree.get(seq[1]) + 1);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(Map.Entry<Integer, Integer> entry : inDegree.entrySet()){
            if(entry.getValue() == 0)
                q.offer(entry.getKey());
        }
        int count = 0;
        while(!q.isEmpty()){
            if(q.size() > 1)
                return false;
            count++;
            int key= q.poll();
            List<Integer> neighbors = adjList.get(key);
            for(int i : neighbors){
                inDegree.put(i , inDegree.get(i) - 1);
                if(inDegree.get(i) == 0)
                    q.offer(i);
            }
        }
        return count == list.length;
    }

    /**
     * You are given the edges for an undirected tree
     * Your goal is to find the minimum height you can reconstruct the tree
     */
    public static List<Integer> problem6(int n, int[][] edges){
        if(edges == null || n <= 0)
            throw new IllegalArgumentException();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        for(int i = 0; i < n; i++){
            adjList.put(i, new ArrayList<>());
            outDegree.put(i, 0);
        }

        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
            outDegree.put(edge[0], outDegree.get(edge[0]) + 1);
            outDegree.put(edge[1], outDegree.get(edge[1]) + 1);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(Map.Entry<Integer, Integer> entry : outDegree.entrySet()){
            if(entry.getValue() == 1)
                q.offer(entry.getKey());
        }
        int nodesRemaining = n;
        while(nodesRemaining > 2){
            int length = q.size();
            nodesRemaining -= length;
            for(int i = 0; i < length; i++){
                int vertex = q.poll();
                List<Integer> neighbors = adjList.get(vertex);
                for(int j : neighbors){
                    if(outDegree.containsKey(j)){
                        outDegree.put(j, outDegree.get(j) - 1);
                        if(outDegree.get(j) == 1)
                            q.offer(j);
                    }
                }
            }
        }
        return new ArrayList<>(q);
    }
}