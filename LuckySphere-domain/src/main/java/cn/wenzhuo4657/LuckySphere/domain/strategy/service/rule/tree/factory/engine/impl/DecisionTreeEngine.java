package cn.wenzhuo4657.LuckySphere.domain.strategy.service.rule.tree.factory.engine.impl;

import cn.wenzhuo4657.LuckySphere.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import cn.wenzhuo4657.LuckySphere.domain.strategy.model.valobj.RuleTreeNodeLineVo;
import cn.wenzhuo4657.LuckySphere.domain.strategy.model.valobj.RuleTreeNodeVo;
import cn.wenzhuo4657.LuckySphere.domain.strategy.model.valobj.RuleTreeVo;
import cn.wenzhuo4657.LuckySphere.domain.strategy.service.rule.chain.ILogicChain;
import cn.wenzhuo4657.LuckySphere.domain.strategy.service.rule.tree.ILogicTreeNode;
import cn.wenzhuo4657.LuckySphere.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import cn.wenzhuo4657.LuckySphere.domain.strategy.service.rule.tree.factory.engine.IDecisionTreeEngine;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * @className: DecisionTreeEngine
 * @author: wenzhuo4657
 * @date: 2024/10/4
 * @Version: 1.0
 * @description:
 */
@Slf4j
public class DecisionTreeEngine implements IDecisionTreeEngine {
    private final Map<String, ILogicTreeNode> logicTreeNodeMap;
    private final RuleTreeVo ruleTreeVo;

    public DecisionTreeEngine(Map<String, ILogicTreeNode> logicTreeNodeMap, RuleTreeVo ruleTreeVo) {
        this.logicTreeNodeMap = logicTreeNodeMap;
        this.ruleTreeVo = ruleTreeVo;
    }

    @Override
    public DefaultTreeFactory.StrategyAwardVO process(String userId, Long strategyId, Integer awardId) {
        DefaultTreeFactory.StrategyAwardVO awardData=null;
        String nextNode = ruleTreeVo.getTreeRootRuleNode();
        Map<String, RuleTreeNodeVo> treeNodeMap = ruleTreeVo.getTreeNodeMap();
        RuleTreeNodeVo ruleTreeNodeVo = treeNodeMap.get(nextNode);

        while(null!=nextNode){
            ILogicTreeNode treeNode = logicTreeNodeMap.get(ruleTreeNodeVo.getRuleKey());
            String ruleValue = ruleTreeNodeVo.getRuleValue();
            DefaultTreeFactory.TreeActionEntity logicEntity = treeNode.logic(userId, strategyId, awardId,ruleValue);

            RuleLogicCheckTypeVO ruleLogicCheckType = logicEntity.getRuleLogicCheckType();
            awardData = logicEntity.getStrategyAwardData();
            log.info("决策树引擎【{}】treeId:{} node:{} code:{}", ruleTreeVo.getTreeName(), ruleTreeVo.getTreeId(), nextNode, ruleLogicCheckType.getCode());
             nextNode = nextNode(ruleLogicCheckType.getCode(), ruleTreeNodeVo.getTreeNodeLineVOList());
             ruleTreeNodeVo=treeNodeMap.get(nextNode);
        }
        return awardData;
    }


    public String nextNode(String code, List<RuleTreeNodeLineVo> treeNodeLineVoList){
        if (null==treeNodeLineVoList||treeNodeLineVoList.isEmpty())return  null;
        for (RuleTreeNodeLineVo nodeLineVo:treeNodeLineVoList){
                if(decisionLogic(code,nodeLineVo)){
                    return nodeLineVo.getRuleNodeTo();
                }
        }
        return null;
    }

    /**
     *  @author:wenzhuo4657
        des:
    nodeLineVo.getRuleLimitValue()在数据库中的值是ALLOW/TAKE_OVER，也就是节点的校验结果RuleLogicCheckTypeVO，
     因此猜测该方法用于根据节点的校验结果来判断该找哪一个指向节点，目前判断方式仅仅是字段对比。
    */
    public boolean decisionLogic(String code,RuleTreeNodeLineVo nodeLineVo){
        switch (nodeLineVo.getRuleLimitType()){
            case EQUAL:
                return code.equals(nodeLineVo.getRuleLimitValue().getCode());
              //  wenzhuo TODO 2024/10/4 : 暂未实现
            case GT:
            case LT:
            case GE:
            case LE:
            default:
                return false;

        }
    }
}
