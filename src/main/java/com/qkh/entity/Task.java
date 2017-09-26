package com.qkh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private String type;

    private String taskName;

    private boolean finsh;

    private int taskId;

    public String toString(){
        return "task:{type:" + this.getType() + ", taskName:" + this.getTaskName() + ", finsh:" + this.isFinsh() + ", taskId:" + this.getTaskId() + "}";
    }
}
