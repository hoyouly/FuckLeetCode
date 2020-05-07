package fun.hoyouly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class Leetcode_102 {
    public static void main(String[] args) {
        Solution test = new Solution();
    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            List<Integer> rootList = new ArrayList<>();
            rootList.add(root.val);
            result.add(rootList);

            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.pollFirst();
                    if (node.left != null) {
                        queue.add(node.left);
                        list.add(node.left.val);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                        list.add(node.right.val);
                    }

                }
                if(!list.isEmpty()){
                    result.add(list);
                }
            }

            return result;

        }
    }
}
