package cn.edu.henu.service.impl;

import java.util.List;

import cn.edu.henu.bean.Consumer;
import cn.edu.henu.service.IConsumerService;
import org.springframework.stereotype.Service;

/**
 * @author Qing_Y
 */
@Service("customerSer")
public class ConsumerServiceImpl implements IConsumerService {

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
