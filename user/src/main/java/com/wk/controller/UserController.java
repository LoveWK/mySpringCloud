package com.wk.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wk.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    private static final String  POWER_URL="http://SERVER-POWER";
    private static final String  ORDER_URL="http://SERVER-ORDER";


    @RequestMapping("/getUser.do")
    public R getUser(){
        Map<String,Object> map = new HashMap<>();
        map.put("key","user");

        return R.success("返回成功",map);
    }

    @RequestMapping("/getOrder.do")
    public R getOrder(){
        return R.success("操作成功",restTemplate.getForObject(ORDER_URL+"/getOrder.do",Object.class));
    }


//    @RequestMapping("/getFeignPower.do")
//    public R getFeignPower(){
//
//        Object power = powerFeignClient.getPower();
//
//        //  map.put("key","power1");
//
//        //"msg":"power服务暂时不可用","code":"500"}
//
//        powerFeignClient.getPowerList();
//
//        return R.success("操作成功");
//
//    }

    @RequestMapping("/getPower.do")
    @HystrixCommand(threadPoolKey = "power",
            threadPoolProperties ={@HystrixProperty(name = "coreSize",value = "5")
            })
    public R getPower(){
        System.out.println("调用了方法");
        return R.success("操作成功",restTemplate.getForObject(POWER_URL+"/getPower.do",Object.class));
    }


    public R  getFeignPowerFullBack(){
        return R.error("系统正在维护中,请稍后重试");
    }

}
