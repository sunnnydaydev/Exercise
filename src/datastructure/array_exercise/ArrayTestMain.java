package datastructure.array_exercise;

/**
 * Created by sunnyDay on 2019/12/23 19:37
 */
public class ArrayTestMain {
    public static void main(String[] args) {
        try {
            // 测试
            CommonIntListPlus commonIntListPlus = new CommonIntListPlus();
            commonIntListPlus.addLast(1);
            commonIntListPlus.addLast(2);
            commonIntListPlus.add(0, 0);
            commonIntListPlus.add(10, 3);
            commonIntListPlus.add(10, 4);
            commonIntListPlus.add(10, 5);
            System.out.println(commonIntListPlus.toString());
            System.out.println("查找索引为1的元素：" + commonIntListPlus.findElementByIndex(1));
            System.out.println("查找元素为10的索引：" + commonIntListPlus.findIndexByElement(10));
            commonIntListPlus.modifyElementByIndex(5, 100);
            System.out.println("修改后：" + commonIntListPlus.toString());
            commonIntListPlus.removeElement(6);
            System.out.println("删除后：" + commonIntListPlus.toString());
            // 简单修改
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
