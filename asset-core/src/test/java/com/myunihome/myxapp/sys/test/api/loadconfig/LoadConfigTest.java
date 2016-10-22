package com.myunihome.myxapp.sys.test.api.loadconfig;

import com.myunihome.myxapp.utils.loader.Load2ConfigCenter;

public class LoadConfigTest {
	public static void main(String[] args) {
		System.out.println("开始导入配置。。。。");
		Load2ConfigCenter.main(new String[]{"g:\\dbload"});
		System.out.println("完成导入配置。。。。");
	}
}
