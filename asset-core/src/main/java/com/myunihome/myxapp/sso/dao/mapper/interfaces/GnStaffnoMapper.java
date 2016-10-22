package com.myunihome.myxapp.sso.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myunihome.myxapp.sso.dao.mapper.bo.GnStaffno;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnStaffnoCriteria;

public interface GnStaffnoMapper {
    
    int countByExample(GnStaffnoCriteria example);

    int deleteByExample(GnStaffnoCriteria example);

    int deleteByPrimaryKey(Long staffnoId);

    int insert(GnStaffno record);

    int insertSelective(GnStaffno record);

    List<GnStaffno> selectByExample(GnStaffnoCriteria example);

    GnStaffno selectByPrimaryKey(Long staffnoId);

    int updateByExampleSelective(@Param("record") GnStaffno record, @Param("example") GnStaffnoCriteria example);

    int updateByExample(@Param("record") GnStaffno record, @Param("example") GnStaffnoCriteria example);

    int updateByPrimaryKeySelective(GnStaffno record);

    int updateByPrimaryKey(GnStaffno record);
}