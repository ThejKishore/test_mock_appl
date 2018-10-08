package com.kish.desig.demoset;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class QuickTest {


    @Test
    public void quickTest(){
        Collection c = Arrays.asList(1,2,3,4,5,6,7,8,1,2,3,4,5,6,7,8,1,2,3,4,5,6,7,8);
        val data = Math.max((int) (c.size() / .75f) + 1,16);

        System.out.println(data);
        // hash map
//        System.out.println(MINIMUM_CAPACITY);

        System.out.println(tableSizeFor(6));

        int n =0;
        System.out.println( (n |=6 >>> 2));
        System.out.println( (n |=6 >>> 4));
        System.out.println( (n |=6 >>> 8));
        System.out.println( (n |=6 >>> 16));

//        HashSet<String> data1 = new HashSet<>();
//        data1.retainAll(null);

        System.out.println(MAXIMUM_CAPACITY);
        System.out.println((long)Math.abs(Math.pow(2.0,30.0)));
        int v;
        System.out.println(hash("Hello")+"   "+ ((v="Hello".hashCode()) ^ (v >>> 16)));
        System.out.println(hash("Hello"));

    }
    final int MAXIMUM_CAPACITY = 1 << 30; // 2 power 30  //1,073,741,824
    final int MINIMUM_CAPACITY = 1 << 4; // 2 power 4

    final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
