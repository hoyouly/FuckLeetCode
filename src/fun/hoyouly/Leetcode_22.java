package fun.hoyouly;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Leetcode_22 {
    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.generateParenthesis(3).toString());
    }

    static class Solution {
        public List<String> generateParenthesis(int n) {
            if (n <= 0) {
                return null;
            }
            List<String> result = new ArrayList<>();
            _gen(0, 0, n, result, "");
            return result;
        }

        private void _gen(int left, int right, int n, List<String> result, String data) {
            if (left == n && right == n) {
                result.add(data);
            }
            if (left < n) {
                _gen(left + 1, right, n, result, data + "(");
            }
            if (right < left && right < n) {
                _gen(left, right + 1, n, result, data + ")");
            }
        }
    }
}
