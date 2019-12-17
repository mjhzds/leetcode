package com.elvis.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
    public static void preOrderTraversalRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderTraversalRecursion(root.left);
        preOrderTraversalRecursion(root.right);
    }

    public static void inOrderTraversalRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversalRecursion(root.left);
        System.out.println(root.val);
        inOrderTraversalRecursion(root.right);
    }

    public static void postOrderTraversalRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversalRecursion(root.left);
        postOrderTraversalRecursion(root.right);
        System.out.println(root.val);
    }

    public static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            root = stack.pop();
            System.out.println(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root.left);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }

    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.println(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public static void morrisTraversal(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.left == null) {
                System.out.println(cur.val);
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    System.out.println(cur.val);
                    cur = cur.right;
                }
            }
        }
    }

    public boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val > max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
