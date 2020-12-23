package cn.edu.henu.bean;

import java.io.Serializable;

/**
 * @author Qing_Y
 * @date 2020-11-26 19:05
 */
public class Product implements Serializable {
    /**
     * 商品id
     */
    private Integer id;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 餐品简介
     */
    private String productIntr;
    /**
     * 商品价格
     */
    private Float productPrice;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 图片路径
     */
    private String photosrc;
    /**
     * 商品评分
     */
    private Float productGrade;
    /**
     * 商品标志位
     * 1：存在
     * 0：下架
     */
    private Integer status;
    /**
     * 商家id
     */
    private Integer bid;
    /**
     * 店铺信息
     */
    private Business business;

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

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductIntr() {
        return productIntr;
    }

    public void setProductIntr(String productIntr) {
        this.productIntr = productIntr;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public String getPhotosrc() {
        return photosrc;
    }

    public void setPhotosrc(String photosrc) {
        this.photosrc = photosrc;
    }

    public Float getProductGrade() {
        return productGrade;
    }

    public void setProductGrade(Float productGrade) {
        this.productGrade = productGrade;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productIntr='" + productIntr + '\'' +
                ", productPrice=" + productPrice +
                ", num=" + num +
                ", photosrc='" + photosrc + '\'' +
                ", productGrade=" + productGrade +
                ", status=" + status +
                ", bid=" + bid +
                ", business=" + business +
                '}';
    }
}
