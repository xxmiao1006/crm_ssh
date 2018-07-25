package com.Alice.service;

import com.Alice.domain.Linkman;
import com.Alice.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @author Alice
 * @date 2018-07-2018/7/25/025-16:30
 */
public interface LinkmanService {
    PageBean<Linkman> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);
}
