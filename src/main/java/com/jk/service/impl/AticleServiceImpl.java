package com.jk.service.impl;

import com.jk.dao.AticleDao;
import com.jk.model.Aticle;
import com.jk.service.AticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2018/4/19 0019.
 */
@Service("aticleService")
public class AticleServiceImpl implements AticleService{
    @Autowired
    private AticleDao aticleDao;

    @Override
    public List<Aticle> findAll() {
        return aticleDao.findAll();
    }
}
