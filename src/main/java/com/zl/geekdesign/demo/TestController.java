package com.zl.geekdesign.demo;

import com.zl.geekdesign.demo.entity.T3;
import com.zl.geekdesign.demo.mapper.T3Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zhanglong on 2020/4/8
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    private T3Mapper t2Mapper;

    @GetMapping("/insert")
    public String insert() {
        for (int i = 101; i <= 100000; i++) {
            T3 t2 = new T3(i, i, i);
            t2Mapper.insert(t2);

        }
        return "success";
    }
}
