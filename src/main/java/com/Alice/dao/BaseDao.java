package com.Alice.dao;

import com.Alice.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 *以后所有Dao的接口都需要继承BaseDao
 */
public interface BaseDao<T> {

    void save(T t);

    void delete(T t);

    void update(T t);

    T findById(Long id);

    List<T> findAll();

    PageBean<T> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);



}
