package cn.edu.henu.bean;

/**
 * @author Qing_Y
 * @date 2020-12-13 20:35
 */
public class OrderDetail {
    /**
     * 订单详情项id
     */
    private Integer id;
    /**
     * 订单id
     */
    private Integer oid;
    /**
     * 商品id
     */
    private Integer pid;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 折扣
     */
    private Float discount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", oid=" + oid +
                ", pid=" + pid +
                ", num=" + num +
                ", discount=" + discount +
                '}';
    }
}
