package cn.wenzhuo4657.LuckySphere.infrastructure.persistent.dao;


import cn.wenzhuo4657.LuckySphere.infrastructure.persistent.BugleCaller;
import cn.wenzhuo4657.LuckySphere.infrastructure.persistent.po.RaffleActivityAccount;

import java.util.List;

/**
 * 抽奖活动(总)账户表(RaffleActivityAccount)表数据库访问层
 *
 * @author makejava
 * @since 2024-10-17 09:11:48
 */

public interface RaffleActivityAccountDao  extends BugleCaller {




    RaffleActivityAccount queryActivityAccountByUserId(RaffleActivityAccount raffleActivityAccountReq);


    List<RaffleActivityAccount> queryDepleteCountByUserId(RaffleActivityAccount raffleActivityAccountReq);

    int updateActivityAccountSubtractionQuota(RaffleActivityAccount raffleActivityAccount);
    /**
     *  @author:wenzhuo4657
        des:更新月镜像账户
    */
    int updateActivityAccountMonthSubtractionQuota(RaffleActivityAccount raffleActivityAccount);

    /**
     *  @author:wenzhuo4657
        des:
     更新日镜像账户
    */
    int updateActivityAccountDaySubtractionQuota(RaffleActivityAccount raffleActivityAccount);

    /**
     *  @author:wenzhuo4657
        des: 更新总账户中的月额度
    */

    void updateActivityAccountMonthSurplusImageQuota(RaffleActivityAccount raffleActivityAccount);
    /**
     *  @author:wenzhuo4657
    des: 更新总账户中的日额度
     */
    void updateActivityAccountDaySurplusImageQuota(RaffleActivityAccount raffleActivityAccount);

    /**
     *  @author:wenzhuo4657
        des:更新账户额度。curren=total_count + #{totalCount}
    */
    int updateAccountQuota(RaffleActivityAccount raffleActivityAccount);

    void insert(RaffleActivityAccount raffleActivityAccount);


    @Override
    List<Long> getId();
}

