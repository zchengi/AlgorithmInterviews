package seven.four;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 257. Binary Tree Paths
 *
 * @author cheng
 *         2018/7/30 20:25
 */
public class Solution2 {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        binaryTreePaths(root, "", res);
        return res;
    }

    private void binaryTreePaths(TreeNode root, String path, List<String> res) {

        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }

        if (root.left != null) {
            binaryTreePaths(root.left, path + root.val + "->", res);
        }
        if (root.right != null) {
            binaryTreePaths(root.right, path + root.val + "->", res);
        }
    }

    public static void main(String[] args) {


        TreeNode left = new TreeNode(4);
        TreeNode leftLeft = new TreeNode(11);
        leftLeft.left = new TreeNode(7);
        leftLeft.right = new TreeNode(2);
        left.left = leftLeft;

        TreeNode right = new TreeNode(8);
        TreeNode rightLeft = new TreeNode(13);
        TreeNode rightRight = new TreeNode(4);
        rightRight.right = new TreeNode(1);

        right.left = rightLeft;
        right.right = rightRight;

        TreeNode root = new TreeNode(5);
        root.left = left;
        root.right = right;

        System.out.println(new Solution2().binaryTreePaths(root));
    }
}
