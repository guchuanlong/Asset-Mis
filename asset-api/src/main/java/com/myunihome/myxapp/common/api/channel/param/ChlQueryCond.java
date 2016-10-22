package com.myunihome.myxapp.common.api.channel.param;

import com.myunihome.myxapp.base.vo.BaseInfo;
import com.myunihome.myxapp.base.vo.PageInfo;

/**
 * 渠道查询条件
 *
 * Date: 2015年10月12日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author zhanglh
 */
public class ChlQueryCond extends BaseInfo {

	/**
	 * 渠道ID
	 */
	private String chnlId;

	/**
	 * 渠道编码
	 */
	private String chnlCode;

	/**
	 * 渠道名称
	 */
	private String chnlName;
	/**
	 * 渠道所属省分
	 */
	private String provinceCode;

	/**
	 * 渠道所属地市
	 */
	private String cityCode;
	/**
	 * 渠道类型编码
	 */
	private String kindId;
	
	
	/**
	 * 分页信息
	 */
	private PageInfo<GnChannelVo> pageInfo;
	
	public String getChnlId() {
		return chnlId;
	}
	public void setChnlId(String chnlId) {
		this.chnlId = chnlId;
	}
	public String getChnlCode() {
		return chnlCode;
	}
	public void setChnlCode(String chnlCode) {
		this.chnlCode = chnlCode;
	}
	public String getChnlName() {
		return chnlName;
	}
	public void setChnlName(String chnlName) {
		this.chnlName = chnlName;
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
	public String getKindId() {
		return kindId;
	}
	public void setKindId(String kindId) {
		this.kindId = kindId;
	}
	public PageInfo<GnChannelVo> getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo<GnChannelVo> pageInfo) {
		this.pageInfo = pageInfo;
	}
	
}