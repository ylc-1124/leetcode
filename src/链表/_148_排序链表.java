package 链表;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/sort-list/
 */
public class _148_排序链表 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        //将当前链表一分为二
        ListNode middleNode = middleNode(head);
        ListNode rightNode = middleNode.next;
        middleNode.next = null;

        //将分割后的两个链表递归调用此方法继续分割
        ListNode left = sortList(head);
        ListNode right = sortList(rightNode);

        //全部分割到不能分割了，开始合并
        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        l3.next = null;
        ListNode head = l3;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        if (l1 != null) {
            l3.next = l1;
        } else {
            l3.next = l2;
        }

        return head.next;
    }

    private ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
