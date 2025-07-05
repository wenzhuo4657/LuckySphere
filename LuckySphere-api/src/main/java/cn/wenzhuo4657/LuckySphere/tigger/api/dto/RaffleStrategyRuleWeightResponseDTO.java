package cn.wenzhuo4657.LuckySphere.tigger.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RaffleStrategyRuleWeightResponseDTO implements Serializable {

    // 权重规则配置的抽奖次数
    private Integer ruleWeightCount;
    // 用户在一个活动下完成的总抽奖次数
    private Integer userActivityAccountTotalUseCount;
    // 当前权重可抽奖范围
    private List<StrategyAward> strategyAwards;

    @Data
    public static class StrategyAward {
        // 奖品ID
        private Integer awardId;
        // 奖品标题
        private String awardTitle;
    }

}
