package org.five.five;

import org.util.ListNode;

/**
 * LeetCode 237. Delete Node in a Linked List
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * @author cheng
 *         2018/4/14 22:15
 */
public class Solution1 {
    public void deleteNode(ListNode node) {

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = node;

        ListNode delNode = null;
        while (dummyNode.next != null) {
            delNode = dummyNode;
            dummyNode.val = dummyNode.next.val;
            dummyNode = dummyNode.next;
        }

        delNode.next = null;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(arr);
        new Solution1().deleteNode(listNode.next.next);
        System.out.println(listNode);
    }
}
