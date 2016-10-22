package com.myunihome.myxapp.sso.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class GnTabSysIpMapCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public GnTabSysIpMapCriteria() {
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

        public Criteria andSystemIdIsNull() {
            addCriterion("system_id is null");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNotNull() {
            addCriterion("system_id is not null");
            return (Criteria) this;
        }

        public Criteria andSystemIdEqualTo(String value) {
            addCriterion("system_id =", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotEqualTo(String value) {
            addCriterion("system_id <>", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThan(String value) {
            addCriterion("system_id >", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThanOrEqualTo(String value) {
            addCriterion("system_id >=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThan(String value) {
            addCriterion("system_id <", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThanOrEqualTo(String value) {
            addCriterion("system_id <=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLike(String value) {
            addCriterion("system_id like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotLike(String value) {
            addCriterion("system_id not like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdIn(List<String> values) {
            addCriterion("system_id in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotIn(List<String> values) {
            addCriterion("system_id not in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdBetween(String value1, String value2) {
            addCriterion("system_id between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotBetween(String value1, String value2) {
            addCriterion("system_id not between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andConnectIpIsNull() {
            addCriterion("connect_ip is null");
            return (Criteria) this;
        }

        public Criteria andConnectIpIsNotNull() {
            addCriterion("connect_ip is not null");
            return (Criteria) this;
        }

        public Criteria andConnectIpEqualTo(String value) {
            addCriterion("connect_ip =", value, "connectIp");
            return (Criteria) this;
        }

        public Criteria andConnectIpNotEqualTo(String value) {
            addCriterion("connect_ip <>", value, "connectIp");
            return (Criteria) this;
        }

        public Criteria andConnectIpGreaterThan(String value) {
            addCriterion("connect_ip >", value, "connectIp");
            return (Criteria) this;
        }

        public Criteria andConnectIpGreaterThanOrEqualTo(String value) {
            addCriterion("connect_ip >=", value, "connectIp");
            return (Criteria) this;
        }

        public Criteria andConnectIpLessThan(String value) {
            addCriterion("connect_ip <", value, "connectIp");
            return (Criteria) this;
        }

        public Criteria andConnectIpLessThanOrEqualTo(String value) {
            addCriterion("connect_ip <=", value, "connectIp");
            return (Criteria) this;
        }

        public Criteria andConnectIpLike(String value) {
            addCriterion("connect_ip like", value, "connectIp");
            return (Criteria) this;
        }

        public Criteria andConnectIpNotLike(String value) {
            addCriterion("connect_ip not like", value, "connectIp");
            return (Criteria) this;
        }

        public Criteria andConnectIpIn(List<String> values) {
            addCriterion("connect_ip in", values, "connectIp");
            return (Criteria) this;
        }

        public Criteria andConnectIpNotIn(List<String> values) {
            addCriterion("connect_ip not in", values, "connectIp");
            return (Criteria) this;
        }

        public Criteria andConnectIpBetween(String value1, String value2) {
            addCriterion("connect_ip between", value1, value2, "connectIp");
            return (Criteria) this;
        }

        public Criteria andConnectIpNotBetween(String value1, String value2) {
            addCriterion("connect_ip not between", value1, value2, "connectIp");
            return (Criteria) this;
        }

        public Criteria andConnectPortIsNull() {
            addCriterion("connect_port is null");
            return (Criteria) this;
        }

        public Criteria andConnectPortIsNotNull() {
            addCriterion("connect_port is not null");
            return (Criteria) this;
        }

        public Criteria andConnectPortEqualTo(String value) {
            addCriterion("connect_port =", value, "connectPort");
            return (Criteria) this;
        }

        public Criteria andConnectPortNotEqualTo(String value) {
            addCriterion("connect_port <>", value, "connectPort");
            return (Criteria) this;
        }

        public Criteria andConnectPortGreaterThan(String value) {
            addCriterion("connect_port >", value, "connectPort");
            return (Criteria) this;
        }

        public Criteria andConnectPortGreaterThanOrEqualTo(String value) {
            addCriterion("connect_port >=", value, "connectPort");
            return (Criteria) this;
        }

        public Criteria andConnectPortLessThan(String value) {
            addCriterion("connect_port <", value, "connectPort");
            return (Criteria) this;
        }

        public Criteria andConnectPortLessThanOrEqualTo(String value) {
            addCriterion("connect_port <=", value, "connectPort");
            return (Criteria) this;
        }

        public Criteria andConnectPortLike(String value) {
            addCriterion("connect_port like", value, "connectPort");
            return (Criteria) this;
        }

        public Criteria andConnectPortNotLike(String value) {
            addCriterion("connect_port not like", value, "connectPort");
            return (Criteria) this;
        }

        public Criteria andConnectPortIn(List<String> values) {
            addCriterion("connect_port in", values, "connectPort");
            return (Criteria) this;
        }

        public Criteria andConnectPortNotIn(List<String> values) {
            addCriterion("connect_port not in", values, "connectPort");
            return (Criteria) this;
        }

        public Criteria andConnectPortBetween(String value1, String value2) {
            addCriterion("connect_port between", value1, value2, "connectPort");
            return (Criteria) this;
        }

        public Criteria andConnectPortNotBetween(String value1, String value2) {
            addCriterion("connect_port not between", value1, value2, "connectPort");
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

        public Criteria andMappedIdIsNull() {
            addCriterion("mapped_id is null");
            return (Criteria) this;
        }

        public Criteria andMappedIdIsNotNull() {
            addCriterion("mapped_id is not null");
            return (Criteria) this;
        }

        public Criteria andMappedIdEqualTo(String value) {
            addCriterion("mapped_id =", value, "mappedId");
            return (Criteria) this;
        }

        public Criteria andMappedIdNotEqualTo(String value) {
            addCriterion("mapped_id <>", value, "mappedId");
            return (Criteria) this;
        }

        public Criteria andMappedIdGreaterThan(String value) {
            addCriterion("mapped_id >", value, "mappedId");
            return (Criteria) this;
        }

        public Criteria andMappedIdGreaterThanOrEqualTo(String value) {
            addCriterion("mapped_id >=", value, "mappedId");
            return (Criteria) this;
        }

        public Criteria andMappedIdLessThan(String value) {
            addCriterion("mapped_id <", value, "mappedId");
            return (Criteria) this;
        }

        public Criteria andMappedIdLessThanOrEqualTo(String value) {
            addCriterion("mapped_id <=", value, "mappedId");
            return (Criteria) this;
        }

        public Criteria andMappedIdLike(String value) {
            addCriterion("mapped_id like", value, "mappedId");
            return (Criteria) this;
        }

        public Criteria andMappedIdNotLike(String value) {
            addCriterion("mapped_id not like", value, "mappedId");
            return (Criteria) this;
        }

        public Criteria andMappedIdIn(List<String> values) {
            addCriterion("mapped_id in", values, "mappedId");
            return (Criteria) this;
        }

        public Criteria andMappedIdNotIn(List<String> values) {
            addCriterion("mapped_id not in", values, "mappedId");
            return (Criteria) this;
        }

        public Criteria andMappedIdBetween(String value1, String value2) {
            addCriterion("mapped_id between", value1, value2, "mappedId");
            return (Criteria) this;
        }

        public Criteria andMappedIdNotBetween(String value1, String value2) {
            addCriterion("mapped_id not between", value1, value2, "mappedId");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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