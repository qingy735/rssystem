package cn.edu.henu.bean;

import java.io.Serializable;

/**
 * @author Qing_Y
 * @date 2020-11-26 19:05
 */
public class Product implements Serializable {
    /**
     * 店铺id
     */
    private Integer bsId;
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
     * 图片路径
     */
    private String photosrc;
    /**
     * 商品评分
     */
    private Float productGrade;

    public Integer getBsId() {
        return bsId;
    }

    public void setBsId(Integer bsId) {
        this.bsId = bsId;
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
                "bsId=" + bsId +
                ", productName='" + productName + '\'' +
                ", productIntr='" + productIntr + '\'' +
                ", productPrice=" + productPrice +
                ", photosrc='" + photosrc + '\'' +
                ", productGrade=" + productGrade +
                '}';
    }
}
