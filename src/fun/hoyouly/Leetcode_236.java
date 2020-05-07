package fun.hoyouly;

/**
 *
 */
public class Leetcode_236 {
    public static void main(String[] args) {
        Solution test = new Solution();
    }

    static class Solution {
        public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
            TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

            if (leftNode == null) {
                //说明root 左节点不存在P和q，那么P和Q肯定在root的右节点上
                return rightNode;
            } else {
                if (rightNode == null) {
                    //右节点也为空，说明左节点就是要查找的
                    return leftNode;
                } else {
                    //左边存在P和Q，右边也存在P和Q，那么 root 就是要查找的节点
                    return root;
                }
            }
        }


        /**
         * 二叉搜索树 ，左节点小于父节点小于右节点
         *
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //根节点的值大于P和q节点的值，说明P和Q在root节点的左侧
            if (p.val < root.val && root.val > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else if (p.val > root.val && root.val < q.val) {
                //根节点的值小于 P和q节点的值，说明P和Q在root节点的右侧
                return lowestCommonAncestor(root.right, p, q);
            }
            //说明根节点就是
            return root;
        }
    }
}
