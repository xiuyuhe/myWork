package com.qihoo360os.mapper;

import com.qihoo360os.entity.RealHoaxesMB;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by i-hexiuyu on 2017/6/27.
 */

@Mapper
public interface RealHoaxesMapper {

    @Select("SELECT * FROM tp_real_hoaxes limit 10")
    List<RealHoaxesMB> findAll();

}
