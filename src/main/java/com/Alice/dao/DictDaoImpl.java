package com.Alice.dao;

import com.Alice.domain.Dict;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 字典持久层
 */
public class DictDaoImpl extends HibernateDaoSupport implements DictDao{

    /**
     * 根据客户类别编码查询字典
     * @param dict_type_code
     * @return
     */
    public List<Dict> findByCode(String dict_type_code) {
        return (List<Dict>) this.getHibernateTemplate().find("from Dict where dict_type_code = ?", dict_type_code);
    }
}
