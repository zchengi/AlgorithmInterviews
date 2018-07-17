package six.four;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 102. Binary Tree Level Order Traversal
 * <p>
 * 二叉树的层序遍历（递归）
 * 时间复杂度: O(n), n为树的节点个数
 * 空间复杂度: O(n)
 *
 * @author cheng
 *         2018/5/3 23:34
 */
public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> levelList = new ArrayList<>();

        helper(root, levelList, 0);
        return levelList;
    }

    private void helper(TreeNode node, List<List<Integer>> levelList, int level) {

        if (node == null) {
            return;
        }

        if (levelList.size() <= level) {
            levelList.add(new ArrayList<>());
        }

        levelList.get(level).add(node.val);
        helper(node.left, levelList, level + 1);
        helper(node.right, levelList, level + 1);
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3);
        TreeNode right = new TreeNode(20);

        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        treeNode.left = new TreeNode(9);
        treeNode.right = right;

        System.out.println(new Solution2().levelOrder(treeNode));
    }
}
