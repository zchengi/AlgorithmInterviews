package seven.three;

import util.TreeNode;

/**
 * LeetCode 112. Path Sum
 * <p>
 * 时间复杂度: O(n), n为树的节点个数
 * 空间复杂度: O(h), h为树的高度
 *
 * @author cheng
 *         2018/7/27 22:58
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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

        int sum = 22;

        System.out.println(new Solution().hasPathSum(root, sum));
    }
}
