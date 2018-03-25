package org.five.two;

/**
 * 测试实现的ListNode类
 *
 * @author cheng
 *         2018/3/25 18:04
 */
public class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode pre = null, cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        System.out.println(new Solution().reverseList(head));
    }
}
