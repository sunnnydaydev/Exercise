package algorithm.exercise;

/**
 * Create by SunnyDay on 2020/11/11 20:23
 * 二分搜索算法：有序数组中查找指定元素。
 */
public class BinarySearch {
    public static void main(String[] args) {
        //test case
        int[] arr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,};
        int[] arr2 = {};
        int[] arr3 = null;

        // 循环 true
        System.out.println(binarySearchLoop(arr1, 5));
        System.out.println(binarySearchLoop(arr1, 0));
        System.out.println(binarySearchLoop(arr1, 8));
        System.out.println(binarySearchLoop(arr1, 9));
        // 循环 false
        System.out.println(binarySearchLoop(arr1, 20));
        System.out.println(binarySearchLoop(arr2, 10));
        System.out.println(binarySearchLoop(arr3, 10));

        //递归
        System.out.println(binarySearchRecursion(arr1, 8, 0, arr1.length - 1));
    }

    /**
     * 1、循环方式
     */
    // 循环写法
    public static boolean binarySearchLoop(int[] array, int target) {
        if (null == array || array.length == 0) {
            return false;
        }
        int startIndex = 0;
        int endIndex = array.length - 1;
        // 特别注意判断条件的边界
        while (startIndex <= endIndex) {//这里少写等于号时，剩余最后两数假如为【0,1】，最终平均数落到1上。target为0时少判断一步循环结束。
            int midIndex = startIndex + ((endIndex - startIndex) >> 1);// 平均数（中间值）避免溢出。优化写法使用位移。
            if (array[midIndex] > target) {
                endIndex = midIndex - 1;
            } else if (array[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 2、递归方式：优点bug，留坑。
     */
    static boolean binarySearchRecursion(int[] array, int target, int startIndex, int endIndex) {
        if (null == array || startIndex > endIndex || 0 == array.length) {//特殊值处理
            return false;
        }
        int midIndex = startIndex + (endIndex - startIndex) / 2;// 可优化
        if (array[midIndex] == target) {
            return true;
        } else if (array[midIndex] > target) {//大于目标值 左边区间查找
            binarySearchRecursion(array, target, startIndex, midIndex - 1);
        } else if (array[midIndex] < target) {//小于目标值 右边区间查找
            binarySearchRecursion(array, target, midIndex + 1, endIndex);
        }

        return false;
    }
}
