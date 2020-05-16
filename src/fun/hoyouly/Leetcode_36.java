package fun.hoyouly;

/**
 *
 */
public class Leetcode_36 {
    public static void main(String[] args) {
        Solution test = new Solution();
    }

    static class Solution {

        /**
         * 用空间换时间
         * @param board
         * @return
         */
        public boolean isValidSudoku(char[][] board) {
            int[][] rows = new int[9][10];
            int[][] column = new int[9][10];
            int[][] boxs = new int[9][10];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    int num = board[i][j] - '0';
                    rows[i][num]++;
                    column[j][num]++;
                    int n = (i / 3) * 3 + j / 3;
                    boxs[n][num]++;
                    if (rows[i][num] + column[j][num] + boxs[n][num] > 3) {
                        return false;
                    }

                }
            }
            return true;
        }

        //正常运行
        public boolean isValidSudoku_2(char[][] board) {
            if (board == null || board.length == 0) {
                return false;
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] != '.') {//说明这个位置是一个数字，判断这个数字是否合法
                        if (!isValidHelp(board, board[i][j], i, j)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        private boolean isValidHelp(char[][] board, char c, int row, int column) {
            if (board == null) {
                return false;
            }

            for (int i = 0; i < row; i++) {
                if (board[i][column] == c) {
                    return false;
                }
            }

            for (int i = 0; i < column; i++) {
                if (board[row][i] == c) {
                    return false;
                }
            }

            int n = row / 3;
            int m = column / 3;
            for (int i = n * 3; i < n * 3 + 3; i++) {
                for (int j = m * 3; j < m * 3 + 3; j++) {
                    if (board[i][j] == c) {
                        //判断是否是自己
                        if (i != row && j != column) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }


        public boolean isValidSudoku_1(char[][] board) {
            if (board == null || board.length == 0) {
                return false;
            }
            return slove(board);
        }

        private boolean slove(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    //判断是否是要填写的部分
                    if (board[i][j] == '.') {
                        //遍历整个可以填写的数字，判断是否有合法的
                        for (char c = '1'; c < '9'; c++) {
                            if (isValid(board, i, j, c)) {
                                board[i][j] = c;
                                if (slove(board)) {
                                    return true;
                                } else {
                                    board[i][j] = '.';
                                }
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isValid(char[][] board, int row, int col, char c) {
            for (int i = 0; i < 9; i++) {
                //检查列
                if (board[i][col] != '.' && board[i][col] == c) {
                    return false;
                }
                //检查行
                if (board[row][i] != '.' && board[row][i] == c) {
                    return false;
                }
                int k = 3 * (row / 3) + i / 3;
                int j = 3 * (col / 3) + i % 3;
                if (board[k][j] != '.' && board[k][j] == c) {
                    return false;
                }
            }
            return true;
        }


    }
}
