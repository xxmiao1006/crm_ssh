package com.Alice.dao;

import com.Alice.domain.Customer;
import com.Alice.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{

    /**
     * 分页查询
     * @param pageCode
     * @param pageSize
     * @param criteria
     * @return
     */
    public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
        PageBean<Customer> page = new PageBean<>();
        page.setPageCode(pageCode);
        page.setPageSize(pageSize);
        //先查总记录数
        criteria.setProjection(Projections.rowCount());
        List<Number> list = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
        if(list!=null&&list.size()>0){
            int totalCount = list.get(0).intValue();
            //设置总记录数
            page.setTotalCount(totalCount);
        }
        //先清空 变成select *
        criteria.setProjection(null);
        List<Customer> beanList= (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria,( pageCode - 1) * pageSize, pageSize);
        //分页查数据
        page.setBeanList(beanList);
        return page;
    }

    /**
     * 保存客户
     * @param customer
     */
    public void save(Customer customer) {
        this.getHibernateTemplate().save(customer);
    }

    /**
     * 通过id查找客户
     * @param cust_id
     * @return
     */
    public Customer findById(Long cust_id) {
        return this.getHibernateTemplate().get(Customer.class,cust_id);
    }

    /**
     * 删除客户
     * @param customer
     */
    public void delete(Customer customer) {
        this.getHibernateTemplate().delete(customer);
    }
}
