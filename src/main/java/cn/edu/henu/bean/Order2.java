package cn.edu.henu.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-12-13 19:57
 */
public class Order2 implements Serializable {
    /**
     * 订单id
     */
    private Integer id;
    /**
     * 消费者id
     */
    private String cid;
    /**
     * 商家id
     */
    private Integer bid;
    /**
     * 备注
     */
    private String note;
    /**
     * 取餐码
     */
    private String code;
    /**
     * 订餐日期
     */
    private Date orderTime;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 总价
     */
    private Float total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order2{" +
                "id=" + id +
                ", cid='" + cid + '\'' +
                ", bid=" + bid +
                ", note='" + note + '\'' +
                ", code='" + code + '\'' +
                ", orderTime=" + orderTime +
                ", status=" + status +
                ", total=" + total +
                '}';
    }
}
