package com.myunihome.myxapp.sso.service;

import java.util.List;

import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSystem;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSystemKey;

public interface ITabSystemService {
	List<GnTabSystem> queryGnTabSystemList(GnTabSystemKey tabSystemKey);
	GnTabSystem getGnTabSystem(GnTabSystemKey tabSystemKey);
}
