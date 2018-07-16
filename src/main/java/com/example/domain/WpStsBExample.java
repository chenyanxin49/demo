package com.example.domain;

import java.util.ArrayList;
import java.util.List;

public class WpStsBExample {
    /**
     * WP_STS_B
     */
    protected String orderByClause;

    /**
     * WP_STS_B
     */
    protected boolean distinct;

    /**
     * WP_STS_B
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated 2018-07-08
     */
    public WpStsBExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbggenerated 2018-07-08
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbggenerated 2018-07-08
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbggenerated 2018-07-08
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbggenerated 2018-07-08
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbggenerated 2018-07-08
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbggenerated 2018-07-08
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbggenerated 2018-07-08
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbggenerated 2018-07-08
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
     * @mbggenerated 2018-07-08
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbggenerated 2018-07-08
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * WP_STS_B 2018-07-08
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStsnmIsNull() {
            addCriterion("STSNM is null");
            return (Criteria) this;
        }

        public Criteria andStsnmIsNotNull() {
            addCriterion("STSNM is not null");
            return (Criteria) this;
        }

        public Criteria andStsnmEqualTo(String value) {
            addCriterion("STSNM =", value, "stsnm");
            return (Criteria) this;
        }

        public Criteria andStsnmNotEqualTo(String value) {
            addCriterion("STSNM <>", value, "stsnm");
            return (Criteria) this;
        }

        public Criteria andStsnmGreaterThan(String value) {
            addCriterion("STSNM >", value, "stsnm");
            return (Criteria) this;
        }

        public Criteria andStsnmGreaterThanOrEqualTo(String value) {
            addCriterion("STSNM >=", value, "stsnm");
            return (Criteria) this;
        }

        public Criteria andStsnmLessThan(String value) {
            addCriterion("STSNM <", value, "stsnm");
            return (Criteria) this;
        }

        public Criteria andStsnmLessThanOrEqualTo(String value) {
            addCriterion("STSNM <=", value, "stsnm");
            return (Criteria) this;
        }

        public Criteria andStsnmLike(String value) {
            addCriterion("STSNM like", value, "stsnm");
            return (Criteria) this;
        }

        public Criteria andStsnmNotLike(String value) {
            addCriterion("STSNM not like", value, "stsnm");
            return (Criteria) this;
        }

        public Criteria andStsnmIn(List<String> values) {
            addCriterion("STSNM in", values, "stsnm");
            return (Criteria) this;
        }

        public Criteria andStsnmNotIn(List<String> values) {
            addCriterion("STSNM not in", values, "stsnm");
            return (Criteria) this;
        }

        public Criteria andStsnmBetween(String value1, String value2) {
            addCriterion("STSNM between", value1, value2, "stsnm");
            return (Criteria) this;
        }

        public Criteria andStsnmNotBetween(String value1, String value2) {
            addCriterion("STSNM not between", value1, value2, "stsnm");
            return (Criteria) this;
        }

        public Criteria andLocIsNull() {
            addCriterion("LOC is null");
            return (Criteria) this;
        }

        public Criteria andLocIsNotNull() {
            addCriterion("LOC is not null");
            return (Criteria) this;
        }

