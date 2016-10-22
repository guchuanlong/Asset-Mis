package com.myunihome.myxapp.common.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class GnChlKindCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public GnChlKindCriteria() {
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

        public Criteria andKindIdIsNull() {
            addCriterion("KIND_ID is null");
            return (Criteria) this;
        }

        public Criteria andKindIdIsNotNull() {
            addCriterion("KIND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andKindIdEqualTo(String value) {
            addCriterion("KIND_ID =", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdNotEqualTo(String value) {
            addCriterion("KIND_ID <>", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdGreaterThan(String value) {
            addCriterion("KIND_ID >", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdGreaterThanOrEqualTo(String value) {
            addCriterion("KIND_ID >=", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdLessThan(String value) {
            addCriterion("KIND_ID <", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdLessThanOrEqualTo(String value) {
            addCriterion("KIND_ID <=", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdLike(String value) {
            addCriterion("KIND_ID like", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdNotLike(String value) {
            addCriterion("KIND_ID not like", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdIn(List<String> values) {
            addCriterion("KIND_ID in", values, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdNotIn(List<String> values) {
            addCriterion("KIND_ID not in", values, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdBetween(String value1, String value2) {
            addCriterion("KIND_ID between", value1, value2, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdNotBetween(String value1, String value2) {
            addCriterion("KIND_ID not between", value1, value2, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindValueIsNull() {
            addCriterion("KIND_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andKindValueIsNotNull() {
            addCriterion("KIND_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andKindValueEqualTo(String value) {
            addCriterion("KIND_VALUE =", value, "kindValue");
            return (Criteria) this;
        }

        public Criteria andKindValueNotEqualTo(String value) {
            addCriterion("KIND_VALUE <>", value, "kindValue");
            return (Criteria) this;
        }

        public Criteria andKindValueGreaterThan(String value) {
            addCriterion("KIND_VALUE >", value, "kindValue");
            return (Criteria) this;
        }

        public Criteria andKindValueGreaterThanOrEqualTo(String value) {
            addCriterion("KIND_VALUE >=", value, "kindValue");
            return (Criteria) this;
        }

        public Criteria andKindValueLessThan(String value) {
            addCriterion("KIND_VALUE <", value, "kindValue");
            return (Criteria) this;
        }

        public Criteria andKindValueLessThanOrEqualTo(String value) {
            addCriterion("KIND_VALUE <=", value, "kindValue");
            return (Criteria) this;
        }

        public Criteria andKindValueLike(String value) {
            addCriterion("KIND_VALUE like", value, "kindValue");
            return (Criteria) this;
        }

        public Criteria andKindValueNotLike(String value) {
            addCriterion("KIND_VALUE not like", value, "kindValue");
            return (Criteria) this;
        }

        public Criteria andKindValueIn(List<String> values) {
            addCriterion("KIND_VALUE in", values, "kindValue");
            return (Criteria) this;
        }

        public Criteria andKindValueNotIn(List<String> values) {
            addCriterion("KIND_VALUE not in", values, "kindValue");
            return (Criteria) this;
        }

        public Criteria andKindValueBetween(String value1, String value2) {
            addCriterion("KIND_VALUE between", value1, value2, "kindValue");
            return (Criteria) this;
        }

        public Criteria andKindValueNotBetween(String value1, String value2) {
            addCriterion("KIND_VALUE not between", value1, value2, "kindValue");
            return (Criteria) this;
        }

        public Criteria andUpKindIdIsNull() {
            addCriterion("UP_KIND_ID is null");
            return (Criteria) this;
        }

        public Criteria andUpKindIdIsNotNull() {
            addCriterion("UP_KIND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUpKindIdEqualTo(String value) {
            addCriterion("UP_KIND_ID =", value, "upKindId");
            return (Criteria) this;
        }

        public Criteria andUpKindIdNotEqualTo(String value) {
            addCriterion("UP_KIND_ID <>", value, "upKindId");
            return (Criteria) this;
        }

        public Criteria andUpKindIdGreaterThan(String value) {
            addCriterion("UP_KIND_ID >", value, "upKindId");
            return (Criteria) this;
        }

        public Criteria andUpKindIdGreaterThanOrEqualTo(String value) {
            addCriterion("UP_KIND_ID >=", value, "upKindId");
            return (Criteria) this;
        }

        public Criteria andUpKindIdLessThan(String value) {
            addCriterion("UP_KIND_ID <", value, "upKindId");
            return (Criteria) this;
        }

        public Criteria andUpKindIdLessThanOrEqualTo(String value) {
            addCriterion("UP_KIND_ID <=", value, "upKindId");
            return (Criteria) this;
        }

        public Criteria andUpKindIdLike(String value) {
            addCriterion("UP_KIND_ID like", value, "upKindId");
            return (Criteria) this;
        }

        public Criteria andUpKindIdNotLike(String value) {
            addCriterion("UP_KIND_ID not like", value, "upKindId");
            return (Criteria) this;
        }

        public Criteria andUpKindIdIn(List<String> values) {
            addCriterion("UP_KIND_ID in", values, "upKindId");
            return (Criteria) this;
        }

        public Criteria andUpKindIdNotIn(List<String> values) {
            addCriterion("UP_KIND_ID not in", values, "upKindId");
            return (Criteria) this;
        }

        public Criteria andUpKindIdBetween(String value1, String value2) {
            addCriterion("UP_KIND_ID between", value1, value2, "upKindId");
            return (Criteria) this;
        }

        public Criteria andUpKindIdNotBetween(String value1, String value2) {
            addCriterion("UP_KIND_ID not between", value1, value2, "upKindId");
            return (Criteria) this;
        }

        public Criteria andKindLevelIsNull() {
            addCriterion("KIND_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andKindLevelIsNotNull() {
            addCriterion("KIND_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andKindLevelEqualTo(String value) {
            addCriterion("KIND_LEVEL =", value, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelNotEqualTo(String value) {
            addCriterion("KIND_LEVEL <>", value, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelGreaterThan(String value) {
            addCriterion("KIND_LEVEL >", value, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelGreaterThanOrEqualTo(String value) {
            addCriterion("KIND_LEVEL >=", value, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelLessThan(String value) {
            addCriterion("KIND_LEVEL <", value, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelLessThanOrEqualTo(String value) {
            addCriterion("KIND_LEVEL <=", value, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelLike(String value) {
            addCriterion("KIND_LEVEL like", value, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelNotLike(String value) {
            addCriterion("KIND_LEVEL not like", value, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelIn(List<String> values) {
            addCriterion("KIND_LEVEL in", values, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelNotIn(List<String> values) {
            addCriterion("KIND_LEVEL not in", values, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelBetween(String value1, String value2) {
            addCriterion("KIND_LEVEL between", value1, value2, "kindLevel");
            return (Criteria) this;
        }

        public Criteria andKindLevelNotBetween(String value1, String value2) {
            addCriterion("KIND_LEVEL not between", value1, value2, "kindLevel");
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