package cn.wenzhuo4657.BigMarket.domain.activity.model.entity;

import cn.wenzhuo4657.BigMarket.domain.activity.model.valobj.OrderStateVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: wenzhuo4657
 * @date: 2024/10/17
 * @description: 活动参与实体，订单实体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityOrderEntity {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * sku
    * */
    private Long sku;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 抽奖策略ID
     */
    private Long strategyId;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 下单时间
     */
    private Date orderTime;

    /**
     * 总次数
     */
    private Integer totalCount;

    /**
     * 日次数
     */
    private Integer dayCount;

    /**
     * 月次数
     */
    private Integer monthCount;

    /**
     * 订单状态
     */
    private OrderStateVO state;

    /**
     * 业务防重ID
     */
    private  String outBusinessNo;
}
