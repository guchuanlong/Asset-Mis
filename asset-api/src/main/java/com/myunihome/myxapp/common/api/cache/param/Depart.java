package com.myunihome.myxapp.common.api.cache.param;

import java.io.Serializable;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 部门详情<br>
 * Date: 2015年11月12日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 *
 * @author gucl
 */
public class Depart extends BaseInfo implements Serializable {
    /**
     * 机构编码
     */
    private String departId;
    /**
     * 机构名称
     */
    private String departName;
    /**
     * 机构类别
     */
    private String departKindType;
    /**
     * 机构级别
     */
    private String departLevel;
    /**
     * 归属省份编码
     */
    private String provinceCode;
    /**
     * 归属地市编码
     */
    private String cityCode;
    /**
     * 归属区域编码
     */
    private String areaCode;
    /**
     * 区域名称
     */
    private String areaName;

    /**
     * 区域级别 0：全国  1：省 2：地市  3：区县 4：街道 5：小区
     */
    private String areaLevel;
    /**
     * 上级机构编码
     */
    private String parentDepartId;
    /**
     * 上级机构名称
     */
    private String parentDepartName;
    /**
     * 统计排序号
     */
    private int sortId;
    /**
     * 联系人
     */
    private String contactName;
    /**
     * 联系电话
     */
    private String contactTel;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 邮政编码
     */
    private String postcode;
    
    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getDepartKindType() {
        return departKindType;
    }

    public void setDepartKindType(String departKindType) {
        this.departKindType = departKindType;
    }

    public String getDepartLevel() {
        return departLevel;
    }

    public void setDepartLevel(String departLevel) {
        this.departLevel = departLevel;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getParentDepartId() {
        return parentDepartId;
    }

    public void setParentDepartId(String parentDepartId) {
        this.parentDepartId = parentDepartId;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }


    public String getParentDepartName() {
        return parentDepartName;
    }

    public void setParentDepartName(String parentDepartName) {
        this.parentDepartName = parentDepartName;
    }

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaLevel() {
		return areaLevel;
	}

	public void setAreaLevel(String areaLevel) {
		this.areaLevel = areaLevel;
	}
    
}
