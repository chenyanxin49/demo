package com.example.tests;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: realtour-r8-qj-b2b
 * @description: 团队人数表
 * @author: 周成平
 * @create: 2018-08-27 16:51
 **/
@Data
public class ProjectPeopleNumber implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 团队ID
     */
    private String projectId;

    /**
     * 计划人数
     */
    private Integer peopleNum;

    /**
     * 全陪人数（领队人数）
     */
    private Integer leaderNum;

    /**
     * 可超收人数
     */
    private Integer exceedPeopleNum;

    /**
     * 已收
     */
    private Integer receivedNum;

    /**
     * 预占申请数
     */
    private Integer preemptApplyNum;

    /**
     * 预占数
     */
    private Integer preemptNum;

    /**
     * 占位
     */
    private Integer occupancyNum;

    /**
     * 切位人数
     */
    private Integer carveUpNum;

    /**
     * 剩余
     */
    private Integer surplusNum;

    /**
     * 余位数
     */
    private Integer saleSurplusNum;

    /**
     * 自备票人数
     */
    private Integer overseasNum;

    /**
     * 预占比
     */
    private BigDecimal preemptNumPercent;
}