package cn.edu.henu.service.impl;

import java.util.List;

import cn.edu.henu.bean.Customer;
import cn.edu.henu.service.ICustomerService;
import org.springframework.stereotype.Service;

/**
 * @author Qing_Y
 */
@Service("customerSer")
public class CustomerServiceImpl implements ICustomerService {

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
