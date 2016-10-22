package com.myunihome.myxapp.common.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class GnChannelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public GnChannelCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andChnlIdIsNull() {
            addCriterion("CHNL_ID is null");
            return (Criteria) this;
        }

        public Criteria andChnlIdIsNotNull() {
            addCriterion("CHNL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChnlIdEqualTo(String value) {
            addCriterion("CHNL_ID =", value, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdNotEqualTo(String value) {
            addCriterion("CHNL_ID <>", value, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdGreaterThan(String value) {
            addCriterion("CHNL_ID >", value, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHNL_ID >=", value, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdLessThan(String value) {
            addCriterion("CHNL_ID <", value, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdLessThanOrEqualTo(String value) {
            addCriterion("CHNL_ID <=", value, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdLike(String value) {
            addCriterion("CHNL_ID like", value, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdNotLike(String value) {
            addCriterion("CHNL_ID not like", value, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdIn(List<String> values) {
            addCriterion("CHNL_ID in", values, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdNotIn(List<String> values) {
            addCriterion("CHNL_ID not in", values, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdBetween(String value1, String value2) {
            addCriterion("CHNL_ID between", value1, value2, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdNotBetween(String value1, String value2) {
            addCriterion("CHNL_ID not between", value1, value2, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlCodeIsNull() {
            addCriterion("CHNL_CODE is null");
            return (Criteria) this;
        }

        public Criteria andChnlCodeIsNotNull() {
            addCriterion("CHNL_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andChnlCodeEqualTo(String value) {
            addCriterion("CHNL_CODE =", value, "chnlCode");
            return (Criteria) this;
        }

        public Criteria andChnlCodeNotEqualTo(String value) {
            addCriterion("CHNL_CODE <>", value, "chnlCode");
            return (Criteria) this;
        }

        public Criteria andChnlCodeGreaterThan(String value) {
            addCriterion("CHNL_CODE >", value, "chnlCode");
            return (Criteria) this;
        }

        public Criteria andChnlCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CHNL_CODE >=", value, "chnlCode");
            return (Criteria) this;
        }

        public Criteria andChnlCodeLessThan(String value) {
            addCriterion("CHNL_CODE <", value, "chnlCode");
            return (Criteria) this;
        }

        public Criteria andChnlCodeLessThanOrEqualTo(String value) {
            addCriterion("CHNL_CODE <=", value, "chnlCode");
            return (Criteria) this;
        }

        public Criteria andChnlCodeLike(String value) {
            addCriterion("CHNL_CODE like", value, "chnlCode");
            return (Criteria) this;
        }

        public Criteria andChnlCodeNotLike(String value) {
            addCriterion("CHNL_CODE not like", value, "chnlCode");
            return (Criteria) this;
        }

        public Criteria andChnlCodeIn(List<String> values) {
            addCriterion("CHNL_CODE in", values, "chnlCode");
            return (Criteria) this;
        }

        public Criteria andChnlCodeNotIn(List<String> values) {
            addCriterion("CHNL_CODE not in", values, "chnlCode");
            return (Criteria) this;
        }

        public Criteria andChnlCodeBetween(String value1, String value2) {
            addCriterion("CHNL_CODE between", value1, value2, "chnlCode");
            return (Criteria) this;
        }

        public Criteria andChnlCodeNotBetween(String value1, String value2) {
            addCriterion("CHNL_CODE not between", value1, value2, "chnlCode");
            return (Criteria) this;
        }

        public Criteria andChnlNameIsNull() {
            addCriterion("CHNL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andChnlNameIsNotNull() {
            addCriterion("CHNL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andChnlNameEqualTo(String value) {
            addCriterion("CHNL_NAME =", value, "chnlName");
            return (Criteria) this;
        }

        public Criteria andChnlNameNotEqualTo(String value) {
            addCriterion("CHNL_NAME <>", value, "chnlName");
            return (Criteria) this;
        }

        public Criteria andChnlNameGreaterThan(String value) {
            addCriterion("CHNL_NAME >", value, "chnlName");
            return (Criteria) this;
        }

        public Criteria andChnlNameGreaterThanOrEqualTo(String value) {
            addCriterion("CHNL_NAME >=", value, "chnlName");
            return (Criteria) this;
        }

        public Criteria andChnlNameLessThan(String value) {
            addCriterion("CHNL_NAME <", value, "chnlName");
            return (Criteria) this;
        }

        public Criteria andChnlNameLessThanOrEqualTo(String value) {
            addCriterion("CHNL_NAME <=", value, "chnlName");
            return (Criteria) this;
        }

        public Criteria andChnlNameLike(String value) {
            addCriterion("CHNL_NAME like", value, "chnlName");
            return (Criteria) this;
        }

        public Criteria andChnlNameNotLike(String value) {
            addCriterion("CHNL_NAME not like", value, "chnlName");
            return (Criteria) this;
        }

        public Criteria andChnlNameIn(List<String> values) {
            addCriterion("CHNL_NAME in", values, "chnlName");
            return (Criteria) this;
        }

        public Criteria andChnlNameNotIn(List<String> values) {
            addCriterion("CHNL_NAME not in", values, "chnlName");
            return (Criteria) this;
        }

        public Criteria andChnlNameBetween(String value1, String value2) {
            addCriterion("CHNL_NAME between", value1, value2, "chnlName");
            return (Criteria) this;
        }

        public Criteria andChnlNameNotBetween(String value1, String value2) {
            addCriterion("CHNL_NAME not between", value1, value2, "chnlName");
            return (Criteria) this;
        }

        public Criteria andChnlDescIsNull() {
            addCriterion("CHNL_DESC is null");
            return (Criteria) this;
        }

        public Criteria andChnlDescIsNotNull() {
            addCriterion("CHNL_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andChnlDescEqualTo(String value) {
            addCriterion("CHNL_DESC =", value, "chnlDesc");
            return (Criteria) this;
        }

        public Criteria andChnlDescNotEqualTo(String value) {
            addCriterion("CHNL_DESC <>", value, "chnlDesc");
            return (Criteria) this;
        }

        public Criteria andChnlDescGreaterThan(String value) {
            addCriterion("CHNL_DESC >", value, "chnlDesc");
            return (Criteria) this;
        }

        public Criteria andChnlDescGreaterThanOrEqualTo(String value) {
            addCriterion("CHNL_DESC >=", value, "chnlDesc");
            return (Criteria) this;
        }

        public Criteria andChnlDescLessThan(String value) {
            addCriterion("CHNL_DESC <", value, "chnlDesc");
            return (Criteria) this;
        }

        public Criteria andChnlDescLessThanOrEqualTo(String value) {
            addCriterion("CHNL_DESC <=", value, "chnlDesc");
            return (Criteria) this;
        }

        public Criteria andChnlDescLike(String value) {
            addCriterion("CHNL_DESC like", value, "chnlDesc");
            return (Criteria) this;
        }

        public Criteria andChnlDescNotLike(String value) {
            addCriterion("CHNL_DESC not like", value, "chnlDesc");
            return (Criteria) this;
        }

        public Criteria andChnlDescIn(List<String> values) {
            addCriterion("CHNL_DESC in", values, "chnlDesc");
            return (Criteria) this;
        }

        public Criteria andChnlDescNotIn(List<String> values) {
            addCriterion("CHNL_DESC not in", values, "chnlDesc");
            return (Criteria) this;
        }

        public Criteria andChnlDescBetween(String value1, String value2) {
            addCriterion("CHNL_DESC between", value1, value2, "chnlDesc");
            return (Criteria) this;
        }

        public Criteria andChnlDescNotBetween(String value1, String value2) {
            addCriterion("CHNL_DESC not between", value1, value2, "chnlDesc");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andChnlKindIdIsNull() {
            addCriterion("CHNL_KIND_ID is null");
            return (Criteria) this;
        }

        public Criteria andChnlKindIdIsNotNull() {
            addCriterion("CHNL_KIND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChnlKindIdEqualTo(String value) {
            addCriterion("CHNL_KIND_ID =", value, "chnlKindId");
            return (Criteria) this;
        }

        public Criteria andChnlKindIdNotEqualTo(String value) {
            addCriterion("CHNL_KIND_ID <>", value, "chnlKindId");
            return (Criteria) this;
        }

        public Criteria andChnlKindIdGreaterThan(String value) {
            addCriterion("CHNL_KIND_ID >", value, "chnlKindId");
            return (Criteria) this;
        }

        public Criteria andChnlKindIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHNL_KIND_ID >=", value, "chnlKindId");
            return (Criteria) this;
        }

        public Criteria andChnlKindIdLessThan(String value) {
            addCriterion("CHNL_KIND_ID <", value, "chnlKindId");
            return (Criteria) this;
        }

        public Criteria andChnlKindIdLessThanOrEqualTo(String value) {
            addCriterion("CHNL_KIND_ID <=", value, "chnlKindId");
            return (Criteria) this;
        }

        public Criteria andChnlKindIdLike(String value) {
            addCriterion("CHNL_KIND_ID like", value, "chnlKindId");
            return (Criteria) this;
        }

        public Criteria andChnlKindIdNotLike(String value) {
            addCriterion("CHNL_KIND_ID not like", value, "chnlKindId");
            return (Criteria) this;
        }

        public Criteria andChnlKindIdIn(List<String> values) {
            addCriterion("CHNL_KIND_ID in", values, "chnlKindId");
            return (Criteria) this;
        }

        public Criteria andChnlKindIdNotIn(List<String> values) {
            addCriterion("CHNL_KIND_ID not in", values, "chnlKindId");
            return (Criteria) this;
        }

        public Criteria andChnlKindIdBetween(String value1, String value2) {
            addCriterion("CHNL_KIND_ID between", value1, value2, "chnlKindId");
            return (Criteria) this;
        }

        public Criteria andChnlKindIdNotBetween(String value1, String value2) {
            addCriterion("CHNL_KIND_ID not between", value1, value2, "chnlKindId");
            return (Criteria) this;
        }

        public Criteria andSelfFlagIsNull() {
            addCriterion("SELF_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andSelfFlagIsNotNull() {
            addCriterion("SELF_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andSelfFlagEqualTo(String value) {
            addCriterion("SELF_FLAG =", value, "selfFlag");
            return (Criteria) this;
        }

        public Criteria andSelfFlagNotEqualTo(String value) {
            addCriterion("SELF_FLAG <>", value, "selfFlag");
            return (Criteria) this;
        }

        public Criteria andSelfFlagGreaterThan(String value) {
            addCriterion("SELF_FLAG >", value, "selfFlag");
            return (Criteria) this;
        }

        public Criteria andSelfFlagGreaterThanOrEqualTo(String value) {
            addCriterion("SELF_FLAG >=", value, "selfFlag");
            return (Criteria) this;
        }

        public Criteria andSelfFlagLessThan(String value) {
            addCriterion("SELF_FLAG <", value, "selfFlag");
            return (Criteria) this;
        }

        public Criteria andSelfFlagLessThanOrEqualTo(String value) {
            addCriterion("SELF_FLAG <=", value, "selfFlag");
            return (Criteria) this;
        }

        public Criteria andSelfFlagLike(String value) {
            addCriterion("SELF_FLAG like", value, "selfFlag");
            return (Criteria) this;
        }

        public Criteria andSelfFlagNotLike(String value) {
            addCriterion("SELF_FLAG not like", value, "selfFlag");
            return (Criteria) this;
        }

        public Criteria andSelfFlagIn(List<String> values) {
            addCriterion("SELF_FLAG in", values, "selfFlag");
            return (Criteria) this;
        }

        public Criteria andSelfFlagNotIn(List<String> values) {
            addCriterion("SELF_FLAG not in", values, "selfFlag");
            return (Criteria) this;
        }

        public Criteria andSelfFlagBetween(String value1, String value2) {
            addCriterion("SELF_FLAG between", value1, value2, "selfFlag");
            return (Criteria) this;
        }

        public Criteria andSelfFlagNotBetween(String value1, String value2) {
            addCriterion("SELF_FLAG not between", value1, value2, "selfFlag");
            return (Criteria) this;
        }

        public Criteria andFeeCloseFlagIsNull() {
            addCriterion("FEE_CLOSE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFeeCloseFlagIsNotNull() {
            addCriterion("FEE_CLOSE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFeeCloseFlagEqualTo(String value) {
            addCriterion("FEE_CLOSE_FLAG =", value, "feeCloseFlag");
            return (Criteria) this;
        }

        public Criteria andFeeCloseFlagNotEqualTo(String value) {
            addCriterion("FEE_CLOSE_FLAG <>", value, "feeCloseFlag");
            return (Criteria) this;
        }

        public Criteria andFeeCloseFlagGreaterThan(String value) {
            addCriterion("FEE_CLOSE_FLAG >", value, "feeCloseFlag");
            return (Criteria) this;
        }

        public Criteria andFeeCloseFlagGreaterThanOrEqualTo(String value) {
            addCriterion("FEE_CLOSE_FLAG >=", value, "feeCloseFlag");
            return (Criteria) this;
        }

        public Criteria andFeeCloseFlagLessThan(String value) {
            addCriterion("FEE_CLOSE_FLAG <", value, "feeCloseFlag");
            return (Criteria) this;
        }

        public Criteria andFeeCloseFlagLessThanOrEqualTo(String value) {
            addCriterion("FEE_CLOSE_FLAG <=", value, "feeCloseFlag");
            return (Criteria) this;
        }

        public Criteria andFeeCloseFlagLike(String value) {
            addCriterion("FEE_CLOSE_FLAG like", value, "feeCloseFlag");
            return (Criteria) this;
        }

        public Criteria andFeeCloseFlagNotLike(String value) {
            addCriterion("FEE_CLOSE_FLAG not like", value, "feeCloseFlag");
            return (Criteria) this;
        }

        public Criteria andFeeCloseFlagIn(List<String> values) {
            addCriterion("FEE_CLOSE_FLAG in", values, "feeCloseFlag");
            return (Criteria) this;
        }

        public Criteria andFeeCloseFlagNotIn(List<String> values) {
            addCriterion("FEE_CLOSE_FLAG not in", values, "feeCloseFlag");
            return (Criteria) this;
        }

        public Criteria andFeeCloseFlagBetween(String value1, String value2) {
            addCriterion("FEE_CLOSE_FLAG between", value1, value2, "feeCloseFlag");
            return (Criteria) this;
        }

        public Criteria andFeeCloseFlagNotBetween(String value1, String value2) {
            addCriterion("FEE_CLOSE_FLAG not between", value1, value2, "feeCloseFlag");
            return (Criteria) this;
        }

        public Criteria andDepartIdIsNull() {
            addCriterion("DEPART_ID is null");
            return (Criteria) this;
        }

        public Criteria andDepartIdIsNotNull() {
            addCriterion("DEPART_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDepartIdEqualTo(String value) {
            addCriterion("DEPART_ID =", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdNotEqualTo(String value) {
            addCriterion("DEPART_ID <>", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdGreaterThan(String value) {
            addCriterion("DEPART_ID >", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEPART_ID >=", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdLessThan(String value) {
            addCriterion("DEPART_ID <", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdLessThanOrEqualTo(String value) {
            addCriterion("DEPART_ID <=", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdLike(String value) {
            addCriterion("DEPART_ID like", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdNotLike(String value) {
            addCriterion("DEPART_ID not like", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdIn(List<String> values) {
            addCriterion("DEPART_ID in", values, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdNotIn(List<String> values) {
            addCriterion("DEPART_ID not in", values, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdBetween(String value1, String value2) {
            addCriterion("DEPART_ID between", value1, value2, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdNotBetween(String value1, String value2) {
            addCriterion("DEPART_ID not between", value1, value2, "departId");
            return (Criteria) this;
        }

        public Criteria andManagerStaffIdIsNull() {
            addCriterion("MANAGER_STAFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andManagerStaffIdIsNotNull() {
            addCriterion("MANAGER_STAFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andManagerStaffIdEqualTo(String value) {
            addCriterion("MANAGER_STAFF_ID =", value, "managerStaffId");
            return (Criteria) this;
        }

        public Criteria andManagerStaffIdNotEqualTo(String value) {
            addCriterion("MANAGER_STAFF_ID <>", value, "managerStaffId");
            return (Criteria) this;
        }

        public Criteria andManagerStaffIdGreaterThan(String value) {
            addCriterion("MANAGER_STAFF_ID >", value, "managerStaffId");
            return (Criteria) this;
        }

        public Criteria andManagerStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("MANAGER_STAFF_ID >=", value, "managerStaffId");
            return (Criteria) this;
        }

        public Criteria andManagerStaffIdLessThan(String value) {
            addCriterion("MANAGER_STAFF_ID <", value, "managerStaffId");
            return (Criteria) this;
        }

        public Criteria andManagerStaffIdLessThanOrEqualTo(String value) {
            addCriterion("MANAGER_STAFF_ID <=", value, "managerStaffId");
            return (Criteria) this;
        }

        public Criteria andManagerStaffIdLike(String value) {
            addCriterion("MANAGER_STAFF_ID like", value, "managerStaffId");
            return (Criteria) this;
        }

        public Criteria andManagerStaffIdNotLike(String value) {
            addCriterion("MANAGER_STAFF_ID not like", value, "managerStaffId");
            return (Criteria) this;
        }

        public Criteria andManagerStaffIdIn(List<String> values) {
            addCriterion("MANAGER_STAFF_ID in", values, "managerStaffId");
            return (Criteria) this;
        }

        public Criteria andManagerStaffIdNotIn(List<String> values) {
            addCriterion("MANAGER_STAFF_ID not in", values, "managerStaffId");
            return (Criteria) this;
        }

        public Criteria andManagerStaffIdBetween(String value1, String value2) {
            addCriterion("MANAGER_STAFF_ID between", value1, value2, "managerStaffId");
            return (Criteria) this;
        }

        public Criteria andManagerStaffIdNotBetween(String value1, String value2) {
            addCriterion("MANAGER_STAFF_ID not between", value1, value2, "managerStaffId");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("PROVINCE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("PROVINCE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(String value) {
            addCriterion("PROVINCE_CODE =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(String value) {
            addCriterion("PROVINCE_CODE <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(String value) {
            addCriterion("PROVINCE_CODE >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE_CODE >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(String value) {
            addCriterion("PROVINCE_CODE <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE_CODE <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLike(String value) {
            addCriterion("PROVINCE_CODE like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotLike(String value) {
            addCriterion("PROVINCE_CODE not like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<String> values) {
            addCriterion("PROVINCE_CODE in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<String> values) {
            addCriterion("PROVINCE_CODE not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(String value1, String value2) {
            addCriterion("PROVINCE_CODE between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("PROVINCE_CODE not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNull() {
            addCriterion("CITY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNotNull() {
            addCriterion("CITY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCityCodeEqualTo(String value) {
            addCriterion("CITY_CODE =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(String value) {
            addCriterion("CITY_CODE <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(String value) {
            addCriterion("CITY_CODE >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CITY_CODE >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(String value) {
            addCriterion("CITY_CODE <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(String value) {
            addCriterion("CITY_CODE <=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLike(String value) {
            addCriterion("CITY_CODE like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotLike(String value) {
            addCriterion("CITY_CODE not like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<String> values) {
            addCriterion("CITY_CODE in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<String> values) {
            addCriterion("CITY_CODE not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(String value1, String value2) {
            addCriterion("CITY_CODE between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(String value1, String value2) {
            addCriterion("CITY_CODE not between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNull() {
            addCriterion("AREA_CODE is null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNotNull() {
            addCriterion("AREA_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeEqualTo(String value) {
            addCriterion("AREA_CODE =", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotEqualTo(String value) {
            addCriterion("AREA_CODE <>", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThan(String value) {
            addCriterion("AREA_CODE >", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("AREA_CODE >=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThan(String value) {
            addCriterion("AREA_CODE <", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("AREA_CODE <=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLike(String value) {
            addCriterion("AREA_CODE like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotLike(String value) {
            addCriterion("AREA_CODE not like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIn(List<String> values) {
            addCriterion("AREA_CODE in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotIn(List<String> values) {
            addCriterion("AREA_CODE not in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeBetween(String value1, String value2) {
            addCriterion("AREA_CODE between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotBetween(String value1, String value2) {
            addCriterion("AREA_CODE not between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("POSTCODE is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("POSTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(String value) {
            addCriterion("POSTCODE =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(String value) {
            addCriterion("POSTCODE <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(String value) {
            addCriterion("POSTCODE >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("POSTCODE >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(String value) {
            addCriterion("POSTCODE <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(String value) {
            addCriterion("POSTCODE <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLike(String value) {
            addCriterion("POSTCODE like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotLike(String value) {
            addCriterion("POSTCODE not like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<String> values) {
            addCriterion("POSTCODE in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<String> values) {
            addCriterion("POSTCODE not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(String value1, String value2) {
            addCriterion("POSTCODE between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(String value1, String value2) {
            addCriterion("POSTCODE not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("LONGITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("LONGITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("LONGITUDE =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("LONGITUDE <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("LONGITUDE >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("LONGITUDE >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("LONGITUDE <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("LONGITUDE <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("LONGITUDE like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("LONGITUDE not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("LONGITUDE in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("LONGITUDE not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("LONGITUDE between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("LONGITUDE not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("LATITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("LATITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("LATITUDE =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("LATITUDE <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("LATITUDE >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("LATITUDE >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("LATITUDE <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("LATITUDE <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("LATITUDE like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("LATITUDE not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("LATITUDE in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("LATITUDE not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("LATITUDE between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("LATITUDE not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andContactTelIsNull() {
            addCriterion("CONTACT_TEL is null");
            return (Criteria) this;
        }

        public Criteria andContactTelIsNotNull() {
            addCriterion("CONTACT_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andContactTelEqualTo(String value) {
            addCriterion("CONTACT_TEL =", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotEqualTo(String value) {
            addCriterion("CONTACT_TEL <>", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelGreaterThan(String value) {
            addCriterion("CONTACT_TEL >", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_TEL >=", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLessThan(String value) {
            addCriterion("CONTACT_TEL <", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_TEL <=", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLike(String value) {
            addCriterion("CONTACT_TEL like", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotLike(String value) {
            addCriterion("CONTACT_TEL not like", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelIn(List<String> values) {
            addCriterion("CONTACT_TEL in", values, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotIn(List<String> values) {
            addCriterion("CONTACT_TEL not in", values, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelBetween(String value1, String value2) {
            addCriterion("CONTACT_TEL between", value1, value2, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotBetween(String value1, String value2) {
            addCriterion("CONTACT_TEL not between", value1, value2, "contactTel");
            return (Criteria) this;
        }

        public Criteria andSuperChnlIdIsNull() {
            addCriterion("SUPER_CHNL_ID is null");
            return (Criteria) this;
        }

        public Criteria andSuperChnlIdIsNotNull() {
            addCriterion("SUPER_CHNL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSuperChnlIdEqualTo(String value) {
            addCriterion("SUPER_CHNL_ID =", value, "superChnlId");
            return (Criteria) this;
        }

        public Criteria andSuperChnlIdNotEqualTo(String value) {
            addCriterion("SUPER_CHNL_ID <>", value, "superChnlId");
            return (Criteria) this;
        }

        public Criteria andSuperChnlIdGreaterThan(String value) {
            addCriterion("SUPER_CHNL_ID >", value, "superChnlId");
            return (Criteria) this;
        }

        public Criteria andSuperChnlIdGreaterThanOrEqualTo(String value) {
            addCriterion("SUPER_CHNL_ID >=", value, "superChnlId");
            return (Criteria) this;
        }

        public Criteria andSuperChnlIdLessThan(String value) {
            addCriterion("SUPER_CHNL_ID <", value, "superChnlId");
            return (Criteria) this;
        }

        public Criteria andSuperChnlIdLessThanOrEqualTo(String value) {
            addCriterion("SUPER_CHNL_ID <=", value, "superChnlId");
            return (Criteria) this;
        }

        public Criteria andSuperChnlIdLike(String value) {
            addCriterion("SUPER_CHNL_ID like", value, "superChnlId");
            return (Criteria) this;
        }

        public Criteria andSuperChnlIdNotLike(String value) {
            addCriterion("SUPER_CHNL_ID not like", value, "superChnlId");
            return (Criteria) this;
        }

        public Criteria andSuperChnlIdIn(List<String> values) {
            addCriterion("SUPER_CHNL_ID in", values, "superChnlId");
            return (Criteria) this;
        }

        public Criteria andSuperChnlIdNotIn(List<String> values) {
            addCriterion("SUPER_CHNL_ID not in", values, "superChnlId");
            return (Criteria) this;
        }

        public Criteria andSuperChnlIdBetween(String value1, String value2) {
            addCriterion("SUPER_CHNL_ID between", value1, value2, "superChnlId");
            return (Criteria) this;
        }

        public Criteria andSuperChnlIdNotBetween(String value1, String value2) {
            addCriterion("SUPER_CHNL_ID not between", value1, value2, "superChnlId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Timestamp value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Timestamp value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Timestamp> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Timestamp> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Timestamp value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Timestamp value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Timestamp> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Timestamp> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("TENANT_ID is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("TENANT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("TENANT_ID =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("TENANT_ID <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("TENANT_ID >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("TENANT_ID >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("TENANT_ID <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("TENANT_ID <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("TENANT_ID like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("TENANT_ID not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("TENANT_ID in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("TENANT_ID not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("TENANT_ID between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("TENANT_ID not between", value1, value2, "tenantId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}