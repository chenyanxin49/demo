package com.example.domain;

import io.swagger.annotations.ApiModelProperty;

public class FXbhBKey {
    @ApiModelProperty(value = "村镇代码")
    private String addvcd;

    @ApiModelProperty(value = "小班号")
    private String xbh;

    /**
     * 村镇代码
     * @return ADDVCD 村镇代码
     */
    public String getAddvcd() {
        return addvcd;
    }

    /**
     * 村镇代码
     * @param addvcd 村镇代码
     */
    public void setAddvcd(String addvcd) {
        this.addvcd = addvcd == null ? null : addvcd.trim();
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

    /**
     *
     * @mbg.generated 2018-07-20
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", addvcd=").append(addvcd);
        sb.append(", xbh=").append(xbh);
        sb.append("]");
        return sb.toString();
    }
}