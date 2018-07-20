package com.example.enums;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * Created by       Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date     :       2018/7/20
 * Time     :       17:13
 * Version  :       1.0
 * Company  :       北京太比雅科技(武汉研发中心)
 * EnumsTest
 */
public class EnumsTest {

    public static void main(String[] args) {

        // 1.遍历枚举类型

//        System.out.println("演示枚举类型的遍历 ......");

//        testTraversalEnum();

        // 2.演示EnumMap对象的使用

//        System.out.println("演示EnmuMap对象的使用和遍历.....");

//        testEnumMap();

        // 3.演示EnmuSet的使用

        System.out.println("演示EnmuSet对象的使用和遍历.....");

        testEnumSet();

    }

    /**
     *
     * 演示枚举类型的遍历
     */

    private static void testTraversalEnum() {

        Light[] allLight = Light.values();

        for (Light aLight : allLight) {

            System.out.println("当前灯name：" + aLight.name());

            System.out.println("当前灯ordinal：" + aLight.ordinal());

            System.out.println("当前灯：" + aLight);

        }

    }

    /**
     *
     * 演示EnumMap的使用，EnumMap跟HashMap的使用差不多，只不过key要是枚举类型
     */

    private static void testEnumMap() {

        // 1.演示定义EnumMap对象，EnumMap对象的构造函数需要参数传入,默认是key的类的类型

        EnumMap<Light, String> currEnumMap = new EnumMap<Light, String>(

                Light.class);

        currEnumMap.put(Light.RED, "红灯");

        currEnumMap.put(Light.GREEN, "绿灯");

        currEnumMap.put(Light.YELLOW, "黄灯");

        // 2.遍历对象

        for (Light aLight : Light.values()) {

            System.out.println("[key=" + aLight.name() + ",value="

                    + currEnumMap.get(aLight) + "]");

        }

    }

    /**
     *
     * 演示EnumSet如何使用，EnumSet是一个抽象类，获取一个类型的枚举类型内容<BR/>
     *
     * 可以使用allOf方法
     */

    private static void testEnumSet() {

        EnumSet<Light> currEnumSet = EnumSet.allOf(Light.class);

        for (Light aLightSetElement : currEnumSet) {

            System.out.println("当前EnumSet中数据为：" + aLightSetElement);

        }

    }
}
