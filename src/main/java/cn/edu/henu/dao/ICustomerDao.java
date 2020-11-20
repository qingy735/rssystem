package cn.edu.henu.dao;

import java.util.List;

import cn.edu.henu.bean.Customer;

/**
 * @author Qing_Y
 */
public interface ICustomerDao {

    /**
     * 获取所有消费者信息
     *
     * @return
     */
    List<Customer> getAllCustomer();

    /**
     * 根据消费者id查询消费者信息
     *
     * @param id
     * @return
     */
    Customer getOneById(Integer id);

    /**
     * 根据消费者id删除消费者
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 修改消费者信息
     *
     * @param customer
     */
    void update(Customer customer);

    /**
     * 添加消费者
     *
     * @param customer
     */
    void add(Customer customer);
}
