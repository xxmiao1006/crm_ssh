package com.Alice.service;

import com.Alice.dao.LinkmanDao;
import com.Alice.domain.Linkman;
import com.Alice.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Alice
 * @date 2018-07-2018/7/25/025-16:30
 */
@Transactional
public class LinkmanServiceImpl implements LinkmanService{

    private LinkmanDao linkmanDao;
    public void setLinkmanDao(LinkmanDao linkmanDao) {
        this.linkmanDao = linkmanDao;
    }

    @Override
    public PageBean<Linkman> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
        return (PageBean<Linkman>) linkmanDao.findByPage(pageCode,pageSize,criteria);

    }
}
