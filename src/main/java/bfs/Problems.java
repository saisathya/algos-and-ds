package bfs;

import java.util.*;

public class Problems {

    /**
     * Do a level by level output of binary Tree and return it as a list of list representing each level
     */
    public static List<List<Integer>> problem1(TreeNode root){
        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> output = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int count = q.size();
            for(int i = 0; i < count; i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
            output.add(list);
        }

        return output;
    }

    /**
     * Provide a reverse level by level order traversal for a binary tree
     */
    public static List<List<Integer>> problem2(TreeNode root){
        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> output = new LinkedList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int count = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < count; i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
            output.add(0, list);
        }
        return output;
    }
}
