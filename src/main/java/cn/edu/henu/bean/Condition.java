package cn.edu.henu.bean;

/**
 * @author Qing_Y
 * @date 2020-12-03 17:13
 */
public class Condition {
    /**
     * 商品名
     */
    private String name;
    /**
     * 价钱
     */
    private Float price;
    /**
     * 评分
     */
    private Float grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", grade=" + grade +
                '}';
    }
}
