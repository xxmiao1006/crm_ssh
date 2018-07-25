package com.Alice.service;

import com.Alice.domain.Customer;
import com.Alice.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerService {
    PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

    void save(Customer customer);

    Customer findById(Long cust_id);

    void delete(Customer customer);

    void update(Customer customer);

    List<Customer> findAll();
}
