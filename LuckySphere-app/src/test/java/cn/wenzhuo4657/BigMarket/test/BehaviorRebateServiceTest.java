package cn.wenzhuo4657.LuckySphere.test;

import cn.wenzhuo4657.LuckySphere.domain.rebate.model.entity.BehaviorEntity;
import cn.wenzhuo4657.LuckySphere.domain.rebate.model.valobj.BehaviorTypeVO;
import cn.wenzhuo4657.LuckySphere.domain.rebate.service.IBehaviorRebateService;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 行为返利单测
 * @create 2024-04-30 17:53
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BehaviorRebateServiceTest {

    @Resource
    private IBehaviorRebateService behaviorRebateService;

    @Test
    public void test_createOrder() throws InterruptedException {
        BehaviorEntity behaviorEntity = new BehaviorEntity();
        behaviorEntity.setUserId("xiaofuge");
        behaviorEntity.setBehaviorTypeVO(BehaviorTypeVO.SIGN);
        // 重复的 OutBusinessNo 会报错唯一索引冲突，这也是保证幂等的手段，确保不会多记账
        behaviorEntity.setOutBusinessNo("2024042931231");

        List<String> orderIds = behaviorRebateService.createOrder(behaviorEntity);
        log.info("请求参数：{}", JSON.toJSONString(behaviorEntity));
        log.info("测试结果：{}", JSON.toJSONString(orderIds));

        new CountDownLatch(1).await();
    }

}
