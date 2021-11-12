package org.learn.collection.map;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @author : gaoluu
 * @date : Created in 9:41 上午 2021/2/22
 */

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put("key1", "value1");
        linkedHashMap.put("key2", "value2");
        linkedHashMap.put("key3", "value2");
        linkedHashMap.put("key4", "value2");
        linkedHashMap.put("5key5", "value2");
        linkedHashMap.put("6key6", "value2");

        linkedHashMap.forEach((k, v) -> System.out.println(k));
//        System.out.println(linkedHashMap.get("key4"));
        Set<String> keySet = linkedHashMap.keySet();

    }

}

