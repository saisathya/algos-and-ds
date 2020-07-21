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
}
