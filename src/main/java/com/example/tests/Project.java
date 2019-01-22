package com.example.tests;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: realtour-r8-qj-b2b
 * @description: 团队表
 * @author: 周成平
 * @create: 2018-08-27 16:51
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class Project extends ProjectPeopleNumber implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 团队编号
     */
    private String projectCode;

    /**
     * 团队全称
     */
    private String projectFullName;

    /**
     * 团队类型
     */
    private String projectClass;

    /**
     * 团队类型名称
     */
    @JSONField(name = "ProjectClassDesc")
    private String projectClassName;

    /**
     * 机票控位ID
     */
    private String purchaseId;

    /**
     * 线路ID
     */
    private String routeId;

    /**
     * 线路ID
     */
    private String routeName;

    /**
     * 出发地ID
     */
    private String startCityId;

    /**
     * 出发地名称
     */
    private String startCityName;

    /**
     * 出团日期
     */
    private String startDate;

    /**
     * 回团日期
     */
    private String endDate;

    /**
     * 截止报名日期
     */
    private String endSignDate;

    /**
     * 团队状态 0未开团 1报名 2截止 3取消 4核算 5结算 6:暂停
     */
    private Integer projectStatus;

    /**
     * 团队状态名称
     */
    @JSONField(name = "ProjectStatusDesc")
    private String projectStatusName;

    /**
     * 最少成团人数
     */
    private Integer leastPeopleNum;

    /**
     * 每人定金
     */
    private BigDecimal bargainMoney;

    /**
     * 价格说明
     */
    private String priceDesc;

    /**
     * 直客价
     */
    private BigDecimal teamCustomerPrice;

    /**
     * 同行价
     */
    private BigDecimal teamPrice;

    /**
     * 领队名称
     */
    private String leaderName;

    /**
     * 导游姓名
     */
    private String ciceroniName;

    /**
     * 成人年龄开始
     */
    private Integer adultAgeMin;

    /**
     * 成人年龄结束
     */
    private Integer adultAgeMax;

    /**
     * 计调ID
     */
    private String userId;

    /**
     * 计调名称
     */
    private String userName;

    /**
     * 创建人
     */
    private String createUserId;

    /**
     * 创建人姓名
     */
    private String createUserName;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 修改人
     */
    private String lastModifiedUserId;

    /**
     * 修改人姓名
     */
    private String lastModifiedUserName;

    /**
     * 修改时间
     */
    private String lastModifiedDate;

    /**
     * 删除标识
     */
    private Integer delFlag;

    /**
     * 出团通知状态 0：未生成 1：已生成
     */
    private Integer projectNotifyStatus;

    /**
     * 出团通知状态说明 0：未生成 1：已生成
     */
    @JSONField(name = "ProjectNotifyStatusDesc")
    private String projectNotifyStatusName;

    /**
     * 最晚收照日期
     */
    private String endReceiveDate;

    /**
     * 机票使用方式：-1无，0共享，1独享
     */
    @JSONField(name = "TicketAssignTypeId")
    private Integer ticketAssignType;

    /**
     * 机票使用方式
     */
    private String ticketAssignTypeName;

    /**
     * 送签时间
     */
    private String visaDate;

    /**
     * 确认送签时间
     */
    private String confirmVisaDate;

    /**
     * 录入指纹时间
     */
    private String recordFingerDate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 团队价格列表
     */

    /**
     * 游客附件列表
     */
}