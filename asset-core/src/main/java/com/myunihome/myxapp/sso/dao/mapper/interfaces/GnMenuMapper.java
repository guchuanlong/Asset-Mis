package com.myunihome.myxapp.sso.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myunihome.myxapp.sso.dao.mapper.bo.GnMenu;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnMenuCriteria;

public interface GnMenuMapper {
    
    int countByExample(GnMenuCriteria example);

    int deleteByExample(GnMenuCriteria example);

    int deleteByPrimaryKey(Long menuId);

    Long insert(GnMenu record);

    Long insertSelective(GnMenu record);

    List<GnMenu> selectByExample(GnMenuCriteria example);
    
    GnMenu selectByPrimaryKey(Long menuId);
    
    int updateByExampleSelective(@Param("record") GnMenu record, @Param("example") GnMenuCriteria example);

    int updateByExample(@Param("record") GnMenu record, @Param("example") GnMenuCriteria example);

    int updateByPrimaryKeySelective(GnMenu record);

    int updateByPrimaryKey(GnMenu record);
}