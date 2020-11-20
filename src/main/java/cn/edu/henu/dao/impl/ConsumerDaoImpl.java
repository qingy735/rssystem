package cn.edu.henu.dao.impl;

import java.util.List;

import cn.edu.henu.bean.Consumer;
import org.springframework.stereotype.Repository;

import cn.edu.henu.dao.IConsumerDao;

/**
 * @author Qing_Y
 */
@Repository("customerDao")
public class ConsumerDaoImpl implements IConsumerDao {

    @Override
    public List<Consumer> getAllCustomer() {

        return null;
    }

    @Override
    public Consumer getOneById(Integer id) {

        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void update(Consumer consumer) {

    }

    @Override
    public void add(Consumer consumer) {

    }

}
