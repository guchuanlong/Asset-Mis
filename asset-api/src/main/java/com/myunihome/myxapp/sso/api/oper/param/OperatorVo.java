package com.myunihome.myxapp.sso.api.oper.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 操作员VO
 * @author Becky
 * 
 */

public class OperatorVo extends BaseInfo implements java.io.Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5334134721780134928L;

	/**
	 * 操作员ID
	 */
    private Long operId;

    /**
     * 操作员编码
     */
    private String operCode;


    
   /**
    * 归属组织类型
    */
    private String orgType;

    /**
     * 归属组织
     */
    private String orgId;

	public Long getOperId() {
		return operId;
	}

	public void setOperId(Long operId) {
		this.operId = operId;
	}

	public String getOperCode() {
		return operCode;
	}

	public void setOperCode(String operCode) {
		this.operCode = operCode;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

    

	
}
