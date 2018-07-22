package seven.one;

import util.TreeNode;

/**
 * LeetCode 104. Maximum Depth of Binary Tree
 * <p>
 * 时间复杂度: O(n), n是树中的节点个数
 * 空间复杂度: O(h), h是树的高度
 *
 * @author cheng
 *         2018/7/22 17:58
 */
public class Solution {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        TreeNode root = new TreeNode(3);
        root.left = left;
        root.right = right;

        System.out.println(new Solution().maxDepth(root));
    }
}
