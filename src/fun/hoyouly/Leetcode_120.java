package fun.hoyouly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 */
public class Leetcode_120 {
    public static void main(String[] args) {
        Solution test = new Solution();
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(new Integer[]{2}));
        triangle.add(Arrays.asList(new Integer[]{3, 4}));
        triangle.add(Arrays.asList(new Integer[]{6, 5, 7}));
        triangle.add(Arrays.asList(new Integer[]{4, 1, 8, 3}));
        System.out.println(test.minimumTotal(triangle));
    }

    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            //定义一个数组，保存结果，
            int[] mini = new int[triangle.size() + 1];
            //两层循环遍历，因为动态规划是自下而上的，所以最外层循环从最底部开始
            for (int i = triangle.size() - 1; i >= 0; i--) {
                //内层循环就从左至右，
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    //Math.min(mini[j], mini[j + 1] 是保存的最小值
                    //然后加上这个遍历到的数字本身，重新赋值给mini[j]
                    //因为 mini[j] 只使用一次，所以得到的最小值重新赋值，不断复用本身
                    mini[j] = triangle.get(i).get(j) + Math.min(mini[j], mini[j + 1]);
                }
            }
            return mini[0];
        }
    }
}
