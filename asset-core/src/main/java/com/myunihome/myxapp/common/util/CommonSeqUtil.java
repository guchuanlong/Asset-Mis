package com.myunihome.myxapp.common.util;


import com.myunihome.myxapp.common.constants.Constants;
import com.myunihome.myxapp.paas.sequence.SeqUtil;


 /**
  * 
  *
  * Date: 2015年10月20日 <br>
  * Copyright (c) 2015 asiainfo.com <br>
  * @author zhanglh
  */
public final class CommonSeqUtil {

    private CommonSeqUtil(){
    }
   /**
    * 获取staffId
    * @return
    * @author zhanglh
    * @ApiDocMethod
    * @ApiCode
    */
    public static String getStaffId() {
        return SeqUtil.getNewId(Constants.SEQ.STAFF_ID_SEQ, 10);
    }

    /**
     * 获取departId
     * @return
     * @author zhanglh
     * @ApiDocMethod
     * @ApiCode
     */
     public static String getDepartId(String provinceCode) {
    	 String province="";
    	 if(provinceCode.isEmpty()){
    		  province="00";
    	 }else{
    		  province = provinceCode.substring(0, 2);
    	 }
         String seq = SeqUtil.getNewId(Constants.SEQ.DEPART_ID_SEQ, 8);
         
         return  province + seq;
     }
     
     public static String getAreaCode() {    	 
         return SeqUtil.getNewId(Constants.SEQ.AREA_CODE_SEQ).toString();
     }

    
}
