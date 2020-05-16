package fun.hoyouly;

/**
 *
 */
public class Leetcode_231 {
    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.isPowerOfTwo(1));
    }

    static class Solution {
        public boolean isPowerOfTwo(int n) {
            //2 的n 次幂结果肯定是一个大于0的数据，并且转换成二进制有且只有一个1，其他的都是0
            return (n > 0) && (n & (n - 1)) == 0;
        }
    }
}
