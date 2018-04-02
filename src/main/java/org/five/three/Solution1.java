package org.five.three;

import org.util.ListNode;

/**
 * LeetCode 203. Remove Linked List Elements
 * <p>
 * 使用虚拟头结点
 * <p>
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 *
 * @author cheng
 *         2018/4/2 22:47
 */
public class Solution1 {
    public ListNode removeElements(ListNode head, int val) {

        // 虚拟头结点
        ListNode sentry = new ListNode(0);
        sentry.next = head;
        ListNode cur = sentry;
        while (cur.next != null) {
            if (cur.next.val == val) {
                if (cur.next.next != null) {
                    cur.next = cur.next.next;
                } else {
                    cur.next = null;
                }
            } else {
                cur = cur.next;
            }
        }

        return sentry.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        ListNode listNode = new ListNode(nums);
        int val = 1;
        System.out.println(new Solution1().removeElements(listNode, val));
    }
}
