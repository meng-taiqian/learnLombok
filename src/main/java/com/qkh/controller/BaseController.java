package com.qkh.controller;


import com.qkh.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qiukaihong
 * @since 2017-10-11
 */
public class BaseController<T, S extends IService<T, PK>, PK> {

    @Autowired
    private S s;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public T get(@PathVariable PK pk){
        return s.selectByPrimaryKey(pk);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable PK pk){
        return s.delete(pk);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<T> selectList(){
        return s.selectList();
    }

    @RequestMapping(method = RequestMethod.POST)
    public int insert(@Valid T t, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return 0;
        return s.insert(t);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public int update(@PathVariable PK pk, T t){
        try {
            Method m = t.getClass().getMethod("setId", new Class[]{pk.getClass()});
            m.invoke(t, pk);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return s.updateSelective(t);
    }
	
}