package com.study.gatewaydemo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {
    @GetMapping("/fallback")
    @PostMapping("/fallback")
    public String dc() {
        return "哦豁，熔断了";
    }
}
