package com.Alice.dao;

import com.Alice.domain.Visit;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author Alice
 * @date 2018/7/26/026-11:22
 */
@Repository(value = "visitDao")
public class VisitDaoImpl extends BaseDaoImpl<Visit> implements VisitDao {

    @Resource(name = "sessionFactory")
    public void set2SessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }
}
