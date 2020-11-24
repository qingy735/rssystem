package cn.edu.henu.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Qing_Y
 */
public class Consumer {
    /**
     * 账号
     */
    @Length(min = 10, max = 10, message = "学号不符合规范")
    private String username;
    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    private String password;
    /**
     * 姓名
     */
    @NotEmpty(message = "姓名不能为空")
    private String name;
    /**
     * 昵称
     * 默认：用户名/账号
     */
    @Length(min = 2, max = 6)
    private String nickname;
    /**
     * 性别：
     * 0：女
     * 1：男
     * 默认：1
     */
    private Integer sex;
    /**
     * 手机号
     */
    private String tel;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", tel='" + tel + '\'' +
                '}';
    }
}
