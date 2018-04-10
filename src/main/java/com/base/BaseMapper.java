package com.base;

import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T extends BaseModel> {

    int deleteByPrimaryKey(Map<String, Object> params);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Map<String, Object> params);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    List<T> selectAll();

    Page<T> findByCondition(Map<String, Object> params);
}
