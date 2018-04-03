package org.five.four;

import org.util.ListNode;

/**
 * LeetCode 024. Swap Nodes in Pairs
 * <p>
 * Solution1 优化版本(但是起的作用并不大)
 * <p>
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 *
 * @author cheng
 *         2018/4/3 23:43
 */
public class Solution2 {
    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null) {
            ListNode temp1 = p;
            p = p.next;
            temp1.next = p.next;

            ListNode temp2 = p.next.next;
            p.next.next = p;
            p.next = temp2;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode listNode = new ListNode(arr);
        System.out.println(new Solution2().swapPairs(listNode));
    }
}