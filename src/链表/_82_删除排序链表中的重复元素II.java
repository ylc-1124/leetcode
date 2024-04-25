package 链表;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class _82_删除排序链表中的重复元素II {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode();
        newHead.next = head;

        ListNode prev = newHead, cur = prev.next;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                // 指针后移直到为空或者不同的元素
                ListNode p = cur.next;
                while (p != null && p.val == cur.val) p = p.next;

                // 删除相同的元素
                prev.next = p;
                cur = p;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }

        return newHead.next;
    }
//    public ListNode deleteDuplicates(ListNode head) {
//        // 保存每个元素出现的次数
//        Map<Integer, Integer> map = new HashMap<>();
//        ListNode p = head;
//        while (p != null) {
//            Integer freq = map.getOrDefault(p.val, 0);
//            map.put(p.val, freq + 1);
//            p = p.next;
//        }
//        // 出现次数大于1的结点删除
//        ListNode newHead = new ListNode();
//        newHead.next = head;
//
//        ListNode prev = newHead;
//        p = newHead.next;
//        while (p != null) {
//            Integer freq = map.get(p.val);
//            if (freq > 1) {
//                prev.next = p.next;
//            } else {
//                prev = p;
//            }
//            p = p.next;
//        }
//
//        return newHead.next;
//    }

//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null) return null;
//        ListNode newHead = new ListNode(0, head);
//        ListNode node = head;
//        ListNode next = node.next;
//        ListNode prev = newHead;
//
//        while (node != null && next != null) {
//            if (node.val != next.val) { //不重复则继续往后面遍历
//                prev = node;
//                node = node.next;
//                if (node != null) {
//                    next = node.next;
//                }
//                continue;
//            }
//            //node.val是重复的值,next指针移动到一一个大于这个值的位置
//            while (next != null && next.val == node.val) {
//                next = next.next;
//            }
//            //next指向第一个不等于这个重复值的结点
//            prev.next = next;
//            node = next;
//            if (node != null) {
//                next = node.next;
//            }
//        }
//        return newHead.next;
//    }

}
