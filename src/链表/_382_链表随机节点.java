package 链表;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/linked-list-random-node/
 */
public class _382_链表随机节点 {
    List<ListNode> list = new LinkedList<>();
    Random random = new Random();
    public _382_链表随机节点(ListNode head) {
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size())).val;
    }

}
