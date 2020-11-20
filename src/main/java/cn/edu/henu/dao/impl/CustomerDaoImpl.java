package cn.edu.henu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.henu.bean.Customer;
import cn.edu.henu.dao.ICustomerDao;

/**
 * @author Qing_Y
 */
@Repository("customerDao")
public class CustomerDaoImpl implements ICustomerDao {

    @Override
    public List<Customer> getAllCustomer() {

        return null;
    }

    @Override
    public Customer getOneById(Integer id) {

        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void add(Customer customer) {

    }

}
