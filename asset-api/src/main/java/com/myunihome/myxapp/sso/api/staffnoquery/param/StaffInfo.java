package com.myunihome.myxapp.sso.api.staffnoquery.param;

import java.sql.Timestamp;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 员工信息<br> 
 * Date: 2015年8月17日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author zhouyy5
 */
public class StaffInfo extends BaseInfo {

    private static final long serialVersionUID = 2579255457536164067L;
    /**
     * 员工id
     */
    private String staffId;
    /**
     * 员工名称
     */
    private String staffName;

    /**
     * 员工编码
     */
    private String staffNo;

    /**
     * 工号Id
     */
    private Long staffnoId;

    /**
     * 工号密码
     */

    private String staffPasswd;

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
     * 创建时间
     */

    private Timestamp createTime;

    /**
     * 创建人
     */

    private Long createOperId;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 更新人
     */
    private Long updateOperId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 密码更新时间
     */
    private Timestamp pwdUpdateTime;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public Long getStaffnoId() {
        return staffnoId;
    }

    public void setStaffnoId(Long staffnoId) {
        this.staffnoId = staffnoId;
    }

    public String getStaffPasswd() {
        return staffPasswd;
    }

    public void setStaffPasswd(String staffPasswd) {
        this.staffPasswd = staffPasswd;
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

    public Timestamp getCreateTime() {
        return createTime == null?null:new Timestamp(createTime.getTime());
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = (createTime == null?null:new Timestamp(createTime.getTime()));
    }

    public Long getCreateOperId() {
        return createOperId;
    }

    public void setCreateOperId(Long createOperId) {
        this.createOperId = createOperId;
    }

    public Timestamp getUpdateTime() {
        return updateTime == null?null:new Timestamp(updateTime.getTime());
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = (updateTime == null?null:new Timestamp(updateTime.getTime()));
    }

    public Long getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(Long updateOperId) {
        this.updateOperId = updateOperId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getPwdUpdateTime() {
        return pwdUpdateTime == null?null:new Timestamp(pwdUpdateTime.getTime());
    }

    public void setPwdUpdateTime(Timestamp pwdUpdateTime) {
        this.pwdUpdateTime = (pwdUpdateTime == null?null:new Timestamp(pwdUpdateTime.getTime()));
    }

}
