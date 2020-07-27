package dfs;

import java.util.*;

public class Problems {

    /**
     * You are given the root of a binary tree and an integer k. Find if you get add the sums of the nodes to get the value k
     */
    public static boolean problem1(TreeNode root, int sum){
        if(root == null)
            return false;

        if(root.val - sum == 0)
            return true;
        else
            return problem1(root.left, sum - root.val) || problem1(root.right, sum - root.val);
    }

    /**
     * Given a binary tree, find all the paths that add up to a particular sum.
     * Space complexity: O(n lg n) is balanced binary tree, or O(n) is unbalanced
     * Time complexity: O(n^2), it takes n time to traverse through all nodes and might take up to O(n) time to copy all values to the new accumulator
     */
    public static List<List<Integer>> problem2(TreeNode root, int sum){
        List<List<Integer>> output = new ArrayList<>();
        problem2_helper(root, sum, new ArrayList<>(), output);
        return output;
    }

    public static void problem2_helper(TreeNode root, int sum, List<Integer> acc, List<List<Integer>> output){
        if(root == null)
            return;
        List<Integer> newAcc = new ArrayList<>(acc);
        newAcc.add(root.val);
        if(sum - root.val == 0)
            output.add(newAcc);
        problem2_helper(root.left, sum - root.val, newAcc, output);
        problem2_helper(root.right, sum - root.val, newAcc, output);
    }

    /**
     * Given a binary tree, each node represents a value between 0 to 9. Each path from root to leave represents a number.
     * Find the sum of all these numbers
     */
    public static int problem3(TreeNode root){
        if(root == null)
            return -1;
        return problem3_helper(root, 0);
    }

    public static int problem3_helper(TreeNode root, int acc){
        if(root == null)
            return 0;
        acc = acc * 10 + root.val;
        if(root.left == null && root.right == null)
            return acc;
        return problem3_helper(root.left, acc) + problem3_helper(root.right, acc);
    }

    /**
     * Given a path from root to leaf, determine if the binary tree has such a path
     */
    public static boolean problem4(TreeNode root, int[] seq){
        if(root == null){
            if(seq == null || seq.length == 0)
                return true;
            return false;
        }
        if(seq == null)
            return false;
        return problem4_helper(root, seq, 0);
    }

    public static boolean problem4_helper(TreeNode root, int[] seq, int index){
        if(root == null || index >= seq.length || root.val != seq[index])
            return false;
        else if(index == seq.length - 1){
            if(root.left == null && root.right == null)
                return true;
            else return false;
        }
        else return problem4_helper(root.left, seq, index + 1) || problem4_helper(root.right, seq, index + 1);
    }

    /**
     * Given a value k, find the number of paths that add up to k.
     * If it is a balanced binary tree runtime is O(n lgn) because at each level we will need to recalculate lg(n - 1) items
     */
    public static int problem5(TreeNode root, int k){
        return problem5_helper(root, k, new HashMap<>());
    }

    public static int problem5_helper(TreeNode root, int k, Map<Integer, Integer> map){
        if(root == null)
            return map.getOrDefault(k,0);
        Map<Integer, Integer> newMap = new HashMap<>();
        for(int i : map.keySet()){
            newMap.put(i + root.val, map.getOrDefault(i, 1));
        }
        newMap.put(root.val, map.getOrDefault(root.val, 1));
        int left = problem5_helper(root.left, k, new HashMap<>(newMap));
        int right = problem5_helper(root.right, k, new HashMap<>(newMap));
        return left + right - newMap.getOrDefault(k, 0);
    }
}
