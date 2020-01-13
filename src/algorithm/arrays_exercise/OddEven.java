package algorithm.arrays_exercise;

/**
 * Created by sunnyDay on 2020/1/13 10:37
 * <p>
 * 问题：判断一个数是否为奇数
 * ps：三种写法（程序员：初级(小明)、中级（小华）、高级（Tom））
 */
public class OddEven {
    public static void main(String[] args) {
        System.out.println("判断8是否为奇数小明：" + ming(8));
        System.out.println("判断9是否为奇数小明：" + ming(9));
        /**
         * false
         * 算法写的有欠缺，考虑不全，整数取值范围[Integer.MIN_VALUE,Integer.MAX_VALUE]
         * 当取负数时导致结果判断失误，所以 number%2==1  适合数字为正数的那一半[1,Integer.MAX_VALUE]判断。
         * 正确判断方式  number%2==0
         *
         * */
        System.out.println("判断-3是否为奇数小明：" + ming(-3));


        System.out.println("判断8是否为奇数小华：" + hua(8));
        System.out.println("判断9是否为奇数小华：" + hua(9));
        System.out.println("判断-3是否为奇数小华：" + hua(-3));

        System.out.println("判断8是否为奇数Tom：" + Tom(8));
        System.out.println("判断9是否为奇数Tom：" + Tom(9));
        System.out.println("判断-3是否为奇数Tom：" + Tom(-3));
    }

    /**
     * 初级工程师：小明
     */
    public static boolean ming(int number) {
        return number % 2 == 1;
    }

    /**
     * 中级工程师：小华
     */
    public static boolean hua(int number) {
        return number % 2 != 0;
    }

    /**
     * 高级工程师：Tom
     *
     * 任何数字都可以用二进制表示为：   2^n + ... + 2^0 的形式。
     * 例如：8的二进制 1000
     *      5的二进制 101
     *
     *      奇数的末尾为1，偶数的结尾为0， 则拿number与1按位（&：相同为1，不同为0）计算即可
     */
    public static boolean Tom(int number) {
        return (number & 1) != 0;
    }

}
