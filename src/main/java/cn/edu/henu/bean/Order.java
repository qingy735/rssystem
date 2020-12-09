package cn.edu.henu.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-11-27 16:14
 */
public class Order implements Serializable {
    /**
     * 订单id 主键
     */
    private Integer orderId;
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
     * 优惠券使用
     */
    private Integer discountUse;
    /**
     * 消费者id
     */
    private String cid;
    /**
     * 消费者信息
     */
    private Consumer consumer;
    /**
     * 商品id
     */
    private Integer pid;
    /**
     * 商品信息
     */
    private Product product;
    /**
     * 商家id
     */
    private Integer bid;
    /**
     * 商家信息
     */
    private Business business;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 总价
     */
    private Float totalPrice;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
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

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Float getTotalPrice() {
        // 数量 * 单价 - 折扣
        return num * getProduct().getProductPrice() - discountUse;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", note='" + note + '\'' +
                ", code='" + code + '\'' +
                ", orderTime=" + orderTime +
                ", status=" + status +
                ", discountUse=" + discountUse +
                ", cid='" + cid + '\'' +
                ", consumer=" + consumer +
                ", pid=" + pid +
                ", product=" + product +
                ", bid=" + bid +
                ", business=" + business +
                ", num=" + num +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
