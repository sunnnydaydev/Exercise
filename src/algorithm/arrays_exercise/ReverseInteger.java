package algorithm.arrays_exercise;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by sunnyDay on 2020/1/8 17:07
 * <p>
 * 给定一个32位带符号整数，整数的反向数字。
 * <p>
 * 范例1：
 * <p>
 * 输入： 123
 * 输出： 321
 * 范例2：
 * <p>
 * 输入： -123
 * 输出： -321
 * 范例3：
 * <p>
 * 输入： 120
 * 输出： 21
 * 注意：
 * 假设我们正在处理这只能在32位带符号整数的范围内存储整数的环境：[-2 31 2 31  - 1] 出于此问题的目的，假定反向整数溢出时函数返回0。
 */
public class ReverseInteger {
    public static int reverse(int x) {
        if (x < Integer.MIN_VALUE || x > Integer.MAX_VALUE) {
            return 0;
        }
        String string = Integer.toString(x);
        char[] chars = new char[string.length()];

        Stack<Character> characterStack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            characterStack.push(string.charAt(i));
        }
        for (int i = 0; i < string.length(); i++) {
            if (characterStack.peek() != 0) {
                chars[i] = characterStack.pop();
            } else {
                characterStack.pop();
            }
        }

      

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("（2的31次方）1左移31：" + (1 << 31));
        System.out.println("整形最大值：" + Integer.MAX_VALUE); // 整形最大值:2147483647  2的31次方
        System.out.println("整形最小值：" + Integer.MIN_VALUE); // 整形最小值 -2^31+1
    }
}
