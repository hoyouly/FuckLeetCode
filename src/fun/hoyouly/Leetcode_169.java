package fun.hoyouly;

import java.util.HashMap;

/**
 *
 */
public class Leetcode_169 {
    public static void main(String[] args) {
        Solution test = new Solution();
    }

    static class Solution {
        public int majorityElement(int[] nums) {
            int num = nums[0];
            int count = 1;
            for (int i : nums) {
                if (i == num) {
                    count++;
                } else if (count - 1 == 0) {
                    num = i;
                } else {
                    count--;
                }
            }
            return num;
        }
    }
}
