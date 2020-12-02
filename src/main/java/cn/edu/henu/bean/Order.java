package cn.edu.henu.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Qing_Y
 * @date 2020-11-27 16:14
 */
public class Order implements Serializable {
    /**
     * 订单id 主键
     */
    private String orderId;
    /**
     * 备注
     */
    private String note;
    /**
     * 取餐码
     */
    private String code;
    /**
     * 下单时间
     */
    private Date orderTime;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 优惠券使用
     */
    private Integer discountUse;
    /**
     * 消费者id
     */
    private String cid;
    /**
     * 商家id
     */
    private Integer bid;
    /**
     * 商品名称
     */
    private String pName;
    /**
     * 消费者信息
     */
    private Consumer consumer;
    /**
     * 商品信息
     */
    private Product product;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getDiscountUse() {
        return discountUse;
    }

    public void setDiscountUse(Integer discountUse) {
        this.discountUse = discountUse;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", note='" + note + '\'' +
                ", code='" + code + '\'' +
                ", orderTime=" + orderTime +
                ", status=" + status +
                ", num=" + num +
                ", discountUse=" + discountUse +
                ", consumer=" + consumer +
                ", product=" + product +
                '}';
    }
}
