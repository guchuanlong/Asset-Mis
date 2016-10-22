package com.myunihome.myxapp.sso.dao.mapper.factory;

import javax.annotation.PostConstruct;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myunihome.myxapp.common.dao.mapper.interfaces.GnAreaMapper;
import com.myunihome.myxapp.common.dao.mapper.interfaces.GnCfgPropertiesMapper;
import com.myunihome.myxapp.common.dao.mapper.interfaces.GnChannelMapper;
import com.myunihome.myxapp.common.dao.mapper.interfaces.GnChlKindMapper;
import com.myunihome.myxapp.common.dao.mapper.interfaces.GnDepartMapper;
import com.myunihome.myxapp.common.dao.mapper.interfaces.GnServiceRouteConfigMapper;
import com.myunihome.myxapp.common.dao.mapper.interfaces.GnSettleRuleMapper;
import com.myunihome.myxapp.common.dao.mapper.interfaces.GnStaffMapper;
import com.myunihome.myxapp.common.dao.mapper.interfaces.GnSubjectFundMapper;
import com.myunihome.myxapp.common.dao.mapper.interfaces.GnSubjectMapper;
import com.myunihome.myxapp.common.dao.mapper.interfaces.GnSysParamMapper;
import com.myunihome.myxapp.common.dao.mapper.interfaces.GnTenantMapper;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnMenuMapper;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnOperAreaMapper;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnOperMapper;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnOperRoleMapper;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnRoleMapper;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnRoleMenuMapper;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnStaffnoMapper;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnSystemModeMapper;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnTabSysIpMapMapper;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnTabSystemMapper;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnUserLoginMapper;

@Component
public class MapperFactory {

    private static SqlSessionTemplate sqlSessionTemplate;
    
    @Autowired
    private SqlSessionTemplate st;

    @PostConstruct
    void init() {
        setSqlSessionTemplate(st);
    }
    
    public static SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public static void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        MapperFactory.sqlSessionTemplate = sqlSessionTemplate;
    }

    public static GnUserLoginMapper getGnUserLoginMapper() {
        return sqlSessionTemplate.getMapper(GnUserLoginMapper.class);
    }

    public static GnOperMapper getGnOperMapper(){
    	return sqlSessionTemplate.getMapper(GnOperMapper.class);
    }
    
    public static GnOperRoleMapper getGnOperRoleMapper(){
    	return sqlSessionTemplate.getMapper(GnOperRoleMapper.class);
    }
    
    public static GnOperAreaMapper getGnOperAreaMapper(){
    	return sqlSessionTemplate.getMapper(GnOperAreaMapper.class);
    }
    
    public static GnRoleMenuMapper getGnRoleMenuMapper(){
    	return sqlSessionTemplate.getMapper(GnRoleMenuMapper.class);
    }
    
    public static GnMenuMapper getGnMenuMapper(){
    	return sqlSessionTemplate.getMapper(GnMenuMapper.class);
    }
    
    public static GnRoleMapper getGnRoleMapper(){
    	return sqlSessionTemplate.getMapper(GnRoleMapper.class);
    }
    
    public static GnStaffnoMapper getGnStaffnoMapper(){
    	return sqlSessionTemplate.getMapper(GnStaffnoMapper.class);
    }
    
    public static GnTabSysIpMapMapper getGnTabSysIpMapMapper(){
    	return sqlSessionTemplate.getMapper(GnTabSysIpMapMapper.class);
    }
    
    public static GnTabSystemMapper getGnTabSystemMapper(){
    	return sqlSessionTemplate.getMapper(GnTabSystemMapper.class);
    }
    
    public static GnSystemModeMapper getGnSystemModeMapper(){
    	return sqlSessionTemplate.getMapper(GnSystemModeMapper.class);
    }
    
    public static GnSysParamMapper getGnSysParamMapper() {
        return sqlSessionTemplate.getMapper(GnSysParamMapper.class);
    }

    public static GnCfgPropertiesMapper getGnCfgPropertiesMapper() {
        return sqlSessionTemplate.getMapper(GnCfgPropertiesMapper.class);
    }

    public static GnServiceRouteConfigMapper getGnServiceRouteConfigMapper() {
        return sqlSessionTemplate.getMapper(GnServiceRouteConfigMapper.class);
    }

    public static GnAreaMapper getGnAreaMapper() {
        return sqlSessionTemplate.getMapper(GnAreaMapper.class);
    }

    public static GnDepartMapper getGnDepartMapper() {
        return sqlSessionTemplate.getMapper(GnDepartMapper.class);
    }

    public static GnStaffMapper getGnStaffMapper() {
        return sqlSessionTemplate.getMapper(GnStaffMapper.class);
    }

    public static GnTenantMapper getGnTenantMapper() {
        return sqlSessionTemplate.getMapper(GnTenantMapper.class);
    }

    public static GnChannelMapper getGnChannelMapper() {
        return sqlSessionTemplate.getMapper(GnChannelMapper.class);
    }

    public static GnSubjectMapper getGnSubjectMapper() {
        return sqlSessionTemplate.getMapper(GnSubjectMapper.class);
    }

    public static GnSubjectFundMapper getGnSubjectFundMapper() {
        return sqlSessionTemplate.getMapper(GnSubjectFundMapper.class);
    }

    public static GnSettleRuleMapper getGnSettleRuleMapper() {
        return sqlSessionTemplate.getMapper(GnSettleRuleMapper.class);
    }

    public static GnChlKindMapper getGnChlKindMapper() {
        return sqlSessionTemplate.getMapper(GnChlKindMapper.class);
    }

}
