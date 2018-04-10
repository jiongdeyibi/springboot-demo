package com.base;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface BaseService<T extends BaseModel> {

    List<T> selectAll();

    List<T> findByCondition(Map<String, Object> params);

    PageInfo<T> findByPage(Map<String, Object> params);

    int deleteByPrimaryKey(Map<String, Object> params);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Map<String, Object> params);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

}