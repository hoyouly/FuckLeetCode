package fun.hoyouly;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 */
public class Leetcode_141 {
    public static void main(String[] args) {
        Solution test = new Solution();
    }

    static class Solution {
        public boolean hasCycle(ListNode head) {
            // 使用快慢指针
            if (head == null || head.next == null) {
                return false;
            }
            ListNode fastNode = head;
            ListNode slowNode = head;
            while (slowNode != fastNode) {
                if (fastNode == null || fastNode.next == null) {
                    return false;
                }
                fastNode = fastNode.next.next;
                slowNode = slowNode.next;
            }
            return true;
        }

        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            Set<ListNode> set = new HashSet<>();
            while (head != null) {
                if (set.contains(head)) {
                    return head;
                } else {
                    set.add(head);
                }
                head = head.next;
            }
            return null;
        }
    }
}
