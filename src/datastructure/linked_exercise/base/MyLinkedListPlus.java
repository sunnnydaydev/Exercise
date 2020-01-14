package datastructure.linked_exercise.base;

/**
 * Created by sunnyDay on 2020/1/14 14:23
 * <p>
 * 含有虚拟头结点的链表
 */
public class MyLinkedListPlus<E> {
    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private int size;
    private Node dummyHead;

    public int getSize() {
        return size;
    }

    public MyLinkedListPlus() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * @param index 要插入位置的索引
     * @param e     要插入的元素
     * @function添加元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        Node preNode = dummyHead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        /**
         完整写法：
         Node newNode = new Node(); // 创建新节点
         newNode.e = e;// 节点赋值
         newNode.next = preNode.next; // 节点指针指向
         preNode.next = newNode; // 上一节指针指向
         */
        preNode.next = new Node(e, preNode.next);// 优化写法
        size++;
    }

    /**
     * 添加首部：直接复用
     *
     * @param e 要添加的元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 添加尾部：直接复用
     *
     * @param e 要添加的元素
     */
    public void addLast(E e) {
        add(size, e);
    }


    /**
     * toString重写：链表的遍历
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node tempNode = dummyHead.next;
        while (tempNode != null) {
            sb.append(tempNode.e);
            if (tempNode.next != null) {
                sb.append(",");
            }
            tempNode = tempNode.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 删除指定索引元素
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        Node preNode = dummyHead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        Node deleteNode = preNode.next; // 1、创建要删除节点的副本 （记录要删除的节点）
        preNode.next = deleteNode.next; // 2、修改指针，使要删除节点的上一节点的指针，指向要删除节点的下一位置。
        deleteNode.next = null;         // 3、要删除的节点指针域置空
        size--; // 调整集合大小
        return deleteNode.e;
    }


    /**
     * 删除任意元素
     *
     * @param e ps:设计有弊端，本方法只删除首次碰到的元素。也就是第一次出现的。
     */
    public void removeE(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }
        //要删除的元素非空时
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }

}
