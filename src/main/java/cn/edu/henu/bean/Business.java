package cn.edu.henu.bean;

/**
 * 商家/店铺 实体类
 *
 * @author Qing_Y
 */
public class Business {
    /**
     * 店铺id
     */
    private String username;
    /**
     * 店铺账号密码
     */
    private String password;
    /**
     * 负责人姓名
     */
    private String name;
    /**
     * 餐厅id
     */
    private Integer rid;
    /**
     * 窗口id
     */
    private Integer wid;
    /**
     * 负责人电话
     */
    private String tel;
    /**
     * 评分
     */
    private Float grade;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
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

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
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
                ", tel='" + tel + '\'' +
                ", grade=" + grade +
                '}';
    }
}
