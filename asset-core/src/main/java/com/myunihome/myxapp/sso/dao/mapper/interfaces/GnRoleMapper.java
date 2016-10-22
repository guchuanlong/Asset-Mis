package com.myunihome.myxapp.sso.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myunihome.myxapp.sso.dao.mapper.bo.GnRole;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnRoleCriteria;

public interface GnRoleMapper {
    int countByExample(GnRoleCriteria example);

    int deleteByExample(GnRoleCriteria example);

    int deleteByPrimaryKey(Long roleId);

    Long insert(GnRole record);

    Long insertSelective(GnRole record);

    List<GnRole> selectByExample(GnRoleCriteria example);

    GnRole selectByPrimaryKey(Long roleId);
    
    int updateByExampleSelective(@Param("record") GnRole record, @Param("example") GnRoleCriteria example);

    int updateByExample(@Param("record") GnRole record, @Param("example") GnRoleCriteria example);

    int updateByPrimaryKeySelective(GnRole record);

    int updateByPrimaryKey(GnRole record);
}