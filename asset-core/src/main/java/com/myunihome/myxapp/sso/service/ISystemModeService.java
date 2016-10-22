package com.myunihome.myxapp.sso.service;

import java.util.List;

import com.myunihome.myxapp.sso.dao.mapper.bo.GnSystemMode;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnSystemModeKey;

public interface ISystemModeService {
	GnSystemMode queryGnSystemModeByKey(GnSystemModeKey systemModeKey);
	
	List<GnSystemMode> queryGnSystemModeList(GnSystemMode systemMode);
}
