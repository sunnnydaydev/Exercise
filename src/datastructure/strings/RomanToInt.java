package datastructure.strings;


import java.util.HashMap;
import java.util.Map;

/**
 * Create by SunnyDay 2023/02/20 20:50:08
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 规则：
 * 一般来说小数字符号都在大数字符号右面如6 VI 、7VII，也有特殊的小数字在大数字左面表示特殊数字，特殊数字有如下六种：
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 收获：简单的映射关系，写个方法比使用map要快点、节约内存。
 **/
public class RomanToInt {
    /**
     * 官方思路：
     * 先找规律，我们发现若全是正规的字符就好搞了，依次累加每个字符代表的整数值即可。但是有一些特殊字符还是有规律的，如：
     * 9->IX 就相当于X-I，5->IV 就相当于V-I 这样我们就发现规律了"当前字符比下一个字符小时当前字符数值取负即可"这个
     * 规律是建立在下一个字符存在情况下，这点细节需要注意。
     */
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentValue = getNumberByNormalChar(s.charAt(i));
            if (i < s.length() - 1 && currentValue < getNumberByNormalChar(s.charAt(i + 1))) {
                sum -= currentValue;
            } else {
                /**
                 *1、最后一个字符单独计算即可。 因为循环只能循环到i < s.length() - 1，这样能够保证 i+1不会数组越界。
                 *2、currentValue>nextValue case 为正常情况直接累加即可。
                 */
                sum += currentValue;
            }
        }
        return sum;
    }

    /**
     * 单个字符与数字的对应关系
     */
    private int getNumberByNormalChar(char c) {
        int num = 0;
        switch (c) {
            case 'I':
                num = 1;
                break;
            case 'V':
                num = 5;
                break;
            case 'X':
                num = 10;
                break;
            case 'L':
                num = 50;
                break;
            case 'C':
                num = 100;
                break;
            case 'D':
                num = 500;
                break;
            case 'M':
                num = 1000;
                break;
        }
        return num;
    }


    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        int result1 = romanToInt.secondPractice("III");
        System.out.println("RomanToInt:" + result1);
        int result2 = romanToInt.secondPractice("IV");
        System.out.println("RomanToInt:" + result2);
        int result3 = romanToInt.secondPractice("IX");
        System.out.println("RomanToInt:" + result3);
        int result4 = romanToInt.secondPractice("LVIII");
        System.out.println("RomanToInt:" + result4);
        int result5 = romanToInt.secondPractice("MCMXCIV");
        System.out.println("RomanToInt:" + result5);


    }

    public int secondPractice(String s){
        //这个map 比自己写的方法映射慢了两毫秒
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentValue = map.get(s.charAt(i));
            if (i<s.length()-1&&currentValue<map.get(s.charAt(i+1))){
               sum-=map.get(s.charAt(i));
            }else { // 常规字符、最后一个字符
                sum+=map.get(s.charAt(i));
            }
        }

        return sum;
    }
}
