package com.myunihome.myxapp.sso.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myunihome.myxapp.sso.dao.mapper.bo.GnUserLogin;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnUserLoginCriteria;

public interface GnUserLoginMapper {
    int countByExample(GnUserLoginCriteria example);

    int deleteByExample(GnUserLoginCriteria example);

    int deleteByPrimaryKey(Long userLoginId);

    int insert(GnUserLogin record);

    int insertSelective(GnUserLogin record);

    List<GnUserLogin> selectByExample(GnUserLoginCriteria example);

    GnUserLogin selectByPrimaryKey(Long userLoginId);
    
    int updateByExampleSelective(@Param("record") GnUserLogin record, @Param("example") GnUserLoginCriteria example);

    int updateByExample(@Param("record") GnUserLogin record, @Param("example") GnUserLoginCriteria example);

    int updateByPrimaryKeySelective(GnUserLogin record);

    int updateByPrimaryKey(GnUserLogin record);
}