package cn.edu.henu.dao;

import cn.edu.henu.bean.Consumer;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-11-25 12:55
 */
public interface ConsumerMapper extends CrudDao<Consumer> {

    /**
     * 根据传入的条件参数进行查询，包括name、sex、tel
     *
     * @param entity 附带查询条件的实体类
     * @return 符合查询条件的集合
     */
    @Override
    List<Consumer> selectByCondition(Consumer entity);
}
