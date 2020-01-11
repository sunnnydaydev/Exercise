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
        while (head != null) {
            sb.append(head.e);
            if (head.next != null) {
                sb.append(",");
            }
            head = head.next;
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
            while (head != null) {
                head = head.next;
            }
            head = new Node(e, null);
        }

    }

    /**
     * 任意有效位置处添加元素
     *
     * @param index 要添加的位置
     * @param e     要添加的元素
     */
    public void add(int index, E e) {

    }

}
