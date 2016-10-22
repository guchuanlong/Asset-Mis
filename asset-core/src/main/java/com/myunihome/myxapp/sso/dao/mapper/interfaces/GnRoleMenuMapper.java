package com.myunihome.myxapp.sso.dao.mapper.interfaces;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.myunihome.myxapp.sso.dao.mapper.bo.GnRoleMenu;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnRoleMenuCriteria;

public interface GnRoleMenuMapper {
    int countByExample(GnRoleMenuCriteria example);

    int deleteByExample(GnRoleMenuCriteria example);

    int deleteByPrimaryKey(Long roleMenuRelId);

    int insert(GnRoleMenu record);

    int insertSelective(GnRoleMenu record);

    List<GnRoleMenu> selectByExample(GnRoleMenuCriteria example);
    
    GnRoleMenu selectByPrimaryKey(Long roleMenuRelId);

    int updateByExampleSelective(@Param("record") GnRoleMenu record, @Param("example") GnRoleMenuCriteria example);

    int updateByExample(@Param("record") GnRoleMenu record, @Param("example") GnRoleMenuCriteria example);

    int updateByPrimaryKeySelective(GnRoleMenu record);

    int updateByPrimaryKey(GnRoleMenu record);
}