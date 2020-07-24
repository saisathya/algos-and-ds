package dfs;

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
}
