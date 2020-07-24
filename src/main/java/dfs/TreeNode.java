package dfs;

public class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(){
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString(){
        return "" + val;
    }
}
