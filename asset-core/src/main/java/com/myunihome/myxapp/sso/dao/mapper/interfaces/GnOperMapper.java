package com.myunihome.myxapp.sso.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myunihome.myxapp.sso.dao.mapper.bo.GnOper;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperCriteria;

public interface GnOperMapper {
    int countByExample(GnOperCriteria example);

    int deleteByExample(GnOperCriteria example);

    int deleteByPrimaryKey(Long operId);

    int insert(GnOper record);

    int insertSelective(GnOper record);

    List<GnOper> selectByExample(GnOperCriteria example);

    GnOper selectByPrimaryKey(Long operId);

    int updateByExampleSelective(@Param("record") GnOper record, @Param("example") GnOperCriteria example);

    int updateByExample(@Param("record") GnOper record, @Param("example") GnOperCriteria example);
    
    int updateByPrimaryKeySelective(GnOper record);

    int updateByPrimaryKey(GnOper record);
}