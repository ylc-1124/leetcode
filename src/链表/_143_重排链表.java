package 链表;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class _143_重排链表 {
    ListNode left;
    public void reorderList(ListNode head) {
        left = head;
        traversal(head);
    }

    private void traversal(ListNode node) {
        if (node == null) return;
        traversal(node.next); //链表后序遍历 拿到最后一个结点
        //结束无非只有两种情况
        //1.left的后继是node的情况，要使node.next指向null去环
        //2.left和node都指向最后一个结点，看起来是最后一个结点，实际上存在环，要使left.next指向null去环，并将left赋值为null，意为结束回溯不干任何事
        if (left == null ) return;
        if (left == node) {  //left和node指向同一个位置，并且这个位置是末尾，得把这个位置的后继指向null，否则会有环
            left.next = null;
            left = null;
            return;
        }
        if (left.next != node) {
            node.next = left.next;
            left.next = node;
            left = node.next;
        } else { //left的后继为node的情况，直接后继的后继指null，left变为0，不论node怎么回溯都不会执行递归出来的这些代码
            node.next = null;
            left = null;
        }
    }
}
