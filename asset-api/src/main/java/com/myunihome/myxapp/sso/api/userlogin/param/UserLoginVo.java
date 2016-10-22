package com.myunihome.myxapp.sso.api.userlogin.param;

import java.io.Serializable;
import java.sql.Timestamp;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 
 * @author zhangbc
 * 用户登录参数
 */
public class UserLoginVo extends BaseInfo implements Serializable {
	
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 用户登录ID
	 */
    private Long userLoginId;

    /**
	 * 状态
	 */
    private String state;

    /**
	 * 生效时间
	 */
    private Timestamp activeTime;

    /**
	 * 失效时间
	 */
    private Timestamp inactiveTime;

    /**
	 * 备注
	 */
    private String remark;

    /**
	 * 用户名
	 */
    private String userName;
    
    /**
	 * 密码
	 */
    private String userPasswd;

    /**
	 * 手机号
	 */
    private String userIphone;

    /**
	 * 邮箱
	 */
    private String userMail;
    
    /**
     * 新密码（修改密码使用）
     */
    private String newPassword;

  

	public String getUserPasswd() {
		return userPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}

	public String getUserIphone() {
		return userIphone;
	}

	public void setUserIphone(String userIphone) {
		this.userIphone = userIphone;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(Long userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Timestamp getActiveTime() {
		return activeTime == null?null:new Timestamp(activeTime.getTime());
	}

	public void setActiveTime(Timestamp activeTime) {
		this.activeTime = (activeTime == null?null:new Timestamp(activeTime.getTime()));
	}

	public Timestamp getInactiveTime() {
		return inactiveTime == null?null:new Timestamp(inactiveTime.getTime());
	}

	public void setInactiveTime(Timestamp inactiveTime) {
		this.inactiveTime = (inactiveTime == null?null:new Timestamp(inactiveTime.getTime()));
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}


	
	

}
