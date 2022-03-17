package org.learn.serial;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.File;
import java.io.Serializable;

/**
 * @author : gaoluu
 * @date : Created in 6:21 下午 2022/3/17
 */

public class SerializedDemo {

    @Data
    static class ClassA implements Serializable {
        private ClassB classB;
    }

    @Data
    static class ClassB implements Serializable {
        private ClassA classA;
    }

    public static void main(String[] args) {

        File file = new File("/Users/gaoluu/my.txt");

        ClassA classA = new ClassA();
        ClassB classB = new ClassB();
        classA.setClassB(classB);
        classB.setClassA(classA);

//        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));) {
//            outputStream.writeObject(classA);
//            outputStream.writeObject(classB);
//        } catch (IOException e) {
//
//        }

        System.out.println(JSONObject.toJSONString(classA));

    }

}
