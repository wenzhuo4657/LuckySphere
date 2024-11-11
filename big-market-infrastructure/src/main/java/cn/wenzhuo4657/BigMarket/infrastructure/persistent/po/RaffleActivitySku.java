package cn.wenzhuo4657.BigMarket.infrastructure.persistent.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (RaffleActivitySku)实体类
 *
 * @author makejava
 * @since 2024-10-17 08:43:07
 */

public class RaffleActivitySku implements Serializable {
    private static final long serialVersionUID = -66842483358017257L;
    /**
     * 自增ID
     */
    private String id;
    /**
     * 商品sku - 把每一个组合当做一个商品
     */
    private Long sku;
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 活动个人参与次数ID
     */
    private Long activityCountId;
    /**
     * 商品库存
     */
    private Integer stockCount;
    /**
     * 剩余库存
     */
    private Integer stockCountSurplus;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 商品金额【积分】
     */
    private BigDecimal productAmount;
    /**
     * 更新时间
     */
    private Date updateTime;

    public BigDecimal getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getActivityCountId() {
        return activityCountId;
    }

    public void setActivityCountId(Long activityCountId) {
        this.activityCountId = activityCountId;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Integer getStockCountSurplus() {
        return stockCountSurplus;
    }

    public void setStockCountSurplus(Integer stockCountSurplus) {
        this.stockCountSurplus = stockCountSurplus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}

