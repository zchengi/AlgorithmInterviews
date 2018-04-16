package org.five.six;

import org.util.ListNode;

/**
 * LeetCode 019.  Remove Nth Node From End of List
 * <p>
 * 双指针(另一种实现，慢了一点)
 *
 * @author cheng
 *         2018/4/16 14:34
 */
public class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slow = dummyHead, fast = dummyHead;

        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        int count = 0;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int n = 2;
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(arr);
        System.out.println(new Solution2().removeNthFromEnd(listNode, n));
    }
}
