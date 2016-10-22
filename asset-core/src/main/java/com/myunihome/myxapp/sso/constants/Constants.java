package com.myunihome.myxapp.sso.constants;

import com.myunihome.myxapp.paas.util.Md5Encoder;

public final class Constants {

	private Constants() {
	}

	public static final class ResponseState {

		private ResponseState() {
		}

		public final static String SUCCESS = "1";
		public final static String FAILED = "0";

	}

	public static final class RecordsState {

		private RecordsState() {
		}

		public final static String STATE_NORMAL = "01";// 正常
		public final static String STATE_DELETED = "02";// 已注销

	}

	public final static class ErrorCode {
		private ErrorCode() {
		}

		public static final String PARAM_NULL_ERROR = "10001";
		public static final String PARAM_VALUE_ERROR = "10002";
	}
	
	public static final class CreateType{
		private CreateType(){}
		/**
		 * 前台创建
		 */
		public static final String TYPE_CREATE = "1";
		
		/**
		 * 接口同步创建
		 */
		public static final String TYPE_UPDATE = "0";
	}
	
	public static final class StaffPassword{
		private StaffPassword(){}
		
		/**
		 * 初始密码 123456 MD5加密
		 */
		public static final String INIT_PASSWD = Md5Encoder.encodePassword("12345");
	}

}
