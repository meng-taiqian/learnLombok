package com.qkh.service;

import java.util.List;

public interface IService<T, PK> {

    T selectByPrimaryKey(PK pk);

    List<T> selectList();

    int insert(T t);

    int insertSelective(T t);

    int update(T t);

    int updateSelective(T t);

    int delete(PK pk);
}
