package fun.hoyouly;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 */
public class Leetcode_24 {
    public static void main(String[] args) {
        Solution test = new Solution();
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            //创建一个哨兵节点
            ListNode dummy = new ListNode(-1);
            //哨兵节点指向head节点
            dummy.next = head;
            //使用三个指针来处理
            ListNode pre = dummy;
            while (head != null && head.next != null) {
                //保存这两个节点
                ListNode fristNode = head;
                ListNode secondNode = head.next;

                // pre.next 就是头节点，把头结点指向第二个节点
                pre.next = secondNode;
                // 原本的第一个节点的指向第二个节点的下一个节点
                fristNode.next = secondNode.next;
                // 原来的第二个节点指向第一个节点
                secondNode.next = fristNode;

                // pre 节点就指向第二个节点。
                pre = fristNode;
                //头结点就指向了原本第一个节点的下一个节点
                head = fristNode.next;
            }
            return dummy.next;
        }
    }
}


