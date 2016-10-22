package com.myunihome.myxapp.common.dao.mapper.interfaces;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.myunihome.myxapp.common.dao.mapper.bo.GnServiceRouteConfig;
import com.myunihome.myxapp.common.dao.mapper.bo.GnServiceRouteConfigCriteria;

public interface GnServiceRouteConfigMapper {
    int countByExample(GnServiceRouteConfigCriteria example);

    int deleteByExample(GnServiceRouteConfigCriteria example);

    int deleteByPrimaryKey(Long routeId);

    int insert(GnServiceRouteConfig record);

    int insertSelective(GnServiceRouteConfig record);

    List<GnServiceRouteConfig> selectByExample(GnServiceRouteConfigCriteria example);

    GnServiceRouteConfig selectByPrimaryKey(Long routeId);

    int updateByExampleSelective(@Param("record") GnServiceRouteConfig record, @Param("example") GnServiceRouteConfigCriteria example);

    int updateByExample(@Param("record") GnServiceRouteConfig record, @Param("example") GnServiceRouteConfigCriteria example);

    int updateByPrimaryKeySelective(GnServiceRouteConfig record);

    int updateByPrimaryKey(GnServiceRouteConfig record);
}