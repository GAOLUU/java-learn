package org.learn.collection.map;

import java.util.HashMap;

/**
 * @author : gaoluu
 * @date : Created in 10:49 上午 2020/12/9
 */

public class HashMapDemo {

    public static void main(String[] args) {
        Short shorts = Short.valueOf((short) 1);
        Integer integer = Integer.valueOf(1);
        HashMap<Object, Object> map = new HashMap<>();
        map.put(shorts, "1");
        map.put(integer, "2");
        System.out.println(map.size());
    }



}
