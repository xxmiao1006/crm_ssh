package com.Alice.service;

import com.Alice.dao.CustomerDao;
import com.Alice.domain.Customer;
import com.Alice.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

/**
 * 客户的业务层
 */
@Transactional
public class CustomerServiceImpl implements CustomerService{
    private CustomerDao customerDao;
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * 分页查询
     * @param pageCode
     * @param pageSize
     * @param criteria
     * @return
     */
    public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
        return customerDao.findByPage(pageCode,pageSize,criteria);
    }

    /**
     * 保存客户的方法
     * @param customer
     */
    public void save(Customer customer) {
        customerDao.save(customer);
    }

    /**
     * 通过id查找客户
     * @param cust_id
     * @return
     */
    public Customer findById(Long cust_id) {
        return customerDao.findById(cust_id);
    }

    /**
     * 删除客户
     * @param customer
     */
    public void delete(Customer customer) {
        customerDao.delete(customer);
    }
}
