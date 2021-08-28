package 链表;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class _21_合并两个有序链表 {
    //递归 ,合并两个有序链表，返回头结点
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    //迭代
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
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

}
