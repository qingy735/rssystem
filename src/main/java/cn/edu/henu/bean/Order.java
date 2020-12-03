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
     * 优惠券使用
     */
    private Integer discountUse;
    /**
     * 消费者信息
     */
    private Consumer consumer;
    /**
     * 商品信息
     */
    private Product product;
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

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
        return num * product.getProductPrice();
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
                ", consumer=" + consumer +
                ", product=" + product +
                ", business=" + business +
                ", num=" + num +
                ", totalPrice=" + totalPrice +
                '}';
    }
}