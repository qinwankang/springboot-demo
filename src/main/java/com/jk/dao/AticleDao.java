package com.jk.dao;

import com.jk.model.Aticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2018/4/19 0019. 这个是分支
 * --改一下，，，这个是实际上主干
 */
public interface AticleDao extends JpaRepository<Aticle,BigDecimal> {
    List<Aticle> findAll();
    List<Aticle> findAll1();
    List<Aticle> findAll2();
}
