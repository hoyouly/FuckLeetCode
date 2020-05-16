package fun.hoyouly;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 */
public class Leetcode_338 {
    public static void main(String[] args) {
        Solution test = new Solution();
        int[] bits = test.countBits(5);
        for (int bit : bits) {
            System.out.print(bit + " ");
        }
    }

    static class Solution {
        public int[] countBits(int num) {
            int[] count = new int[num + 1];

            for (int i = 1; i <= num; i++) {
                count[i] = count[i & (i - 1)] + 1;
            }

            return count;
        }
    }
}
