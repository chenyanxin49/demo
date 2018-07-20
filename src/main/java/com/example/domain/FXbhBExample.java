package com.example.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FXbhBExample {
    /**
     * F_XBH_B
     */
    protected String orderByClause;

    /**
     * F_XBH_B
     */
    protected boolean distinct;

    /**
     * F_XBH_B
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated 2018-07-20
     */
    public FXbhBExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2018-07-20
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2018-07-20
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2018-07-20
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2018-07-20
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2018-07-20
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2018-07-20
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2018-07-20
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-07-20
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-07-20
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-07-20
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * F_XBH_B 2018-07-20
     */
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

        public Criteria andAddvcdIsNull() {
            addCriterion("ADDVCD is null");
            return (Criteria) this;
        }

        public Criteria andAddvcdIsNotNull() {
            addCriterion("ADDVCD is not null");
            return (Criteria) this;
        }

        public Criteria andAddvcdEqualTo(String value) {
            addCriterion("ADDVCD =", value, "addvcd");
            return (Criteria) this;
        }

        public Criteria andAddvcdNotEqualTo(String value) {
            addCriterion("ADDVCD <>", value, "addvcd");
            return (Criteria) this;
        }

        public Criteria andAddvcdGreaterThan(String value) {
            addCriterion("ADDVCD >", value, "addvcd");
            return (Criteria) this;
        }

        public Criteria andAddvcdGreaterThanOrEqualTo(String value) {
            addCriterion("ADDVCD >=", value, "addvcd");
            return (Criteria) this;
        }

        public Criteria andAddvcdLessThan(String value) {
            addCriterion("ADDVCD <", value, "addvcd");
            return (Criteria) this;
        }

        public Criteria andAddvcdLessThanOrEqualTo(String value) {
            addCriterion("ADDVCD <=", value, "addvcd");
            return (Criteria) this;
        }

        public Criteria andAddvcdLike(String value) {
            addCriterion("ADDVCD like", value, "addvcd");
            return (Criteria) this;
        }

        public Criteria andAddvcdNotLike(String value) {
            addCriterion("ADDVCD not like", value, "addvcd");
            return (Criteria) this;
        }

        public Criteria andAddvcdIn(List<String> values) {
            addCriterion("ADDVCD in", values, "addvcd");
            return (Criteria) this;
        }

        public Criteria andAddvcdNotIn(List<String> values) {
            addCriterion("ADDVCD not in", values, "addvcd");
            return (Criteria) this;
        }

        public Criteria andAddvcdBetween(String value1, String value2) {
            addCriterion("ADDVCD between", value1, value2, "addvcd");
            return (Criteria) this;
        }

        public Criteria andAddvcdNotBetween(String value1, String value2) {
            addCriterion("ADDVCD not between", value1, value2, "addvcd");
            return (Criteria) this;
        }

        public Criteria andXbhIsNull() {
            addCriterion("XBH is null");
            return (Criteria) this;
        }

        public Criteria andXbhIsNotNull() {
            addCriterion("XBH is not null");
            return (Criteria) this;
        }

        public Criteria andXbhEqualTo(String value) {
            addCriterion("XBH =", value, "xbh");
            return (Criteria) this;
        }

        public Criteria andXbhNotEqualTo(String value) {
            addCriterion("XBH <>", value, "xbh");
            return (Criteria) this;
        }

        public Criteria andXbhGreaterThan(String value) {
            addCriterion("XBH >", value, "xbh");
            return (Criteria) this;
        }

        public Criteria andXbhGreaterThanOrEqualTo(String value) {
            addCriterion("XBH >=", value, "xbh");
            return (Criteria) this;
        }

        public Criteria andXbhLessThan(String value) {
            addCriterion("XBH <", value, "xbh");
            return (Criteria) this;
        }

        public Criteria andXbhLessThanOrEqualTo(String value) {
            addCriterion("XBH <=", value, "xbh");
            return (Criteria) this;
        }

        public Criteria andXbhLike(String value) {
            addCriterion("XBH like", value, "xbh");
            return (Criteria) this;
        }

        public Criteria andXbhNotLike(String value) {
            addCriterion("XBH not like", value, "xbh");
            return (Criteria) this;
        }

        public Criteria andXbhIn(List<String> values) {
            addCriterion("XBH in", values, "xbh");
            return (Criteria) this;
        }

        public Criteria andXbhNotIn(List<String> values) {
            addCriterion("XBH not in", values, "xbh");
            return (Criteria) this;
        }

        public Criteria andXbhBetween(String value1, String value2) {
            addCriterion("XBH between", value1, value2, "xbh");
            return (Criteria) this;
        }

        public Criteria andXbhNotBetween(String value1, String value2) {
            addCriterion("XBH not between", value1, value2, "xbh");
            return (Criteria) this;
        }

        public Criteria andAddvnmIsNull() {
            addCriterion("ADDVNM is null");
            return (Criteria) this;
        }

        public Criteria andAddvnmIsNotNull() {
            addCriterion("ADDVNM is not null");
            return (Criteria) this;
        }

        public Criteria andAddvnmEqualTo(String value) {
            addCriterion("ADDVNM =", value, "addvnm");
            return (Criteria) this;
        }

        public Criteria andAddvnmNotEqualTo(String value) {
            addCriterion("ADDVNM <>", value, "addvnm");
            return (Criteria) this;
        }

        public Criteria andAddvnmGreaterThan(String value) {
            addCriterion("ADDVNM >", value, "addvnm");
            return (Criteria) this;
        }

        public Criteria andAddvnmGreaterThanOrEqualTo(String value) {
            addCriterion("ADDVNM >=", value, "addvnm");
            return (Criteria) this;
        }

        public Criteria andAddvnmLessThan(String value) {
            addCriterion("ADDVNM <", value, "addvnm");
            return (Criteria) this;
        }

        public Criteria andAddvnmLessThanOrEqualTo(String value) {
            addCriterion("ADDVNM <=", value, "addvnm");
            return (Criteria) this;
        }

        public Criteria andAddvnmLike(String value) {
            addCriterion("ADDVNM like", value, "addvnm");
            return (Criteria) this;
        }

        public Criteria andAddvnmNotLike(String value) {
            addCriterion("ADDVNM not like", value, "addvnm");
            return (Criteria) this;
        }

        public Criteria andAddvnmIn(List<String> values) {
            addCriterion("ADDVNM in", values, "addvnm");
            return (Criteria) this;
        }

        public Criteria andAddvnmNotIn(List<String> values) {
            addCriterion("ADDVNM not in", values, "addvnm");
            return (Criteria) this;
        }

        public Criteria andAddvnmBetween(String value1, String value2) {
            addCriterion("ADDVNM between", value1, value2, "addvnm");
            return (Criteria) this;
        }

        public Criteria andAddvnmNotBetween(String value1, String value2) {
            addCriterion("ADDVNM not between", value1, value2, "addvnm");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("AREA is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("AREA is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(Double value) {
            addCriterion("AREA =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(Double value) {
            addCriterion("AREA <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(Double value) {
            addCriterion("AREA >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("AREA >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(Double value) {
            addCriterion("AREA <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(Double value) {
            addCriterion("AREA <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<Double> values) {
            addCriterion("AREA in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<Double> values) {
            addCriterion("AREA not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(Double value1, Double value2) {
            addCriterion("AREA between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(Double value1, Double value2) {
            addCriterion("AREA not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andStcdIsNull() {
            addCriterion("STCD is null");
            return (Criteria) this;
        }

        public Criteria andStcdIsNotNull() {
            addCriterion("STCD is not null");
            return (Criteria) this;
        }

        public Criteria andStcdEqualTo(String value) {
            addCriterion("STCD =", value, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdNotEqualTo(String value) {
            addCriterion("STCD <>", value, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdGreaterThan(String value) {
            addCriterion("STCD >", value, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdGreaterThanOrEqualTo(String value) {
            addCriterion("STCD >=", value, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdLessThan(String value) {
            addCriterion("STCD <", value, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdLessThanOrEqualTo(String value) {
            addCriterion("STCD <=", value, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdLike(String value) {
            addCriterion("STCD like", value, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdNotLike(String value) {
            addCriterion("STCD not like", value, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdIn(List<String> values) {
            addCriterion("STCD in", values, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdNotIn(List<String> values) {
            addCriterion("STCD not in", values, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdBetween(String value1, String value2) {
            addCriterion("STCD between", value1, value2, "stcd");
            return (Criteria) this;
        }

        public Criteria andStcdNotBetween(String value1, String value2) {
            addCriterion("STCD not between", value1, value2, "stcd");
            return (Criteria) this;
        }

        public Criteria andUseTypeIsNull() {
            addCriterion("USE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUseTypeIsNotNull() {
            addCriterion("USE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUseTypeEqualTo(String value) {
            addCriterion("USE_TYPE =", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotEqualTo(String value) {
            addCriterion("USE_TYPE <>", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeGreaterThan(String value) {
            addCriterion("USE_TYPE >", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("USE_TYPE >=", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLessThan(String value) {
            addCriterion("USE_TYPE <", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLessThanOrEqualTo(String value) {
            addCriterion("USE_TYPE <=", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLike(String value) {
            addCriterion("USE_TYPE like", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotLike(String value) {
            addCriterion("USE_TYPE not like", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeIn(List<String> values) {
            addCriterion("USE_TYPE in", values, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotIn(List<String> values) {
            addCriterion("USE_TYPE not in", values, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeBetween(String value1, String value2) {
            addCriterion("USE_TYPE between", value1, value2, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotBetween(String value1, String value2) {
            addCriterion("USE_TYPE not between", value1, value2, "useType");
            return (Criteria) this;
        }

        public Criteria andForOwnIsNull() {
            addCriterion("FOR_OWN is null");
            return (Criteria) this;
        }

        public Criteria andForOwnIsNotNull() {
            addCriterion("FOR_OWN is not null");
            return (Criteria) this;
        }

        public Criteria andForOwnEqualTo(String value) {
            addCriterion("FOR_OWN =", value, "forOwn");
            return (Criteria) this;
        }

        public Criteria andForOwnNotEqualTo(String value) {
            addCriterion("FOR_OWN <>", value, "forOwn");
            return (Criteria) this;
        }

        public Criteria andForOwnGreaterThan(String value) {
            addCriterion("FOR_OWN >", value, "forOwn");
            return (Criteria) this;
        }

        public Criteria andForOwnGreaterThanOrEqualTo(String value) {
            addCriterion("FOR_OWN >=", value, "forOwn");
            return (Criteria) this;
        }

        public Criteria andForOwnLessThan(String value) {
            addCriterion("FOR_OWN <", value, "forOwn");
            return (Criteria) this;
        }

        public Criteria andForOwnLessThanOrEqualTo(String value) {
            addCriterion("FOR_OWN <=", value, "forOwn");
            return (Criteria) this;
        }

        public Criteria andForOwnLike(String value) {
            addCriterion("FOR_OWN like", value, "forOwn");
            return (Criteria) this;
        }

        public Criteria andForOwnNotLike(String value) {
            addCriterion("FOR_OWN not like", value, "forOwn");
            return (Criteria) this;
        }

        public Criteria andForOwnIn(List<String> values) {
            addCriterion("FOR_OWN in", values, "forOwn");
            return (Criteria) this;
        }

        public Criteria andForOwnNotIn(List<String> values) {
            addCriterion("FOR_OWN not in", values, "forOwn");
            return (Criteria) this;
        }

        public Criteria andForOwnBetween(String value1, String value2) {
            addCriterion("FOR_OWN between", value1, value2, "forOwn");
            return (Criteria) this;
        }

        public Criteria andForOwnNotBetween(String value1, String value2) {
            addCriterion("FOR_OWN not between", value1, value2, "forOwn");
            return (Criteria) this;
        }

        public Criteria andForUseIsNull() {
            addCriterion("FOR_USE is null");
            return (Criteria) this;
        }

        public Criteria andForUseIsNotNull() {
            addCriterion("FOR_USE is not null");
            return (Criteria) this;
        }

        public Criteria andForUseEqualTo(String value) {
            addCriterion("FOR_USE =", value, "forUse");
            return (Criteria) this;
        }

        public Criteria andForUseNotEqualTo(String value) {
            addCriterion("FOR_USE <>", value, "forUse");
            return (Criteria) this;
        }

        public Criteria andForUseGreaterThan(String value) {
            addCriterion("FOR_USE >", value, "forUse");
            return (Criteria) this;
        }

        public Criteria andForUseGreaterThanOrEqualTo(String value) {
            addCriterion("FOR_USE >=", value, "forUse");
            return (Criteria) this;
        }

        public Criteria andForUseLessThan(String value) {
            addCriterion("FOR_USE <", value, "forUse");
            return (Criteria) this;
        }

        public Criteria andForUseLessThanOrEqualTo(String value) {
            addCriterion("FOR_USE <=", value, "forUse");
            return (Criteria) this;
        }

        public Criteria andForUseLike(String value) {
            addCriterion("FOR_USE like", value, "forUse");
            return (Criteria) this;
        }

        public Criteria andForUseNotLike(String value) {
            addCriterion("FOR_USE not like", value, "forUse");
            return (Criteria) this;
        }

        public Criteria andForUseIn(List<String> values) {
            addCriterion("FOR_USE in", values, "forUse");
            return (Criteria) this;
        }

        public Criteria andForUseNotIn(List<String> values) {
            addCriterion("FOR_USE not in", values, "forUse");
            return (Criteria) this;
        }

        public Criteria andForUseBetween(String value1, String value2) {
            addCriterion("FOR_USE between", value1, value2, "forUse");
            return (Criteria) this;
        }

        public Criteria andForUseNotBetween(String value1, String value2) {
            addCriterion("FOR_USE not between", value1, value2, "forUse");
            return (Criteria) this;
        }

        public Criteria andTreeOwnIsNull() {
            addCriterion("TREE_OWN is null");
            return (Criteria) this;
        }

        public Criteria andTreeOwnIsNotNull() {
            addCriterion("TREE_OWN is not null");
            return (Criteria) this;
        }

        public Criteria andTreeOwnEqualTo(String value) {
            addCriterion("TREE_OWN =", value, "treeOwn");
            return (Criteria) this;
        }

        public Criteria andTreeOwnNotEqualTo(String value) {
            addCriterion("TREE_OWN <>", value, "treeOwn");
            return (Criteria) this;
        }

        public Criteria andTreeOwnGreaterThan(String value) {
            addCriterion("TREE_OWN >", value, "treeOwn");
            return (Criteria) this;
        }

        public Criteria andTreeOwnGreaterThanOrEqualTo(String value) {
            addCriterion("TREE_OWN >=", value, "treeOwn");
            return (Criteria) this;
        }

        public Criteria andTreeOwnLessThan(String value) {
            addCriterion("TREE_OWN <", value, "treeOwn");
            return (Criteria) this;
        }

        public Criteria andTreeOwnLessThanOrEqualTo(String value) {
            addCriterion("TREE_OWN <=", value, "treeOwn");
            return (Criteria) this;
        }

        public Criteria andTreeOwnLike(String value) {
            addCriterion("TREE_OWN like", value, "treeOwn");
            return (Criteria) this;
        }

        public Criteria andTreeOwnNotLike(String value) {
            addCriterion("TREE_OWN not like", value, "treeOwn");
            return (Criteria) this;
        }

        public Criteria andTreeOwnIn(List<String> values) {
            addCriterion("TREE_OWN in", values, "treeOwn");
            return (Criteria) this;
        }

        public Criteria andTreeOwnNotIn(List<String> values) {
            addCriterion("TREE_OWN not in", values, "treeOwn");
            return (Criteria) this;
        }

        public Criteria andTreeOwnBetween(String value1, String value2) {
            addCriterion("TREE_OWN between", value1, value2, "treeOwn");
            return (Criteria) this;
        }

        public Criteria andTreeOwnNotBetween(String value1, String value2) {
            addCriterion("TREE_OWN not between", value1, value2, "treeOwn");
            return (Criteria) this;
        }

        public Criteria andTreeUseIsNull() {
            addCriterion("TREE_USE is null");
            return (Criteria) this;
        }

        public Criteria andTreeUseIsNotNull() {
            addCriterion("TREE_USE is not null");
            return (Criteria) this;
        }

        public Criteria andTreeUseEqualTo(String value) {
            addCriterion("TREE_USE =", value, "treeUse");
            return (Criteria) this;
        }

        public Criteria andTreeUseNotEqualTo(String value) {
            addCriterion("TREE_USE <>", value, "treeUse");
            return (Criteria) this;
        }

        public Criteria andTreeUseGreaterThan(String value) {
            addCriterion("TREE_USE >", value, "treeUse");
            return (Criteria) this;
        }

        public Criteria andTreeUseGreaterThanOrEqualTo(String value) {
            addCriterion("TREE_USE >=", value, "treeUse");
            return (Criteria) this;
        }

        public Criteria andTreeUseLessThan(String value) {
            addCriterion("TREE_USE <", value, "treeUse");
            return (Criteria) this;
        }

        public Criteria andTreeUseLessThanOrEqualTo(String value) {
            addCriterion("TREE_USE <=", value, "treeUse");
            return (Criteria) this;
        }

        public Criteria andTreeUseLike(String value) {
            addCriterion("TREE_USE like", value, "treeUse");
            return (Criteria) this;
        }

        public Criteria andTreeUseNotLike(String value) {
            addCriterion("TREE_USE not like", value, "treeUse");
            return (Criteria) this;
        }

        public Criteria andTreeUseIn(List<String> values) {
            addCriterion("TREE_USE in", values, "treeUse");
            return (Criteria) this;
        }

        public Criteria andTreeUseNotIn(List<String> values) {
            addCriterion("TREE_USE not in", values, "treeUse");
            return (Criteria) this;
        }

        public Criteria andTreeUseBetween(String value1, String value2) {
            addCriterion("TREE_USE between", value1, value2, "treeUse");
            return (Criteria) this;
        }

        public Criteria andTreeUseNotBetween(String value1, String value2) {
            addCriterion("TREE_USE not between", value1, value2, "treeUse");
            return (Criteria) this;
        }

        public Criteria andTreeOwnerIsNull() {
            addCriterion("TREE_OWNER is null");
            return (Criteria) this;
        }

        public Criteria andTreeOwnerIsNotNull() {
            addCriterion("TREE_OWNER is not null");
            return (Criteria) this;
        }

        public Criteria andTreeOwnerEqualTo(String value) {
            addCriterion("TREE_OWNER =", value, "treeOwner");
            return (Criteria) this;
        }

        public Criteria andTreeOwnerNotEqualTo(String value) {
            addCriterion("TREE_OWNER <>", value, "treeOwner");
            return (Criteria) this;
        }

        public Criteria andTreeOwnerGreaterThan(String value) {
            addCriterion("TREE_OWNER >", value, "treeOwner");
            return (Criteria) this;
        }

        public Criteria andTreeOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("TREE_OWNER >=", value, "treeOwner");
            return (Criteria) this;
        }

        public Criteria andTreeOwnerLessThan(String value) {
            addCriterion("TREE_OWNER <", value, "treeOwner");
            return (Criteria) this;
        }

        public Criteria andTreeOwnerLessThanOrEqualTo(String value) {
            addCriterion("TREE_OWNER <=", value, "treeOwner");
            return (Criteria) this;
        }

        public Criteria andTreeOwnerLike(String value) {
            addCriterion("TREE_OWNER like", value, "treeOwner");
            return (Criteria) this;
        }

        public Criteria andTreeOwnerNotLike(String value) {
            addCriterion("TREE_OWNER not like", value, "treeOwner");
            return (Criteria) this;
        }

        public Criteria andTreeOwnerIn(List<String> values) {
            addCriterion("TREE_OWNER in", values, "treeOwner");
            return (Criteria) this;
        }

        public Criteria andTreeOwnerNotIn(List<String> values) {
            addCriterion("TREE_OWNER not in", values, "treeOwner");
            return (Criteria) this;
        }

        public Criteria andTreeOwnerBetween(String value1, String value2) {
            addCriterion("TREE_OWNER between", value1, value2, "treeOwner");
            return (Criteria) this;
        }

        public Criteria andTreeOwnerNotBetween(String value1, String value2) {
            addCriterion("TREE_OWNER not between", value1, value2, "treeOwner");
            return (Criteria) this;
        }

        public Criteria andFoundYearIsNull() {
            addCriterion("FOUND_YEAR is null");
            return (Criteria) this;
        }

        public Criteria andFoundYearIsNotNull() {
            addCriterion("FOUND_YEAR is not null");
            return (Criteria) this;
        }

        public Criteria andFoundYearEqualTo(String value) {
            addCriterion("FOUND_YEAR =", value, "foundYear");
            return (Criteria) this;
        }

        public Criteria andFoundYearNotEqualTo(String value) {
            addCriterion("FOUND_YEAR <>", value, "foundYear");
            return (Criteria) this;
        }

        public Criteria andFoundYearGreaterThan(String value) {
            addCriterion("FOUND_YEAR >", value, "foundYear");
            return (Criteria) this;
        }

        public Criteria andFoundYearGreaterThanOrEqualTo(String value) {
            addCriterion("FOUND_YEAR >=", value, "foundYear");
            return (Criteria) this;
        }

        public Criteria andFoundYearLessThan(String value) {
            addCriterion("FOUND_YEAR <", value, "foundYear");
            return (Criteria) this;
        }

        public Criteria andFoundYearLessThanOrEqualTo(String value) {
            addCriterion("FOUND_YEAR <=", value, "foundYear");
            return (Criteria) this;
        }

        public Criteria andFoundYearLike(String value) {
            addCriterion("FOUND_YEAR like", value, "foundYear");
            return (Criteria) this;
        }

        public Criteria andFoundYearNotLike(String value) {
            addCriterion("FOUND_YEAR not like", value, "foundYear");
            return (Criteria) this;
        }

        public Criteria andFoundYearIn(List<String> values) {
            addCriterion("FOUND_YEAR in", values, "foundYear");
            return (Criteria) this;
        }

        public Criteria andFoundYearNotIn(List<String> values) {
            addCriterion("FOUND_YEAR not in", values, "foundYear");
            return (Criteria) this;
        }

        public Criteria andFoundYearBetween(String value1, String value2) {
            addCriterion("FOUND_YEAR between", value1, value2, "foundYear");
            return (Criteria) this;
        }

        public Criteria andFoundYearNotBetween(String value1, String value2) {
            addCriterion("FOUND_YEAR not between", value1, value2, "foundYear");
            return (Criteria) this;
        }

        public Criteria andModtmIsNull() {
            addCriterion("MODTM is null");
            return (Criteria) this;
        }

        public Criteria andModtmIsNotNull() {
            addCriterion("MODTM is not null");
            return (Criteria) this;
        }

        public Criteria andModtmEqualTo(Date value) {
            addCriterion("MODTM =", value, "modtm");
            return (Criteria) this;
        }

        public Criteria andModtmNotEqualTo(Date value) {
            addCriterion("MODTM <>", value, "modtm");
            return (Criteria) this;
        }

        public Criteria andModtmGreaterThan(Date value) {
            addCriterion("MODTM >", value, "modtm");
            return (Criteria) this;
        }

        public Criteria andModtmGreaterThanOrEqualTo(Date value) {
            addCriterion("MODTM >=", value, "modtm");
            return (Criteria) this;
        }

        public Criteria andModtmLessThan(Date value) {
            addCriterion("MODTM <", value, "modtm");
            return (Criteria) this;
        }

        public Criteria andModtmLessThanOrEqualTo(Date value) {
            addCriterion("MODTM <=", value, "modtm");
            return (Criteria) this;
        }

        public Criteria andModtmIn(List<Date> values) {
            addCriterion("MODTM in", values, "modtm");
            return (Criteria) this;
        }

        public Criteria andModtmNotIn(List<Date> values) {
            addCriterion("MODTM not in", values, "modtm");
            return (Criteria) this;
        }

        public Criteria andModtmBetween(Date value1, Date value2) {
            addCriterion("MODTM between", value1, value2, "modtm");
            return (Criteria) this;
        }

        public Criteria andModtmNotBetween(Date value1, Date value2) {
            addCriterion("MODTM not between", value1, value2, "modtm");
            return (Criteria) this;
        }

        public Criteria andTreeAgeIsNull() {
            addCriterion("TREE_AGE is null");
            return (Criteria) this;
        }

        public Criteria andTreeAgeIsNotNull() {
            addCriterion("TREE_AGE is not null");
            return (Criteria) this;
        }

        public Criteria andTreeAgeEqualTo(Integer value) {
            addCriterion("TREE_AGE =", value, "treeAge");
            return (Criteria) this;
        }

        public Criteria andTreeAgeNotEqualTo(Integer value) {
            addCriterion("TREE_AGE <>", value, "treeAge");
            return (Criteria) this;
        }

        public Criteria andTreeAgeGreaterThan(Integer value) {
            addCriterion("TREE_AGE >", value, "treeAge");
            return (Criteria) this;
        }

        public Criteria andTreeAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TREE_AGE >=", value, "treeAge");
            return (Criteria) this;
        }

        public Criteria andTreeAgeLessThan(Integer value) {
            addCriterion("TREE_AGE <", value, "treeAge");
            return (Criteria) this;
        }

        public Criteria andTreeAgeLessThanOrEqualTo(Integer value) {
            addCriterion("TREE_AGE <=", value, "treeAge");
            return (Criteria) this;
        }

        public Criteria andTreeAgeIn(List<Integer> values) {
            addCriterion("TREE_AGE in", values, "treeAge");
            return (Criteria) this;
        }

        public Criteria andTreeAgeNotIn(List<Integer> values) {
            addCriterion("TREE_AGE not in", values, "treeAge");
            return (Criteria) this;
        }

        public Criteria andTreeAgeBetween(Integer value1, Integer value2) {
            addCriterion("TREE_AGE between", value1, value2, "treeAge");
            return (Criteria) this;
        }

        public Criteria andTreeAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("TREE_AGE not between", value1, value2, "treeAge");
            return (Criteria) this;
        }

        public Criteria andAgeGroupIsNull() {
            addCriterion("AGE_GROUP is null");
            return (Criteria) this;
        }

        public Criteria andAgeGroupIsNotNull() {
            addCriterion("AGE_GROUP is not null");
            return (Criteria) this;
        }

        public Criteria andAgeGroupEqualTo(String value) {
            addCriterion("AGE_GROUP =", value, "ageGroup");
            return (Criteria) this;
        }

        public Criteria andAgeGroupNotEqualTo(String value) {
            addCriterion("AGE_GROUP <>", value, "ageGroup");
            return (Criteria) this;
        }

        public Criteria andAgeGroupGreaterThan(String value) {
            addCriterion("AGE_GROUP >", value, "ageGroup");
            return (Criteria) this;
        }

        public Criteria andAgeGroupGreaterThanOrEqualTo(String value) {
            addCriterion("AGE_GROUP >=", value, "ageGroup");
            return (Criteria) this;
        }

        public Criteria andAgeGroupLessThan(String value) {
            addCriterion("AGE_GROUP <", value, "ageGroup");
            return (Criteria) this;
        }

        public Criteria andAgeGroupLessThanOrEqualTo(String value) {
            addCriterion("AGE_GROUP <=", value, "ageGroup");
            return (Criteria) this;
        }

        public Criteria andAgeGroupLike(String value) {
            addCriterion("AGE_GROUP like", value, "ageGroup");
            return (Criteria) this;
        }

        public Criteria andAgeGroupNotLike(String value) {
            addCriterion("AGE_GROUP not like", value, "ageGroup");
            return (Criteria) this;
        }

        public Criteria andAgeGroupIn(List<String> values) {
            addCriterion("AGE_GROUP in", values, "ageGroup");
            return (Criteria) this;
        }

        public Criteria andAgeGroupNotIn(List<String> values) {
            addCriterion("AGE_GROUP not in", values, "ageGroup");
            return (Criteria) this;
        }

        public Criteria andAgeGroupBetween(String value1, String value2) {
            addCriterion("AGE_GROUP between", value1, value2, "ageGroup");
            return (Criteria) this;
        }

        public Criteria andAgeGroupNotBetween(String value1, String value2) {
            addCriterion("AGE_GROUP not between", value1, value2, "ageGroup");
            return (Criteria) this;
        }
    }

    /**
     * F_XBH_B
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * F_XBH_B 2018-07-20
     */
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