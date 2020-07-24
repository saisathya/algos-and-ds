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
}
