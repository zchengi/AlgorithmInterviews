package org.five.six;

import org.util.ListNode;

/**
 * LeetCode 019.  Remove Nth Node From End of List
 * <p>
 * 先计算链表大小，然后计算要删除结点顺序的值，再循环删除
 *
 * @author cheng
 *         2018/4/16 14:34
 */
public class Solution3 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = 0;
        ListNode node = head;

        while (node != null) {
            len++;
            node = node.next;
        }

        node = new ListNode(-1);
        ListNode dummy = node;
        node.next = head;

        int step = len - n;
        while (step > 0) {
            node = node.next;
            step--;
        }

        node.next = node.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        int n = 2;
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(arr);
        System.out.println(new Solution3().removeNthFromEnd(listNode, n));
    }
}
