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

    @Test
    public void problem5(){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2); root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4); root2.left.right = new TreeNode(5);
        root2.right.left = new TreeNode(6); root2.right.right = new TreeNode(7);
        root2.left.left.left = new TreeNode(8); root2.left.left.right = new TreeNode(9);
        root2.left.right.left = new TreeNode(10);
        assertEquals(2, Problems.problem5(root, 11));
        assertEquals(3, Problems.problem5(root2, 15));
    }

    @Test
    public void problem6(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        assertEquals(5, Problems.problem6(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        assertEquals(7, Problems.problem6(root));
    }

    @Test
    public void problem7(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        assertEquals(6, Problems.problem7(root));
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        assertEquals(31, Problems.problem7(root));

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        assertEquals(-1, Problems.problem7(root));
    }
}