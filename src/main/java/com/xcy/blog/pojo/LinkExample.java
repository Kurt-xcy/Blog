package com.xcy.blog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LinkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LinkExample() {
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

        public Criteria andLinkIdIsNull() {
            addCriterion("link_id is null");
            return (Criteria) this;
        }

        public Criteria andLinkIdIsNotNull() {
            addCriterion("link_id is not null");
            return (Criteria) this;
        }

        public Criteria andLinkIdEqualTo(Integer value) {
            addCriterion("link_id =", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotEqualTo(Integer value) {
            addCriterion("link_id <>", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdGreaterThan(Integer value) {
            addCriterion("link_id >", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("link_id >=", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdLessThan(Integer value) {
            addCriterion("link_id <", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdLessThanOrEqualTo(Integer value) {
            addCriterion("link_id <=", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdIn(List<Integer> values) {
            addCriterion("link_id in", values, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotIn(List<Integer> values) {
            addCriterion("link_id not in", values, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdBetween(Integer value1, Integer value2) {
            addCriterion("link_id between", value1, value2, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("link_id not between", value1, value2, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkUrlIsNull() {
            addCriterion("link_url is null");
            return (Criteria) this;
        }

        public Criteria andLinkUrlIsNotNull() {
            addCriterion("link_url is not null");
            return (Criteria) this;
        }

        public Criteria andLinkUrlEqualTo(String value) {
            addCriterion("link_url =", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotEqualTo(String value) {
            addCriterion("link_url <>", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlGreaterThan(String value) {
            addCriterion("link_url >", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlGreaterThanOrEqualTo(String value) {
            addCriterion("link_url >=", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLessThan(String value) {
            addCriterion("link_url <", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLessThanOrEqualTo(String value) {
            addCriterion("link_url <=", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLike(String value) {
            addCriterion("link_url like", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotLike(String value) {
            addCriterion("link_url not like", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlIn(List<String> values) {
            addCriterion("link_url in", values, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotIn(List<String> values) {
            addCriterion("link_url not in", values, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlBetween(String value1, String value2) {
            addCriterion("link_url between", value1, value2, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotBetween(String value1, String value2) {
            addCriterion("link_url not between", value1, value2, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkNameIsNull() {
            addCriterion("link_name is null");
            return (Criteria) this;
        }

        public Criteria andLinkNameIsNotNull() {
            addCriterion("link_name is not null");
            return (Criteria) this;
        }

        public Criteria andLinkNameEqualTo(String value) {
            addCriterion("link_name =", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotEqualTo(String value) {
            addCriterion("link_name <>", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameGreaterThan(String value) {
            addCriterion("link_name >", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameGreaterThanOrEqualTo(String value) {
            addCriterion("link_name >=", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLessThan(String value) {
            addCriterion("link_name <", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLessThanOrEqualTo(String value) {
            addCriterion("link_name <=", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLike(String value) {
            addCriterion("link_name like", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotLike(String value) {
            addCriterion("link_name not like", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameIn(List<String> values) {
            addCriterion("link_name in", values, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotIn(List<String> values) {
            addCriterion("link_name not in", values, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameBetween(String value1, String value2) {
            addCriterion("link_name between", value1, value2, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotBetween(String value1, String value2) {
            addCriterion("link_name not between", value1, value2, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkImageIsNull() {
            addCriterion("link_image is null");
            return (Criteria) this;
        }

        public Criteria andLinkImageIsNotNull() {
            addCriterion("link_image is not null");
            return (Criteria) this;
        }

        public Criteria andLinkImageEqualTo(String value) {
            addCriterion("link_image =", value, "linkImage");
            return (Criteria) this;
        }

        public Criteria andLinkImageNotEqualTo(String value) {
            addCriterion("link_image <>", value, "linkImage");
            return (Criteria) this;
        }

        public Criteria andLinkImageGreaterThan(String value) {
            addCriterion("link_image >", value, "linkImage");
            return (Criteria) this;
        }

        public Criteria andLinkImageGreaterThanOrEqualTo(String value) {
            addCriterion("link_image >=", value, "linkImage");
            return (Criteria) this;
        }

        public Criteria andLinkImageLessThan(String value) {
            addCriterion("link_image <", value, "linkImage");
            return (Criteria) this;
        }

        public Criteria andLinkImageLessThanOrEqualTo(String value) {
            addCriterion("link_image <=", value, "linkImage");
            return (Criteria) this;
        }

        public Criteria andLinkImageLike(String value) {
            addCriterion("link_image like", value, "linkImage");
            return (Criteria) this;
        }

        public Criteria andLinkImageNotLike(String value) {
            addCriterion("link_image not like", value, "linkImage");
            return (Criteria) this;
        }

        public Criteria andLinkImageIn(List<String> values) {
            addCriterion("link_image in", values, "linkImage");
            return (Criteria) this;
        }

        public Criteria andLinkImageNotIn(List<String> values) {
            addCriterion("link_image not in", values, "linkImage");
            return (Criteria) this;
        }

        public Criteria andLinkImageBetween(String value1, String value2) {
            addCriterion("link_image between", value1, value2, "linkImage");
            return (Criteria) this;
        }

        public Criteria andLinkImageNotBetween(String value1, String value2) {
            addCriterion("link_image not between", value1, value2, "linkImage");
            return (Criteria) this;
        }

        public Criteria andLinkDescriptionIsNull() {
            addCriterion("link_description is null");
            return (Criteria) this;
        }

        public Criteria andLinkDescriptionIsNotNull() {
            addCriterion("link_description is not null");
            return (Criteria) this;
        }

        public Criteria andLinkDescriptionEqualTo(String value) {
            addCriterion("link_description =", value, "linkDescription");
            return (Criteria) this;
        }

        public Criteria andLinkDescriptionNotEqualTo(String value) {
            addCriterion("link_description <>", value, "linkDescription");
            return (Criteria) this;
        }

        public Criteria andLinkDescriptionGreaterThan(String value) {
            addCriterion("link_description >", value, "linkDescription");
            return (Criteria) this;
        }

        public Criteria andLinkDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("link_description >=", value, "linkDescription");
            return (Criteria) this;
        }

        public Criteria andLinkDescriptionLessThan(String value) {
            addCriterion("link_description <", value, "linkDescription");
            return (Criteria) this;
        }

        public Criteria andLinkDescriptionLessThanOrEqualTo(String value) {
            addCriterion("link_description <=", value, "linkDescription");
            return (Criteria) this;
        }

        public Criteria andLinkDescriptionLike(String value) {
            addCriterion("link_description like", value, "linkDescription");
            return (Criteria) this;
        }

        public Criteria andLinkDescriptionNotLike(String value) {
            addCriterion("link_description not like", value, "linkDescription");
            return (Criteria) this;
        }

        public Criteria andLinkDescriptionIn(List<String> values) {
            addCriterion("link_description in", values, "linkDescription");
            return (Criteria) this;
        }

        public Criteria andLinkDescriptionNotIn(List<String> values) {
            addCriterion("link_description not in", values, "linkDescription");
            return (Criteria) this;
        }

        public Criteria andLinkDescriptionBetween(String value1, String value2) {
            addCriterion("link_description between", value1, value2, "linkDescription");
            return (Criteria) this;
        }

        public Criteria andLinkDescriptionNotBetween(String value1, String value2) {
            addCriterion("link_description not between", value1, value2, "linkDescription");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerNicknameIsNull() {
            addCriterion("link_owner_nickname is null");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerNicknameIsNotNull() {
            addCriterion("link_owner_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerNicknameEqualTo(String value) {
            addCriterion("link_owner_nickname =", value, "linkOwnerNickname");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerNicknameNotEqualTo(String value) {
            addCriterion("link_owner_nickname <>", value, "linkOwnerNickname");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerNicknameGreaterThan(String value) {
            addCriterion("link_owner_nickname >", value, "linkOwnerNickname");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("link_owner_nickname >=", value, "linkOwnerNickname");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerNicknameLessThan(String value) {
            addCriterion("link_owner_nickname <", value, "linkOwnerNickname");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerNicknameLessThanOrEqualTo(String value) {
            addCriterion("link_owner_nickname <=", value, "linkOwnerNickname");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerNicknameLike(String value) {
            addCriterion("link_owner_nickname like", value, "linkOwnerNickname");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerNicknameNotLike(String value) {
            addCriterion("link_owner_nickname not like", value, "linkOwnerNickname");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerNicknameIn(List<String> values) {
            addCriterion("link_owner_nickname in", values, "linkOwnerNickname");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerNicknameNotIn(List<String> values) {
            addCriterion("link_owner_nickname not in", values, "linkOwnerNickname");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerNicknameBetween(String value1, String value2) {
            addCriterion("link_owner_nickname between", value1, value2, "linkOwnerNickname");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerNicknameNotBetween(String value1, String value2) {
            addCriterion("link_owner_nickname not between", value1, value2, "linkOwnerNickname");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerContactIsNull() {
            addCriterion("link_owner_contact is null");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerContactIsNotNull() {
            addCriterion("link_owner_contact is not null");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerContactEqualTo(String value) {
            addCriterion("link_owner_contact =", value, "linkOwnerContact");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerContactNotEqualTo(String value) {
            addCriterion("link_owner_contact <>", value, "linkOwnerContact");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerContactGreaterThan(String value) {
            addCriterion("link_owner_contact >", value, "linkOwnerContact");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerContactGreaterThanOrEqualTo(String value) {
            addCriterion("link_owner_contact >=", value, "linkOwnerContact");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerContactLessThan(String value) {
            addCriterion("link_owner_contact <", value, "linkOwnerContact");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerContactLessThanOrEqualTo(String value) {
            addCriterion("link_owner_contact <=", value, "linkOwnerContact");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerContactLike(String value) {
            addCriterion("link_owner_contact like", value, "linkOwnerContact");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerContactNotLike(String value) {
            addCriterion("link_owner_contact not like", value, "linkOwnerContact");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerContactIn(List<String> values) {
            addCriterion("link_owner_contact in", values, "linkOwnerContact");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerContactNotIn(List<String> values) {
            addCriterion("link_owner_contact not in", values, "linkOwnerContact");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerContactBetween(String value1, String value2) {
            addCriterion("link_owner_contact between", value1, value2, "linkOwnerContact");
            return (Criteria) this;
        }

        public Criteria andLinkOwnerContactNotBetween(String value1, String value2) {
            addCriterion("link_owner_contact not between", value1, value2, "linkOwnerContact");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeIsNull() {
            addCriterion("link_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeIsNotNull() {
            addCriterion("link_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeEqualTo(Date value) {
            addCriterion("link_update_time =", value, "linkUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeNotEqualTo(Date value) {
            addCriterion("link_update_time <>", value, "linkUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeGreaterThan(Date value) {
            addCriterion("link_update_time >", value, "linkUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("link_update_time >=", value, "linkUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeLessThan(Date value) {
            addCriterion("link_update_time <", value, "linkUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("link_update_time <=", value, "linkUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeIn(List<Date> values) {
            addCriterion("link_update_time in", values, "linkUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeNotIn(List<Date> values) {
            addCriterion("link_update_time not in", values, "linkUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("link_update_time between", value1, value2, "linkUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("link_update_time not between", value1, value2, "linkUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeIsNull() {
            addCriterion("link_create_time is null");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeIsNotNull() {
            addCriterion("link_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeEqualTo(Date value) {
            addCriterion("link_create_time =", value, "linkCreateTime");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeNotEqualTo(Date value) {
            addCriterion("link_create_time <>", value, "linkCreateTime");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeGreaterThan(Date value) {
            addCriterion("link_create_time >", value, "linkCreateTime");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("link_create_time >=", value, "linkCreateTime");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeLessThan(Date value) {
            addCriterion("link_create_time <", value, "linkCreateTime");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("link_create_time <=", value, "linkCreateTime");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeIn(List<Date> values) {
            addCriterion("link_create_time in", values, "linkCreateTime");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeNotIn(List<Date> values) {
            addCriterion("link_create_time not in", values, "linkCreateTime");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeBetween(Date value1, Date value2) {
            addCriterion("link_create_time between", value1, value2, "linkCreateTime");
            return (Criteria) this;
        }

        public Criteria andLinkCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("link_create_time not between", value1, value2, "linkCreateTime");
            return (Criteria) this;
        }

        public Criteria andLinkOrderIsNull() {
            addCriterion("link_order is null");
            return (Criteria) this;
        }

        public Criteria andLinkOrderIsNotNull() {
            addCriterion("link_order is not null");
            return (Criteria) this;
        }

        public Criteria andLinkOrderEqualTo(Integer value) {
            addCriterion("link_order =", value, "linkOrder");
            return (Criteria) this;
        }

        public Criteria andLinkOrderNotEqualTo(Integer value) {
            addCriterion("link_order <>", value, "linkOrder");
            return (Criteria) this;
        }

        public Criteria andLinkOrderGreaterThan(Integer value) {
            addCriterion("link_order >", value, "linkOrder");
            return (Criteria) this;
        }

        public Criteria andLinkOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("link_order >=", value, "linkOrder");
            return (Criteria) this;
        }

        public Criteria andLinkOrderLessThan(Integer value) {
            addCriterion("link_order <", value, "linkOrder");
            return (Criteria) this;
        }

        public Criteria andLinkOrderLessThanOrEqualTo(Integer value) {
            addCriterion("link_order <=", value, "linkOrder");
            return (Criteria) this;
        }

        public Criteria andLinkOrderIn(List<Integer> values) {
            addCriterion("link_order in", values, "linkOrder");
            return (Criteria) this;
        }

        public Criteria andLinkOrderNotIn(List<Integer> values) {
            addCriterion("link_order not in", values, "linkOrder");
            return (Criteria) this;
        }

        public Criteria andLinkOrderBetween(Integer value1, Integer value2) {
            addCriterion("link_order between", value1, value2, "linkOrder");
            return (Criteria) this;
        }

        public Criteria andLinkOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("link_order not between", value1, value2, "linkOrder");
            return (Criteria) this;
        }

        public Criteria andLinkStatusIsNull() {
            addCriterion("link_status is null");
            return (Criteria) this;
        }

        public Criteria andLinkStatusIsNotNull() {
            addCriterion("link_status is not null");
            return (Criteria) this;
        }

        public Criteria andLinkStatusEqualTo(Integer value) {
            addCriterion("link_status =", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusNotEqualTo(Integer value) {
            addCriterion("link_status <>", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusGreaterThan(Integer value) {
            addCriterion("link_status >", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("link_status >=", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusLessThan(Integer value) {
            addCriterion("link_status <", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusLessThanOrEqualTo(Integer value) {
            addCriterion("link_status <=", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusIn(List<Integer> values) {
            addCriterion("link_status in", values, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusNotIn(List<Integer> values) {
            addCriterion("link_status not in", values, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusBetween(Integer value1, Integer value2) {
            addCriterion("link_status between", value1, value2, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("link_status not between", value1, value2, "linkStatus");
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