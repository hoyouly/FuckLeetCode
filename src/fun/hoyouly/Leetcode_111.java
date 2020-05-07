package fun.hoyouly;

import java.util.LinkedList;

/**
 *
 */
public class Leetcode_111 {
    public static void main(String[] args) {
        Solution test = new Solution();
    }

    static class Solution {
        public int minDepth(TreeNode root) {
            int depth = 0;
            if (root == null) {
                return depth;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                depth++;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.pollFirst();
                    if (node.left == null && node.right == null) {
                        return depth;
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            return depth;
        }
    }
}
