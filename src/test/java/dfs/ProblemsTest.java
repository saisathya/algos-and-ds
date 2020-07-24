package dfs;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProblemsTest {
    @Test
    public void problem1(){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        assertTrue(Problems.problem1(root, 23));
        assertFalse(Problems.problem1(root, 16));
    }
}