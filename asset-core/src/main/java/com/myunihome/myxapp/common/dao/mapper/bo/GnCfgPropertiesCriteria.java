package com.myunihome.myxapp.common.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class GnCfgPropertiesCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public GnCfgPropertiesCriteria() {
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

        public Criteria andGuidkeyIsNull() {
            addCriterion("GUIDKEY is null");
            return (Criteria) this;
        }

        public Criteria andGuidkeyIsNotNull() {
            addCriterion("GUIDKEY is not null");
            return (Criteria) this;
        }

        public Criteria andGuidkeyEqualTo(String value) {
            addCriterion("GUIDKEY =", value, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyNotEqualTo(String value) {
            addCriterion("GUIDKEY <>", value, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyGreaterThan(String value) {
            addCriterion("GUIDKEY >", value, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyGreaterThanOrEqualTo(String value) {
            addCriterion("GUIDKEY >=", value, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyLessThan(String value) {
            addCriterion("GUIDKEY <", value, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyLessThanOrEqualTo(String value) {
            addCriterion("GUIDKEY <=", value, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyLike(String value) {
            addCriterion("GUIDKEY like", value, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyNotLike(String value) {
            addCriterion("GUIDKEY not like", value, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyIn(List<String> values) {
            addCriterion("GUIDKEY in", values, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyNotIn(List<String> values) {
            addCriterion("GUIDKEY not in", values, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyBetween(String value1, String value2) {
            addCriterion("GUIDKEY between", value1, value2, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyNotBetween(String value1, String value2) {
            addCriterion("GUIDKEY not between", value1, value2, "guidkey");
            return (Criteria) this;
        }

        public Criteria andCfgtypeIsNull() {
            addCriterion("CFGTYPE is null");
            return (Criteria) this;
        }

        public Criteria andCfgtypeIsNotNull() {
            addCriterion("CFGTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCfgtypeEqualTo(String value) {
            addCriterion("CFGTYPE =", value, "cfgtype");
            return (Criteria) this;
        }

        public Criteria andCfgtypeNotEqualTo(String value) {
            addCriterion("CFGTYPE <>", value, "cfgtype");
            return (Criteria) this;
        }

        public Criteria andCfgtypeGreaterThan(String value) {
            addCriterion("CFGTYPE >", value, "cfgtype");
            return (Criteria) this;
        }

        public Criteria andCfgtypeGreaterThanOrEqualTo(String value) {
            addCriterion("CFGTYPE >=", value, "cfgtype");
            return (Criteria) this;
        }

        public Criteria andCfgtypeLessThan(String value) {
            addCriterion("CFGTYPE <", value, "cfgtype");
            return (Criteria) this;
        }

        public Criteria andCfgtypeLessThanOrEqualTo(String value) {
            addCriterion("CFGTYPE <=", value, "cfgtype");
            return (Criteria) this;
        }

        public Criteria andCfgtypeLike(String value) {
            addCriterion("CFGTYPE like", value, "cfgtype");
            return (Criteria) this;
        }

        public Criteria andCfgtypeNotLike(String value) {
            addCriterion("CFGTYPE not like", value, "cfgtype");
            return (Criteria) this;
        }

        public Criteria andCfgtypeIn(List<String> values) {
            addCriterion("CFGTYPE in", values, "cfgtype");
            return (Criteria) this;
        }

        public Criteria andCfgtypeNotIn(List<String> values) {
            addCriterion("CFGTYPE not in", values, "cfgtype");
            return (Criteria) this;
        }

        public Criteria andCfgtypeBetween(String value1, String value2) {
            addCriterion("CFGTYPE between", value1, value2, "cfgtype");
            return (Criteria) this;
        }

        public Criteria andCfgtypeNotBetween(String value1, String value2) {
            addCriterion("CFGTYPE not between", value1, value2, "cfgtype");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNull() {
            addCriterion("PROPERTY is null");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNotNull() {
            addCriterion("PROPERTY is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyEqualTo(String value) {
            addCriterion("PROPERTY =", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotEqualTo(String value) {
            addCriterion("PROPERTY <>", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThan(String value) {
            addCriterion("PROPERTY >", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY >=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThan(String value) {
            addCriterion("PROPERTY <", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThanOrEqualTo(String value) {
            addCriterion("PROPERTY <=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLike(String value) {
            addCriterion("PROPERTY like", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotLike(String value) {
            addCriterion("PROPERTY not like", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyIn(List<String> values) {
            addCriterion("PROPERTY in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotIn(List<String> values) {
            addCriterion("PROPERTY not in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyBetween(String value1, String value2) {
            addCriterion("PROPERTY between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotBetween(String value1, String value2) {
            addCriterion("PROPERTY not between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("VALUE is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("VALUE =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("VALUE <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("VALUE >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("VALUE >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("VALUE <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("VALUE <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("VALUE like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("VALUE not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<String> values) {
            addCriterion("VALUE in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<String> values) {
            addCriterion("VALUE not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("VALUE between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("VALUE not between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andCfgdescIsNull() {
            addCriterion("CFGDESC is null");
            return (Criteria) this;
        }

        public Criteria andCfgdescIsNotNull() {
            addCriterion("CFGDESC is not null");
            return (Criteria) this;
        }

        public Criteria andCfgdescEqualTo(String value) {
            addCriterion("CFGDESC =", value, "cfgdesc");
            return (Criteria) this;
        }

        public Criteria andCfgdescNotEqualTo(String value) {
            addCriterion("CFGDESC <>", value, "cfgdesc");
            return (Criteria) this;
        }

        public Criteria andCfgdescGreaterThan(String value) {
            addCriterion("CFGDESC >", value, "cfgdesc");
            return (Criteria) this;
        }

        public Criteria andCfgdescGreaterThanOrEqualTo(String value) {
            addCriterion("CFGDESC >=", value, "cfgdesc");
            return (Criteria) this;
        }

        public Criteria andCfgdescLessThan(String value) {
            addCriterion("CFGDESC <", value, "cfgdesc");
            return (Criteria) this;
        }

        public Criteria andCfgdescLessThanOrEqualTo(String value) {
            addCriterion("CFGDESC <=", value, "cfgdesc");
            return (Criteria) this;
        }

        public Criteria andCfgdescLike(String value) {
            addCriterion("CFGDESC like", value, "cfgdesc");
            return (Criteria) this;
        }

        public Criteria andCfgdescNotLike(String value) {
            addCriterion("CFGDESC not like", value, "cfgdesc");
            return (Criteria) this;
        }

        public Criteria andCfgdescIn(List<String> values) {
            addCriterion("CFGDESC in", values, "cfgdesc");
            return (Criteria) this;
        }

        public Criteria andCfgdescNotIn(List<String> values) {
            addCriterion("CFGDESC not in", values, "cfgdesc");
            return (Criteria) this;
        }

        public Criteria andCfgdescBetween(String value1, String value2) {
            addCriterion("CFGDESC between", value1, value2, "cfgdesc");
            return (Criteria) this;
        }

        public Criteria andCfgdescNotBetween(String value1, String value2) {
            addCriterion("CFGDESC not between", value1, value2, "cfgdesc");
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

        public Criteria andSystemIdIsNull() {
            addCriterion("SYSTEM_ID is null");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNotNull() {
            addCriterion("SYSTEM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSystemIdEqualTo(String value) {
            addCriterion("SYSTEM_ID =", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotEqualTo(String value) {
            addCriterion("SYSTEM_ID <>", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThan(String value) {
            addCriterion("SYSTEM_ID >", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThanOrEqualTo(String value) {
            addCriterion("SYSTEM_ID >=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThan(String value) {
            addCriterion("SYSTEM_ID <", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThanOrEqualTo(String value) {
            addCriterion("SYSTEM_ID <=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLike(String value) {
            addCriterion("SYSTEM_ID like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotLike(String value) {
            addCriterion("SYSTEM_ID not like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdIn(List<String> values) {
            addCriterion("SYSTEM_ID in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotIn(List<String> values) {
            addCriterion("SYSTEM_ID not in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdBetween(String value1, String value2) {
            addCriterion("SYSTEM_ID between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotBetween(String value1, String value2) {
            addCriterion("SYSTEM_ID not between", value1, value2, "systemId");
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