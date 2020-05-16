package fun.hoyouly;

/**
 * 排序算法
 */
public class Leetcode_sort {
    public static void main(String[] args) {
        Solution test = new Solution();
        int[] arr = new int[]{8, 4, 6, 9, 1, 7, 3};
        System.out.print("元素数据：");
        for (int i : arr) {
            System.out.printf(i + " ");
        }
        System.out.println();
        test.quickSort(arr);
        System.out.print("quickSort 排序之后：");
        for (int i : arr) {
            System.out.printf(i + " ");
        }
    }


    static class Solution {
        public void quickSort(int[] arr) {
            if (arr == null || arr.length == 0) {
                return;
            }
            quickSort(arr, 0, arr.length - 1);
        }

        private void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                //将 low high 一分为二，算出关键字，该值的位置固定，不需要变化
                int pivor = parition(arr, low, high);
                quickSort(arr, low, pivor - 1);
                quickSort(arr, pivor + 1, high);
            }
        }

        private int parition(int[] arr, int low, int high) {
            int key = arr[low];
            //顺序很重要，要先从右边找
            while (low < high) {
                while (low < high && arr[high] >= key) {
                    //从后往前找到比 key 小的放到前面去
                    high--;
                }
                swap(arr, high, low);
                while (low < high && arr[low] <= key) {
                    //从前往后找到比 key 大的 放到后面去
                    low++;
                }
                swap(arr, low, high);
            }
            return low;
        }


        public void mergeSort(int[] arr) {
            if (arr == null || arr.length == 0) {
                return;
            }
            mergeSort(arr, 0, arr.length - 1);
        }

        private void mergeSort(int[] arr, int start, int end) {
            if (start >= end) {
                return;
            }
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }

        private void merge(int[] arr, int start, int mid, int end) {
            //用 left 和 right 分别指向两部分的第一个元素
            int left = start;
            int right = mid + 1;
            //创建一个临时数组
            int[] temp = new int[end - start + 1];
            int index = 0;
            //开始比较大小，
            while (left <= mid && right <= end) {
                //把小的那位放入到临时数组中。
                if (arr[left] > arr[right]) {
                    temp[index++] = arr[right++];
                } else {
                    temp[index++] = arr[left++];
                }
            }
            //将两个数组剩余的数放到temp中
            while (left <= mid) {
                temp[index++] = arr[left++];
            }
            while (right <= end) {
                temp[index++] = arr[right++];
            }
            //将temp数组覆盖原数组
            for (int n = 0; n < end - start; n++) {
                arr[start + n] = temp[n];
            }
        }

        public void selectSort(int[] arr) {
            if (arr == null || arr.length == 0) {
                return;
            }
            int length = arr.length;
            for (int i = 0; i < length; i++) {
                int min = i;//默认的最小值是在i的位置
                //遍历后面的数据，找到比 i 更小的index
                for (int j = i + 1; j < length; j++) {
                    if (arr[j] < arr[min]) {
                        //说明找到更小的 index ，那么min重新赋值为j
                        min = j;
                    }
                }
                swap(arr, i, min);
            }
        }

        public void bubbleSort(int[] arr) {
            if (arr == null || arr.length == 0) {
                return;
            }
            int length = arr.length;
            for (int i = 0; i < length; i++) {
                //是否进行数据交换
                boolean isSwap = false;
                //从 0 个开始，一直到length-i-1的位置，这样内循环一次，就把剩余最大的值放到数组最后
                for (int j = 0; j < length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        //说明前面的数据大于后面的数据，那么就需要交换，
                        swap(arr, j, j + 1);
                        isSwap = true;
                    }
                }
                if (!isSwap) {
                    //没有数据交换，直接退出。
                    break;
                }
            }
        }

        public void insertSort(int[] arr) {
            if (arr == null || arr.length == 0) {
                return;
            }
            //从第二个开始比较
            for (int i = 1; i < arr.length; i++) {
                int value = arr[i];
                int j = i - 1;
                //从末尾开始比较，这样方便移动数据
                for (; j >= 0; j--) {
                    if (arr[j] > value) {
                        //说明未排序区间的值在已排序区间内部
                        //那么就需要移动已排序区间，好腾出来一个位置存放value
                        arr[j + 1] = arr[j];
                    } else {
                        // 找到未排序区间中元素的位置
                        break;
                    }
                    //已经确定 value 要插入的位置，j+1
                    arr[j] = value;
                }
            }
        }


        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
