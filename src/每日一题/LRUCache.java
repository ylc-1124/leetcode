package 每日一题;

import java.util.*;

/**
 * https://leetcode.cn/problems/lru-cache/description/?envType=daily-question&envId=2023-09-24
 */

public class LRUCache {

    // HashMap保存key到双向链表结点的映射，时间复杂度O(1)
    private HashMap<Integer, DlinkedNode> map = new HashMap<>();

    //维护双向链表的头尾
    private DlinkedNode head, tail;

    private Integer capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // 虚拟头尾结点
        head = new DlinkedNode();
        tail = new DlinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            // 最近访问的结点，放到链表表头
            DlinkedNode node = map.get(key);
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            DlinkedNode node = new DlinkedNode(key, value, null, null);
            addToHead(node);
            map.put(key, node);

            // 添加可能会造成超过容量的情况
            if (map.size() > capacity) {
                //删除双向链表的尾部节点
                DlinkedNode remove_node = removeTail();
                map.remove(remove_node.key);
            }
        } else {
            DlinkedNode node = map.get(key);
            node.value = value;
            // 最近访问
            moveToHead(node);
        }
    }

    static class DlinkedNode {
        int key;
        int value;
        DlinkedNode prev;
        DlinkedNode next;

        public DlinkedNode() {
        }

        public DlinkedNode(int key, int value, DlinkedNode prev, DlinkedNode next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    //将node添加到双向链表的表头
    private void addToHead(DlinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }

    // 从双向链表中删除node
    private void removeNode(DlinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 将node添加到双向链表的表头
     */
    private void moveToHead(DlinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DlinkedNode removeTail() {
        DlinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }


}
//public class LRUCache extends LinkedHashMap<Integer,Integer> {
//
//    private Map<Integer, Integer> map;
//    private Set<Integer> set; // 用来找不同的key
//    private List<Integer> usedSeq; // 记录使用的顺序
//    private Integer limit;
//    public LRUCache(int capacity) {
//        map = new HashMap<>(capacity);
//        set = new HashSet<>();
//        usedSeq = new Stack<>();
//        limit = capacity;
//    }
//
//    public int get(int key) {
//        if (map.containsKey(key)) {
//            // 如果key在map中，算使用了
//            usedSeq.add(key);
//        }
//        return map.getOrDefault(key, -1);
//    }
//
//    public void put(int key, int value) {
//        if (map.containsKey(key)) {
//            map.put(key, value);
//            usedSeq.add(key);
//        } else {
//            // 需要插入
//            if (map.size() == limit) {
//                // 如果已经满了，删掉最久未使用的
//                usedSeq.add(key);
//                //从列表后面往前找limit个不同的key保留，第limit+1个不同的key删除
//                int count = 0; //记录找到第几个不同的key了
//                for (int i = usedSeq.size() - 1; i >= 0; i--) {
//                    int n = usedSeq.get(i);
//                    if (!set.contains(n) && count < limit) {
//                        count++;
//                        set.add(n);
//                    } else if (!set.contains(n) && count == limit) {
//                        //找到待删除的key了
//                        map.remove(n);
//                        //插入新的key
//                        map.put(key, value);
//                        // set要清空，留着下次用
//                        set.clear();
//                        break; // 赶紧跳出循环不然会多删了
//                    }
//                }
//            } else {
//                map.put(key, value);
//                usedSeq.add(key);
//            }
//        }
//    }
//
//}
