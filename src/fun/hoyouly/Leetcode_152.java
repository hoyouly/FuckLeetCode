package fun.hoyouly;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class Leetcode_152 {
    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.maxProduct(new int[]{0, 4}));
    }

    static class Solution {
        public int maxProduct(int[] nums) {
            //定义一个状态，二维数组，0 表示到达当前位置最大值，1 表示到达当前位置的最小值
            int[][] dp = new int[2][2];
            dp[0][0] = nums[0];
            dp[0][1] = nums[0];
            int res = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                //状态转移方程
                int x = i % 2;//
                int y = (i - 1) % 2;
                //使用了一个2*2的二维数组，这样每次都使用一组得到另外一组
                dp[x][0] = Math.max(Math.max(dp[y][0] * num, dp[y][1] * num), num);
                dp[x][1] = Math.min(Math.min(dp[y][0] * num, dp[y][1] * num), num);
                res = Math.max(res, dp[x][0]);
            }
            return res;
        }
    }
}
