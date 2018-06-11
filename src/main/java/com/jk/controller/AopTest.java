package com.jk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/4/27 0027.
 */
@RestController
public class AopTest {
    @RequestMapping("/first")
    public Object first(String name) {
        return "first controller";
    }

    @RequestMapping("/doError")
    public Object error() {
        return 1 / 0;
    }
}
