package com.jk.controller;

import com.jk.model.Aticle;
import com.jk.service.AticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2018/4/19 0019.
 */
@RestController
@RequestMapping("aticleController")
public class AticleController {
    @Autowired
    private AticleService aticleService;

    @RequestMapping("/findAll")
    public List<Aticle> findAll() {
        List<Aticle> aticleList = aticleService.findAll();
        return aticleList;
    }
}
