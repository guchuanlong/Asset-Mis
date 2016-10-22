package com.myunihome.myxapp.common.dao.mapper.interfaces;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.myunihome.myxapp.common.dao.mapper.bo.GnDepart;
import com.myunihome.myxapp.common.dao.mapper.bo.GnDepartCriteria;

public interface GnDepartMapper {
    int countByExample(GnDepartCriteria example);

    int deleteByExample(GnDepartCriteria example);

    int deleteByPrimaryKey(String departId);

    int insert(GnDepart record);

    int insertSelective(GnDepart record);

    List<GnDepart> selectByExample(GnDepartCriteria example);

    GnDepart selectByPrimaryKey(String departId);

    int updateByExampleSelective(@Param("record") GnDepart record, @Param("example") GnDepartCriteria example);

    int updateByExample(@Param("record") GnDepart record, @Param("example") GnDepartCriteria example);

    int updateByPrimaryKeySelective(GnDepart record);

    int updateByPrimaryKey(GnDepart record);
}