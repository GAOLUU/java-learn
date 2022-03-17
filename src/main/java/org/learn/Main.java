package org.learn;

import java.util.Random;

/**
 * @author : gaoluu
 * @date : Created in 9:42 上午 2020/12/9
 */

public class Main {

    public static void main(String[] args) {
        String a = "a";
        System.out.println(a.hashCode());

        String arg0 = args[0].intern();
        System.out.println(arg0);
        System.out.println(arg0.hashCode());
        String arg1 = args[1];
        System.out.println(arg1);
        System.out.println(arg1.hashCode());

        System.out.println(arg0 == a);
        System.out.println(arg0 == arg1);

        System.out.println(1);
    }

    private void testString() {
        for (int i = 1; ; i++) {
            String s = new Random().nextBoolean() ? "true" + i : "false" + i;
            System.out.println(s);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
