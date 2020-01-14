package datastructure.linked_exercise.base;

/**
 * Created by sunnyDay on 2020/1/14 15:30
 */
public class TestMyLinkedListPlus {
    public static void main(String[] args) {
        MyLinkedListPlus<Integer> mList = new MyLinkedListPlus<>();
        mList.addFirst(2);
        mList.addFirst(1);
        mList.addFirst(0);

        mList.addLast(3);
        mList.addLast(4);

        mList.add(0, 100);
        mList.add(6, 100);
        //mList.add(8,200); // error  index is out of bounds
        System.out.println(mList);
    }
}
