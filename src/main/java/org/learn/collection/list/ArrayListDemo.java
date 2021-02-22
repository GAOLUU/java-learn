package org.learn.collection.list;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * @author : gaoluu
 * @date : Created in 10:13 上午 2020/12/9
 */

public class ArrayListDemo {

    public static void main(String[] args) {
        List<String> arrayList = Lists.newArrayList("1", "2", "4", "5");
        for (String s : arrayList) {
            arrayList.remove(s);
        }
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
        }
        System.out.println(arrayList);
    }

}
