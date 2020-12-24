package cn.edu.henu.service.impl;

import cn.edu.henu.bean.*;
import cn.edu.henu.dao.AdminMapper;
import cn.edu.henu.dao.CommentMapper;
import cn.edu.henu.dao.OrderMapper;
import cn.edu.henu.dao.ProductMapper;
import cn.edu.henu.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Qing_Y
 * @date 2020-12-07 23:19
 */
@Service("adminSer")
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Boolean login(Admin admin) {
        String username = admin.getUsername();
        String password = admin.getPassword();
        Admin realAdmin = adminMapper.selectByPrimarykey(username);
        if (realAdmin != null) {
            return realAdmin.getPassword().equals(password);
        } else {
            return false;
        }
    }

    void initPageBean(PageBean pageBean, int total, Integer row) {
        pageBean.setRows(row);
        pageBean.setTotalCount(total);
        int rows = pageBean.getRows();
        int a = total % rows;
        int b = total / rows;
        pageBean.setTotalPage(a == 0 ? b : b + 1);
    }

    @Override
    public PageBean<Order> findAllOrderByPage(Order order, Integer row) {
        try {
            List<Order> orders;
            if (order != null) {
                orders = adminMapper.selectOrderByCon(order);
            } else {
                orders = adminMapper.selectAllOrder();
            }
            for (Order o : orders) {
                Integer id = o.getId();
                List<OrderDetail> details = orderMapper.selectByOid(id);
                o.setDetails(details);
            }
            PageBean<Order> pageBean = new PageBean<>();
            initPageBean(pageBean, getOrderTotal(order), row);
            pageBean.setList(orders);
            return pageBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PageBean<Business> findAllBusinessByPage(Business business, Integer row) {
        try {
            List<Business> businesses;
            if (business != null) {
                businesses = adminMapper.selectBusinessByCon(business);
            } else {
                businesses = adminMapper.selectAllBusiness();
            }
            for (Business b : businesses) {
                Integer username = b.getUsername();
                Float avg = productMapper.getAvg(username);
                if (avg == null) {
                    avg = 0f;
                } else {
                    int v = (int) (avg * 10);
                    avg = v / 10.0f;
                }
                b.setGrade(avg);
            }
            PageBean<Business> pageBean = new PageBean<>();
            initPageBean(pageBean, getBusTotal(business), row);
            pageBean.setList(businesses);
            return pageBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Comment> findAllComment() {
        try {
            return commentMapper.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public PageBean<Consumer> findAllConsumerByPage(Consumer consumer, Integer row) {
        try {
            List<Consumer> consumers;
            if (consumer != null) {
                consumers = adminMapper.selectConsumerByCon(consumer);
            } else {
                consumers = adminMapper.selectAllConsumer();
            }
            PageBean<Consumer> pageBean = new PageBean<>();
            initPageBean(pageBean, getConTotal(consumer), row);
            pageBean.setList(consumers);
            return pageBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getOrderTotal(Order order) {
        try {
            return adminMapper.selectOrderTotal(order);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int getBusTotal(Business business) {
        try {
            return adminMapper.selectBusinessTotal(business);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int getConTotal(Consumer consumer) {
        try {
            return adminMapper.selectConsumerTotal(consumer);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }


}
