package org.five.four;

import org.util.ListNode;

/**
 * LeetCode 024. Swap Nodes in Pairs
 * <p>
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 *
 * @author cheng
 *         2018/4/3 23:24
 */
public class Solution1 {
    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            p.next = node2;
            node1.next = next;
            node2.next = node1;

            p = node1;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode listNode = new ListNode(arr);
        System.out.println(new Solution1().swapPairs(listNode));
    }
}