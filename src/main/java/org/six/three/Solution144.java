package org.six.three;

import org.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 144. Binary Tree Preorder Traversal
 * <p>
 * 非递归二叉树的前序遍历
 * <p>
 * 时间复杂度: O(n), n为树的节点个数
 * 空间复杂度: O(h), h为树的高度
 *
 * @author cheng
 *         2018/4/30 19:43
 */
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.empty()) {
            Command command = stack.pop();

            if ("print".equals(command.s)) {
                res.add(command.node.val);
            } else {
                assert "go".equals(command.s);
                if (command.node.right != null) {
                    stack.push(new Command("go", command.node.right));
                }
                if (command.node.left != null) {
                    stack.push(new Command("go", command.node.left));
                }

                stack.push(new Command("print", command.node));
            }
        }

        return res;
    }

    private class Command {

        String s;
        TreeNode node;

        public Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);

        System.out.println(new org.six.two.Solution144().preorderTraversal(treeNode));
    }
}
