package fun.hoyouly;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
public class Leetcode_4 {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] num1 = {1, 3};
//        int[] num2 = {2};
//        int[] num1 = {1, 2};
//        int[] num2 = {3, 4};
        int[] num1 = {100001};
        int[] num2 = {100000};
        double result = solution.findMedianSortedArrays_1(num1, num2);
        System.out.println(result);
    }

    static class Solution {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length = nums1.length + nums2.length;
            int mid = length / 2;
            int left = -1;
            int right = -1;
            int aStart = 0;
            int bStart = 0;
            for (int i = 0; i <= mid; i++) {
                //保存前一个数据
                left = right;

                //right始终取的就是两个数组中最小的那个，
                if (aStart < nums1.length && (bStart >= nums2.length || nums1[aStart] < nums2[bStart])) {
                    right = nums1[aStart];
                    aStart++;
                } else {
                    right = nums2[bStart];
                    bStart++;
                }
            }

            if (length % 2 == 0) {
                return (left + right) / 2.0;
            } else {
                return right;
            }
        }

        /**
         * 其实就是查找两个有序数组的第K个元素，如果K=两个数组长度的一半，那么就是该题目的解
         * 分别从num1和num2中取出第k/2 个元素，如果a<b,则k要么在第一个元素k/2的后半段，要么在第二个数组k/2的前半段
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public double findMedianSortedArrays_1(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            if (m == 0) {
                //那么从num2中取出来中间值即可
                if (n % 2 == 0) {
                    //说明长度是偶数，需要m/2和m/2 -1两个元素的和
                    return (nums2[n / 2] + nums2[n / 2 - 1]) / 2.0;
                } else {
                    return nums2[n / 2];
                }
            }

            if (n == 0) {
                //那么从nums1中取出来中间值即可
                if (m % 2 == 0) {
                    //说明长度是偶数，需要m/2和m/2 -1两个元素的和
                    return (nums1[m / 2] + nums1[m / 2 - 1]) / 2.0;
                } else {
                    return nums1[m / 2];
                }
            }

            int total = n + m;
            if (total % 2 == 1) {
                //总长度是奇数
                return finkth(nums1, 0, nums2, 0, total / 2 + 1);
            }
            //总长度是偶数，就需要得到第K个元素值和第k-1个元素和的一半
            return (finkth(nums1, 0, nums2, 0, total / 2) + finkth(nums1, 0, nums2, 0, total / 2 + 1)) / 2.0;
        }

        //查找数组 a,b中从a_begin ，b_begin开始，第K个数字
        private double finkth(int[] a, int a_begin, int[] b, int b_begin, int k) {
            if (a_begin >= a.length) {
                //直接返回b中 b_begin+k个元素
                return b[b_begin + k - 1];
            }

            if (b_begin >= b.length) {
                return a[a_begin + k - 1];
            }

            if (k == 1) {
                //查找第一个元素，那么就返回数组a b中最小那个
                return Math.min(a[a_begin], b[b_begin]);
            }

            int mid_a = Integer.MAX_VALUE;
            int mid_b = Integer.MAX_VALUE;
            //mid_a 和minB 分别表示数组中第k/2个元素的值
            if (a_begin + k / 2 - 1 < a.length) {
                mid_a = a[a_begin + k / 2 - 1];
            }
            if (b_begin + k / 2 - 1 < b.length) {
                mid_b = b[b_begin + k / 2 - 1];
            }

            if (mid_a < mid_b) {
                return finkth(a, a_begin + k / 2, b, b_begin, k - k / 2);
            }
            return finkth(a, a_begin, b, b_begin + k / 2, k - k / 2);

        }


    }


}
