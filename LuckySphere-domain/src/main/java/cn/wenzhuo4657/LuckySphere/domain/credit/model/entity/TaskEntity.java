package cn.wenzhuo4657.LuckySphere.domain.credit.model.entity;

import cn.wenzhuo4657.LuckySphere.domain.award.model.valobj.TaskStateVO;
import cn.wenzhuo4657.LuckySphere.domain.credit.event.CreditAdjustSuccessMessageEvent;
import cn.wenzhuo4657.LuckySphere.types.event.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {

    /** 活动ID */
    private String userId;
    /** 消息主题 */
    private String topic;
    /** 消息编号 */
    private String messageId;
    /** 消息主体 */
    private BaseEvent.EventMessage<CreditAdjustSuccessMessageEvent.CreditAdjustSuccessMessage> message;
    /** 任务状态；create-创建、completed-完成、fail-失败 */
    private TaskStateVO state;

}
