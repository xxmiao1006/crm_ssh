package com.Alice.service;

import com.Alice.dao.DictDao;
import com.Alice.domain.Dict;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 字典类的业务逻辑
 */
@Transactional
public class DictServiceImpl implements DictService{

    private DictDao dictDao;
    public void setDictDao(DictDao dictDao) {
        this.dictDao = dictDao;
    }

    /**
     * 根据客户类别编码查询字典
     * @param dict_type_code
     * @return
     */
    public List<Dict> findByCode(String dict_type_code) {
        return dictDao.findByCode(dict_type_code);
    }
}
