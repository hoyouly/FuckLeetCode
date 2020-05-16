package fun.hoyouly;

import java.util.HashMap;
import java.util.Map;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Leetcode_70 {
    public static void main(String[] args) {
        Solution test = new Solution();
    }

    static class Solution {
        Map<Integer, Integer> value = new HashMap<>();

        public int climbStairs_1(int n) {
            if (n <= 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            if (value.get(n) == null) {
                value.put(n, climbStairs(n - 1) + climbStairs(n - 2));
            }
            return value.get(n);
        }

        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }
            int result = 0;
            int frist = 1;
            int second = 2;
            for (int i = 2; i < n; i++) {
                result = frist + second;
                frist = second;
                second = result;
            }
            return result;
        }
    }
}
