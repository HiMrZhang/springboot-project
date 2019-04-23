package com.easysoft.project.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 用来组拼查询的条件： 使用方法： //1.创建MybatisQueryHelper对象 MybatisQueryHelper queryHelper=
 * new MybatisQueryHelper(); //2.添加and的where条件 Criteria
 * addCri=queryHelper.createCriteria();
 * addCri.andValueNotIn().andValueEqualTo(); //3添加or条件 Criteria
 * or=queryHelper.or(); orCri.andValueNotIn().andValueEqualTo(); 4.进行条件查询
 *
 * @author： zyp[2305658511@qq.com]
 * @date： 2019-04-22 17:30
 * @version： V1.0
 * @review: zyp[2305658511@qq.com]/2019-04-22 17:30
 */
public class MybatisQueryHelper {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public MybatisQueryHelper() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }


    public MybatisQueryHelper setDistinct(boolean distinct) {
        this.distinct = distinct;
        return this;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public MybatisQueryHelper addOrderByClause(String column, boolean isAsc) {
        if (column == null) {
            throw new RuntimeException("column  cannot be null");
        }
        if (orderByClause == null || orderByClause.trim().length() == 0) {
            orderByClause = column + " " + (isAsc ? "asc" : "desc");
        } else {
            orderByClause += "," + column + " "
                    + (isAsc ? "asc" : "desc");
        }
        return this;
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

        protected void addCriterion(String condition, Object value) {
            if (value == null) {
                throw new RuntimeException("Value  cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1,
                                    Object value2) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for  cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andValueIsNull(String columnName) {
            if (columnName == null) {
                throw new RuntimeException("columnName cannot be null");
            }
            addCriterion(columnName + " is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull(String columnName) {
            if (columnName == null) {
                throw new RuntimeException("columnName cannot be null");
            }
            addCriterion(columnName + " is not null");
            return (Criteria) this;
        }

        public Criteria andValueLike(String columnName, Object value) {
            if (columnName == null) {
                throw new RuntimeException("columnName cannot be null");
            }
            if (value == null) {
                throw new RuntimeException("value cannot be null");
            }
            addCriterion(columnName + " like", "%" + value + "%");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String columnName, Object value) {
            if (columnName == null) {
                throw new RuntimeException("columnName cannot be null");
            }
            if (value == null) {
                throw new RuntimeException("value cannot be null");
            }
            addCriterion(columnName + " not like", value);
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String columnName, Object value) {
            if (columnName == null) {
                throw new RuntimeException("columnName cannot be null");
            }
            if (value == null) {
                throw new RuntimeException("value cannot be null");
            }
            addCriterion(columnName + " =", value);
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String columnName, Object value) {
            if (columnName == null) {
                throw new RuntimeException("columnName cannot be null");
            }
            if (value == null) {
                throw new RuntimeException("value cannot be null");
            }
            addCriterion(columnName + " <>", value);
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String columnName, Object value) {
            if (columnName == null) {
                throw new RuntimeException("columnName cannot be null");
            }
            if (value == null) {
                throw new RuntimeException("value cannot be null");
            }
            addCriterion(columnName + " >", value);
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String columnName,
                                                     Object value) {
            if (columnName == null) {
                throw new RuntimeException("columnName cannot be null");
            }
            if (value == null) {
                throw new RuntimeException("value cannot be null");
            }
            addCriterion(columnName + " >=", value);
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String columnName, Object value) {
            if (columnName == null) {
                throw new RuntimeException("columnName cannot be null");
            }
            if (value == null) {
                throw new RuntimeException("value cannot be null");
            }
            addCriterion(columnName + " <", value);
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String columnName,
                                                  Object value) {
            if (columnName == null) {
                throw new RuntimeException("columnName cannot be null");
            }
            if (value == null) {
                throw new RuntimeException("value cannot be null");
            }
            addCriterion(columnName + " <=", value);
            return (Criteria) this;
        }

        public Criteria andValueIn(String columnName, List values) {
            if (columnName == null) {
                throw new RuntimeException("columnName cannot be null");
            }
            if (values == null) {
                throw new RuntimeException("value cannot be null");
            }
            addCriterion(columnName + " in", values);
            return (Criteria) this;
        }

        public Criteria andValueNotIn(String columnName, List values) {
            if (columnName == null) {
                throw new RuntimeException("columnName cannot be null");
            }
            if (values == null) {
                throw new RuntimeException("value cannot be null");
            }
            addCriterion(columnName + " not in", values);
            return (Criteria) this;
        }

        public Criteria andValueBetween(String columnName, Object value1,
                                        Object value2) {
            if (columnName == null) {
                throw new RuntimeException("columnName cannot be null");
            }
            if (value1 == null || value2 == null) {
                throw new RuntimeException("value cannot be null");
            }
            addCriterion(columnName + " between", value1, value2);
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String columnName, Object value1,
                                           Object value2) {
            if (columnName == null) {
                throw new RuntimeException("columnName cannot be null");
            }
            if (value1 == null || value2 == null) {
                throw new RuntimeException("value cannot be null");
            }
            addCriterion(columnName + " not between", value1, value2);
            return (Criteria) this;
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

        protected Criterion(String condition, Object value, Object secondValue,
                            String typeHandler) {
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

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}
