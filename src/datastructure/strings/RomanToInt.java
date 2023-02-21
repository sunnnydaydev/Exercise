package datastructure.strings;


/**
 * Create by SunnyDay 2023/02/20 20:50:08
 * <p>
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 * <p>
 * 字符          数值
 * <p>
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * 规则：
 * <p>
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class RomanToInt {
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentValue = getNumberByNormalChar(s.charAt(i));
            if (i < s.length() - 1 && currentValue < getNumberByNormalChar(s.charAt(i + 1))) {
                sum -= currentValue;
            } else {
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

    private int getNumberBySpecialChar(String s) {
        int num = 0;
        switch (s) {
            case "IV":
                num = 4;
                break;
            case "IX":
                num = 9;
                break;
            case "XL":
                num = 40;
                break;
            case "XC":
                num = 90;
                break;
            case "CD":
                num = 400;
                break;
            case "CM":
                num = 900;
                break;
        }
        return num;
    }


    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        int result1 = romanToInt.romanToInt("III");
        System.out.println("RomanToInt:" + result1);
        int result2 = romanToInt.romanToInt("IV");
        System.out.println("RomanToInt:" + result2);
        int result3 = romanToInt.romanToInt("IX");
        System.out.println("RomanToInt:" + result3);
        int result4 = romanToInt.romanToInt("LVIII");
        System.out.println("RomanToInt:" + result4);
        int result5 = romanToInt.romanToInt("MCMXCIV");
        System.out.println("RomanToInt:" + result5);
    }
}
