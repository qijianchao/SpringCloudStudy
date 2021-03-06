package com.study.eurekaconsumerfeign.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(description = "部门实体")
public class Dept {
    @NotNull
    @ApiModelProperty("部门编号")
    private Integer deptNo;
    @NotNull
    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("部门描述")
    private String deptDesc;

    public Dept(String deptName, String deptDesc) {
        this.deptName = deptName;
        this.deptDesc = deptDesc;
    }

    public Dept() {
    }
}
