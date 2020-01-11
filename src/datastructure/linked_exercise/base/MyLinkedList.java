package datastructure.linked_exercise.base;

/**
 * Created by sunnyDay on 2020/1/10 19:31
 */
public class MyLinkedList<E> {
    private Node head;
    private int size;

    private class Node {
        private E e;
        private Node next;

        Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public int getSize() {
        return size;
    }

    /**
     * 重写toString，遍历输出集合数据.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node node = head;
        while (node != null) {
            sb.append(node.e);
            if (node.next != null) {
                sb.append(",");
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 添加元素到链表的首部
     *
     * @param e 要添加的元素
     */
    public void addFirst(E e) {
        Node node = new Node(); // 1、创建节点
        node.e = e;//2、节点数据域赋值赋值
        node.next = head; // 此处赋值需要留意下
        head = node;// 3、更改头结点
        size++;
    }

    /**
     * 添加元素到尾部
     *
     * @param e 要添加的元素
     */
    public void addLast(E e) {
        // 思路：循环遍历链表，加到尾部即可
        if (size == 0) { // head ==null 也行
            addFirst(e); // 代码复用
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(e, null);
            size++;
        }
    }

    /**
     * 任意有效位置处添加元素
     *
     * @param index 要添加的位置
     * @param e     要添加的元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) { // 数值可以为size的，因为为size使相当于插入末尾
            throw new IndexOutOfBoundsException("index outOf bounds ");
        }
        if (size == 0) {//空集合时特殊处理
            addFirst(e);
        } else {
            Node preNode = head; // head 节点的副本
            for (int i = 0; i < index - 1; i++) { // 从头遍历到要插入节点的上一节点
                preNode = preNode.next;
            }

            /** 完整写法：
             *  Node node = new Node();
                node.e = e;
                node.next = preNode.next;
                preNode.next = node;
             */
            preNode.next = new Node(e, preNode.next); // 优化写法
            size++;
        }
    }

}
