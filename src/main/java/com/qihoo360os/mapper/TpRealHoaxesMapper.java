package com.qihoo360os.mapper;

import com.qihoo360os.entity.RealHoaxesMB;
import com.qihoo360os.model.TpRealHoaxes;
import com.qihoo360os.model.TpRealHoaxesExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;

@Mapper
public interface TpRealHoaxesMapper {
    long countByExample(TpRealHoaxesExample example);

    int deleteByExample(TpRealHoaxesExample example);

    int deleteByPrimaryKey(Integer realPid);

    int insert(TpRealHoaxes record);

    int insertSelective(TpRealHoaxes record);

    List<TpRealHoaxes> selectByExample(TpRealHoaxesExample example);

    TpRealHoaxes selectByPrimaryKey(Integer realPid);

    int updateByExampleSelective(@Param("record") TpRealHoaxes record, @Param("example") TpRealHoaxesExample example);

    int updateByExample(@Param("record") TpRealHoaxes record, @Param("example") TpRealHoaxesExample example);

    int updateByPrimaryKeySelective(TpRealHoaxes record);

    int updateByPrimaryKey(TpRealHoaxes record);

    @Select("SELECT * FROM tp_real_hoaxes")
    @ResultMap("BaseResultMap")
    List<RealHoaxesMB> findAll();
}