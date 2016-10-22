package com.myunihome.myxapp.sso.dao.mapper.interfaces;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperArea;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperAreaCriteria;

public interface GnOperAreaMapper {
    int countByExample(GnOperAreaCriteria example);

    int deleteByExample(GnOperAreaCriteria example);

    int deleteByPrimaryKey(long operAreaRelId);

    int insert(GnOperArea record);

    int insertSelective(GnOperArea record);

    List<GnOperArea> selectByExample(GnOperAreaCriteria example);

    GnOperArea selectByPrimaryKey(long operAreaRelId);

    int updateByExampleSelective(@Param("record") GnOperArea record, @Param("example") GnOperAreaCriteria example);

    int updateByExample(@Param("record") GnOperArea record, @Param("example") GnOperAreaCriteria example);

    int updateByPrimaryKeySelective(GnOperArea record);

    int updateByPrimaryKey(GnOperArea record);
}