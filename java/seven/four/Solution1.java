package seven.four;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 257. Binary Tree Paths
 *
 * @author cheng
 *         2018/7/30 20:00
 */
public class Solution1 {


    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res = new ArrayList<>();
        binaryTreePaths(root, new Stack<>(), res);
        return res;
    }

    private void binaryTreePaths(TreeNode node, Stack<Integer> stack, List<String> res) {

        if (node == null) {
            return;
        }

        stack.push(node.val);

        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();

            for (int i : stack) {
                sb.append(i).append("->");
            }

            sb.delete(sb.length() - 2, sb.length());
            res.add(String.valueOf(sb));
        }

        binaryTreePaths(node.left, stack, res);
        binaryTreePaths(node.right, stack, res);
        stack.pop();
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

        System.out.println(new Solution1().binaryTreePaths(root));
    }
}
