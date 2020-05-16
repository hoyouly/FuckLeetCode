package fun.hoyouly;

/**
 *
 */
public class Leetcode_52 {
    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.totalNQueens(4));
    }

    static class Solution {
        int count, size;

        public int totalNQueens(int n) {
            // 当每一位都填充为1（每一列都放置了一个皇后，且符合规则）时，则找到一个答案
            count = 0;
            //把0到n-1位，共计n位的所有位置为1
            size = (1 << n) - 1;
            solve(0, 0, 0);
            return count;
        }

        /**
         * @param cols   列被占用的情况，0为没占用，1为占用
         * @param master 主对角线的占用情况，在数组中可以通过相减为常数来判断，但在位运算中需要通过别的手段来记录master
         *               二进制数 数位是从右向左，而数组的数位是从左向右，因此数组中的右移一位在位运算中就是 <<1 (左移一位)
         * @param slave  副对角线，和master同理
         */
        private void solve(int cols, int master, int slave) {
            if (cols == size) {
                count++;
                return;
            }
            // pos为本层可以放置皇后的点，1为可以放置，0为不可放置。将占用掉的列或起来取个反就可以将所有没被占用的列设为1。
            //cols | master | slave  得到列，主副对角线三个中没有被占用的位置，这个时候，0表示未被占用的
            // ~(cols | master | slave)  就是把0 设置为1，
            // 因为int 类型是32位的，所以这样直接取反之后，之前默认的0 也变成了1，所以需要把这些默认的1 改成0
            // size & 上这个结果，就是把int 类型的默认的1 在设置为0
            int pos = size & (~(cols | master | slave));
            //到这里 pos 中1的位置可以放皇后
            while (pos != 0) {
                //得到最后一个1，这个位置就是皇后可以占用的位置
                int p = pos & -pos;
                solve(cols | p, (master | p) << 1, (slave | p) >> 1);
                //把最低位的1清0，
                pos &= (pos - 1);
            }
        }
    }
}
