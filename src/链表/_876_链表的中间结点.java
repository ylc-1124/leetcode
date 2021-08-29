package 链表;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class _876_链表的中间结点 {
    public ListNode middleNode(ListNode head) { //朴素的单指针法
        int count=0;
        ListNode node = head;
        while (node != null) { //遍历得到链表长度
            count++;
            node = node.next;
        }
        node = head;

        for (int i = 0; i < count / 2; i++) {
            node = node.next;
        }
        return node;

    }
    public ListNode middleNode2(ListNode head) { //快慢指针法
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;
    }

}
