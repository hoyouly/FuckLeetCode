package fun.hoyouly;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * . N皇后
 */
public class Leetcode_51 {
    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.printf(test.solveNQueens(4).toString());
    }

    static class Solution {
        //定义列和对角线
        private boolean[] cols;
        private boolean[] d1;
        private boolean[] d2;

        //结果
        List<List<String>> ans = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            cols = new boolean[n];
            d1 = new boolean[2 * n - 1];
            d2 = new boolean[2 * n - 1];
            // 定义每行的元素个数
            List<Integer> row = new LinkedList<>();
            // 回溯寻找符合要求的每组解
            putQueue(n, 0, row);
            return ans;
        }

        // index 代表当前访问的行数,最多到 n; row 用来存放满足题意的一种情况
        private void putQueue(int n, int index, List<Integer> row) {
            // 如果遍历到了最后一行，即代表已经找出一组解出来
            if (n == index) {
                // 将找到的一组解转化为棋盘格的形式后再放入 ans
                ans.add(changBoard(n, row));
                return;
            }

            for (int i = 0; i < n; i++) {
                // index + i 表示横纵坐标相加
                int id1 = index + i;
                // index - i + n - 1 表示横纵坐标之差
                int id2 = index - i + n - 1;
                // 如果当前位置元素与他同一列，同一主副对角线上没有重复元素
                if (!cols[i] && !d1[id1] && !d2[id2]) {
                    // 则该位置即皇后放置的位置，放入 row 存储位置信息，并标记为 true
                    row.add(i);
                    cols[i] = true;
                    d1[id1] = true;
                    d2[id2] = true;

                    // 接着递归寻找下一行
                    putQueue(n, index + 1, row);

                    // 遍历完后再退出标记
                    cols[i] = false;
                    d1[id1] = false;
                    d2[id2] = false;

                    // 回退上一格子(回溯)
                    row.remove(row.size() - 1);
                }
            }
        }

        private List<String> changBoard(int n, List<Integer> row) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                // 初始化 ch 中所有位置元素为 ‘.’
                char[] ch = new char[n];
                Arrays.fill(ch, '.');
                // 将 row 中已经确定下来的 Queen 位置改为 ‘Q’
                ch[row.get(i)] = 'Q';
                // 然后放入 tmp 中
                tmp.add(new String(ch));
            }
            return tmp;
        }
    }
}
