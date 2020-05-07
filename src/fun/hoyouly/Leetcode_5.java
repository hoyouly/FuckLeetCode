package fun.hoyouly;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class Leetcode_5 {
    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.longestPalindrome3(""));
    }

    static class Solution {


        /**
         * 字符串翻转，然后双重遍历,时间复杂度是O(n*n) 空间复杂度是O(n*n)
         *
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            //字符串倒置
            String reverseStr = new StringBuffer(s).reverse().toString();

            int maxLen = 0;//最大长度是0；
            int maxEnd = 0;//最长的回文字符串的结束为止

            int length = s.length();
            int[][] cell = new int[length][length];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (s.charAt(i) == reverseStr.charAt(j)) {
                        if (i == 0 || j == 0) {//说明是第一个匹配成功的，那么在二维数组相应的位置存入1
                            cell[i][j] = 1;
                        } else {
                            cell[i][j] = cell[i - 1][j - 1] + 1;
                        }
                    } else {
                        //说明这两个字符串不相等，那么就往二维数组中相应的位置存入0
                        cell[i][j] = 0;
                    }

                    if (cell[i][j] > maxLen) {
                        //倒置前该字符对应的坐标，
                        int beforRevInde = length - 1 - j;
                        //字符串倒置前的下标和当前的字符串下标是不是匹配。
                        if (beforRevInde + cell[i][j] - 1 == i) {
                            //如果这个是最长回文子串的话，那么加上回文子串的长度，应该是和倒置前的i相等的
                            maxLen = cell[i][j];
                            maxEnd = i;
                        }

                    }
                }
            }
            printArray(cell);

            return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
        }

        /**
         * 优化双重遍历，把空间复杂度变为O(n)
         *
         * @param s
         * @return
         */
        public String longestPalindromeBetter(String s) {
            if (s == null || s.equals("")) {
                return s;
            }
            //字符串倒置
            String reverseStr = new StringBuffer(s).reverse().toString();

            int maxLen = 0;//最大长度是0；
            int maxEnd = 0;//最长的回文字符串的结束为止

            int length = s.length();
            int[] cell = new int[length];
            for (int i = 0; i < length; i++) {
                for (int j = length - 1; j >= 0; j--) {
                    if (s.charAt(i) == reverseStr.charAt(j)) {
                        if (i == 0 || j == 0) {//说明是第一个匹配成功的，那么在二维数组相应的位置存入1
                            cell[j] = 1;
                        } else {
                            cell[j] = cell[j - 1] + 1;
                        }
                    } else {
                        //说明这两个字符串不相等，那么就往二维数组中相应的位置存入0
                        cell[j] = 0;
                    }

                    if (cell[j] > maxLen) {
                        //倒置前该字符对应的坐标，
                        int beforRevInde = length - 1 - j;
                        //字符串倒置前的下标和当前的字符串下标是不是匹配。
                        if (beforRevInde + cell[j] - 1 == i) {
                            //如果这个是最长回文子串的话，那么加上回文子串的长度，应该是和倒置前的i相等的
                            maxLen = cell[j];
                            maxEnd = i;
                        }

                    }
                }
                System.out.printf("第：" + i + "   --->  ");
                for (int j = 0; j < cell.length; j++) {
                    System.out.print(cell[j] + " ");
                }
                System.out.println();
            }

            return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
        }

        private void printArray(int[][] cell) {
            for (int i = 0; i < cell.length; i++) {
                for (int j = 0; j < cell[i].length; j++) {
                    System.out.printf(cell[i][j] + " ");
                }
                System.out.println();
            }
        }


        /**
         * 中心扩展方式 先找到中心点，然后左右遍历，如果左右相等，继续遍历，直到左右不相等的时候，遍历结束，得到的就是最长回文子串
         *
         * @param s
         * @return
         */
        public String longestPalindrome3(String s) {
            if (s == null || s.isEmpty()) {
                return s;
            }
            int start = 0;
            int end = 0;
            for (int i = 0; i < s.length(); i++) {
                //因为中心点可能是某个字符，也可能在两个字符中间，例如cddf,中心点就在dd之间
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        //中心点左右遍历
        private int expandAroundCenter(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(r) == s.charAt(l)) {
                l--;
                r++;
            }
            return r - l - 1;
        }
    }
}