        public Criteria andLocEqualTo(String value) {
            addCriterion("LOC =", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocNotEqualTo(String value) {
            addCriterion("LOC <>", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocGreaterThan(String value) {
            addCriterion("LOC >", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocGreaterThanOrEqualTo(String value) {
            addCriterion("LOC >=", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocLessThan(String value) {
            addCriterion("LOC <", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocLessThanOrEqualTo(String value) {
            addCriterion("LOC <=", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocLike(String value) {
            addCriterion("LOC like", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocNotLike(String value) {
            addCriterion("LOC not like", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocIn(List<String> values) {
            addCriterion("LOC in", values, "loc");
            return (Criteria) this;
        }

        public Criteria andLocNotIn(List<String> values) {
            addCriterion("LOC not in", values, "loc");
            return (Criteria) this;
        }

        public Criteria andLocBetween(String value1, String value2) {
            addCriterion("LOC between", value1, value2, "loc");
            return (Criteria) this;
        }

        public Criteria andLocNotBetween(String value1, String value2) {
            addCriterion("LOC not between", value1, value2, "loc");
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

        public Criteria andLgtdIsNull() {
            addCriterion("LGTD is null");
            return (Criteria) this;
        }

        public Criteria andLgtdIsNotNull() {
            addCriterion("LGTD is not null");
            return (Criteria) this;
        }

        public Criteria andLgtdEqualTo(Double value) {
            addCriterion("LGTD =", value, "lgtd");
            return (Criteria) this;
        }

        public Criteria andLgtdNotEqualTo(Double value) {
            addCriterion("LGTD <>", value, "lgtd");
            return (Criteria) this;
        }

        public Criteria andLgtdGreaterThan(Double value) {
            addCriterion("LGTD >", value, "lgtd");
            return (Criteria) this;
        }

        public Criteria andLgtdGreaterThanOrEqualTo(Double value) {
            addCriterion("LGTD >=", value, "lgtd");
            return (Criteria) this;
        }

        public Criteria andLgtdLessThan(Double value) {
            addCriterion("LGTD <", value, "lgtd");
            return (Criteria) this;
        }

        public Criteria andLgtdLessThanOrEqualTo(Double value) {
            addCriterion("LGTD <=", value, "lgtd");
            return (Criteria) this;
        }

        public Criteria andLgtdIn(List<Double> values) {
            addCriterion("LGTD in", values, "lgtd");
            return (Criteria) this;
        }

        public Criteria andLgtdNotIn(List<Double> values) {
            addCriterion("LGTD not in", values, "lgtd");
            return (Criteria) this;
        }

        public Criteria andLgtdBetween(Double value1, Double value2) {
            addCriterion("LGTD between", value1, value2, "lgtd");
            return (Criteria) this;
        }

        public Criteria andLgtdNotBetween(Double value1, Double value2) {
            addCriterion("LGTD not between", value1, value2, "lgtd");
            return (Criteria) this;
        }

        public Criteria andLttdIsNull() {
            addCriterion("LTTD is null");
            return (Criteria) this;
        }

        public Criteria andLttdIsNotNull() {
            addCriterion("LTTD is not null");
            return (Criteria) this;
        }

        public Criteria andLttdEqualTo(Double value) {
            addCriterion("LTTD =", value, "lttd");
            return (Criteria) this;
        }

        public Criteria andLttdNotEqualTo(Double value) {
            addCriterion("LTTD <>", value, "lttd");
            return (Criteria) this;
        }

        public Criteria andLttdGreaterThan(Double value) {
            addCriterion("LTTD >", value, "lttd");
            return (Criteria) this;
        }

        public Criteria andLttdGreaterThanOrEqualTo(Double value) {
            addCriterion("LTTD >=", value, "lttd");
            return (Criteria) this;
        }

        public Criteria andLttdLessThan(Double value) {
            addCriterion("LTTD <", value, "lttd");
            return (Criteria) this;
        }

        public Criteria andLttdLessThanOrEqualTo(Double value) {
            addCriterion("LTTD <=", value, "lttd");
            return (Criteria) this;
        }

        public Criteria andLttdIn(List<Double> values) {
            addCriterion("LTTD in", values, "lttd");
            return (Criteria) this;
        }

        public Criteria andLttdNotIn(List<Double> values) {
            addCriterion("LTTD not in", values, "lttd");
            return (Criteria) this;
        }

        public Criteria andLttdBetween(Double value1, Double value2) {
            addCriterion("LTTD between", value1, value2, "lttd");
            return (Criteria) this;
        }

        public Criteria andLttdNotBetween(Double value1, Double value2) {
            addCriterion("LTTD not between", value1, value2, "lttd");
            return (Criteria) this;
        }

        public Criteria andDdstcIsNull() {
            addCriterion("DDSTC is null");
            return (Criteria) this;
        }

        public Criteria andDdstcIsNotNull() {
            addCriterion("DDSTC is not null");
            return (Criteria) this;
        }

        public Criteria andDdstcEqualTo(Double value) {
            addCriterion("DDSTC =", value, "ddstc");
            return (Criteria) this;
        }

        public Criteria andDdstcNotEqualTo(Double value) {
            addCriterion("DDSTC <>", value, "ddstc");
            return (Criteria) this;
        }

        public Criteria andDdstcGreaterThan(Double value) {
            addCriterion("DDSTC >", value, "ddstc");
            return (Criteria) this;
        }

        public Criteria andDdstcGreaterThanOrEqualTo(Double value) {
            addCriterion("DDSTC >=", value, "ddstc");
            return (Criteria) this;
        }

        public Criteria andDdstcLessThan(Double value) {
            addCriterion("DDSTC <", value, "ddstc");
            return (Criteria) this;
        }

        public Criteria andDdstcLessThanOrEqualTo(Double value) {
            addCriterion("DDSTC <=", value, "ddstc");
            return (Criteria) this;
        }

        public Criteria andDdstcIn(List<Double> values) {
            addCriterion("DDSTC in", values, "ddstc");
            return (Criteria) this;
        }

        public Criteria andDdstcNotIn(List<Double> values) {
            addCriterion("DDSTC not in", values, "ddstc");
            return (Criteria) this;
        }

        public Criteria andDdstcBetween(Double value1, Double value2) {
            addCriterion("DDSTC between", value1, value2, "ddstc");
            return (Criteria) this;
        }

        public Criteria andDdstcNotBetween(Double value1, Double value2) {
            addCriterion("DDSTC not between", value1, value2, "ddstc");
            return (Criteria) this;
        }

        public Criteria andYdstcIsNull() {
            addCriterion("YDSTC is null");
            return (Criteria) this;
        }

        public Criteria andYdstcIsNotNull() {
            addCriterion("YDSTC is not null");
            return (Criteria) this;
        }

        public Criteria andYdstcEqualTo(Double value) {
            addCriterion("YDSTC =", value, "ydstc");
            return (Criteria) this;
        }

        public Criteria andYdstcNotEqualTo(Double value) {
            addCriterion("YDSTC <>", value, "ydstc");
            return (Criteria) this;
        }

        public Criteria andYdstcGreaterThan(Double value) {
            addCriterion("YDSTC >", value, "ydstc");
            return (Criteria) this;
        }

        public Criteria andYdstcGreaterThanOrEqualTo(Double value) {
            addCriterion("YDSTC >=", value, "ydstc");
            return (Criteria) this;
        }

        public Criteria andYdstcLessThan(Double value) {
            addCriterion("YDSTC <", value, "ydstc");
            return (Criteria) this;
        }

        public Criteria andYdstcLessThanOrEqualTo(Double value) {
            addCriterion("YDSTC <=", value, "ydstc");
            return (Criteria) this;
        }

        public Criteria andYdstcIn(List<Double> values) {
            addCriterion("YDSTC in", values, "ydstc");
            return (Criteria) this;
        }

        public Criteria andYdstcNotIn(List<Double> values) {
            addCriterion("YDSTC not in", values, "ydstc");
            return (Criteria) this;
        }

        public Criteria andYdstcBetween(Double value1, Double value2) {
            addCriterion("YDSTC between", value1, value2, "ydstc");
            return (Criteria) this;
        }

        public Criteria andYdstcNotBetween(Double value1, Double value2) {
            addCriterion("YDSTC not between", value1, value2, "ydstc");
            return (Criteria) this;
        }

        public Criteria andProcessIsNull() {
            addCriterion("PROCESS is null");
            return (Criteria) this;
        }

        public Criteria andProcessIsNotNull() {
            addCriterion("PROCESS is not null");
            return (Criteria) this;
        }

        public Criteria andProcessEqualTo(String value) {
            addCriterion("PROCESS =", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessNotEqualTo(String value) {
            addCriterion("PROCESS <>", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessGreaterThan(String value) {
            addCriterion("PROCESS >", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessGreaterThanOrEqualTo(String value) {
            addCriterion("PROCESS >=", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessLessThan(String value) {
            addCriterion("PROCESS <", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessLessThanOrEqualTo(String value) {
            addCriterion("PROCESS <=", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessLike(String value) {
            addCriterion("PROCESS like", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessNotLike(String value) {
            addCriterion("PROCESS not like", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessIn(List<String> values) {
            addCriterion("PROCESS in", values, "process");
            return (Criteria) this;
        }

        public Criteria andProcessNotIn(List<String> values) {
            addCriterion("PROCESS not in", values, "process");
            return (Criteria) this;
        }

        public Criteria andProcessBetween(String value1, String value2) {
            addCriterion("PROCESS between", value1, value2, "process");
            return (Criteria) this;
        }

        public Criteria andProcessNotBetween(String value1, String value2) {
            addCriterion("PROCESS not between", value1, value2, "process");
            return (Criteria) this;
        }

        public Criteria andTargetIsNull() {
            addCriterion("TARGET is null");
            return (Criteria) this;
        }

        public Criteria andTargetIsNotNull() {
            addCriterion("TARGET is not null");
            return (Criteria) this;
        }

        public Criteria andTargetEqualTo(Integer value) {
            addCriterion("TARGET =", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotEqualTo(Integer value) {
            addCriterion("TARGET <>", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetGreaterThan(Integer value) {
            addCriterion("TARGET >", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetGreaterThanOrEqualTo(Integer value) {
            addCriterion("TARGET >=", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLessThan(Integer value) {
            addCriterion("TARGET <", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLessThanOrEqualTo(Integer value) {
            addCriterion("TARGET <=", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetIn(List<Integer> values) {
            addCriterion("TARGET in", values, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotIn(List<Integer> values) {
            addCriterion("TARGET not in", values, "target");
            return (Criteria) this;
        }

        public Criteria andTargetBetween(Integer value1, Integer value2) {
            addCriterion("TARGET between", value1, value2, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotBetween(Integer value1, Integer value2) {
            addCriterion("TARGET not between", value1, value2, "target");
            return (Criteria) this;
        }

        public Criteria andRlnmIsNull() {
            addCriterion("RLNM is null");
            return (Criteria) this;
        }

        public Criteria andRlnmIsNotNull() {
            addCriterion("RLNM is not null");
            return (Criteria) this;
        }

        public Criteria andRlnmEqualTo(String value) {
            addCriterion("RLNM =", value, "rlnm");
            return (Criteria) this;
        }

        public Criteria andRlnmNotEqualTo(String value) {
            addCriterion("RLNM <>", value, "rlnm");
            return (Criteria) this;
        }

        public Criteria andRlnmGreaterThan(String value) {
            addCriterion("RLNM >", value, "rlnm");
            return (Criteria) this;
        }

        public Criteria andRlnmGreaterThanOrEqualTo(String value) {
            addCriterion("RLNM >=", value, "rlnm");
            return (Criteria) this;
        }

        public Criteria andRlnmLessThan(String value) {
            addCriterion("RLNM <", value, "rlnm");
            return (Criteria) this;
        }

        public Criteria andRlnmLessThanOrEqualTo(String value) {
            addCriterion("RLNM <=", value, "rlnm");
            return (Criteria) this;
        }

        public Criteria andRlnmLike(String value) {
            addCriterion("RLNM like", value, "rlnm");
            return (Criteria) this;
        }

        public Criteria andRlnmNotLike(String value) {
            addCriterion("RLNM not like", value, "rlnm");
            return (Criteria) this;
        }

        public Criteria andRlnmIn(List<String> values) {
            addCriterion("RLNM in", values, "rlnm");
            return (Criteria) this;
        }

        public Criteria andRlnmNotIn(List<String> values) {
            addCriterion("RLNM not in", values, "rlnm");
            return (Criteria) this;
        }

        public Criteria andRlnmBetween(String value1, String value2) {
            addCriterion("RLNM between", value1, value2, "rlnm");
            return (Criteria) this;
        }

        public Criteria andRlnmNotBetween(String value1, String value2) {
            addCriterion("RLNM not between", value1, value2, "rlnm");
            return (Criteria) this;
        }

        public Criteria andEmistpIsNull() {
            addCriterion("EMISTP is null");
            return (Criteria) this;
        }

        public Criteria andEmistpIsNotNull() {
            addCriterion("EMISTP is not null");
            return (Criteria) this;
        }

        public Criteria andEmistpEqualTo(String value) {
            addCriterion("EMISTP =", value, "emistp");
            return (Criteria) this;
        }

        public Criteria andEmistpNotEqualTo(String value) {
            addCriterion("EMISTP <>", value, "emistp");
            return (Criteria) this;
        }

        public Criteria andEmistpGreaterThan(String value) {
            addCriterion("EMISTP >", value, "emistp");
            return (Criteria) this;
        }

        public Criteria andEmistpGreaterThanOrEqualTo(String value) {
            addCriterion("EMISTP >=", value, "emistp");
            return (Criteria) this;
        }

        public Criteria andEmistpLessThan(String value) {
            addCriterion("EMISTP <", value, "emistp");
            return (Criteria) this;
        }

        public Criteria andEmistpLessThanOrEqualTo(String value) {
            addCriterion("EMISTP <=", value, "emistp");
            return (Criteria) this;
        }

        public Criteria andEmistpLike(String value) {
            addCriterion("EMISTP like", value, "emistp");
            return (Criteria) this;
        }

        public Criteria andEmistpNotLike(String value) {
            addCriterion("EMISTP not like", value, "emistp");
            return (Criteria) this;
        }

        public Criteria andEmistpIn(List<String> values) {
            addCriterion("EMISTP in", values, "emistp");
            return (Criteria) this;
        }

        public Criteria andEmistpNotIn(List<String> values) {
            addCriterion("EMISTP not in", values, "emistp");
            return (Criteria) this;
        }

        public Criteria andEmistpBetween(String value1, String value2) {
            addCriterion("EMISTP between", value1, value2, "emistp");
            return (Criteria) this;
        }

        public Criteria andEmistpNotBetween(String value1, String value2) {
            addCriterion("EMISTP not between", value1, value2, "emistp");
            return (Criteria) this;
        }

        public Criteria andPdosourIsNull() {
            addCriterion("PDOSOUR is null");
            return (Criteria) this;
        }

        public Criteria andPdosourIsNotNull() {
            addCriterion("PDOSOUR is not null");
            return (Criteria) this;
        }

        public Criteria andPdosourEqualTo(String value) {
            addCriterion("PDOSOUR =", value, "pdosour");
            return (Criteria) this;
        }

        public Criteria andPdosourNotEqualTo(String value) {
            addCriterion("PDOSOUR <>", value, "pdosour");
            return (Criteria) this;
        }

        public Criteria andPdosourGreaterThan(String value) {
            addCriterion("PDOSOUR >", value, "pdosour");
            return (Criteria) this;
        }

        public Criteria andPdosourGreaterThanOrEqualTo(String value) {
            addCriterion("PDOSOUR >=", value, "pdosour");
            return (Criteria) this;
        }

        public Criteria andPdosourLessThan(String value) {
            addCriterion("PDOSOUR <", value, "pdosour");
            return (Criteria) this;
        }

        public Criteria andPdosourLessThanOrEqualTo(String value) {
            addCriterion("PDOSOUR <=", value, "pdosour");
            return (Criteria) this;
        }

        public Criteria andPdosourLike(String value) {
            addCriterion("PDOSOUR like", value, "pdosour");
            return (Criteria) this;
        }

        public Criteria andPdosourNotLike(String value) {
            addCriterion("PDOSOUR not like", value, "pdosour");
            return (Criteria) this;
        }

        public Criteria andPdosourIn(List<String> values) {
            addCriterion("PDOSOUR in", values, "pdosour");
            return (Criteria) this;
        }

        public Criteria andPdosourNotIn(List<String> values) {
            addCriterion("PDOSOUR not in", values, "pdosour");
            return (Criteria) this;
        }

        public Criteria andPdosourBetween(String value1, String value2) {
            addCriterion("PDOSOUR between", value1, value2, "pdosour");
            return (Criteria) this;
        }

        public Criteria andPdosourNotBetween(String value1, String value2) {
            addCriterion("PDOSOUR not between", value1, value2, "pdosour");
            return (Criteria) this;
        }

        public Criteria andInrvtpIsNull() {
            addCriterion("INRVTP is null");
            return (Criteria) this;
        }

        public Criteria andInrvtpIsNotNull() {
            addCriterion("INRVTP is not null");
            return (Criteria) this;
        }

        public Criteria andInrvtpEqualTo(String value) {
            addCriterion("INRVTP =", value, "inrvtp");
            return (Criteria) this;
        }

        public Criteria andInrvtpNotEqualTo(String value) {
            addCriterion("INRVTP <>", value, "inrvtp");
            return (Criteria) this;
        }

        public Criteria andInrvtpGreaterThan(String value) {
            addCriterion("INRVTP >", value, "inrvtp");
            return (Criteria) this;
        }

        public Criteria andInrvtpGreaterThanOrEqualTo(String value) {
            addCriterion("INRVTP >=", value, "inrvtp");
            return (Criteria) this;
        }

        public Criteria andInrvtpLessThan(String value) {
            addCriterion("INRVTP <", value, "inrvtp");
            return (Criteria) this;
        }

        public Criteria andInrvtpLessThanOrEqualTo(String value) {
            addCriterion("INRVTP <=", value, "inrvtp");
            return (Criteria) this;
        }

        public Criteria andInrvtpLike(String value) {
            addCriterion("INRVTP like", value, "inrvtp");
            return (Criteria) this;
        }

        public Criteria andInrvtpNotLike(String value) {
            addCriterion("INRVTP not like", value, "inrvtp");
            return (Criteria) this;
        }

        public Criteria andInrvtpIn(List<String> values) {
            addCriterion("INRVTP in", values, "inrvtp");
            return (Criteria) this;
        }

        public Criteria andInrvtpNotIn(List<String> values) {
            addCriterion("INRVTP not in", values, "inrvtp");
            return (Criteria) this;
        }

        public Criteria andInrvtpBetween(String value1, String value2) {
            addCriterion("INRVTP between", value1, value2, "inrvtp");
            return (Criteria) this;
        }

        public Criteria andInrvtpNotBetween(String value1, String value2) {
            addCriterion("INRVTP not between", value1, value2, "inrvtp");
            return (Criteria) this;
        }

        public Criteria andPdosizeIsNull() {
            addCriterion("PDOSIZE is null");
            return (Criteria) this;
        }

        public Criteria andPdosizeIsNotNull() {
            addCriterion("PDOSIZE is not null");
            return (Criteria) this;
        }

        public Criteria andPdosizeEqualTo(String value) {
            addCriterion("PDOSIZE =", value, "pdosize");
            return (Criteria) this;
        }

        public Criteria andPdosizeNotEqualTo(String value) {
            addCriterion("PDOSIZE <>", value, "pdosize");
            return (Criteria) this;
        }

        public Criteria andPdosizeGreaterThan(String value) {
            addCriterion("PDOSIZE >", value, "pdosize");
            return (Criteria) this;
        }

        public Criteria andPdosizeGreaterThanOrEqualTo(String value) {
            addCriterion("PDOSIZE >=", value, "pdosize");
            return (Criteria) this;
        }

        public Criteria andPdosizeLessThan(String value) {
            addCriterion("PDOSIZE <", value, "pdosize");
            return (Criteria) this;
        }

        public Criteria andPdosizeLessThanOrEqualTo(String value) {
            addCriterion("PDOSIZE <=", value, "pdosize");
            return (Criteria) this;
        }

        public Criteria andPdosizeLike(String value) {
            addCriterion("PDOSIZE like", value, "pdosize");
            return (Criteria) this;
        }

        public Criteria andPdosizeNotLike(String value) {
            addCriterion("PDOSIZE not like", value, "pdosize");
            return (Criteria) this;
        }

        public Criteria andPdosizeIn(List<String> values) {
            addCriterion("PDOSIZE in", values, "pdosize");
            return (Criteria) this;
        }

        public Criteria andPdosizeNotIn(List<String> values) {
            addCriterion("PDOSIZE not in", values, "pdosize");
            return (Criteria) this;
        }

        public Criteria andPdosizeBetween(String value1, String value2) {
            addCriterion("PDOSIZE between", value1, value2, "pdosize");
            return (Criteria) this;
        }

        public Criteria andPdosizeNotBetween(String value1, String value2) {
            addCriterion("PDOSIZE not between", value1, value2, "pdosize");
            return (Criteria) this;
        }

        public Criteria andKeypolluIsNull() {
            addCriterion("KEYPOLLU is null");
            return (Criteria) this;
        }

        public Criteria andKeypolluIsNotNull() {
            addCriterion("KEYPOLLU is not null");
            return (Criteria) this;
        }

        public Criteria andKeypolluEqualTo(String value) {
            addCriterion("KEYPOLLU =", value, "keypollu");
            return (Criteria) this;
        }

        public Criteria andKeypolluNotEqualTo(String value) {
            addCriterion("KEYPOLLU <>", value, "keypollu");
            return (Criteria) this;
        }

        public Criteria andKeypolluGreaterThan(String value) {
            addCriterion("KEYPOLLU >", value, "keypollu");
            return (Criteria) this;
        }

        public Criteria andKeypolluGreaterThanOrEqualTo(String value) {
            addCriterion("KEYPOLLU >=", value, "keypollu");
            return (Criteria) this;
        }

        public Criteria andKeypolluLessThan(String value) {
            addCriterion("KEYPOLLU <", value, "keypollu");
            return (Criteria) this;
        }

        public Criteria andKeypolluLessThanOrEqualTo(String value) {
            addCriterion("KEYPOLLU <=", value, "keypollu");
            return (Criteria) this;
        }

        public Criteria andKeypolluLike(String value) {
            addCriterion("KEYPOLLU like", value, "keypollu");
            return (Criteria) this;
        }

        public Criteria andKeypolluNotLike(String value) {
            addCriterion("KEYPOLLU not like", value, "keypollu");
            return (Criteria) this;
        }

        public Criteria andKeypolluIn(List<String> values) {
            addCriterion("KEYPOLLU in", values, "keypollu");
            return (Criteria) this;
        }

        public Criteria andKeypolluNotIn(List<String> values) {
            addCriterion("KEYPOLLU not in", values, "keypollu");
            return (Criteria) this;
        }

        public Criteria andKeypolluBetween(String value1, String value2) {
            addCriterion("KEYPOLLU between", value1, value2, "keypollu");
            return (Criteria) this;
        }

        public Criteria andKeypolluNotBetween(String value1, String value2) {
            addCriterion("KEYPOLLU not between", value1, value2, "keypollu");
            return (Criteria) this;
        }

        public Criteria andEsstymIsNull() {
            addCriterion("ESSTYM is null");
            return (Criteria) this;
        }

        public Criteria andEsstymIsNotNull() {
            addCriterion("ESSTYM is not null");
            return (Criteria) this;
        }

        public Criteria andEsstymEqualTo(String value) {
            addCriterion("ESSTYM =", value, "esstym");
            return (Criteria) this;
        }

        public Criteria andEsstymNotEqualTo(String value) {
            addCriterion("ESSTYM <>", value, "esstym");
            return (Criteria) this;
        }

        public Criteria andEsstymGreaterThan(String value) {
            addCriterion("ESSTYM >", value, "esstym");
            return (Criteria) this;
        }

        public Criteria andEsstymGreaterThanOrEqualTo(String value) {
            addCriterion("ESSTYM >=", value, "esstym");
            return (Criteria) this;
        }

        public Criteria andEsstymLessThan(String value) {
            addCriterion("ESSTYM <", value, "esstym");
            return (Criteria) this;
        }

        public Criteria andEsstymLessThanOrEqualTo(String value) {
            addCriterion("ESSTYM <=", value, "esstym");
            return (Criteria) this;
        }

        public Criteria andEsstymLike(String value) {
            addCriterion("ESSTYM like", value, "esstym");
            return (Criteria) this;
        }

        public Criteria andEsstymNotLike(String value) {
            addCriterion("ESSTYM not like", value, "esstym");
            return (Criteria) this;
        }

        public Criteria andEsstymIn(List<String> values) {
            addCriterion("ESSTYM in", values, "esstym");
            return (Criteria) this;
        }

        public Criteria andEsstymNotIn(List<String> values) {
            addCriterion("ESSTYM not in", values, "esstym");
            return (Criteria) this;
        }

        public Criteria andEsstymBetween(String value1, String value2) {
            addCriterion("ESSTYM between", value1, value2, "esstym");
            return (Criteria) this;
        }

        public Criteria andEsstymNotBetween(String value1, String value2) {
            addCriterion("ESSTYM not between", value1, value2, "esstym");
            return (Criteria) this;
        }

        public Criteria andCapexIsNull() {
            addCriterion("CAPEX is null");
            return (Criteria) this;
        }

        public Criteria andCapexIsNotNull() {
            addCriterion("CAPEX is not null");
            return (Criteria) this;
        }

        public Criteria andCapexEqualTo(Double value) {
            addCriterion("CAPEX =", value, "capex");
            return (Criteria) this;
        }

        public Criteria andCapexNotEqualTo(Double value) {
            addCriterion("CAPEX <>", value, "capex");
            return (Criteria) this;
        }

        public Criteria andCapexGreaterThan(Double value) {
            addCriterion("CAPEX >", value, "capex");
            return (Criteria) this;
        }

        public Criteria andCapexGreaterThanOrEqualTo(Double value) {
            addCriterion("CAPEX >=", value, "capex");
            return (Criteria) this;
        }

        public Criteria andCapexLessThan(Double value) {
            addCriterion("CAPEX <", value, "capex");
            return (Criteria) this;
        }

        public Criteria andCapexLessThanOrEqualTo(Double value) {
            addCriterion("CAPEX <=", value, "capex");
            return (Criteria) this;
        }

        public Criteria andCapexIn(List<Double> values) {
            addCriterion("CAPEX in", values, "capex");
            return (Criteria) this;
        }

        public Criteria andCapexNotIn(List<Double> values) {
            addCriterion("CAPEX not in", values, "capex");
            return (Criteria) this;
        }

        public Criteria andCapexBetween(Double value1, Double value2) {
            addCriterion("CAPEX between", value1, value2, "capex");
            return (Criteria) this;
        }

        public Criteria andCapexNotBetween(Double value1, Double value2) {
            addCriterion("CAPEX not between", value1, value2, "capex");
            return (Criteria) this;
        }

        public Criteria andFareaIsNull() {
            addCriterion("FAREA is null");
            return (Criteria) this;
        }

        public Criteria andFareaIsNotNull() {
            addCriterion("FAREA is not null");
            return (Criteria) this;
        }

        public Criteria andFareaEqualTo(Double value) {
            addCriterion("FAREA =", value, "farea");
            return (Criteria) this;
        }

        public Criteria andFareaNotEqualTo(Double value) {
            addCriterion("FAREA <>", value, "farea");
            return (Criteria) this;
        }

        public Criteria andFareaGreaterThan(Double value) {
            addCriterion("FAREA >", value, "farea");
            return (Criteria) this;
        }

        public Criteria andFareaGreaterThanOrEqualTo(Double value) {
            addCriterion("FAREA >=", value, "farea");
            return (Criteria) this;
        }

        public Criteria andFareaLessThan(Double value) {
            addCriterion("FAREA <", value, "farea");
            return (Criteria) this;
        }

        public Criteria andFareaLessThanOrEqualTo(Double value) {
            addCriterion("FAREA <=", value, "farea");
            return (Criteria) this;
        }

        public Criteria andFareaIn(List<Double> values) {
            addCriterion("FAREA in", values, "farea");
            return (Criteria) this;
        }

        public Criteria andFareaNotIn(List<Double> values) {
            addCriterion("FAREA not in", values, "farea");
            return (Criteria) this;
        }

        public Criteria andFareaBetween(Double value1, Double value2) {
            addCriterion("FAREA between", value1, value2, "farea");
            return (Criteria) this;
        }

        public Criteria andFareaNotBetween(Double value1, Double value2) {
            addCriterion("FAREA not between", value1, value2, "farea");
            return (Criteria) this;
        }

        public Criteria andSareaIsNull() {
            addCriterion("SAREA is null");
            return (Criteria) this;
        }

        public Criteria andSareaIsNotNull() {
            addCriterion("SAREA is not null");
            return (Criteria) this;
        }

        public Criteria andSareaEqualTo(Double value) {
            addCriterion("SAREA =", value, "sarea");
            return (Criteria) this;
        }

        public Criteria andSareaNotEqualTo(Double value) {
            addCriterion("SAREA <>", value, "sarea");
            return (Criteria) this;
        }

        public Criteria andSareaGreaterThan(Double value) {
            addCriterion("SAREA >", value, "sarea");
            return (Criteria) this;
        }

        public Criteria andSareaGreaterThanOrEqualTo(Double value) {
            addCriterion("SAREA >=", value, "sarea");
            return (Criteria) this;
        }

        public Criteria andSareaLessThan(Double value) {
            addCriterion("SAREA <", value, "sarea");
            return (Criteria) this;
        }

        public Criteria andSareaLessThanOrEqualTo(Double value) {
            addCriterion("SAREA <=", value, "sarea");
            return (Criteria) this;
        }

        public Criteria andSareaIn(List<Double> values) {
            addCriterion("SAREA in", values, "sarea");
            return (Criteria) this;
        }

        public Criteria andSareaNotIn(List<Double> values) {
            addCriterion("SAREA not in", values, "sarea");
            return (Criteria) this;
        }

        public Criteria andSareaBetween(Double value1, Double value2) {
            addCriterion("SAREA between", value1, value2, "sarea");
            return (Criteria) this;
        }

        public Criteria andSareaNotBetween(Double value1, Double value2) {
            addCriterion("SAREA not between", value1, value2, "sarea");
            return (Criteria) this;
        }

        public Criteria andSercovIsNull() {
            addCriterion("SERCOV is null");
            return (Criteria) this;
        }

        public Criteria andSercovIsNotNull() {
            addCriterion("SERCOV is not null");
            return (Criteria) this;
        }

        public Criteria andSercovEqualTo(String value) {
            addCriterion("SERCOV =", value, "sercov");
            return (Criteria) this;
        }

        public Criteria andSercovNotEqualTo(String value) {
            addCriterion("SERCOV <>", value, "sercov");
            return (Criteria) this;
        }

        public Criteria andSercovGreaterThan(String value) {
            addCriterion("SERCOV >", value, "sercov");
            return (Criteria) this;
        }

        public Criteria andSercovGreaterThanOrEqualTo(String value) {
            addCriterion("SERCOV >=", value, "sercov");
            return (Criteria) this;
        }

        public Criteria andSercovLessThan(String value) {
            addCriterion("SERCOV <", value, "sercov");
            return (Criteria) this;
        }

        public Criteria andSercovLessThanOrEqualTo(String value) {
            addCriterion("SERCOV <=", value, "sercov");
            return (Criteria) this;
        }

        public Criteria andSercovLike(String value) {
            addCriterion("SERCOV like", value, "sercov");
            return (Criteria) this;
        }

        public Criteria andSercovNotLike(String value) {
            addCriterion("SERCOV not like", value, "sercov");
            return (Criteria) this;
        }

        public Criteria andSercovIn(List<String> values) {
            addCriterion("SERCOV in", values, "sercov");
            return (Criteria) this;
        }

        public Criteria andSercovNotIn(List<String> values) {
            addCriterion("SERCOV not in", values, "sercov");
            return (Criteria) this;
        }

        public Criteria andSercovBetween(String value1, String value2) {
            addCriterion("SERCOV between", value1, value2, "sercov");
            return (Criteria) this;
        }

        public Criteria andSercovNotBetween(String value1, String value2) {
            addCriterion("SERCOV not between", value1, value2, "sercov");
            return (Criteria) this;
        }

        public Criteria andSerpopIsNull() {
            addCriterion("SERPOP is null");
            return (Criteria) this;
        }

        public Criteria andSerpopIsNotNull() {
            addCriterion("SERPOP is not null");
            return (Criteria) this;
        }

        public Criteria andSerpopEqualTo(Integer value) {
            addCriterion("SERPOP =", value, "serpop");
            return (Criteria) this;
        }

        public Criteria andSerpopNotEqualTo(Integer value) {
            addCriterion("SERPOP <>", value, "serpop");
            return (Criteria) this;
        }

        public Criteria andSerpopGreaterThan(Integer value) {
            addCriterion("SERPOP >", value, "serpop");
            return (Criteria) this;
        }

        public Criteria andSerpopGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERPOP >=", value, "serpop");
            return (Criteria) this;
        }

        public Criteria andSerpopLessThan(Integer value) {
            addCriterion("SERPOP <", value, "serpop");
            return (Criteria) this;
        }

        public Criteria andSerpopLessThanOrEqualTo(Integer value) {
            addCriterion("SERPOP <=", value, "serpop");
            return (Criteria) this;
        }

        public Criteria andSerpopIn(List<Integer> values) {
            addCriterion("SERPOP in", values, "serpop");
            return (Criteria) this;
        }

        public Criteria andSerpopNotIn(List<Integer> values) {
            addCriterion("SERPOP not in", values, "serpop");
            return (Criteria) this;
        }

        public Criteria andSerpopBetween(Integer value1, Integer value2) {
            addCriterion("SERPOP between", value1, value2, "serpop");
            return (Criteria) this;
        }

        public Criteria andSerpopNotBetween(Integer value1, Integer value2) {
            addCriterion("SERPOP not between", value1, value2, "serpop");
            return (Criteria) this;
        }

        public Criteria andCurdepIsNull() {
            addCriterion("CURDEP is null");
            return (Criteria) this;
        }

        public Criteria andCurdepIsNotNull() {
            addCriterion("CURDEP is not null");
            return (Criteria) this;
        }

        public Criteria andCurdepEqualTo(String value) {
            addCriterion("CURDEP =", value, "curdep");
            return (Criteria) this;
        }

        public Criteria andCurdepNotEqualTo(String value) {
            addCriterion("CURDEP <>", value, "curdep");
            return (Criteria) this;
        }

        public Criteria andCurdepGreaterThan(String value) {
            addCriterion("CURDEP >", value, "curdep");
            return (Criteria) this;
        }

        public Criteria andCurdepGreaterThanOrEqualTo(String value) {
            addCriterion("CURDEP >=", value, "curdep");
            return (Criteria) this;
        }

        public Criteria andCurdepLessThan(String value) {
            addCriterion("CURDEP <", value, "curdep");
            return (Criteria) this;
        }

        public Criteria andCurdepLessThanOrEqualTo(String value) {
            addCriterion("CURDEP <=", value, "curdep");
            return (Criteria) this;
        }

        public Criteria andCurdepLike(String value) {
            addCriterion("CURDEP like", value, "curdep");
            return (Criteria) this;
        }

        public Criteria andCurdepNotLike(String value) {
            addCriterion("CURDEP not like", value, "curdep");
            return (Criteria) this;
        }

        public Criteria andCurdepIn(List<String> values) {
            addCriterion("CURDEP in", values, "curdep");
            return (Criteria) this;
        }

        public Criteria andCurdepNotIn(List<String> values) {
            addCriterion("CURDEP not in", values, "curdep");
            return (Criteria) this;
        }

        public Criteria andCurdepBetween(String value1, String value2) {
            addCriterion("CURDEP between", value1, value2, "curdep");
            return (Criteria) this;
        }

        public Criteria andCurdepNotBetween(String value1, String value2) {
            addCriterion("CURDEP not between", value1, value2, "curdep");
            return (Criteria) this;
        }

        public Criteria andBuilddepIsNull() {
            addCriterion("BUILDDEP is null");
            return (Criteria) this;
        }

        public Criteria andBuilddepIsNotNull() {
            addCriterion("BUILDDEP is not null");
            return (Criteria) this;
        }

        public Criteria andBuilddepEqualTo(String value) {
            addCriterion("BUILDDEP =", value, "builddep");
            return (Criteria) this;
        }

        public Criteria andBuilddepNotEqualTo(String value) {
            addCriterion("BUILDDEP <>", value, "builddep");
            return (Criteria) this;
        }

        public Criteria andBuilddepGreaterThan(String value) {
            addCriterion("BUILDDEP >", value, "builddep");
            return (Criteria) this;
        }

        public Criteria andBuilddepGreaterThanOrEqualTo(String value) {
            addCriterion("BUILDDEP >=", value, "builddep");
            return (Criteria) this;
        }

        public Criteria andBuilddepLessThan(String value) {
            addCriterion("BUILDDEP <", value, "builddep");
            return (Criteria) this;
        }

        public Criteria andBuilddepLessThanOrEqualTo(String value) {
            addCriterion("BUILDDEP <=", value, "builddep");
            return (Criteria) this;
        }

        public Criteria andBuilddepLike(String value) {
            addCriterion("BUILDDEP like", value, "builddep");
            return (Criteria) this;
        }

        public Criteria andBuilddepNotLike(String value) {
            addCriterion("BUILDDEP not like", value, "builddep");
            return (Criteria) this;
        }

        public Criteria andBuilddepIn(List<String> values) {
            addCriterion("BUILDDEP in", values, "builddep");
            return (Criteria) this;
        }

        public Criteria andBuilddepNotIn(List<String> values) {
            addCriterion("BUILDDEP not in", values, "builddep");
            return (Criteria) this;
        }

        public Criteria andBuilddepBetween(String value1, String value2) {
            addCriterion("BUILDDEP between", value1, value2, "builddep");
            return (Criteria) this;
        }

        public Criteria andBuilddepNotBetween(String value1, String value2) {
            addCriterion("BUILDDEP not between", value1, value2, "builddep");
            return (Criteria) this;
        }

        public Criteria andSttpIsNull() {
            addCriterion("STTP is null");
            return (Criteria) this;
        }

        public Criteria andSttpIsNotNull() {
            addCriterion("STTP is not null");
            return (Criteria) this;
        }

        public Criteria andSttpEqualTo(String value) {
            addCriterion("STTP =", value, "sttp");
            return (Criteria) this;
        }

        public Criteria andSttpNotEqualTo(String value) {
            addCriterion("STTP <>", value, "sttp");
            return (Criteria) this;
        }

        public Criteria andSttpGreaterThan(String value) {
            addCriterion("STTP >", value, "sttp");
            return (Criteria) this;
        }

        public Criteria andSttpGreaterThanOrEqualTo(String value) {
            addCriterion("STTP >=", value, "sttp");
            return (Criteria) this;
        }

        public Criteria andSttpLessThan(String value) {
            addCriterion("STTP <", value, "sttp");
            return (Criteria) this;
        }

        public Criteria andSttpLessThanOrEqualTo(String value) {
            addCriterion("STTP <=", value, "sttp");
            return (Criteria) this;
        }

        public Criteria andSttpLike(String value) {
            addCriterion("STTP like", value, "sttp");
            return (Criteria) this;
        }

        public Criteria andSttpNotLike(String value) {
            addCriterion("STTP not like", value, "sttp");
            return (Criteria) this;
        }

        public Criteria andSttpIn(List<String> values) {
            addCriterion("STTP in", values, "sttp");
            return (Criteria) this;
        }

        public Criteria andSttpNotIn(List<String> values) {
            addCriterion("STTP not in", values, "sttp");
            return (Criteria) this;
        }

        public Criteria andSttpBetween(String value1, String value2) {
            addCriterion("STTP between", value1, value2, "sttp");
            return (Criteria) this;
        }

        public Criteria andSttpNotBetween(String value1, String value2) {
            addCriterion("STTP not between", value1, value2, "sttp");
            return (Criteria) this;
        }

        public Criteria andIsautoIsNull() {
            addCriterion("ISAUTO is null");
            return (Criteria) this;
        }

        public Criteria andIsautoIsNotNull() {
            addCriterion("ISAUTO is not null");
            return (Criteria) this;
        }

        public Criteria andIsautoEqualTo(String value) {
            addCriterion("ISAUTO =", value, "isauto");
            return (Criteria) this;
        }

        public Criteria andIsautoNotEqualTo(String value) {
            addCriterion("ISAUTO <>", value, "isauto");
            return (Criteria) this;
        }

        public Criteria andIsautoGreaterThan(String value) {
            addCriterion("ISAUTO >", value, "isauto");
            return (Criteria) this;
        }

        public Criteria andIsautoGreaterThanOrEqualTo(String value) {
            addCriterion("ISAUTO >=", value, "isauto");
            return (Criteria) this;
        }

        public Criteria andIsautoLessThan(String value) {
            addCriterion("ISAUTO <", value, "isauto");
            return (Criteria) this;
        }

        public Criteria andIsautoLessThanOrEqualTo(String value) {
            addCriterion("ISAUTO <=", value, "isauto");
            return (Criteria) this;
        }

        public Criteria andIsautoLike(String value) {
            addCriterion("ISAUTO like", value, "isauto");
            return (Criteria) this;
        }

        public Criteria andIsautoNotLike(String value) {
            addCriterion("ISAUTO not like", value, "isauto");
            return (Criteria) this;
        }

        public Criteria andIsautoIn(List<String> values) {
            addCriterion("ISAUTO in", values, "isauto");
            return (Criteria) this;
        }

        public Criteria andIsautoNotIn(List<String> values) {
            addCriterion("ISAUTO not in", values, "isauto");
            return (Criteria) this;
        }

        public Criteria andIsautoBetween(String value1, String value2) {
            addCriterion("ISAUTO between", value1, value2, "isauto");
            return (Criteria) this;
        }

        public Criteria andIsautoNotBetween(String value1, String value2) {
            addCriterion("ISAUTO not between", value1, value2, "isauto");
            return (Criteria) this;
        }

        public Criteria andPdocdIsNull() {
            addCriterion("PDOCD is null");
            return (Criteria) this;
        }

        public Criteria andPdocdIsNotNull() {
            addCriterion("PDOCD is not null");
            return (Criteria) this;
        }

        public Criteria andPdocdEqualTo(String value) {
            addCriterion("PDOCD =", value, "pdocd");
            return (Criteria) this;
        }

        public Criteria andPdocdNotEqualTo(String value) {
            addCriterion("PDOCD <>", value, "pdocd");
            return (Criteria) this;
        }

        public Criteria andPdocdGreaterThan(String value) {
            addCriterion("PDOCD >", value, "pdocd");
            return (Criteria) this;
        }

        public Criteria andPdocdGreaterThanOrEqualTo(String value) {
            addCriterion("PDOCD >=", value, "pdocd");
            return (Criteria) this;
        }

        public Criteria andPdocdLessThan(String value) {
            addCriterion("PDOCD <", value, "pdocd");
            return (Criteria) this;
        }

        public Criteria andPdocdLessThanOrEqualTo(String value) {
            addCriterion("PDOCD <=", value, "pdocd");
            return (Criteria) this;
        }

        public Criteria andPdocdLike(String value) {
            addCriterion("PDOCD like", value, "pdocd");
            return (Criteria) this;
        }

        public Criteria andPdocdNotLike(String value) {
            addCriterion("PDOCD not like", value, "pdocd");
            return (Criteria) this;
        }

        public Criteria andPdocdIn(List<String> values) {
            addCriterion("PDOCD in", values, "pdocd");
            return (Criteria) this;
        }

        public Criteria andPdocdNotIn(List<String> values) {
            addCriterion("PDOCD not in", values, "pdocd");
            return (Criteria) this;
        }

        public Criteria andPdocdBetween(String value1, String value2) {
            addCriterion("PDOCD between", value1, value2, "pdocd");
            return (Criteria) this;
        }

        public Criteria andPdocdNotBetween(String value1, String value2) {
            addCriterion("PDOCD not between", value1, value2, "pdocd");
            return (Criteria) this;
        }
    }

    /**
     * WP_STS_B
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * WP_STS_B 2018-07-08
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