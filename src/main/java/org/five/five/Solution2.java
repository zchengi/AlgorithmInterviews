package org.five.five;

import org.util.ListNode;

/**
 * LeetCode 237. Delete Node in a Linked List
 * <p>
 * java更简单的实现方法：
 * 直接将下一个结点的值赋给当前结点，然后让当前结点的 next 指向下一个结点的 next。相当于删除了当前结点
 * <p>
 * 时间复杂度：O(1)
 * 空间复杂度：O(1)
 *
 * @author cheng
 *         2018/4/14 22:15
 */
public class Solution2 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(arr);
        new Solution2().deleteNode(listNode.next.next);
        System.out.println(listNode);
    }
}
