package com.example.domain;

import io.swagger.annotations.ApiModelProperty;

public class FXbhBKey {
    @ApiModelProperty(value = "村镇代码")
    private String towncd;

    @ApiModelProperty(value = "小班号")
    private String xbh;

    /**
     * 村镇代码
     * @return TOWNCD 村镇代码
     */
    public String getTowncd() {
        return towncd;
    }

    /**
     * 村镇代码
     * @param towncd 村镇代码
     */
    public void setTowncd(String towncd) {
        this.towncd = towncd == null ? null : towncd.trim();
    }

    /**
     * 小班号
     * @return XBH 小班号
     */
    public String getXbh() {
        return xbh;
    }

    /**
     * 小班号
     * @param xbh 小班号
     */
    public void setXbh(String xbh) {
        this.xbh = xbh == null ? null : xbh.trim();
    }
}