package com.Alice.dao;

import com.Alice.domain.Customer;

import java.util.List;

public interface CustomerDao extends BaseDao<Customer>{

    List<Object[]> findBySource();
    //PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

    //void save(Customer customer);

    //Customer findById(Long cust_id);

    //void delete(Customer customer);

    //void update(Customer customer);
}
