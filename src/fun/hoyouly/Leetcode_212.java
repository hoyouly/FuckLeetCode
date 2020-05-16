package fun.hoyouly;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class Leetcode_212 {
    public static void main(String[] args) {
        Solution test = new Solution();
    }

    static class Solution {
        Set<String> res = new HashSet<>();

        public List<String> findWords(char[][] board, String[] words) {
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }

            int m = board.length;
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(board, visited, "", i, j, trie);
                }
            }
            return new ArrayList<>(res);
        }

        private void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
            if (x > board.length || x < 0 || y < 0 || y > board[0].length) {
                return;
            }

            if (visited[x][y]) {
                //说明已经访问过了
                return;
            }
            str += board[x][y];
            //树中不包含这个前缀，那么肯定就不存在了
            if (!trie.startsWith(str)) {
                return;
            }
            if (trie.search(str)) {
                //查找到了，那么添加到返回的集合中
                res.add(str);
            }
            visited[x][y] = true;
            //查找这个点的前后左右四个点是否有符合的。
            dfs(board, visited, str, x + 1, y, trie);
            dfs(board, visited, str, x - 1, y, trie);
            dfs(board, visited, str, x, y + 1, trie);
            dfs(board, visited, str, x, y - 1, trie);
            visited[x][y] = false;
        }
    }
}
