package 链表;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class _23_合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode newHead = new ListNode(0, null);
        ListNode tail = newHead;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length
                , (o1, o2) -> o1.val - o2.val);
        for (ListNode head : lists) {
            ListNode node = head;
            while (node != null) {
                queue.offer(node);
                node = node.next;
            }
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            node.next = null;
            tail.next = node;
            tail = node;
        }
        return newHead.next;
    }
}
