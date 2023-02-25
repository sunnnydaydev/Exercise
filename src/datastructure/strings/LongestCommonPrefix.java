package datastructure.strings;

/**
 * Create by SunnyDay 2023/02/23 20:50:46
 * 最长公共前缀
 * https://leetcode.cn/problems/longest-common-prefix/
 *
 * 收获：要学会问题的分解。和一串数字中找最大数最小数的思想是一致的。假定第一个元素为最值，然后依次遍历所有的元素，遍历过程中进行对比即可
 * 这样遍历完一圈所有的元素也就比了一遍了。
 **/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        String[] test1 = new String[]{"flower","flow","flight"};
        String[] test2 = new String[]{"dog","racecar","car"};
        String[] test3 = new String[]{"car","cir"};

        System.out.println("test1:"+longestCommonPrefix.longestCommonPrefix(test1));
        System.out.println("test2:"+longestCommonPrefix.longestCommonPrefix(test2));
        System.out.println("test3:"+longestCommonPrefix.longestCommonPrefix(test3));

    }
    public String longestCommonPrefix(String[] strs) {
// 没必要，官方提示 数组长度最小为1
//        if (strs == null || strs.length == 0) {
//            return result;
//        }
        String currentPrefix = strs[0];
        for (String str : strs) {
            currentPrefix = getCommonPrefix(currentPrefix, str);
            if (currentPrefix.equals("")) break;
        }
        return currentPrefix;
    }

    /**
     * 获取两个字符串的公共前缀。
     * 按照题意要求，每个字符串的长度最小为0，因此这里我们不再进行空值处理了。
     */
    public String getCommonPrefix1(String s1, String s2) {
        int min = Math.min(s1.length(), s2.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < min; i++) {
            if (s1.charAt(i) == s2.charAt(i)) { // 不能这样写，这样会出现 cir car   ->  cr 的结果
                sb.append(s1.charAt(i));
            }
        }
        return sb.toString();
    }

    public String getCommonPrefix(String s1, String s2) {
        int min = Math.min(s1.length(), s2.length());
        int index = 0;
        // 官方使用的是while 道理一致。
        for (int i = 0; i < min; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                index++; // 注意这里不要使用i
            }else{
                break;
            }
        }
        return s1.substring(0,index);
    }
}
