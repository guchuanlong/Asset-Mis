package com.myunihome.myxapp.common.dao.mapper.interfaces;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.myunihome.myxapp.common.dao.mapper.bo.GnCfgProperties;
import com.myunihome.myxapp.common.dao.mapper.bo.GnCfgPropertiesCriteria;

public interface GnCfgPropertiesMapper {
    int countByExample(GnCfgPropertiesCriteria example);

    int deleteByExample(GnCfgPropertiesCriteria example);

    int deleteByPrimaryKey(String guidkey);

    int insert(GnCfgProperties record);

    int insertSelective(GnCfgProperties record);

    List<GnCfgProperties> selectByExample(GnCfgPropertiesCriteria example);

    GnCfgProperties selectByPrimaryKey(String guidkey);

    int updateByExampleSelective(@Param("record") GnCfgProperties record, @Param("example") GnCfgPropertiesCriteria example);

    int updateByExample(@Param("record") GnCfgProperties record, @Param("example") GnCfgPropertiesCriteria example);

    int updateByPrimaryKeySelective(GnCfgProperties record);

    int updateByPrimaryKey(GnCfgProperties record);
}