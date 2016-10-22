package com.myunihome.myxapp.common.service.business.channel;

import java.util.List;

import com.myunihome.myxapp.common.api.channel.param.GnChlKindVo;

public interface IGnChlKindBusiSV {
	 /**
	    * 查询所有的渠道类型
	    * @return
	    * @author zhanglh
	    * @ApiDocMethod
	    * @ApiCode GN_0502
	    */
	    List<GnChlKindVo> queryChlKinds();

}
