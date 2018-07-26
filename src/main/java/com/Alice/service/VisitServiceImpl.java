package com.Alice.service;

import com.Alice.dao.VisitDao;
import com.Alice.domain.PageBean;
import com.Alice.domain.Visit;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Alice
 * @date 2018/7/26/026-11:32
 */
@Service(value = "visitService")
@Transactional
public class VisitServiceImpl implements VisitService {

    @Resource(name = "visitDao")
    private VisitDao visitDao;

    /**
     * 分页查询所有访问记录
     * @param pageCode
     * @param pageSize
     * @param criteria
     * @return
     */
    public PageBean<Visit> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
        return visitDao.findByPage(pageCode,pageSize,criteria);
    }

    /**
     * 添加访问记录
     * @param visit
     */
    public void save(Visit visit) {
        visitDao.save(visit);
    }
}
