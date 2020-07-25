package com.wk.service;

import com.wk.util.R;
import org.springframework.stereotype.Component;

/**
 * feign的熔断类
 */
@Component
public class PowerFeignClientFallBack implements PowerFeignClient {
    @Override
    public Object getPower() {
        return R.error("测试降级");
    }
}
