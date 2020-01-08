package datastructure.array_exercise;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by sunnyDay on 2020/1/8 14:31
 * 基于数组封装的集合
 */
public class SimpleArrayList<E> implements Serializable {
    /**
     * 序列化使用的这里不必关注详情参考：
     * https://blog.csdn.net/qq_38350635/article/details/88925390
     */
    private static final long serialVersionUID = 1L;


    /**
     * 默认的动态数组的容量 10
     */
    private static final int DEFAULT_CAPACITY = 10;


    /**
     * 容量为0的空数组
     */
    private static final Object[] EMPTY_ELEMENT_DATA = {};


    /**
     * 默认容量的空数组
     */
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};

    /**
     * 能够申请数组的最大空间
     * 一些虚拟机在数组中保留了一些字段，尝试请求分配最大容量的数组可能会导致OOM
     */
    private static int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    /**
     * 使用Object数组作为本集合的底层数据结构
     */

    private Object[] data;
    /**
     * 集合大小
     */
    private int size; // 数组容量

    /**
     * @param capacity 集合容量
     * @function 初始化集合容量。 满足条件：capacity >=0；否则抛出异常。
     */
    public SimpleArrayList(int capacity) {
        if (capacity > 0) {
            this.data = new Object[capacity];
        } else if (capacity == 0) {
            this.data = EMPTY_ELEMENT_DATA; // 用户传递的 capacity为0时
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }

    }

    /**
     * @function 声明一个默认的、容量为0的空数组
     */
    public SimpleArrayList() {
        this.data = DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
    }


    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param e 要添加的元素
     * @function 添加元素到数组末尾
     */
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        data[size++] = e; // 吧元素添加到集合的末尾，集合大小+1
        return true;
    }

    /**
     * 指定位置添加元素
     */
    public void add(int index, E e) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacityInternal(size + 1);
        // 吧老数组 拷贝到扩容好的新数组中，由于grow方法扩容后吧数组对象又赋值给了data，所以这里只需把 data的 index 位置开始往后的元素，复制到data，的index+1位置开始
        // 复制的长度为 size - index
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
    }

    /**
     * @deprecated
     */
    public void remove() {
        // todo 动态数组的核心扩容，已经搞完。而且也添加了 add方法实战。
        //  删除几乎和添加类似。还有查找就更简单啦。 在CommonIntList中已经实现过
        // 这里就不在写啦！
    }


    /**
     * 确保内部的初始容量
     *
     * @param minCapacity 最小容量
     */
    private void ensureCapacityInternal(int minCapacity) {
        // 用户直接new 无参的构造时
        if (data == DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA) {
            // 给最小容量重新赋值（取二者的最大值）
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        // 可见无论集合是否为null， 这里传入的minCapacity值都是数组的size+1
        ensureExplicitCapacity(minCapacity);
    }

    /**
     * 确保最终的容量，也就是内部的if判断，容量不足，动态的扩容。
     */
    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - data.length > 0) {
            grow(minCapacity);
        }
    }

    /**
     * 扩容:
     */
    private void grow(int minCapacity) {
        int oldCapacity = data.length;
        // 这里使用到了右移运算符，oldCapacity >> 1 代表  oldCapacity 除以 2的1次方（右移n 就代表除以2的n次方）
        int newCapacity = oldCapacity + (oldCapacity >> 1);// 新的容量为 oldCapacity+oldCapacity/2

        // 感觉 普通情况下 这个不会走（集合大小+集合大小一半 肯定大于集合大小+1）
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        // 感觉这个一般情况下也不会触发
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        // 扩容
        data = Arrays.copyOf(data, newCapacity); // 吧数组拷贝到更大的数组中（底层是System.arraycopy方法 为native方法）
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }


}
