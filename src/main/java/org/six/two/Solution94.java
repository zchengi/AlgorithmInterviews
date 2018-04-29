package org.six.two;

import org.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 094. Binary Tree Inorder Traversal
 *
 * @author cheng
 *         2018/4/29 22:37
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode node, List<Integer> res) {

        if (node != null) {
            inorder(node.left, res);
            res.add(node.val);
            inorder(node.right, res);
        }
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);

        System.out.println(new Solution94().inorderTraversal(treeNode));
    }
}