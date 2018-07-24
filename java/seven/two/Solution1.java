package seven.two;

import util.TreeNode;

/**
 * LeetCode 226. Invert Binary Tree
 * <p>
 * 时间复杂度: O(n), n为树中节点个数
 * 空间复杂度: O(h), h为树的高度
 *
 * @author cheng
 *         2018/7/24 20:48
 */
public class Solution1 {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);

        left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        right.left = new TreeNode(6);
        right.right = new TreeNode(9);

        TreeNode root = new TreeNode(4);
        root.left = left;
        root.right = right;

        System.out.println(new Solution1().invertTree(root));
        System.out.println(123);

    }
}
