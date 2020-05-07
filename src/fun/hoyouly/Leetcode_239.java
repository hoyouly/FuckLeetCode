package fun.hoyouly;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 */
public class Leetcode_239 {
    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = new int[]{1, 3, 1, 2, 0, 5};
        int[] window = test.maxSlidingWindow(nums, 3);
        System.out.println(window);
        for (int i : window) {
            System.out.printf(i + "  ");
        }
    }

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length < 2) {
                return nums;
            }
            // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
            LinkedList<Integer> queue = new LinkedList<>();
            // 结果数组
            int[] result = new int[nums.length - k + 1];

            for (int i = 0; i < nums.length; i++) {
                // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
                while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                    queue.pollLast();
                }
                // 添加当前值对应的数组下标
                queue.addLast(i);
                // 判断当前队列中队首的值是否有效
                if (queue.peek() <= i - k) {
                    queue.poll();
                }
                // 当窗口长度为k时 保存当前窗口中最大值
                if (i + 1 > k) {
                    result[i + 1 - k] = nums[queue.peek()];
                }
            }
            return result;
        }

        public int[] maxSlidingWindow_1(int[] nums, int k) {
            if (nums == null || nums.length < k || k == 1) {
                return nums;
            }
            int[] arr = new int[nums.length - k + 1];
            //使用双端队列
            Deque<Integer> deque = new ArrayDeque<>(k);

            for (int i = 0; i < nums.length; i++) {
                addDeque(deque, nums[i], k);
                if (i >= k - 1) {
                    arr[i + 1 - k] = deque.getFirst();
                }
            }
            return arr;
        }

        private void addDeque(Deque<Integer> deque, int num, int k) {
            if (deque.isEmpty()) {
                deque.add(num);
                return;
            }
            boolean isOver = false;
            if (deque.size() == k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && !isOver) {
                Integer value = deque.getFirst();
                if (value < num) {
                    deque.removeFirst();
                } else {
                    isOver = true;
                }
            }
            deque.add(num);
        }
    }
}
