package datastructure.array_exercise;

/**
 * Created by sunnyDay on 2019/12/31 14:32
 * 普通Int集合的优化写法
 */
public class CommonIntListPlus extends CommonIntList {
    /**
     * addFirst优化：添加头部其实只是添加的特例，只是添加的索引为0
     */
    @Override
    public void addFirst(int number) throws IllegalAccessException {
        super.add(number, 0);
    }

    /**
     * addLast优化：添加尾部也是添加的特例只是添加的索引为size
     */
    @Override
    public void addLast(int number) throws IllegalAccessException {
        super.add(number, getSize());
    }

    /**
     * add的for循环优化，使用编译器推荐写法System 的 array copy 方法
     */
    @Override
    public void add(int number, int index) throws IllegalAccessException {
        checkListIsFull();
        checkInsertPositionIsIllegal(index);
        /**
         *      数组拷贝:
         *       @param      src      the source array.（源数组）
         *       @param      srcPos   starting position in the source array.（源数组拷贝的起始位置）
         *       @param      dest     the destination array.（目的数组）
         *       @param      destPos  starting position in the destination data.（目的数组的起始位置）
         *       @param      length   the number of array elements to be copied.（源数组要拷贝的长度）
         *  */
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = number;
        size++;
    }

}
