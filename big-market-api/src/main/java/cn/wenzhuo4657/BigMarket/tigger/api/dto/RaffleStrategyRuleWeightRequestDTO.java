package cn.wenzhuo4657.BigMarket.tigger.api.dto;

import lombok.Data;

@Data
public class RaffleStrategyRuleWeightRequestDTO {

    // 用户ID
    private String userId;
    // 抽奖活动ID
    private Long activityId;

}