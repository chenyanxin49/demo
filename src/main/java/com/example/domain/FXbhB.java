package com.example.domain;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class FXbhB extends FXbhBKey {
    @ApiModelProperty(value = "村名称")
    private String villnm;

    @ApiModelProperty(value = "面积（公顷）")
    private Double area;

    @ApiModelProperty(value = "优势树种 (F_SCS_B)")
    private String stcd;

    @ApiModelProperty(value = "森林用途 （1-公益林，2-商品林）")
    private String useType;

    @ApiModelProperty(value = "林地所有权(1-国有，2-集体，3-个人）")
    private String forOwn;

    @ApiModelProperty(value = "林地使用权(1-国有，2-集体，3-个人）")
    private String forUse;

    @ApiModelProperty(value = "林木所有权(1-国有，2-集体，3-个人）")
    private String treeOwn;

    @ApiModelProperty(value = "林木使用权(1-国有，2-集体，3-个人）")
    private String treeUse;

    @ApiModelProperty(value = "林木所有人")
    private String treeOwner;

    @ApiModelProperty(value = "立项年份")
    private String foundYear;

    @ApiModelProperty(value = "修改时间")
    private Date modtm;

    /**
     * 村名称
     * @return VILLNM 村名称
     */
    public String getVillnm() {
        return villnm;
    }

    /**
     * 村名称
     * @param villnm 村名称
     */
    public void setVillnm(String villnm) {
        this.villnm = villnm == null ? null : villnm.trim();
    }

    /**
     * 面积（公顷）
     * @return AREA 面积（公顷）
     */
    public Double getArea() {
        return area;
    }

    /**
     * 面积（公顷）
     * @param area 面积（公顷）
     */
    public void setArea(Double area) {
        this.area = area;
    }

    /**
     * 优势树种 (F_SCS_B)
     * @return STCD 优势树种 (F_SCS_B)
     */
    public String getStcd() {
        return stcd;
    }

    /**
     * 优势树种 (F_SCS_B)
     * @param stcd 优势树种 (F_SCS_B)
     */
    public void setStcd(String stcd) {
        this.stcd = stcd == null ? null : stcd.trim();
    }

    /**
     * 森林用途 （1-公益林，2-商品林）
     * @return USE_TYPE 森林用途 （1-公益林，2-商品林）
     */
    public String getUseType() {
        return useType;
    }

    /**
     * 森林用途 （1-公益林，2-商品林）
     * @param useType 森林用途 （1-公益林，2-商品林）
     */
    public void setUseType(String useType) {
        this.useType = useType == null ? null : useType.trim();
    }

    /**
     * 林地所有权(1-国有，2-集体，3-个人）
     * @return FOR_OWN 林地所有权(1-国有，2-集体，3-个人）
     */
    public String getForOwn() {
        return forOwn;
    }

    /**
     * 林地所有权(1-国有，2-集体，3-个人）
     * @param forOwn 林地所有权(1-国有，2-集体，3-个人）
     */
    public void setForOwn(String forOwn) {
        this.forOwn = forOwn == null ? null : forOwn.trim();
    }

    /**
     * 林地使用权(1-国有，2-集体，3-个人）
     * @return FOR_USE 林地使用权(1-国有，2-集体，3-个人）
     */
    public String getForUse() {
        return forUse;
    }

    /**
     * 林地使用权(1-国有，2-集体，3-个人）
     * @param forUse 林地使用权(1-国有，2-集体，3-个人）
     */
    public void setForUse(String forUse) {
        this.forUse = forUse == null ? null : forUse.trim();
    }

    /**
     * 林木所有权(1-国有，2-集体，3-个人）
     * @return TREE_OWN 林木所有权(1-国有，2-集体，3-个人）
     */
    public String getTreeOwn() {
        return treeOwn;
    }

    /**
     * 林木所有权(1-国有，2-集体，3-个人）
     * @param treeOwn 林木所有权(1-国有，2-集体，3-个人）
     */
    public void setTreeOwn(String treeOwn) {
        this.treeOwn = treeOwn == null ? null : treeOwn.trim();
    }

    /**
     * 林木使用权(1-国有，2-集体，3-个人）
     * @return TREE_USE 林木使用权(1-国有，2-集体，3-个人）
     */
    public String getTreeUse() {
        return treeUse;
    }

    /**
     * 林木使用权(1-国有，2-集体，3-个人）
     * @param treeUse 林木使用权(1-国有，2-集体，3-个人）
     */
    public void setTreeUse(String treeUse) {
        this.treeUse = treeUse == null ? null : treeUse.trim();
    }

    /**
     * 林木所有人
     * @return TREE_OWNER 林木所有人
     */
    public String getTreeOwner() {
        return treeOwner;
    }

    /**
     * 林木所有人
     * @param treeOwner 林木所有人
     */
    public void setTreeOwner(String treeOwner) {
        this.treeOwner = treeOwner == null ? null : treeOwner.trim();
    }

    /**
     * 立项年份
     * @return FOUND_YEAR 立项年份
     */
    public String getFoundYear() {
        return foundYear;
    }

    /**
     * 立项年份
     * @param foundYear 立项年份
     */
    public void setFoundYear(String foundYear) {
        this.foundYear = foundYear == null ? null : foundYear.trim();
    }

    /**
     * 修改时间
     * @return MODTM 修改时间
     */
    public Date getModtm() {
        return modtm;
    }

    /**
     * 修改时间
     * @param modtm 修改时间
     */
    public void setModtm(Date modtm) {
        this.modtm = modtm;
    }
}