package datastructure.array_exercise;

import java.util.Arrays;

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
        if (size == arr.length) {
            throw new IllegalAccessException("add last element fail,list is full");
        }
        arr[size] = number;
        size++;
    }

    /**
     * 指定位置添加元素（添加中间）
     * 1、判满处理
     * 2、插入位置的合法性判断
     * 3、循环挪位置
     * 4、空位置添加元素
     */
    public void add(int number, int index) throws IllegalAccessException {
        checkListIsFull();
        checkInsertPositionIsIllegal(index);
        // 挪移元素，自后向前挪移元素。自后向前挪移元素。自后向前挪移元素。
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = number;
        size++;
    }

    //   添加到首部
    public void addFirst(int number) throws IllegalAccessException {
        checkListIsFull();
        // 循环挪动元素
        for (int i = size - 1; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = number;
        size++;
    }

    /**
     * 数组判满处理
     */
    private void checkListIsFull() throws IllegalAccessException {
        if (size == arr.length) {//当size 为arr.length时 数组已经满，不能在插入。
            throw new IllegalAccessException("add element fail,list is full");
        }
    }

    /**
     * 检测插入位置的合法性
     */
    private void checkInsertPositionIsIllegal(int index) throws IllegalAccessException {
        // 1、上面判断了size==arr.length的状况，要想插入元素位置合法，能够插入元素，size<arr.length即可
        // 2、最不理想的状况就是还能插入一个元素，此时size=arr.length -1
        // 3、这时index==size时就是插入末尾（size代表当前有效元素下一位的索引）
        // 4、当index>size就是插入位置不合法了，超出了数组的界限。
        if (index < 0 || index > size) { // size 代表当前有效元素的下一位置
            throw new IllegalAccessException("add element fail，insert position is Illegal");
        }
    }

    /**
     * 输出数组有效元素
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "申请数组大小：" + arr.length + "\n实际大小：" + size;
        } else {
            StringBuffer sb = new StringBuffer();
            sb.append("申请数组大小：").append(arr.length).append("\n实际大小：").append(size).append("\n遍历结果：");
            sb.append("[");
            for (int i = 0; i <= size - 1; i++) {
                sb.append(arr[i]);
                if (i != size - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
