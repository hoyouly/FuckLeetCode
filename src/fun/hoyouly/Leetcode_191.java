package fun.hoyouly;

/**
 * 位1的个数
 */
public class Leetcode_191 {
    public static void main(String[] args) {
        Solution test = new Solution();
    }

    static class Solution {
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                n = n & (n - 1);
                count++;
            }
            return count;
        }
    }
}
