package com.qkh.controller;

import com.qkh.entity.City;
import com.qkh.service.CityService;

import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qiukaihong
 * @since 2017-10-13
 */
@RestController
@Api(tags = "控制器")
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService service;

    @ApiOperation(value = "根据主键获取")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public City get(@PathVariable Integer id){
        return service.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "根据主键删除")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Integer id){
        return service.delete(id);
    }

    @ApiOperation(value = "获取列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<City> selectList(){
        return service.selectList();
    }

    @ApiOperation(value = "新增")
    @RequestMapping(method = RequestMethod.POST)
    public int insert(@Valid City city, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return 0;
        return service.insert(city);
    }

    @ApiOperation(value = "根据主键更新信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public int update(@PathVariable Integer id, City city){
        city.setId(id);
        return service.updateSelective(city);
    }

}
