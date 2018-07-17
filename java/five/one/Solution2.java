package five.one;


/**
 * LeetCode 206. Reverse Linked List
 * <p>
 * 递归方式反转链表，递归是占用空间的，占用的空间与递归深度成正比；
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * @author cheng
 *         2018/3/24 20:57
 */
public class Solution2 {
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

        // 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }

        ListNode rhead = reverseList(head.next);

        // head -> next 此刻指向 head 后面的链表的尾结点
        // head -> next -> next = head 把 head 结点放在了尾部
        head.next.next = head;
        head.next = null;

        return rhead;
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        System.out.println("未反转：" + listNode);
        System.out.println("反  转： " + new Solution2().reverseList(listNode));
    }
}
