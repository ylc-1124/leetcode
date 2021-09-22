package 链表;

/**
 * https://leetcode-cn.com/problems/split-linked-list-in-parts/
 */
public class _725_分隔链表 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        int averLength = length / k;
        int remainder = length % k;

        node = head;
        ListNode prev = null;
        for (int i = 0; i < k; i++) {
            res[i] = node;
            int tempLength = remainder > 0 ? (averLength + 1) : averLength;
            for (int j = 0; j < tempLength; j++) {
                prev = node;
                node = node.next;
            }
            if (prev != null) {
                prev.next = null;
            }
            if (remainder > 0) {
                remainder--;
            }

        }

        return res;
    }
}
