package com.myunihome.myxapp.common.api.staff.param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 员工查询分页结构对象<br>
 * Date: 2015年8月7日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 *
 * @author zhangxin10
 */
public class StaffPaginationResult implements Serializable {
    /**
     * 在条件的查询出结果的总条数
     */
    private int total;
    /**
     * 此次查询出分页展示的结果集
     */
    private List<GnStaffVo> result = new ArrayList<GnStaffVo>();

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<GnStaffVo> getResult() {
        return result;
    }

    public void setResult(List<GnStaffVo> result) {
        this.result = result;
    }
}
