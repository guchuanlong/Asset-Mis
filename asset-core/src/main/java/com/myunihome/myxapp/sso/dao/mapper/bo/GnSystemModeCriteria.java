package com.myunihome.myxapp.sso.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class GnSystemModeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public GnSystemModeCriteria() {
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

        public Criteria andSystemModeIdIsNull() {
            addCriterion("SYSTEM_MODE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSystemModeIdIsNotNull() {
            addCriterion("SYSTEM_MODE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSystemModeIdEqualTo(String value) {
            addCriterion("SYSTEM_MODE_ID =", value, "systemModeId");
            return (Criteria) this;
        }

        public Criteria andSystemModeIdNotEqualTo(String value) {
            addCriterion("SYSTEM_MODE_ID <>", value, "systemModeId");
            return (Criteria) this;
        }

        public Criteria andSystemModeIdGreaterThan(String value) {
            addCriterion("SYSTEM_MODE_ID >", value, "systemModeId");
            return (Criteria) this;
        }

        public Criteria andSystemModeIdGreaterThanOrEqualTo(String value) {
            addCriterion("SYSTEM_MODE_ID >=", value, "systemModeId");
            return (Criteria) this;
        }

        public Criteria andSystemModeIdLessThan(String value) {
            addCriterion("SYSTEM_MODE_ID <", value, "systemModeId");
            return (Criteria) this;
        }

        public Criteria andSystemModeIdLessThanOrEqualTo(String value) {
            addCriterion("SYSTEM_MODE_ID <=", value, "systemModeId");
            return (Criteria) this;
        }

        public Criteria andSystemModeIdLike(String value) {
            addCriterion("SYSTEM_MODE_ID like", value, "systemModeId");
            return (Criteria) this;
        }

        public Criteria andSystemModeIdNotLike(String value) {
            addCriterion("SYSTEM_MODE_ID not like", value, "systemModeId");
            return (Criteria) this;
        }

        public Criteria andSystemModeIdIn(List<String> values) {
            addCriterion("SYSTEM_MODE_ID in", values, "systemModeId");
            return (Criteria) this;
        }

        public Criteria andSystemModeIdNotIn(List<String> values) {
            addCriterion("SYSTEM_MODE_ID not in", values, "systemModeId");
            return (Criteria) this;
        }

        public Criteria andSystemModeIdBetween(String value1, String value2) {
            addCriterion("SYSTEM_MODE_ID between", value1, value2, "systemModeId");
            return (Criteria) this;
        }

        public Criteria andSystemModeIdNotBetween(String value1, String value2) {
            addCriterion("SYSTEM_MODE_ID not between", value1, value2, "systemModeId");
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

        public Criteria andSystemModeNameIsNull() {
            addCriterion("SYSTEM_MODE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSystemModeNameIsNotNull() {
            addCriterion("SYSTEM_MODE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSystemModeNameEqualTo(String value) {
            addCriterion("SYSTEM_MODE_NAME =", value, "systemModeName");
            return (Criteria) this;
        }

        public Criteria andSystemModeNameNotEqualTo(String value) {
            addCriterion("SYSTEM_MODE_NAME <>", value, "systemModeName");
            return (Criteria) this;
        }

        public Criteria andSystemModeNameGreaterThan(String value) {
            addCriterion("SYSTEM_MODE_NAME >", value, "systemModeName");
            return (Criteria) this;
        }

        public Criteria andSystemModeNameGreaterThanOrEqualTo(String value) {
            addCriterion("SYSTEM_MODE_NAME >=", value, "systemModeName");
            return (Criteria) this;
        }

        public Criteria andSystemModeNameLessThan(String value) {
            addCriterion("SYSTEM_MODE_NAME <", value, "systemModeName");
            return (Criteria) this;
        }

        public Criteria andSystemModeNameLessThanOrEqualTo(String value) {
            addCriterion("SYSTEM_MODE_NAME <=", value, "systemModeName");
            return (Criteria) this;
        }

        public Criteria andSystemModeNameLike(String value) {
            addCriterion("SYSTEM_MODE_NAME like", value, "systemModeName");
            return (Criteria) this;
        }

        public Criteria andSystemModeNameNotLike(String value) {
            addCriterion("SYSTEM_MODE_NAME not like", value, "systemModeName");
            return (Criteria) this;
        }

        public Criteria andSystemModeNameIn(List<String> values) {
            addCriterion("SYSTEM_MODE_NAME in", values, "systemModeName");
            return (Criteria) this;
        }

        public Criteria andSystemModeNameNotIn(List<String> values) {
            addCriterion("SYSTEM_MODE_NAME not in", values, "systemModeName");
            return (Criteria) this;
        }

        public Criteria andSystemModeNameBetween(String value1, String value2) {
            addCriterion("SYSTEM_MODE_NAME between", value1, value2, "systemModeName");
            return (Criteria) this;
        }

        public Criteria andSystemModeNameNotBetween(String value1, String value2) {
            addCriterion("SYSTEM_MODE_NAME not between", value1, value2, "systemModeName");
            return (Criteria) this;
        }

        public Criteria andSystemUrlContextIsNull() {
            addCriterion("SYSTEM_URL_CONTEXT is null");
            return (Criteria) this;
        }

        public Criteria andSystemUrlContextIsNotNull() {
            addCriterion("SYSTEM_URL_CONTEXT is not null");
            return (Criteria) this;
        }

        public Criteria andSystemUrlContextEqualTo(String value) {
            addCriterion("SYSTEM_URL_CONTEXT =", value, "systemUrlContext");
            return (Criteria) this;
        }

        public Criteria andSystemUrlContextNotEqualTo(String value) {
            addCriterion("SYSTEM_URL_CONTEXT <>", value, "systemUrlContext");
            return (Criteria) this;
        }

        public Criteria andSystemUrlContextGreaterThan(String value) {
            addCriterion("SYSTEM_URL_CONTEXT >", value, "systemUrlContext");
            return (Criteria) this;
        }

        public Criteria andSystemUrlContextGreaterThanOrEqualTo(String value) {
            addCriterion("SYSTEM_URL_CONTEXT >=", value, "systemUrlContext");
            return (Criteria) this;
        }

        public Criteria andSystemUrlContextLessThan(String value) {
            addCriterion("SYSTEM_URL_CONTEXT <", value, "systemUrlContext");
            return (Criteria) this;
        }

        public Criteria andSystemUrlContextLessThanOrEqualTo(String value) {
            addCriterion("SYSTEM_URL_CONTEXT <=", value, "systemUrlContext");
            return (Criteria) this;
        }

        public Criteria andSystemUrlContextLike(String value) {
            addCriterion("SYSTEM_URL_CONTEXT like", value, "systemUrlContext");
            return (Criteria) this;
        }

        public Criteria andSystemUrlContextNotLike(String value) {
            addCriterion("SYSTEM_URL_CONTEXT not like", value, "systemUrlContext");
            return (Criteria) this;
        }

        public Criteria andSystemUrlContextIn(List<String> values) {
            addCriterion("SYSTEM_URL_CONTEXT in", values, "systemUrlContext");
            return (Criteria) this;
        }

        public Criteria andSystemUrlContextNotIn(List<String> values) {
            addCriterion("SYSTEM_URL_CONTEXT not in", values, "systemUrlContext");
            return (Criteria) this;
        }

        public Criteria andSystemUrlContextBetween(String value1, String value2) {
            addCriterion("SYSTEM_URL_CONTEXT between", value1, value2, "systemUrlContext");
            return (Criteria) this;
        }

        public Criteria andSystemUrlContextNotBetween(String value1, String value2) {
            addCriterion("SYSTEM_URL_CONTEXT not between", value1, value2, "systemUrlContext");
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