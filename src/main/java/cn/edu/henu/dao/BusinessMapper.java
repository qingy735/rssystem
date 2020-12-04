package cn.edu.henu.dao;

import cn.edu.henu.bean.Business;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-11-24 21:06
 */
public interface BusinessMapper extends CrudDao<Business> {

    /**
     * 根据传入的条件参数进行查询，包括name、rid、wid、wid、wname、tel
     *
     * @param entity 附带查询条件的实体类
     * @return 符合查询条件的集合
     */
    @Override
    List<Business> selectByCondition(Business entity);

    /**
     * 根据传入的grade进行查找
     *
     * @param grade 店铺评分
     * @param p     判断进行大于操作还是小于还是等于
     * @return 返回符合查询的Business集合
     */
    List<Business> selectByGrade(@Param("grade") Integer grade, @Param("standard") Integer p);

}
