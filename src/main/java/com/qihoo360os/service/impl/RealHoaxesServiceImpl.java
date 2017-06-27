package com.qihoo360os.service.impl;

import com.qihoo360os.entity.RealHoaxes;
import com.qihoo360os.repository.RealHoaxesRepository;
import com.qihoo360os.service.RealHoaxesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by i-hexiuyu on 2017/6/27.
 */
@Service
public class RealHoaxesServiceImpl implements RealHoaxesService {

    @Autowired
    private RealHoaxesRepository realHoaxesRepository;

    @Override
    public Page<RealHoaxes> findAll(Pageable pageable) {
        return  realHoaxesRepository.findAll(pageable);

    }


}
