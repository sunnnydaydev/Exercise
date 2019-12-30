package datastructure.array_exercise;

/**
 * Created by sunnyDay on 2019/12/23 20:33
 * <p>
 * 简单的集合封装：存int类型
 */
public class CommonIntList {
    private int size;
    private int[] arr;  // 本集合底层使用的数据结构

    public CommonIntList(int capacity) {
        arr = new int[capacity];
    }

    public CommonIntList() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    /**
     * 添加到尾部
     */
    public void addLast(int number) throws IllegalAccessException {
        if (getSize() == arr.length) {
            throw new IllegalAccessException("add last element fail,list is full");
        }
        arr[size] = number;
        size++;
    }

    /**
     * 指定位置添加元素（添加中间）
     * */
    public void add(int number, int index) {

    }
}
