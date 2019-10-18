package com.example.enums;

/**
 * @program: realtour-r8-qj-b2b
 * @description:
 * @author: chenYanXin
 * @create: 2018/9/4 11:45
 */
public enum Color {
    /**
     * colors 重写toString后可以直接当常量使用
     */
    RED("red", "1"),
    BLUE("blue", "2"),
    GREEN("green", "3");

    Color(String type, String address) {
        this.type = type;
        this.address = address;
    }

    private String type;
    private String address;

    public String getType() {
        return type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static String getAddress(String type) {
        for (Color c : Color.values()) {
            if (c.getType().equals(type)) {
                return c.address;
            }
        }
        return null;
    }

    public String getAddress() {
        return address;
    }
}
