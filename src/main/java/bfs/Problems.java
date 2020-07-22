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

    /**
     * Zig zag level traversal of binary tree
     */
    public static List<List<Integer>> problem3(TreeNode root){
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        boolean isLtr = true;
        while(!list.isEmpty()){
            List<Integer> row = new ArrayList<>();
            int count = list.size();
            if(isLtr){
                for(int i = 0; i < count; i++){
                    TreeNode node = list.remove(0);
                    row.add(node.val);
                    if(node.left != null)
                        list.add(node.left);
                    if(node.right != null)
                        list.add(node.right);
                }
            }
            else{
                for(int i = 0; i < count; i++){
                    TreeNode node = list.remove(list.size() - 1);
                    row.add(node.val);
                    if(node.right != null)
                        list.add(0, node.right);
                    if(node.left != null)
                        list.add(0, node.left);
                }
            }
            output.add(row);
            isLtr = !isLtr;
        }

        return output;
    }

    /**
     * Given a binary tree, get the average of each level
     */
    public static List<Double> problem4(TreeNode root){
        if(root == null)
            return new ArrayList<>();

        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()){
            int count = q.size();
            double sum = 0;
            for(int i = 0; i < count; i++){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            result.add(sum / count);
        }

        return result;
    }

    /**
     * Find the minimum depth (shortest path from root to a leave) in a binary tree
     */
    public static int problem5(TreeNode root){
        if(root == null)
            return 0;
        int depth = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            depth++;
            int count = q.size();
            for(int i = 0; i < count; i++){
                TreeNode node = q.poll();
                if(node.left == null && node.right == null)
                    return depth;
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
        }
        return 0;
    }

    /**
     * Given a binary tree, print it's right view
     */
    public static List<Integer> problem6(TreeNode root){
        if(root == null)
            return new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int count = q.size();
            for(int i = 0; i < count; i++){
                if(i == 0)
                    output.add(q.peek().val);
                TreeNode node = q.poll();
                if(node.right != null)
                    q.offer(node.right);
                if(node.left != null)
                    q.offer(node.left);
            }
        }

        return output;
    }
}
