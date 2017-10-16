package com.qkh.service.impl;

import com.qkh.mapper.BaseMapper;
import com.qkh.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class  ServiceImpl<M extends BaseMapper<T, PK>, T, PK> implements IService<T, PK>{

    @Autowired
    private M m;

    @Override
    public T selectByPrimaryKey(PK pk) {
        return m.selectByPrimaryKey(pk);
    }

    @Override
    public List<T> selectList() {
        return m.selectList();
    }

    @Override
    public int insert(T t) {
        return m.insert(t);
    }

    @Override
    public int insertSelective(T t) {
        return m.insertSelective(t);
    }

    @Override
    public int update(T t) {
        return m.updateByPrimaryKey(t);
    }

    @Override
    public int updateSelective(T t) {
        return m.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(PK pk) {
        return m.delete(pk);
    }
}
