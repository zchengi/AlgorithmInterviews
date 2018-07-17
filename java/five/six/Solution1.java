package five.six;

import util.ListNode;

/**
 * LeetCode 019.  Remove Nth Node From End of List
 * <p>
 * 双指针
 *
 * @author cheng
 *         2018/4/16 14:34
 */
public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slow = dummyHead, fast = dummyHead;


        int count = 0;
        while (fast != null) {

            if (count < n + 1) {
                fast = fast.next;
                count++;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }

        slow.next = slow.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int n = 1;
        int[] arr = {1, 2};
        ListNode listNode = new ListNode(arr);
        System.out.println(new Solution1().removeNthFromEnd(listNode, n));
    }
}
