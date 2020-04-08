package com.study.eurekaconsumerfeign.web;

import com.study.eurekaconsumerfeign.domain.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("eureka-SpringBoot-study-client")
public interface DcClient {
    @GetMapping("/DeptMybatis/")
    String consumer();

    @PostMapping("/DeptMybatis/deptNo/")
    Object consumerByDeptNo(@RequestParam Integer deptNo);

    @PostMapping("/DeptMybatis/")
    String consumerAddDept(@RequestBody Dept dept);
}
