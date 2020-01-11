package datastructure.linked_exercise.base;

/**
 * Created by sunnyDay on 2020/1/11 14:50
 */
public class Test1 {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
//        list.addFirst(1);
//        list.addFirst(2);

          list.addLast(1);
          list.addLast(2);
          list.addLast(3);
          list.addLast(4);

        System.out.println(list.toString());
    }
}
