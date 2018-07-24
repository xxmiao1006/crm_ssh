package com.Alice.dao;

import com.Alice.domain.Customer;
import com.Alice.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface CustomerDao {
    PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

    void save(Customer customer);

    Customer findById(Long cust_id);

    void delete(Customer customer);
}
