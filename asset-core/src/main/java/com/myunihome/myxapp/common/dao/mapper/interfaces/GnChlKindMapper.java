package com.myunihome.myxapp.common.dao.mapper.interfaces;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.myunihome.myxapp.common.dao.mapper.bo.GnChlKind;
import com.myunihome.myxapp.common.dao.mapper.bo.GnChlKindCriteria;

public interface GnChlKindMapper {
    int countByExample(GnChlKindCriteria example);

    int deleteByExample(GnChlKindCriteria example);

    int deleteByPrimaryKey(String kindId);

    int insert(GnChlKind record);

    int insertSelective(GnChlKind record);

    List<GnChlKind> selectByExample(GnChlKindCriteria example);

    GnChlKind selectByPrimaryKey(String kindId);

    int updateByExampleSelective(@Param("record") GnChlKind record, @Param("example") GnChlKindCriteria example);

    int updateByExample(@Param("record") GnChlKind record, @Param("example") GnChlKindCriteria example);

    int updateByPrimaryKeySelective(GnChlKind record);

    int updateByPrimaryKey(GnChlKind record);
}