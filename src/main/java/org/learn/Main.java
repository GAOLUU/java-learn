package org.learn;

import java.util.HashMap;

/**
 * @author : gaoluu
 * @date : Created in 9:42 上午 2020/12/9
 */

public class Main {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(null, "123");
        map.put(null, "456");
        System.out.println(map.get(null));
    }
}
