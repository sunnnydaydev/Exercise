package algorithm.exercise;

/**
 * Create by SunnyDay on 2020/11/12 21:13
 */
public class MiddleNumber {
    public static void main(String[] args) {
        System.out.println(getMiddleNumber(1, 5));
    }

    /**
     * 适合：两数平均值计算、数组线段中间索引计算。
     * 1、做减法
     * 2、位移运算
     * */
    public static int getMiddleNumber(int num1, int num2) {
        return num1 + ((num2 - num1) >> 1);
    }
}
