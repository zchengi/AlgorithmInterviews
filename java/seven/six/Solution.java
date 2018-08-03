package seven.six;

import util.TreeNode;

/**
 * LeetCode 235. Lowest Common Ancestor of a Binary Search Tree
 *
 * @author cheng
 *         2018/8/3 20:32
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {

        TreeNode leftRight = new TreeNode(4);
        leftRight.left = new TreeNode(3);
        leftRight.right = new TreeNode(5);

        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(0);
        left.right = leftRight;

        TreeNode right = new TreeNode(8);
        right.left = new TreeNode(7);
        right.right = new TreeNode(9);

        TreeNode root = new TreeNode(6);
        root.left = left;
        root.right = right;

        TreeNode p = new TreeNode(2), q = new TreeNode(8);
        System.out.println(new Solution().lowestCommonAncestor(root, p, q).val);
        q = new TreeNode(4);
        System.out.println(new Solution().lowestCommonAncestor(root, p, q).val);
    }
}
