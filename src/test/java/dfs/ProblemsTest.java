package dfs;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.Matchers.*;
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

    @Test
    public void problem2(){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        assertThat(Problems.problem2(root, 23), hasItems(Arrays.asList(12, 7, 4), Arrays.asList(12, 1, 10)));
    }

    @Test
    public void problem3(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        assertEquals(332, Problems.problem3(root));
    }

    @Test
    public void problem4(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        assertFalse(Problems.problem4(root, new int[] { 1, 0, 7 }));
        assertTrue(Problems.problem4(root, new int[] { 1, 1, 6 }));
        assertFalse(Problems.problem4(root, new int[]{1, 1}));
        assertTrue(Problems.problem4(null, new int[]{}));
        assertTrue(Problems.problem4(null, null));
    }
}