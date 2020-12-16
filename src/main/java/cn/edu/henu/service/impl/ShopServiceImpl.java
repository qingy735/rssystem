package cn.edu.henu.service.impl;

import cn.edu.henu.bean.Shop;
import cn.edu.henu.dao.ShopMapper;
import cn.edu.henu.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-12-13 17:52
 */
@Service("shopSer")
public class ShopServiceImpl implements IShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public int insert(Shop shop) {
        try {
            return shopMapper.insert(shop);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(Integer id) {
        try {
            return shopMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int batchDelete(List<Integer> ids) {
        try {
            return shopMapper.batchDelete(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int update(Shop shop) {
        try {
            return shopMapper.updateByPrimaryKey(shop);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<Shop> selectAll() {
        try {
            return shopMapper.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Shop> selectByCid(String cid) {
        try {
            return shopMapper.selectByCid(cid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Shop selectByPrimaryKey(Integer id) {
        try {
            return shopMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Shop> batchSelect(List<Integer> ids) {
        try {
            return shopMapper.batchSelect(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
