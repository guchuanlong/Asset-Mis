package com.myunihome.myxapp.sso.dao.mapper.interfaces;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSystem;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSystemCriteria;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSystemKey;

public interface GnTabSystemMapper {
    int countByExample(GnTabSystemCriteria example);

    int deleteByExample(GnTabSystemCriteria example);

    int deleteByPrimaryKey(GnTabSystemKey key);

    int insert(GnTabSystem record);

    int insertSelective(GnTabSystem record);

    List<GnTabSystem> selectByExample(GnTabSystemCriteria example);

    GnTabSystem selectByPrimaryKey(GnTabSystemKey key);

    int updateByExampleSelective(@Param("record") GnTabSystem record, @Param("example") GnTabSystemCriteria example);

    int updateByExample(@Param("record") GnTabSystem record, @Param("example") GnTabSystemCriteria example);

    int updateByPrimaryKeySelective(GnTabSystem record);

    int updateByPrimaryKey(GnTabSystem record);
}