package com.myunihome.myxapp.common.dao.mapper.interfaces;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.myunihome.myxapp.common.dao.mapper.bo.GnStaff;
import com.myunihome.myxapp.common.dao.mapper.bo.GnStaffCriteria;

public interface GnStaffMapper {
    int countByExample(GnStaffCriteria example);

    int deleteByExample(GnStaffCriteria example);

    int deleteByPrimaryKey(String staffId);

    int insert(GnStaff record);

    int insertSelective(GnStaff record);

    List<GnStaff> selectByExample(GnStaffCriteria example);

    GnStaff selectByPrimaryKey(String staffId);

    int updateByExampleSelective(@Param("record") GnStaff record, @Param("example") GnStaffCriteria example);

    int updateByExample(@Param("record") GnStaff record, @Param("example") GnStaffCriteria example);

    int updateByPrimaryKeySelective(GnStaff record);

    int updateByPrimaryKey(GnStaff record);
}