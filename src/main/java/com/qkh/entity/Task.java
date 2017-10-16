package com.qkh.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("任务")
public class Task {
    @ApiModelProperty("任务类型")
    private String type;

    private String taskName;

    private boolean finsh;

    private int taskId;

    public String toString(){
        return "task:{type:" + this.getType() + ", taskName:" + this.getTaskName() + ", finsh:" + this.isFinsh() + ", taskId:" + this.getTaskId() + "}";
    }
}
