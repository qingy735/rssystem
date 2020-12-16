package cn.edu.henu.bean;

import java.io.Serializable;

/**
 * @author Qing_Y
 * @date 2020-12-16 13:33
 */
public class Comment implements Serializable {
    /**
     * 评论id
     */
    private Integer id;
    /**
     * 评论用户id
     */
    private String cid;
    /**
     * 评论商品id
     */
    private Integer pid;
    /**
     * 父评论id
     */
    private Integer preCid;

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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPreCid() {
        return preCid;
    }

    public void setPreCid(Integer preCid) {
        this.preCid = preCid;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", cid='" + cid + '\'' +
                ", pid=" + pid +
                ", preCid=" + preCid +
                '}';
    }
}
