package fun.hoyouly;

import java.util.LinkedList;

/**
 *
 */
public class Leetcode_104 {
    public static void main(String[] args) {
        Solution test = new Solution();
    }

    static class Solution {
        public int maxDepth(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int maxDepth = 0;
            while (!queue.isEmpty()) {
                maxDepth++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.pollFirst();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }

            return maxDepth;
        }


        public int maxDepth_1(TreeNode root) {
            //递归退出条件，到叶子节点
            if (root == null) {
                return 0;
            }
            //计算左子树最大深度
            int lefMax = maxDepth(root.left);
            //计算右子树最大深度
            int rightMax = maxDepth(root.right);
            //以某个节点为根节点的数的最大深度为max
            return Math.max(lefMax, rightMax) + 1;
        }
    }
}
