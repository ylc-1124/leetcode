package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class _206_反转链表 {
  /*  public ListNode reverseList(ListNode head) {//方法一：递归
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }*/
  public ListNode reverseList(ListNode head) { //方法二：迭代
      ListNode newHead = null;
      while (head != null) {
          ListNode tmp = head.next;
          head.next = newHead;
          newHead = head;
          head = tmp;
      }
      return newHead;
  }
}
