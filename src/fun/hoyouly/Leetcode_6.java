package fun.hoyouly;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 */
public class Leetcode_6 {
    public static void main(String[] args) {
        Solution test = new Solution();
//        "PAYPALISHIRING"

        String convert = test.convert2("PAYPALISHIRING", 3);
        System.out.println(convert);
    }

    static class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }

            List<StringBuilder> rows = new ArrayList<>();
            for (int i = 0; i < Math.min(numRows, s.length()); i++) {
                rows.add(new StringBuilder());
            }
            int curRow = 0;
            boolean goingDown = false;
            for (char c : s.toCharArray()) {
                rows.get(curRow).append(c);
                if (curRow == 0 || curRow == numRows - 1) {
                    goingDown = !goingDown;
                }
                curRow += (goingDown ? 1 : -1);
            }

            StringBuilder result = new StringBuilder();
            for (StringBuilder row : rows) {
                result.append(row.toString());
            }

            return result.toString();
        }


        public String convert1(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            StringBuilder ret = new StringBuilder();
            int n = s.length();
            //每次遍历的步长
            int cycleLen = 2 * numRows - 2;

            //遍历行数，一行一行的取得值
            for (int i = 0; i < numRows; i++) {
                //每行的步长都是cycleLen,
                for (int j = 0; j + i < n; j += cycleLen) {
                    ret.append(s.charAt(i + j));
                    //
                    if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                        ret.append(s.charAt(j + cycleLen - i));
                    }
                }
            }
            return ret.toString();
        }

        public String convert2(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            StringBuilder ret = new StringBuilder();
            int step = 2 * numRows - 2;
            int index = 0;//记录s的下标
            int add = 0;//真实的间距
            int len = s.length();

            for (int i = 0; i < numRows; i++) {//i 表示行号
                index = i;
                add = i * 2;
                while (index < len) {//超出字符串长度计算下一行
                    ret.append(s.charAt(index));//当前行第一个字符
                    add = step - add;//第一次间距是setp-2*i,第二次是2*i
                    index += (i == 0 || i == numRows - 1) ? step : add;//0行和最后一行使用step间距，其余使用add间距
                }
            }
            return ret.toString();

        }
    }
}
