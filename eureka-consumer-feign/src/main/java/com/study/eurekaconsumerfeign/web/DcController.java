package com.study.eurekaconsumerfeign.web;

import com.study.eurekaconsumerfeign.domain.Dept;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "消费者调用client的服务")
@RestController
public class DcController {
    DcClient dcClient;

    public DcController(DcClient dcClient) {
        this.dcClient = dcClient;
    }

    @GetMapping("/consumer")
    public String dc() {
        return dcClient.consumer();
    }

    @PostMapping("/consumer/deptNo/")
    public Object dcByDeptNo(@RequestParam Integer deptNo) {
        return dcClient.consumerByDeptNo(deptNo);
    }

    @ApiOperation(value = "创建一个部门", notes = "根据Dept对象创建部门")
    @PostMapping("/consumer/")
    public String dcByDeptNo(@RequestBody com.study.eurekaconsumerfeign.domain.Dept dept) {
        return dcClient.consumerAddDept(dept);
    }

}
