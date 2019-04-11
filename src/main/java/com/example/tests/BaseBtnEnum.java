package com.example.tests;

/**
 * 六个基础按钮枚举
 *
 * @author : chenYanXin
 * @date : 2018-12-20 14:12
 */
public enum BaseBtnEnum {
    /**
     * 六个基础按钮
     */
    CREATE("2", "新增", "create", "eventAdd"),
    UPDATE("4", "修改", "update", "eventEdit"),
    DELETE("8", "删除", "remove", "eventDel"),
    VIEW("1", "查看", "view", "eventView"),
    HISTORY("32", "修改日志", "history", "eventHistory"),
    SHOW_EXPORT("16", "导出", "showExport", "eventExport");

    /**
     * resource 和right对应值
     */
    private String id;
    private String rightName;
    private String rightFun;
    private String rightId;

    BaseBtnEnum(String id, String rightName, String rightFun, String rightId) {
        this.id = id;
        this.rightName = rightName;
        this.rightFun = rightFun;
        this.rightId = rightId;
    }

    public static BaseBtnEnum getInstance(String rightId) {
        for (BaseBtnEnum c : BaseBtnEnum.values()) {
            if (c.getRightId().equalsIgnoreCase(rightId)) {
                return c;
            }
        }
        return null;
    }

    public String getRightId() {
        return rightId;
    }

    public String getRightName() {
        return rightName;
    }

    public String getRightFun() {
        return rightFun;
    }

    public String getId() {
        return id;
    }
}