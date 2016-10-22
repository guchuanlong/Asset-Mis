package com.myunihome.myxapp.sso.dao.mapper.interfaces;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.myunihome.myxapp.sso.dao.mapper.bo.GnSystemMode;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnSystemModeCriteria;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnSystemModeKey;

public interface GnSystemModeMapper {
    int countByExample(GnSystemModeCriteria example);

    int deleteByExample(GnSystemModeCriteria example);

    int deleteByPrimaryKey(GnSystemModeKey key);

    int insert(GnSystemMode record);

    int insertSelective(GnSystemMode record);

    List<GnSystemMode> selectByExample(GnSystemModeCriteria example);

    GnSystemMode selectByPrimaryKey(GnSystemModeKey key);

    int updateByExampleSelective(@Param("record") GnSystemMode record, @Param("example") GnSystemModeCriteria example);

    int updateByExample(@Param("record") GnSystemMode record, @Param("example") GnSystemModeCriteria example);

    int updateByPrimaryKeySelective(GnSystemMode record);

    int updateByPrimaryKey(GnSystemMode record);
}