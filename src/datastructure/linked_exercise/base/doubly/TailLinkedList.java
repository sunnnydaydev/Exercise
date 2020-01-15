package datastructure.linked_exercise.base.doubly;

/**
 * Created by sunnyDay on 2020/1/14 18:06
 * 带尾结点链表
 */
public class TailLinkedList<E> {
    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node head) {
            this.e = e;
            this.next = head;

        }

        public Node() {
            this(null, null);
        }
    }

    private Node head;
    private Node last;
    private int size;


    /**
     * @param index 要插入的位置
     * @param e     要插入的元素
     * @function 元素的插入
     */
    public void insert(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        Node node = new Node(e, null);
        if (size == 0) { // 1、链表为空
            head = last = node;
        } else if (index == 0) { //2、 插入首部
            node.next = head;
            head = node;
        } else if (index == size) { //3、 插入尾部
            last.next = node;
            last = node;
        } else { // 4、插入中间
            Node preNode = get(index - 1);
            node.next = preNode.next;
            preNode.next = node;
        }
        size++;
    }


    /**
     * @param index 要删除的索引
     */
    public E remove(int index) {
        Node node = null;
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        if (index == 0) {//删除头
            node = head;
            head = node.next;
        }
        if (index == size) {// 删除尾部
            node = get(size - 1);// 先驱节点
            Node deleteNode = node.next;
            node.next = null;
            last = node;
        } else {// 删除中间
            node = get(index - 1);
            Node nextNode = node.next.next;
            Node deleteNode = node.next;
            node.next = nextNode;
        }
        size--;
        return node.e;
    }

    /**
     * 查找指定的节点
     */
    private Node get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }


    /**
     * 遍历
     */
    @Override
    public String toString() {
        //  遍历输出链表即可
        return super.toString();
    }
}
