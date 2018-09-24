package com.example.json;

/**
 * FieldConvertEnum  ERP对接字段转换枚举
 * realtour
 *
 * @author :        ChenYanxin
 * @date :          2018/9/24 20:12
 */
public enum FieldConvertEnum {
    /**
     * name 为erp json字段名，convertName b2b字段名
     */
    ID("ids", "id"),
    NAME("names", "name");

    private String name;
    private String convertName;

    FieldConvertEnum(String name, String convertName) {
        this.name = name;
        this.convertName = convertName;
    }

    public static FieldConvertEnum getInstance(String name) {
        for (FieldConvertEnum c : FieldConvertEnum.values()) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getConvertName() {
        return convertName;
    }
}
