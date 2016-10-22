package com.myunihome.myxapp.common.service.atom.channel;

import java.util.List;

import com.myunihome.myxapp.common.api.channel.param.GnChlKindVo;
import com.myunihome.myxapp.common.dao.mapper.bo.GnChlKind;

public interface IGnChlKindAtomSV {
	 /**
	    * 查询所有的渠道类型
	    * @return
	    * @author zhanglh
	    * @ApiDocMethod
	    * @ApiCode GN_0502
	    */
	    List<GnChlKind> queryChlKinds();
}
