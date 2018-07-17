package six.two;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 144. Binary Tree Preorder Traversal
 *
 * @author cheng
 *         2018/4/29 22:16
 */
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode node, List<Integer> res) {

        if (node != null) {
            res.add(node.val);
            preorder(node.left, res);
            preorder(node.right,res);
        }
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);

        System.out.println(new Solution144().preorderTraversal(treeNode));
    }
}
