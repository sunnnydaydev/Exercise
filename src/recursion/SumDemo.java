package recursion;

/**
 * Created by sunnyDay on 2020/1/17 17:36
 * 使用递归进行求和练习
 */
public class SumDemo {
    public static void main(String[] args) {
        commonSum(new int[]{1, 2, 3, 4, 5, 6});

    }

    /**
     * 普通的循环栗子
     */
    private static int commonSum(int arr[]) {
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        System.out.println("和：" + sum);
        return sum;
    }

    /**
     * @param arr   目标数组
     * @param depth 区间深度
     */
    private static int recursionSum(int arr[], int depth) {
        if (depth == arr.length) {
            return 0;
        }
        int result = arr[depth] + recursionSum(arr, depth + 1);
        return result;
    }

}
