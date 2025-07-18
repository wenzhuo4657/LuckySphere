package cn.wenzhuo4657.LuckySphere.domain.award.model.entity;


import cn.wenzhuo4657.LuckySphere.domain.award.model.valobj.AwardStateVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * @author: wenzhuo4657
 * @date: 2024/10/28
 * @description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAwardRecordEntity {

    /** 分布式id:用于辨识同一用户的同一活动下的不同抽奖订单， */
    private  long id;
    /** 用户ID */
    private String userId;
    /** 活动ID */
    private Long activityId;
    /** 抽奖策略ID */
    private Long strategyId;
    /** 抽奖订单ID【作为幂等使用】 */
    private String orderId;
    /** 奖品ID */
    private Integer awardId;
    /** 奖品标题（名称） */
    private String awardTitle;
    /** 中奖时间 */
    private Date awardTime;
    /** 奖品状态；create-创建、completed-发奖完成 */
    private AwardStateVO awardState;

    /** 奖品配置信息；发奖的时候，可以根据 */
    private String awardConfig;

}
