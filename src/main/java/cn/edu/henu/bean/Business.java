package cn.edu.henu.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * 商家/店铺 实体类
 *
 * @author Qing_Y
 */
public class Business {
    /**
     * 店铺id
     * 数据库中为int类型
     */
    private Integer username;
    /**
     * 店铺账号密码
     */
    @NotEmpty(message = "密码不能为空")
    private String password;
    /**
     * 负责人姓名
     */
    @NotEmpty(message = "姓名不能为空")
    private String name;
    /**
     * 餐厅id
     */
    @NotEmpty(message = "餐厅名不能为空")
    private String rid;
    /**
     * 窗口号
     */
    @NotNull(message = "窗口号不能为空")
    private Integer wid;
    /**
     * 窗口名
     */
    @NotEmpty(message = "窗口名不能为空")
    private String wname;
    /**
     * 负责人电话
     */
    @NotEmpty(message = "手机号不能为空")
    @Length(min = 11, max = 11, message = "手机号必须为11位")
    private String tel;
    /**
     * 评分
     */
    private Float grade;

    public Integer getUsername() {
        return username;
    }

    public void setUsername(Integer username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Business{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", rid=" + rid +
                ", wid=" + wid +
                ", wname='" + wname + '\'' +
                ", tel='" + tel + '\'' +
                ", grade=" + grade +
                '}';
    }
}
