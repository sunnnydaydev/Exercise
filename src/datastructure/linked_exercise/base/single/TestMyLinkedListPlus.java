package datastructure.linked_exercise.base.single;

/**
 * Created by sunnyDay on 2020/1/14 15:30
 */
public class TestMyLinkedListPlus {
    public static void main(String[] args) {
        MyLinkedListPlus<Integer> mList = new MyLinkedListPlus<>();
        mList.addFirst(1);
        mList.addFirst(0);
        mList.add(0, 100);
        mList.addLast(100);
        mList.removeE(100);
        System.out.println(mList);


    }
}
