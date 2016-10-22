package com.myunihome.myxapp.sso.api.staffnoquery.interfaces;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.sso.api.staffnoquery.param.StaffNoInfoQuery;
import com.myunihome.myxapp.sso.api.staffnoquery.param.StaffNoVo;
/**
 * 
 * Date: 2015年8月17日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author zhouyy5
 */
public interface IStaffNoQuerySV {
	

   /**
    * 根据员工id或员工名称（模糊查询）返回工号列表服务<br>
    * @param vo 
    * 参数 员工id(staffId)和员工名称(staffName)不能同时为空 ，
    * pageNumber(查询页码)必填、pageSize(一页显示条数)必填、租户id(tenantId) 必填<br>
    * @return StaffNoInfoQuery<br>
    * @author zhouyy5<br>
    * @ApiDocMethod
    * @ApiCode SYS_0010
    */
	StaffNoInfoQuery queryStaffNo(StaffNoVo vo) throws CallerException;

}
