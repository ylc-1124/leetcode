package 链表;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class _142_环形链表II {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        Set<ListNode> set = new HashSet<>();
        boolean isCycle = false;
        while (node != null) {
            if (set.contains(node)) {
                isCycle = true;
                break;
            }
            set.add(node);
            node = node.next;
        }

        return isCycle ? node : null;
    }
}
