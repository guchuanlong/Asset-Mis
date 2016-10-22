package com.myunihome.myxapp.common.api.channel.interfaces;


import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.common.api.channel.param.GnChlKindVo;

/**
 * 公共域-渠道类型管理类
 *
 * Date: 2015年10月12日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * @author zhanglh
 */
public interface IGnChlKindQuerySV {

   /**
    * 查询所有的渠道类型
    * @return
    * @author zhanglh
    * @ApiDocMethod
    * @ApiCode GN_0502
    */
    List<GnChlKindVo> queryChlKinds() throws CallerException;


}
