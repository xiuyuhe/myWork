package com.qihoo360os.repository;

import com.qihoo360os.entity.RealHoaxes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by i-hexiuyu on 2017/6/27.
 */

@Repository
public interface RealHoaxesRepository extends JpaRepository<RealHoaxes, Integer>{

}
