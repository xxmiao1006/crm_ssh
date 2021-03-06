package com.Alice.dao;

import com.Alice.domain.Customer;

import java.util.List;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{
    @Override
    public List<Object[]> findBySource() {
        String hql = "select c.source.dict_item_name,count(*) from Customer c inner join c.source group by c.source";
        // 查询
        return (List<Object[]>) this.getHibernateTemplate().find(hql);
    }


    /**
     * 分页查询
     * @param pageCode
     * @param pageSize
     * @param criteria
     * @return
     */
    /*public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
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
    }*/

    /**
     * 保存客户
     * @param customer
     */
   /* public void save(Customer customer) {
        this.getHibernateTemplate().save(customer);
    }*/

    /**
     * 通过id查找客户
     * @param cust_id
     * @return
     */
    /*public Customer findById(Long cust_id) {
        return this.getHibernateTemplate().get(Customer.class,cust_id);
    }
*/
    /**
     * 删除客户
     * @param customer
     */
    /*public void delete(Customer customer) {
        this.getHibernateTemplate().delete(customer);
    }

    @Override
    public void update(Customer customer) {
        this.getHibernateTemplate().update(customer);
    }*/
}
