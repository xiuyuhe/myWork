package com.qihoo360os.service.impl;

import com.qihoo360os.entity.RealHoaxes;
import com.qihoo360os.mapper.TpRealHoaxesMapper;
import com.qihoo360os.model.TpRealHoaxes;
import com.qihoo360os.repository.RealHoaxesRepository;
import com.qihoo360os.service.RealHoaxesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by i-hexiuyu on 2017/6/27.
 */
//@Service
@Transactional
public class RealHoaxesServiceImpl implements RealHoaxesService {

    @Autowired
    private RealHoaxesRepository realHoaxesRepository;

    @Autowired
    private TpRealHoaxesMapper realHoaxesMapper;

    /**
     *  use JPA to find all
     * @param pageable
     * @return
     */
    @Override
    public Page<RealHoaxes> findAll(Pageable pageable) {
        return  realHoaxesRepository.findAll(pageable);
    }

    /**
     *  use Mybatis to find all
     * @return
     */
    @Override
    public List<TpRealHoaxes> selectAll() {
        return realHoaxesMapper.selectAll();
    }

}
