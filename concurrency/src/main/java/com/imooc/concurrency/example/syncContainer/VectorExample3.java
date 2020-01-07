package com.imooc.concurrency.example.syncContainer;

import com.imooc.concurrency.annotations.NotThreadSafe;

import java.util.Iterator;
import java.util.Vector;

public class VectorExample3 {

    /**
     * 在遍历的过程中 不做更新，只做标记
     * 在遍历完成后统一做更新
     * 或
     * 使用 for 循环
     */

    //java.util.ConcurrentModificationException
    public static void test1(Vector<Integer> v1) { //foreach
        for (Integer integer : v1) {
            if (integer.equals(3)){
                v1.remove(integer);
            }
        }
    }

    //java.util.ConcurrentModificationException
    public static void test2(Vector<Integer> v1) {//iterator
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (next.equals(3)){
                v1.remove(next);
            }
        }
    }

    //success
    public static void test3(Vector<Integer> v1) { //for
        for (int i = 0;i < v1.size();i++){
            if (v1.get(i).equals(3)){
                v1.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test1(vector);
    }

}
