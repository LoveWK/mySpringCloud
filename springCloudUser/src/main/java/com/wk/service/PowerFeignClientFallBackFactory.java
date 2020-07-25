package com.wk.service;

import com.wk.util.R;
import feign.hystrix.FallbackFactory;

/**
 * 熔断类
 */
public class PowerFeignClientFallBackFactory implements FallbackFactory<PowerFeignClient> {
    @Override
    public PowerFeignClient create(Throwable throwable) {
        return new PowerFeignClient() {
            @Override
            public Object getPower() {
                //得到具体错误信息
                String message = throwable.getMessage();
                return R.error("测试降级");
            }
        };
    }
}
