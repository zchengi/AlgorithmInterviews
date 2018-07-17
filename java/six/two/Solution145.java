package six.two;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 145. Binary Tree Postorder Traversal
 *
 * @author cheng
 *         2018/4/29 22:37
 */
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        postorder(root, res);
        return res;
    }

    private void postorder(TreeNode node, List<Integer> res) {

        if (node != null) {
            postorder(node.left,res);
            postorder(node.right,res);
            res.add(node.val);
        }
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);

        System.out.println(new Solution145().postorderTraversal(treeNode));
    }
}
