package com.Alice.dao;

import com.Alice.domain.Dict;

import java.util.List;

public interface DictDao {
    List<Dict> findByCode(String dict_type_code);
}
