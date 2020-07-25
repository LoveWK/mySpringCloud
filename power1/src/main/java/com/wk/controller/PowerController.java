package com.wk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PowerController {


    @RequestMapping("/getPower.do")
    public Object getPoser(){
        Map<String,Object> map = new HashMap<>();
        map.put("key","power1");
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return map;
    }

}
