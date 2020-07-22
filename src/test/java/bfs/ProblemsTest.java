package bfs;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ProblemsTest {
    @Test
    public void problem1() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        assertThat(Problems.problem1(root), hasItems(Arrays.asList(12), Arrays.asList(7, 1), Arrays.asList(9, 10, 5)));
    }

    @Test
    public void problem2() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        assertThat(Problems.problem2(root), hasItems(Arrays.asList(9, 10, 5), Arrays.asList(7, 1), Arrays.asList(12)));
    }

    @Test
    public void problem3(){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        assertThat(Problems.problem3(root), hasItems(Arrays.asList(12), Arrays.asList(1, 7), Arrays.asList(9, 10, 5), Arrays.asList(17, 20)));
    }

    @Test
    public void problem4(){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        assertThat(Problems.problem4(root), hasItems(12.0, 4.0, 6.5));
    }

    @Test
    public void problem5(){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        assertEquals(3, Problems.problem5(root));
    }

    @Test
    public void problem6(){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<Integer> result = Problems.problem6(root);
        assertThat(result, hasItems(12, 1, 5, 3));
    }
}
