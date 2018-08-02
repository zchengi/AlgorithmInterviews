package seven.five;

import util.TreeNode;

/**
 * LeetCode 437. Path Sum III
 * <p>
 * 时间复杂度: O(n), n为树的节点个数
 * 空间复杂度: O(h), h为树的高度
 *
 * @author cheng
 *         2018/8/2 21:05
 */
public class Solution1 {

    /**
     * 在以root为根节点的二叉树中,寻找和为 sum 的路径,返回这样的路径个数
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }

        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    /**
     * 在以 node 为根节点的二叉树中，寻找包含 node 的路径，和为 sum
     * 返回这样的路径的个数
     *
     * @param node
     * @param num
     * @return
     */
    private int findPath(TreeNode node, int num) {

        if (node == null) {
            return 0;
        }

        int res = 0;
        if (node.val == num) {
            res += 1;
        }

        res += findPath(node.left, num - node.val);
        res += findPath(node.right, num - node.val);

        return res;
    }

    public static void main(String[] args) {

        TreeNode leftLeft = new TreeNode(3);
        leftLeft.left = new TreeNode(3);
        leftLeft.right = new TreeNode(-2);
        TreeNode rightRight = new TreeNode(2);
        rightRight.right = new TreeNode(1);

        TreeNode left = new TreeNode(5);
        left.left = leftLeft;
        left.right = rightRight;
        TreeNode right = new TreeNode(-3);
        right.right = new TreeNode(11);

        TreeNode root = new TreeNode(10);
        root.left = left;
        root.right = right;

        int sum = 8;

        System.out.println(new Solution1().pathSum(root, sum));
    }
}
