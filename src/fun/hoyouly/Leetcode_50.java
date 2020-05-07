package fun.hoyouly;

/**
 *
 */
public class Leetcode_50 {
    public static void main(String[] args) {
        Solution test = new Solution();

        System.out.printf("result: " + test.myPow(2.00000, -2));
    }

    static class Solution {
        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return x;
            }
            if (n == -1) {
                return 1 / x;
            }
            double value = myPow(x, n / 2);
            return value * value * myPow(x, n % 2);
        }
    }
}
