package com.qkh.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 *
 * </p>
 *
 * @author qiukaihong
 * @since 2017-10-12
 */
@Data
@Accessors(chain = true)
@ApiModel("")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    @TableId(value="ID", type= IdType.AUTO)
    private Integer id;

    /**
     * 城市名称
     */
    @ApiModelProperty(value = "城市名称", required = true )
    @TableField("Name")
    private String name;

    @ApiModelProperty(value = "", required = true )
    @TableField("CountryCode")
    private String countryCode;

    @ApiModelProperty(value = "", required = true )
    @TableField("District")
    private String district;

    @ApiModelProperty(value = "", required = true )
    @TableField("Population")
    private Integer population;


}
