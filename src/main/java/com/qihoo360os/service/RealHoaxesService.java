package com.qihoo360os.service;

import com.qihoo360os.entity.RealHoaxes;
import com.qihoo360os.model.TpRealHoaxes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by i-hexiuyu on 2017/6/27.
 */
public interface RealHoaxesService {
    Page<RealHoaxes> findAll(Pageable pageable);

    List<TpRealHoaxes> selectAll();
}
