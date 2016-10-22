package com.myunihome.myxapp.common.dao.mapper.interfaces;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.myunihome.myxapp.common.dao.mapper.bo.GnChannel;
import com.myunihome.myxapp.common.dao.mapper.bo.GnChannelCriteria;

public interface GnChannelMapper {
    int countByExample(GnChannelCriteria example);

    int deleteByExample(GnChannelCriteria example);

    int insert(GnChannel record);

    int insertSelective(GnChannel record);

    List<GnChannel> selectByExample(GnChannelCriteria example);

    int updateByExampleSelective(@Param("record") GnChannel record, @Param("example") GnChannelCriteria example);

    int updateByExample(@Param("record") GnChannel record, @Param("example") GnChannelCriteria example);
}