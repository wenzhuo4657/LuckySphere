package cn.wenzhuo4657.LuckySphere.test;

import cn.wenzhuo4657.LuckySphere.domain.strategy.service.armory.IStrategyArmory;
import cn.wenzhuo4657.LuckySphere.domain.strategy.service.armory.IStrategyDispatch;
import cn.wenzhuo4657.LuckySphere.domain.strategy.service.armory.StrategyArmoryDispatch;
import cn.wenzhuo4657.LuckySphere.infrastructure.persistent.redis.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RMap;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;

/**
 * @className: StrategyTest
 * @author: wenzhuo4657
 * @date: 2024/9/26
 * @Version: 1.0
 * @description:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyTest {
    @Resource
    private StrategyArmoryDispatch strategyArmory;

    @Resource
    private StrategyArmoryDispatch strategyDispatch;

    @Before
    public void test_strategyArmory() {
        boolean success = strategyArmory.assembleLotteryStrategy(100001L);
        log.info("测试结果：{}", success);
    }

    /**
     * 根据策略ID+权重值，从装配的策略中随机获取奖品ID值
     */
    @Test
    public void test_getRandomAwardId_ruleWeightValue() {
        log.info("测试结果：{} - 6000 策略配置", strategyDispatch.getRandomAwardId(100001L, "6000:102,103,104,105,106,107,108,109"));
    }

    @Resource
    private IRedisService redissonService;

    @Test
    public void test_map() {
        RMap<Integer, Integer> map = redissonService.getMap("strategy_id_100001");
        map.put(1, 101);
        map.put(2, 101);
        map.put(3, 101);
        map.put(4, 102);
        map.put(5, 102);
        map.put(6, 102);
        map.put(7, 103);
        map.put(8, 103);
        map.put(9, 104);
        map.put(10, 105);

        log.info("测试结果：{}", redissonService.getMap("strategy_id_100001").get(1));
    }

    @Test
    public void test_shuffle() {
        Map<Integer, Integer> strategyAwardSearchRateTable = new HashMap<>();
        // 添加内容到Map中
        strategyAwardSearchRateTable.put(1, 10);
        strategyAwardSearchRateTable.put(2, 20);
        strategyAwardSearchRateTable.put(3, 30);
        strategyAwardSearchRateTable.put(4, 40);

        // 将Map中的值转换为List
        List<Integer> valueList = new ArrayList<>(strategyAwardSearchRateTable.values());

        // 使用Collections.shuffle()方法对值的List进行乱序
        Collections.shuffle(valueList);

        // 将乱序后的值重新放回Map中
        Map<Integer, Integer> randomizedMap = new LinkedHashMap<>();
        Iterator<Integer> valueIterator = valueList.iterator();
        for (Integer key : strategyAwardSearchRateTable.keySet()) {
            randomizedMap.put(key, valueIterator.next());
        }

        // 打印乱序后的Map内容
        for (Map.Entry<Integer, Integer> entry : randomizedMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }


    }


}
