package five.three;

import util.ListNode;

/**
 * LeetCode 203. Remove Linked List Elements
 * <p>
 * 使用虚拟头结点（优化版本）
 * <p>
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 *
 * @author cheng
 *         2018/4/2 22:08
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {

        // 虚拟头结点
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode cur = head;
        ListNode pre = dummyNode;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        ListNode listNode = new ListNode(nums);
        int val = 1;
        System.out.println(new Solution2().removeElements(listNode, val));
    }
}
