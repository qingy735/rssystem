package cn.edu.henu.service.impl;

import java.util.List;

import cn.edu.henu.bean.Consumer;
import cn.edu.henu.dao.IConsumerDao;
import cn.edu.henu.service.IConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Qing_Y
 */
@Service("consumerSer")
public class ConsumerServiceImpl implements IConsumerService {

    @Autowired
    private IConsumerDao consumerDao;

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

    /**
     * 添加用户
     *
     * @param consumer
     * @return
     */
    @Override
    public Integer save(Consumer consumer) {
        return consumerDao.add(consumer);
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
        return consumerDao.getOneByLoginInfo(username, password);
    }

}
