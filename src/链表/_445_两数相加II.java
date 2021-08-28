package 链表;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class _445_两数相加II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode res = new ListNode(0, null);


        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode node1 = l1, node2 = l2;
        while (node1 != null) {
            stack1.push(node1);
            node1 = node1.next;
        }
        while (node2 != null) {
            stack2.push(node2);
            node2 = node2.next;
        }

        int carry = 0; //进位
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ListNode cur1 = stack1.isEmpty() ? null : stack1.pop();
            ListNode cur2 = stack2.isEmpty() ? null : stack2.pop();
            int value1 = cur1 != null ? cur1.val : 0;
            int value2 = cur2 != null ? cur2.val : 0;
            int value = value1 + value2;
            ListNode newNode = new ListNode((value + carry) % 10, res.next);
            res.next = newNode;
            carry = value + carry > 9 ? 1 : 0; //计算是否有进位
        }
        if (carry == 1) {
            res.next = new ListNode(1, res.next);
        }
        return res.next;

    }
}
