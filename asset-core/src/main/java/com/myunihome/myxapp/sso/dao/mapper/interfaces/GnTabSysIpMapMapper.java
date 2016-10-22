package com.myunihome.myxapp.sso.dao.mapper.interfaces;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSysIpMap;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSysIpMapCriteria;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSysIpMapKey;

public interface GnTabSysIpMapMapper {
    int countByExample(GnTabSysIpMapCriteria example);

    int deleteByExample(GnTabSysIpMapCriteria example);

    int deleteByPrimaryKey(GnTabSysIpMapKey key);

    int insert(GnTabSysIpMap record);

    int insertSelective(GnTabSysIpMap record);

    List<GnTabSysIpMap> selectByExample(GnTabSysIpMapCriteria example);

    GnTabSysIpMap selectByPrimaryKey(GnTabSysIpMapKey key);

    int updateByExampleSelective(@Param("record") GnTabSysIpMap record, @Param("example") GnTabSysIpMapCriteria example);

    int updateByExample(@Param("record") GnTabSysIpMap record, @Param("example") GnTabSysIpMapCriteria example);

    int updateByPrimaryKeySelective(GnTabSysIpMap record);

    int updateByPrimaryKey(GnTabSysIpMap record);
}