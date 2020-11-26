package cn.edu.henu.service.impl;

import java.util.List;

import cn.edu.henu.bean.Consumer;
import cn.edu.henu.dao.ConsumerMapper;
import cn.edu.henu.service.IConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Qing_Y
 */
@Service("consumerSer")
public class ConsumerServiceImpl implements IConsumerService {

    @Autowired
    private ConsumerMapper consumerMapper;

    @Override
    public List<Consumer> getAllCustomer() {

        return null;
    }

    @Override
    public Consumer getOneById(Integer id) {
        try {
            return consumerMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public int update(Consumer consumer) {
        try {
            System.out.println(consumer);
            return consumerMapper.updateByPrimaryKey(consumer);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 添加用户
     *
     * @param consumer
     * @return
     */
    @Override
    public Integer save(Consumer consumer) {
        if (consumer == null) {
            return -2;
        }
        try {
            Consumer tempConsumer = consumerMapper.selectByPrimaryKey(Integer.parseInt(consumer.getUsername()));
            if (tempConsumer == null) {
                return consumerMapper.insert(consumer);
            } else {
                return 0;
            }
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 登录校验：
     * 调用持久层方法
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public Consumer login(String username, String password) {
        try {
            Consumer consumer = consumerMapper.selectByPrimaryKey(Integer.parseInt(username));
            if (consumer != null && password.equals(consumer.getPassword())) {
                return consumer;
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
