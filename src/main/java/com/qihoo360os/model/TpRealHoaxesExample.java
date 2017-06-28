package com.qihoo360os.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TpRealHoaxesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public TpRealHoaxesExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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

        public Criteria andRealPidIsNull() {
            addCriterion("real_pid is null");
            return (Criteria) this;
        }

        public Criteria andRealPidIsNotNull() {
            addCriterion("real_pid is not null");
            return (Criteria) this;
        }

        public Criteria andRealPidEqualTo(Integer value) {
            addCriterion("real_pid =", value, "realPid");
            return (Criteria) this;
        }

        public Criteria andRealPidNotEqualTo(Integer value) {
            addCriterion("real_pid <>", value, "realPid");
            return (Criteria) this;
        }

        public Criteria andRealPidGreaterThan(Integer value) {
            addCriterion("real_pid >", value, "realPid");
            return (Criteria) this;
        }

        public Criteria andRealPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("real_pid >=", value, "realPid");
            return (Criteria) this;
        }

        public Criteria andRealPidLessThan(Integer value) {
            addCriterion("real_pid <", value, "realPid");
            return (Criteria) this;
        }

        public Criteria andRealPidLessThanOrEqualTo(Integer value) {
            addCriterion("real_pid <=", value, "realPid");
            return (Criteria) this;
        }

        public Criteria andRealPidIn(List<Integer> values) {
            addCriterion("real_pid in", values, "realPid");
            return (Criteria) this;
        }

        public Criteria andRealPidNotIn(List<Integer> values) {
            addCriterion("real_pid not in", values, "realPid");
            return (Criteria) this;
        }

        public Criteria andRealPidBetween(Integer value1, Integer value2) {
            addCriterion("real_pid between", value1, value2, "realPid");
            return (Criteria) this;
        }

        public Criteria andRealPidNotBetween(Integer value1, Integer value2) {
            addCriterion("real_pid not between", value1, value2, "realPid");
            return (Criteria) this;
        }

        public Criteria andRealChannelIsNull() {
            addCriterion("real_channel is null");
            return (Criteria) this;
        }

        public Criteria andRealChannelIsNotNull() {
            addCriterion("real_channel is not null");
            return (Criteria) this;
        }

        public Criteria andRealChannelEqualTo(String value) {
            addCriterion("real_channel =", value, "realChannel");
            return (Criteria) this;
        }

        public Criteria andRealChannelNotEqualTo(String value) {
            addCriterion("real_channel <>", value, "realChannel");
            return (Criteria) this;
        }

        public Criteria andRealChannelGreaterThan(String value) {
            addCriterion("real_channel >", value, "realChannel");
            return (Criteria) this;
        }

        public Criteria andRealChannelGreaterThanOrEqualTo(String value) {
            addCriterion("real_channel >=", value, "realChannel");
            return (Criteria) this;
        }

        public Criteria andRealChannelLessThan(String value) {
            addCriterion("real_channel <", value, "realChannel");
            return (Criteria) this;
        }

        public Criteria andRealChannelLessThanOrEqualTo(String value) {
            addCriterion("real_channel <=", value, "realChannel");
            return (Criteria) this;
        }

        public Criteria andRealChannelLike(String value) {
            addCriterion("real_channel like", value, "realChannel");
            return (Criteria) this;
        }

        public Criteria andRealChannelNotLike(String value) {
            addCriterion("real_channel not like", value, "realChannel");
            return (Criteria) this;
        }

        public Criteria andRealChannelIn(List<String> values) {
            addCriterion("real_channel in", values, "realChannel");
            return (Criteria) this;
        }

        public Criteria andRealChannelNotIn(List<String> values) {
            addCriterion("real_channel not in", values, "realChannel");
            return (Criteria) this;
        }

        public Criteria andRealChannelBetween(String value1, String value2) {
            addCriterion("real_channel between", value1, value2, "realChannel");
            return (Criteria) this;
        }

        public Criteria andRealChannelNotBetween(String value1, String value2) {
            addCriterion("real_channel not between", value1, value2, "realChannel");
            return (Criteria) this;
        }

        public Criteria andRealM1IsNull() {
            addCriterion("real_m1 is null");
            return (Criteria) this;
        }

        public Criteria andRealM1IsNotNull() {
            addCriterion("real_m1 is not null");
            return (Criteria) this;
        }

        public Criteria andRealM1EqualTo(String value) {
            addCriterion("real_m1 =", value, "realM1");
            return (Criteria) this;
        }

        public Criteria andRealM1NotEqualTo(String value) {
            addCriterion("real_m1 <>", value, "realM1");
            return (Criteria) this;
        }

        public Criteria andRealM1GreaterThan(String value) {
            addCriterion("real_m1 >", value, "realM1");
            return (Criteria) this;
        }

        public Criteria andRealM1GreaterThanOrEqualTo(String value) {
            addCriterion("real_m1 >=", value, "realM1");
            return (Criteria) this;
        }

        public Criteria andRealM1LessThan(String value) {
            addCriterion("real_m1 <", value, "realM1");
            return (Criteria) this;
        }

        public Criteria andRealM1LessThanOrEqualTo(String value) {
            addCriterion("real_m1 <=", value, "realM1");
            return (Criteria) this;
        }

        public Criteria andRealM1Like(String value) {
            addCriterion("real_m1 like", value, "realM1");
            return (Criteria) this;
        }

        public Criteria andRealM1NotLike(String value) {
            addCriterion("real_m1 not like", value, "realM1");
            return (Criteria) this;
        }

        public Criteria andRealM1In(List<String> values) {
            addCriterion("real_m1 in", values, "realM1");
            return (Criteria) this;
        }

        public Criteria andRealM1NotIn(List<String> values) {
            addCriterion("real_m1 not in", values, "realM1");
            return (Criteria) this;
        }

        public Criteria andRealM1Between(String value1, String value2) {
            addCriterion("real_m1 between", value1, value2, "realM1");
            return (Criteria) this;
        }

        public Criteria andRealM1NotBetween(String value1, String value2) {
            addCriterion("real_m1 not between", value1, value2, "realM1");
            return (Criteria) this;
        }

        public Criteria andRealM2IsNull() {
            addCriterion("real_m2 is null");
            return (Criteria) this;
        }

        public Criteria andRealM2IsNotNull() {
            addCriterion("real_m2 is not null");
            return (Criteria) this;
        }

        public Criteria andRealM2EqualTo(String value) {
            addCriterion("real_m2 =", value, "realM2");
            return (Criteria) this;
        }

        public Criteria andRealM2NotEqualTo(String value) {
            addCriterion("real_m2 <>", value, "realM2");
            return (Criteria) this;
        }

        public Criteria andRealM2GreaterThan(String value) {
            addCriterion("real_m2 >", value, "realM2");
            return (Criteria) this;
        }

        public Criteria andRealM2GreaterThanOrEqualTo(String value) {
            addCriterion("real_m2 >=", value, "realM2");
            return (Criteria) this;
        }

        public Criteria andRealM2LessThan(String value) {
            addCriterion("real_m2 <", value, "realM2");
            return (Criteria) this;
        }

        public Criteria andRealM2LessThanOrEqualTo(String value) {
            addCriterion("real_m2 <=", value, "realM2");
            return (Criteria) this;
        }

        public Criteria andRealM2Like(String value) {
            addCriterion("real_m2 like", value, "realM2");
            return (Criteria) this;
        }

        public Criteria andRealM2NotLike(String value) {
            addCriterion("real_m2 not like", value, "realM2");
            return (Criteria) this;
        }

        public Criteria andRealM2In(List<String> values) {
            addCriterion("real_m2 in", values, "realM2");
            return (Criteria) this;
        }

        public Criteria andRealM2NotIn(List<String> values) {
            addCriterion("real_m2 not in", values, "realM2");
            return (Criteria) this;
        }

        public Criteria andRealM2Between(String value1, String value2) {
            addCriterion("real_m2 between", value1, value2, "realM2");
            return (Criteria) this;
        }

        public Criteria andRealM2NotBetween(String value1, String value2) {
            addCriterion("real_m2 not between", value1, value2, "realM2");
            return (Criteria) this;
        }

        public Criteria andRealEmmcIsNull() {
            addCriterion("real_emmc is null");
            return (Criteria) this;
        }

        public Criteria andRealEmmcIsNotNull() {
            addCriterion("real_emmc is not null");
            return (Criteria) this;
        }

        public Criteria andRealEmmcEqualTo(String value) {
            addCriterion("real_emmc =", value, "realEmmc");
            return (Criteria) this;
        }

        public Criteria andRealEmmcNotEqualTo(String value) {
            addCriterion("real_emmc <>", value, "realEmmc");
            return (Criteria) this;
        }

        public Criteria andRealEmmcGreaterThan(String value) {
            addCriterion("real_emmc >", value, "realEmmc");
            return (Criteria) this;
        }

        public Criteria andRealEmmcGreaterThanOrEqualTo(String value) {
            addCriterion("real_emmc >=", value, "realEmmc");
            return (Criteria) this;
        }

        public Criteria andRealEmmcLessThan(String value) {
            addCriterion("real_emmc <", value, "realEmmc");
            return (Criteria) this;
        }

        public Criteria andRealEmmcLessThanOrEqualTo(String value) {
            addCriterion("real_emmc <=", value, "realEmmc");
            return (Criteria) this;
        }

        public Criteria andRealEmmcLike(String value) {
            addCriterion("real_emmc like", value, "realEmmc");
            return (Criteria) this;
        }

        public Criteria andRealEmmcNotLike(String value) {
            addCriterion("real_emmc not like", value, "realEmmc");
            return (Criteria) this;
        }

        public Criteria andRealEmmcIn(List<String> values) {
            addCriterion("real_emmc in", values, "realEmmc");
            return (Criteria) this;
        }

        public Criteria andRealEmmcNotIn(List<String> values) {
            addCriterion("real_emmc not in", values, "realEmmc");
            return (Criteria) this;
        }

        public Criteria andRealEmmcBetween(String value1, String value2) {
            addCriterion("real_emmc between", value1, value2, "realEmmc");
            return (Criteria) this;
        }

        public Criteria andRealEmmcNotBetween(String value1, String value2) {
            addCriterion("real_emmc not between", value1, value2, "realEmmc");
            return (Criteria) this;
        }

        public Criteria andRealCpuIsNull() {
            addCriterion("real_cpu is null");
            return (Criteria) this;
        }

        public Criteria andRealCpuIsNotNull() {
            addCriterion("real_cpu is not null");
            return (Criteria) this;
        }

        public Criteria andRealCpuEqualTo(String value) {
            addCriterion("real_cpu =", value, "realCpu");
            return (Criteria) this;
        }

        public Criteria andRealCpuNotEqualTo(String value) {
            addCriterion("real_cpu <>", value, "realCpu");
            return (Criteria) this;
        }

        public Criteria andRealCpuGreaterThan(String value) {
            addCriterion("real_cpu >", value, "realCpu");
            return (Criteria) this;
        }

        public Criteria andRealCpuGreaterThanOrEqualTo(String value) {
            addCriterion("real_cpu >=", value, "realCpu");
            return (Criteria) this;
        }

        public Criteria andRealCpuLessThan(String value) {
            addCriterion("real_cpu <", value, "realCpu");
            return (Criteria) this;
        }

        public Criteria andRealCpuLessThanOrEqualTo(String value) {
            addCriterion("real_cpu <=", value, "realCpu");
            return (Criteria) this;
        }

        public Criteria andRealCpuLike(String value) {
            addCriterion("real_cpu like", value, "realCpu");
            return (Criteria) this;
        }

        public Criteria andRealCpuNotLike(String value) {
            addCriterion("real_cpu not like", value, "realCpu");
            return (Criteria) this;
        }

        public Criteria andRealCpuIn(List<String> values) {
            addCriterion("real_cpu in", values, "realCpu");
            return (Criteria) this;
        }

        public Criteria andRealCpuNotIn(List<String> values) {
            addCriterion("real_cpu not in", values, "realCpu");
            return (Criteria) this;
        }

        public Criteria andRealCpuBetween(String value1, String value2) {
            addCriterion("real_cpu between", value1, value2, "realCpu");
            return (Criteria) this;
        }

        public Criteria andRealCpuNotBetween(String value1, String value2) {
            addCriterion("real_cpu not between", value1, value2, "realCpu");
            return (Criteria) this;
        }

        public Criteria andRealOsversionIsNull() {
            addCriterion("real_osversion is null");
            return (Criteria) this;
        }

        public Criteria andRealOsversionIsNotNull() {
            addCriterion("real_osversion is not null");
            return (Criteria) this;
        }

        public Criteria andRealOsversionEqualTo(String value) {
            addCriterion("real_osversion =", value, "realOsversion");
            return (Criteria) this;
        }

        public Criteria andRealOsversionNotEqualTo(String value) {
            addCriterion("real_osversion <>", value, "realOsversion");
            return (Criteria) this;
        }

        public Criteria andRealOsversionGreaterThan(String value) {
            addCriterion("real_osversion >", value, "realOsversion");
            return (Criteria) this;
        }

        public Criteria andRealOsversionGreaterThanOrEqualTo(String value) {
            addCriterion("real_osversion >=", value, "realOsversion");
            return (Criteria) this;
        }

        public Criteria andRealOsversionLessThan(String value) {
            addCriterion("real_osversion <", value, "realOsversion");
            return (Criteria) this;
        }

        public Criteria andRealOsversionLessThanOrEqualTo(String value) {
            addCriterion("real_osversion <=", value, "realOsversion");
            return (Criteria) this;
        }

        public Criteria andRealOsversionLike(String value) {
            addCriterion("real_osversion like", value, "realOsversion");
            return (Criteria) this;
        }

        public Criteria andRealOsversionNotLike(String value) {
            addCriterion("real_osversion not like", value, "realOsversion");
            return (Criteria) this;
        }

        public Criteria andRealOsversionIn(List<String> values) {
            addCriterion("real_osversion in", values, "realOsversion");
            return (Criteria) this;
        }

        public Criteria andRealOsversionNotIn(List<String> values) {
            addCriterion("real_osversion not in", values, "realOsversion");
            return (Criteria) this;
        }

        public Criteria andRealOsversionBetween(String value1, String value2) {
            addCriterion("real_osversion between", value1, value2, "realOsversion");
            return (Criteria) this;
        }

        public Criteria andRealOsversionNotBetween(String value1, String value2) {
            addCriterion("real_osversion not between", value1, value2, "realOsversion");
            return (Criteria) this;
        }

        public Criteria andRealServerTimeIsNull() {
            addCriterion("real_server_time is null");
            return (Criteria) this;
        }

        public Criteria andRealServerTimeIsNotNull() {
            addCriterion("real_server_time is not null");
            return (Criteria) this;
        }

        public Criteria andRealServerTimeEqualTo(Date value) {
            addCriterion("real_server_time =", value, "realServerTime");
            return (Criteria) this;
        }

        public Criteria andRealServerTimeNotEqualTo(Date value) {
            addCriterion("real_server_time <>", value, "realServerTime");
            return (Criteria) this;
        }

        public Criteria andRealServerTimeGreaterThan(Date value) {
            addCriterion("real_server_time >", value, "realServerTime");
            return (Criteria) this;
        }

        public Criteria andRealServerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("real_server_time >=", value, "realServerTime");
            return (Criteria) this;
        }

        public Criteria andRealServerTimeLessThan(Date value) {
            addCriterion("real_server_time <", value, "realServerTime");
            return (Criteria) this;
        }

        public Criteria andRealServerTimeLessThanOrEqualTo(Date value) {
            addCriterion("real_server_time <=", value, "realServerTime");
            return (Criteria) this;
        }

        public Criteria andRealServerTimeIn(List<Date> values) {
            addCriterion("real_server_time in", values, "realServerTime");
            return (Criteria) this;
        }

        public Criteria andRealServerTimeNotIn(List<Date> values) {
            addCriterion("real_server_time not in", values, "realServerTime");
            return (Criteria) this;
        }

        public Criteria andRealServerTimeBetween(Date value1, Date value2) {
            addCriterion("real_server_time between", value1, value2, "realServerTime");
            return (Criteria) this;
        }

        public Criteria andRealServerTimeNotBetween(Date value1, Date value2) {
            addCriterion("real_server_time not between", value1, value2, "realServerTime");
            return (Criteria) this;
        }

        public Criteria andRealEventKeyIsNull() {
            addCriterion("real_event_key is null");
            return (Criteria) this;
        }

        public Criteria andRealEventKeyIsNotNull() {
            addCriterion("real_event_key is not null");
            return (Criteria) this;
        }

        public Criteria andRealEventKeyEqualTo(String value) {
            addCriterion("real_event_key =", value, "realEventKey");
            return (Criteria) this;
        }

        public Criteria andRealEventKeyNotEqualTo(String value) {
            addCriterion("real_event_key <>", value, "realEventKey");
            return (Criteria) this;
        }

        public Criteria andRealEventKeyGreaterThan(String value) {
            addCriterion("real_event_key >", value, "realEventKey");
            return (Criteria) this;
        }

        public Criteria andRealEventKeyGreaterThanOrEqualTo(String value) {
            addCriterion("real_event_key >=", value, "realEventKey");
            return (Criteria) this;
        }

        public Criteria andRealEventKeyLessThan(String value) {
            addCriterion("real_event_key <", value, "realEventKey");
            return (Criteria) this;
        }

        public Criteria andRealEventKeyLessThanOrEqualTo(String value) {
            addCriterion("real_event_key <=", value, "realEventKey");
            return (Criteria) this;
        }

        public Criteria andRealEventKeyLike(String value) {
            addCriterion("real_event_key like", value, "realEventKey");
            return (Criteria) this;
        }

        public Criteria andRealEventKeyNotLike(String value) {
            addCriterion("real_event_key not like", value, "realEventKey");
            return (Criteria) this;
        }

        public Criteria andRealEventKeyIn(List<String> values) {
            addCriterion("real_event_key in", values, "realEventKey");
            return (Criteria) this;
        }

        public Criteria andRealEventKeyNotIn(List<String> values) {
            addCriterion("real_event_key not in", values, "realEventKey");
            return (Criteria) this;
        }

        public Criteria andRealEventKeyBetween(String value1, String value2) {
            addCriterion("real_event_key between", value1, value2, "realEventKey");
            return (Criteria) this;
        }

        public Criteria andRealEventKeyNotBetween(String value1, String value2) {
            addCriterion("real_event_key not between", value1, value2, "realEventKey");
            return (Criteria) this;
        }

        public Criteria andRealPkgnameIsNull() {
            addCriterion("real_pkgname is null");
            return (Criteria) this;
        }

        public Criteria andRealPkgnameIsNotNull() {
            addCriterion("real_pkgname is not null");
            return (Criteria) this;
        }

        public Criteria andRealPkgnameEqualTo(String value) {
            addCriterion("real_pkgname =", value, "realPkgname");
            return (Criteria) this;
        }

        public Criteria andRealPkgnameNotEqualTo(String value) {
            addCriterion("real_pkgname <>", value, "realPkgname");
            return (Criteria) this;
        }

        public Criteria andRealPkgnameGreaterThan(String value) {
            addCriterion("real_pkgname >", value, "realPkgname");
            return (Criteria) this;
        }

        public Criteria andRealPkgnameGreaterThanOrEqualTo(String value) {
            addCriterion("real_pkgname >=", value, "realPkgname");
            return (Criteria) this;
        }

        public Criteria andRealPkgnameLessThan(String value) {
            addCriterion("real_pkgname <", value, "realPkgname");
            return (Criteria) this;
        }

        public Criteria andRealPkgnameLessThanOrEqualTo(String value) {
            addCriterion("real_pkgname <=", value, "realPkgname");
            return (Criteria) this;
        }

        public Criteria andRealPkgnameLike(String value) {
            addCriterion("real_pkgname like", value, "realPkgname");
            return (Criteria) this;
        }

        public Criteria andRealPkgnameNotLike(String value) {
            addCriterion("real_pkgname not like", value, "realPkgname");
            return (Criteria) this;
        }

        public Criteria andRealPkgnameIn(List<String> values) {
            addCriterion("real_pkgname in", values, "realPkgname");
            return (Criteria) this;
        }

        public Criteria andRealPkgnameNotIn(List<String> values) {
            addCriterion("real_pkgname not in", values, "realPkgname");
            return (Criteria) this;
        }

        public Criteria andRealPkgnameBetween(String value1, String value2) {
            addCriterion("real_pkgname between", value1, value2, "realPkgname");
            return (Criteria) this;
        }

        public Criteria andRealPkgnameNotBetween(String value1, String value2) {
            addCriterion("real_pkgname not between", value1, value2, "realPkgname");
            return (Criteria) this;
        }

        public Criteria andRealCreateTimeIsNull() {
            addCriterion("real_create_time is null");
            return (Criteria) this;
        }

        public Criteria andRealCreateTimeIsNotNull() {
            addCriterion("real_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andRealCreateTimeEqualTo(String value) {
            addCriterion("real_create_time =", value, "realCreateTime");
            return (Criteria) this;
        }

        public Criteria andRealCreateTimeNotEqualTo(String value) {
            addCriterion("real_create_time <>", value, "realCreateTime");
            return (Criteria) this;
        }

        public Criteria andRealCreateTimeGreaterThan(String value) {
            addCriterion("real_create_time >", value, "realCreateTime");
            return (Criteria) this;
        }

        public Criteria andRealCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("real_create_time >=", value, "realCreateTime");
            return (Criteria) this;
        }

        public Criteria andRealCreateTimeLessThan(String value) {
            addCriterion("real_create_time <", value, "realCreateTime");
            return (Criteria) this;
        }

        public Criteria andRealCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("real_create_time <=", value, "realCreateTime");
            return (Criteria) this;
        }

        public Criteria andRealCreateTimeLike(String value) {
            addCriterion("real_create_time like", value, "realCreateTime");
            return (Criteria) this;
        }

        public Criteria andRealCreateTimeNotLike(String value) {
            addCriterion("real_create_time not like", value, "realCreateTime");
            return (Criteria) this;
        }

        public Criteria andRealCreateTimeIn(List<String> values) {
            addCriterion("real_create_time in", values, "realCreateTime");
            return (Criteria) this;
        }

        public Criteria andRealCreateTimeNotIn(List<String> values) {
            addCriterion("real_create_time not in", values, "realCreateTime");
            return (Criteria) this;
        }

        public Criteria andRealCreateTimeBetween(String value1, String value2) {
            addCriterion("real_create_time between", value1, value2, "realCreateTime");
            return (Criteria) this;
        }

        public Criteria andRealCreateTimeNotBetween(String value1, String value2) {
            addCriterion("real_create_time not between", value1, value2, "realCreateTime");
            return (Criteria) this;
        }

        public Criteria andThedateIsNull() {
            addCriterion("thedate is null");
            return (Criteria) this;
        }

        public Criteria andThedateIsNotNull() {
            addCriterion("thedate is not null");
            return (Criteria) this;
        }

        public Criteria andThedateEqualTo(Date value) {
            addCriterion("thedate =", value, "thedate");
            return (Criteria) this;
        }

        public Criteria andThedateNotEqualTo(Date value) {
            addCriterion("thedate <>", value, "thedate");
            return (Criteria) this;
        }

        public Criteria andThedateGreaterThan(Date value) {
            addCriterion("thedate >", value, "thedate");
            return (Criteria) this;
        }

        public Criteria andThedateGreaterThanOrEqualTo(Date value) {
            addCriterion("thedate >=", value, "thedate");
            return (Criteria) this;
        }

        public Criteria andThedateLessThan(Date value) {
            addCriterion("thedate <", value, "thedate");
            return (Criteria) this;
        }

        public Criteria andThedateLessThanOrEqualTo(Date value) {
            addCriterion("thedate <=", value, "thedate");
            return (Criteria) this;
        }

        public Criteria andThedateIn(List<Date> values) {
            addCriterion("thedate in", values, "thedate");
            return (Criteria) this;
        }

        public Criteria andThedateNotIn(List<Date> values) {
            addCriterion("thedate not in", values, "thedate");
            return (Criteria) this;
        }

        public Criteria andThedateBetween(Date value1, Date value2) {
            addCriterion("thedate between", value1, value2, "thedate");
            return (Criteria) this;
        }

        public Criteria andThedateNotBetween(Date value1, Date value2) {
            addCriterion("thedate not between", value1, value2, "thedate");
            return (Criteria) this;
        }

        public Criteria andRealInstallerIsNull() {
            addCriterion("real_installer is null");
            return (Criteria) this;
        }

        public Criteria andRealInstallerIsNotNull() {
            addCriterion("real_installer is not null");
            return (Criteria) this;
        }

        public Criteria andRealInstallerEqualTo(String value) {
            addCriterion("real_installer =", value, "realInstaller");
            return (Criteria) this;
        }

        public Criteria andRealInstallerNotEqualTo(String value) {
            addCriterion("real_installer <>", value, "realInstaller");
            return (Criteria) this;
        }

        public Criteria andRealInstallerGreaterThan(String value) {
            addCriterion("real_installer >", value, "realInstaller");
            return (Criteria) this;
        }

        public Criteria andRealInstallerGreaterThanOrEqualTo(String value) {
            addCriterion("real_installer >=", value, "realInstaller");
            return (Criteria) this;
        }

        public Criteria andRealInstallerLessThan(String value) {
            addCriterion("real_installer <", value, "realInstaller");
            return (Criteria) this;
        }

        public Criteria andRealInstallerLessThanOrEqualTo(String value) {
            addCriterion("real_installer <=", value, "realInstaller");
            return (Criteria) this;
        }

        public Criteria andRealInstallerLike(String value) {
            addCriterion("real_installer like", value, "realInstaller");
            return (Criteria) this;
        }

        public Criteria andRealInstallerNotLike(String value) {
            addCriterion("real_installer not like", value, "realInstaller");
            return (Criteria) this;
        }

        public Criteria andRealInstallerIn(List<String> values) {
            addCriterion("real_installer in", values, "realInstaller");
            return (Criteria) this;
        }

        public Criteria andRealInstallerNotIn(List<String> values) {
            addCriterion("real_installer not in", values, "realInstaller");
            return (Criteria) this;
        }

        public Criteria andRealInstallerBetween(String value1, String value2) {
            addCriterion("real_installer between", value1, value2, "realInstaller");
            return (Criteria) this;
        }

        public Criteria andRealInstallerNotBetween(String value1, String value2) {
            addCriterion("real_installer not between", value1, value2, "realInstaller");
            return (Criteria) this;
        }
    }

    /**
     */
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