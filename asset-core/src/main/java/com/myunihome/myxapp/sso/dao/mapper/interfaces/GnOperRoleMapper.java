package com.myunihome.myxapp.sso.dao.mapper.interfaces;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperRole;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperRoleCriteria;

public interface GnOperRoleMapper {
    int countByExample(GnOperRoleCriteria example);

    int deleteByExample(GnOperRoleCriteria example);

    int deleteByPrimaryKey(Long operRoleRelId);

    int insert(GnOperRole record);

    int insertSelective(GnOperRole record);

    List<GnOperRole> selectByExample(GnOperRoleCriteria example);

    GnOperRole selectByPrimaryKey(Long operRoleRelId);

    int updateByExampleSelective(@Param("record") GnOperRole record, @Param("example") GnOperRoleCriteria example);

    int updateByExample(@Param("record") GnOperRole record, @Param("example") GnOperRoleCriteria example);

    int updateByPrimaryKeySelective(GnOperRole record);

    int updateByPrimaryKey(GnOperRole record);
}