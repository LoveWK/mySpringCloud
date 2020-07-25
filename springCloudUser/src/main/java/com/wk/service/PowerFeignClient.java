package com.wk.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * feign客户端
 */
//@FeignClient(name = "SERVER-POWER",fallback = PowerFeignClientFallBack.class)
@FeignClient(name = "SERVER-POWER",fallbackFactory = PowerFeignClientFallBackFactory.class)
public interface PowerFeignClient {

    @RequestMapping("/getPower.do")
    public Object getPower();
}
