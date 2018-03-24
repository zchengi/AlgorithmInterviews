package org.five.one;


/**
 * LeetCode 206. Reverse Linked List
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * @author cheng
 *         2018/3/24 20:34
 */
public class Solution1 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }

        @Override
        public String toString() {
            ListNode list = this;
            StringBuilder builder = new StringBuilder();
            while (list != null) {
                builder.append(list.val).append(" ");
                list = list.next;
            }
            return builder.toString();
        }
    }

    public ListNode reverseList(ListNode head) {

        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        System.out.println("未反转：" + listNode);
        System.out.println("反  转： " + new Solution1().reverseList(listNode));
    }
}
