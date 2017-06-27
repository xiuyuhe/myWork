package com.qihoo360os.service;

import com.qihoo360os.entity.RealHoaxes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by i-hexiuyu on 2017/6/27.
 */
public interface RealHoaxesService {
    Page<RealHoaxes> findAll(Pageable pageable);
}
