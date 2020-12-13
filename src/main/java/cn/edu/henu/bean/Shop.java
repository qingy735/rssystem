package cn.edu.henu.bean;

import java.io.Serializable;

/**
 * 购物车
 *
 * @author Qing_Y
 * @date 2020-12-13 17:26
 */
public class Shop implements Serializable {
    /**
     * 购物车商品id
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
     * 商品id
     */
    private Integer pid;
    /**
     * 商品数量
     */
    private Integer pnum;
    /**
     * 折扣
     */
    private Integer discountuse;

    private Float totalPrice;

    private Product product;

    public Float getTotalPrice() {
        return getProduct().getProductPrice() * pnum - discountuse;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPnum() {
        return pnum;
    }

    public void setPnum(Integer pnum) {
        this.pnum = pnum;
    }

    public Integer getDiscountuse() {
        return discountuse;
    }

    public void setDiscountuse(Integer discountuse) {
        this.discountuse = discountuse;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", cid='" + cid + '\'' +
                ", bid=" + bid +
                ", pid=" + pid +
                ", pnum=" + pnum +
                ", discountuse=" + discountuse +
                ", totalPrice=" + totalPrice +
                ", product=" + product +
                '}';
    }
}
