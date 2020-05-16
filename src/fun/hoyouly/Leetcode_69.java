package fun.hoyouly;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class Leetcode_69 {
    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.mySqrt(2147395599));
    }

    static class Solution {
        public int mySqrt(int x) {
            long left = 1;
            long right = x;

            while (left <= right) {
                long mid = (left + right) / 2;
                if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                    return (int) mid;
                } else if (mid * mid > x) {
                    right = mid - 1;
                } else {
                    //说明值小了，往右侧查找
                    left = mid + 1;
                }
            }
            return 0;
        }
    }
}
