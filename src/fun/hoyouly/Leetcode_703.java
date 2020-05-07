package fun.hoyouly;

import java.util.PriorityQueue;

public class Leetcode_703 {
    public static void main(String[] args) {
    }
    class KthLargest {
        private int limit;
        //使用优先队列
        private PriorityQueue<Integer> queue;

        public KthLargest(int k, int[] nums) {
            this.limit = k;
            queue = new PriorityQueue<>(k);
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            //队列还没有满
            if (queue.size() < limit) {
                queue.add(val);
            } else if (queue.peek() < val) {
                //查看队列中最小的值是否大于val,如果小于，那么应该移除队列最小值，然后把这个添加进去
                queue.poll();
                queue.add(val);
            }
            return queue.peek();
        }
    }
}
