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

    /**
     * 添加联系人
     * @param linkman
     */
    public void add(Linkman linkman) {
        linkmanDao.save(linkman);
    }

    /**
     * 通过id查找联系人
     * @param id
     * @return
     */
    public Linkman findById(Long id) {
        return linkmanDao.findById(id);
    }

    @Override
    public void update(Linkman linkman) {
        linkmanDao.update(linkman);
    }

    @Override
    public void delete(Linkman linkman) {
        linkmanDao.delete(linkman);
    }
}
