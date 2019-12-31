package datastructure.array_exercise;

import java.util.Arrays;

/**
 * Created by sunnyDay on 2019/12/23 19:37
 */
public class ArrayTestMain {
    public static void main(String[] args) {
        try {
            // 测试
            CommonIntList commonIntList = new CommonIntList();
            commonIntList.addLast(1);
            commonIntList.addLast(2);
            commonIntList.add(0,0);
            commonIntList.add(10, 3);
            commonIntList.add(10, 4);
            System.out.println(commonIntList.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
