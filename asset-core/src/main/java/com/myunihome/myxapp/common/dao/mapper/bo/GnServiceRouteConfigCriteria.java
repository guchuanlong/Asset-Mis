package com.myunihome.myxapp.common.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class GnServiceRouteConfigCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public GnServiceRouteConfigCriteria() {
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

        public Criteria andRouteIdIsNull() {
            addCriterion("ROUTE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRouteIdIsNotNull() {
            addCriterion("ROUTE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRouteIdEqualTo(Long value) {
            addCriterion("ROUTE_ID =", value, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdNotEqualTo(Long value) {
            addCriterion("ROUTE_ID <>", value, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdGreaterThan(Long value) {
            addCriterion("ROUTE_ID >", value, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ROUTE_ID >=", value, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdLessThan(Long value) {
            addCriterion("ROUTE_ID <", value, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdLessThanOrEqualTo(Long value) {
            addCriterion("ROUTE_ID <=", value, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdIn(List<Long> values) {
            addCriterion("ROUTE_ID in", values, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdNotIn(List<Long> values) {
            addCriterion("ROUTE_ID not in", values, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdBetween(Long value1, Long value2) {
            addCriterion("ROUTE_ID between", value1, value2, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdNotBetween(Long value1, Long value2) {
            addCriterion("ROUTE_ID not between", value1, value2, "routeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNull() {
            addCriterion("SERVICE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNotNull() {
            addCriterion("SERVICE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeEqualTo(String value) {
            addCriterion("SERVICE_TYPE =", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotEqualTo(String value) {
            addCriterion("SERVICE_TYPE <>", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThan(String value) {
            addCriterion("SERVICE_TYPE >", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_TYPE >=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThan(String value) {
            addCriterion("SERVICE_TYPE <", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_TYPE <=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLike(String value) {
            addCriterion("SERVICE_TYPE like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotLike(String value) {
            addCriterion("SERVICE_TYPE not like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIn(List<String> values) {
            addCriterion("SERVICE_TYPE in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotIn(List<String> values) {
            addCriterion("SERVICE_TYPE not in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeBetween(String value1, String value2) {
            addCriterion("SERVICE_TYPE between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotBetween(String value1, String value2) {
            addCriterion("SERVICE_TYPE not between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameIsNull() {
            addCriterion("ROUTE_PARAM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameIsNotNull() {
            addCriterion("ROUTE_PARAM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameEqualTo(String value) {
            addCriterion("ROUTE_PARAM_NAME =", value, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameNotEqualTo(String value) {
            addCriterion("ROUTE_PARAM_NAME <>", value, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameGreaterThan(String value) {
            addCriterion("ROUTE_PARAM_NAME >", value, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameGreaterThanOrEqualTo(String value) {
            addCriterion("ROUTE_PARAM_NAME >=", value, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameLessThan(String value) {
            addCriterion("ROUTE_PARAM_NAME <", value, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameLessThanOrEqualTo(String value) {
            addCriterion("ROUTE_PARAM_NAME <=", value, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameLike(String value) {
            addCriterion("ROUTE_PARAM_NAME like", value, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameNotLike(String value) {
            addCriterion("ROUTE_PARAM_NAME not like", value, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameIn(List<String> values) {
            addCriterion("ROUTE_PARAM_NAME in", values, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameNotIn(List<String> values) {
            addCriterion("ROUTE_PARAM_NAME not in", values, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameBetween(String value1, String value2) {
            addCriterion("ROUTE_PARAM_NAME between", value1, value2, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameNotBetween(String value1, String value2) {
            addCriterion("ROUTE_PARAM_NAME not between", value1, value2, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueIsNull() {
            addCriterion("ROUTE_PARAM_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueIsNotNull() {
            addCriterion("ROUTE_PARAM_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueEqualTo(String value) {
            addCriterion("ROUTE_PARAM_VALUE =", value, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueNotEqualTo(String value) {
            addCriterion("ROUTE_PARAM_VALUE <>", value, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueGreaterThan(String value) {
            addCriterion("ROUTE_PARAM_VALUE >", value, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueGreaterThanOrEqualTo(String value) {
            addCriterion("ROUTE_PARAM_VALUE >=", value, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueLessThan(String value) {
            addCriterion("ROUTE_PARAM_VALUE <", value, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueLessThanOrEqualTo(String value) {
            addCriterion("ROUTE_PARAM_VALUE <=", value, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueLike(String value) {
            addCriterion("ROUTE_PARAM_VALUE like", value, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueNotLike(String value) {
            addCriterion("ROUTE_PARAM_VALUE not like", value, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueIn(List<String> values) {
            addCriterion("ROUTE_PARAM_VALUE in", values, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueNotIn(List<String> values) {
            addCriterion("ROUTE_PARAM_VALUE not in", values, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueBetween(String value1, String value2) {
            addCriterion("ROUTE_PARAM_VALUE between", value1, value2, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueNotBetween(String value1, String value2) {
            addCriterion("ROUTE_PARAM_VALUE not between", value1, value2, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteServiceIsNull() {
            addCriterion("ROUTE_SERVICE is null");
            return (Criteria) this;
        }

        public Criteria andRouteServiceIsNotNull() {
            addCriterion("ROUTE_SERVICE is not null");
            return (Criteria) this;
        }

        public Criteria andRouteServiceEqualTo(String value) {
            addCriterion("ROUTE_SERVICE =", value, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceNotEqualTo(String value) {
            addCriterion("ROUTE_SERVICE <>", value, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceGreaterThan(String value) {
            addCriterion("ROUTE_SERVICE >", value, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceGreaterThanOrEqualTo(String value) {
            addCriterion("ROUTE_SERVICE >=", value, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceLessThan(String value) {
            addCriterion("ROUTE_SERVICE <", value, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceLessThanOrEqualTo(String value) {
            addCriterion("ROUTE_SERVICE <=", value, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceLike(String value) {
            addCriterion("ROUTE_SERVICE like", value, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceNotLike(String value) {
            addCriterion("ROUTE_SERVICE not like", value, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceIn(List<String> values) {
            addCriterion("ROUTE_SERVICE in", values, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceNotIn(List<String> values) {
            addCriterion("ROUTE_SERVICE not in", values, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceBetween(String value1, String value2) {
            addCriterion("ROUTE_SERVICE between", value1, value2, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceNotBetween(String value1, String value2) {
            addCriterion("ROUTE_SERVICE not between", value1, value2, "routeService");
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

        public Criteria andCenterCodeIsNull() {
            addCriterion("CENTER_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCenterCodeIsNotNull() {
            addCriterion("CENTER_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCenterCodeEqualTo(String value) {
            addCriterion("CENTER_CODE =", value, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeNotEqualTo(String value) {
            addCriterion("CENTER_CODE <>", value, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeGreaterThan(String value) {
            addCriterion("CENTER_CODE >", value, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CENTER_CODE >=", value, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeLessThan(String value) {
            addCriterion("CENTER_CODE <", value, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeLessThanOrEqualTo(String value) {
            addCriterion("CENTER_CODE <=", value, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeLike(String value) {
            addCriterion("CENTER_CODE like", value, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeNotLike(String value) {
            addCriterion("CENTER_CODE not like", value, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeIn(List<String> values) {
            addCriterion("CENTER_CODE in", values, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeNotIn(List<String> values) {
            addCriterion("CENTER_CODE not in", values, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeBetween(String value1, String value2) {
            addCriterion("CENTER_CODE between", value1, value2, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeNotBetween(String value1, String value2) {
            addCriterion("CENTER_CODE not between", value1, value2, "centerCode");
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