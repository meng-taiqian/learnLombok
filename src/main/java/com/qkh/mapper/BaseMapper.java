package com.qkh.mapper;

import java.util.List;

public interface BaseMapper<T, PK> {

    T selectByPrimaryKey(PK pk);

    List<T> selectList();

    int insert(T t);

    int insertSelective(T t);

    int updateByPrimaryKey(T t);

    int updateByPrimaryKeySelective(T t);

    int delete(PK pk);
}
