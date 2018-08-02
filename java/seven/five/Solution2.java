package seven.five;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 437. Path Sum III
 *
 * @author cheng
 *         2018/8/2 21:42
 */
public class Solution2 {
    public int pathSum(TreeNode root, int sum) {

        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int[] result = new int[1];
        dfs(root, prefixSum, 0, sum, result);

        return result[0];
    }

    private void dfs(TreeNode node, Map<Integer, Integer> map, int currentSum, int target, int[] result) {

        if (node == null) {
            return;
        }

        currentSum += node.val;

        if (map.containsKey(currentSum - target)) {
            result[0] += map.get(currentSum - target);
        }

        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        dfs(node.left,map,currentSum,target,result);
        dfs(node.right,map,currentSum,target,result);
        map.put(currentSum, map.get(currentSum) - 1);
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

        System.out.println(new Solution2().pathSum(root, sum));
    }
}
