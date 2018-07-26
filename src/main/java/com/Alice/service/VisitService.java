package com.Alice.service;

import com.Alice.domain.PageBean;
import com.Alice.domain.Visit;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @author Alice
 * @date 2018/7/26/026-11:31
 */
public interface VisitService {
    PageBean<Visit> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

    void save(Visit visit);
}
