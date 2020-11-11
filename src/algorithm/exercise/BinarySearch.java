package algorithm.exercise;

/**
 * Create by SunnyDay on 2020/11/11 20:23
 * 二分搜索算法：有序数组中查找指定元素。
 */
public class BinarySearch {
    public static void main(String[] args) {
        // test case
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr1 = {};
        int[] arr2 = null;
        System.out.println("循环：");
        System.out.println(binarySearchLoop(arr, 2)); // true
        System.out.println(binarySearchLoop(arr1, 10));//false
        System.out.println(binarySearchLoop(arr2, 10));//false
        System.out.println("递归：");
        System.out.println(binarySearchRecursion(arr, 1, 0, arr.length - 1)); // true
    }

    /**
     * 循环方式：二分查找
     */
    static boolean binarySearchLoop(int[] array, int target) {
        if (null == array || 0 == array.length) {//特殊值处理
            return false;
        }
        int startIndex = 0;//边界起始位置
        int endIndex = array.length - 1;//边界结束位置

        while (startIndex < endIndex) {//二分区间，区间边界值相等时区间就查找完毕了。
            int midIndex = startIndex + (endIndex - startIndex) / 2;// 平均数（中间位置）的优化写法
            if (array[midIndex] > target) {
                endIndex = midIndex - 1;//左区间查找
            } else if (array[midIndex] < target) {
                startIndex = midIndex + 1;//右区间查找
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 递归方式：留个坑
     */
    static boolean binarySearchRecursion(int[] array, int target, int startIndex, int endIndex) {
        if (null == array || startIndex > endIndex || 0 == array.length) {//特殊值处理
            return false;
        }
        if (startIndex < endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (array[midIndex] > target) {//大于目标值 左边区间查找
                binarySearchRecursion(array, target, startIndex, midIndex - 1);
            } else if (array[midIndex] < target) {//小于目标值 右边区间查找
                binarySearchRecursion(array, target, midIndex + 1, endIndex);
            } else {
                return true;
            }
        }
        return false;
    }
}
