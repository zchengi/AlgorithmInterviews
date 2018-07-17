package util;

/**
 * Definition for singly-linked list.
 * <p>
 * 在Java版本中，我们将LinkedList相关的测试辅助函数写在ListNode里；
 *
 * @author cheng
 *         2018/3/25 17:59
 */
public class ListNode {

    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    /**
     * 根据n个元素的数组arr创建一个链表
     * 使用arr作为参数，创建另外一个ListNode的构造函数
     */
    public ListNode(int[] arr) {

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Arr can not be empty.");
        }

        this.val = arr[0];
        ListNode curNode = this;
        for (int i = 1; i < arr.length; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        ListNode curNode = this;
        while (curNode != null) {
            builder.append(curNode.val);
            builder.append(" -> ");
            curNode = curNode.next;
        }

        return builder.append("NULL").toString();
    }

}
