package com.Alice.service;

import com.Alice.domain.Dict;

import java.util.List;

public interface DictService {
    List<Dict> findByCode(String dict_type_code);
}
