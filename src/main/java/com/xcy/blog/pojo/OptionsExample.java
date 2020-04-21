package com.xcy.blog.pojo;

import java.util.ArrayList;
import java.util.List;

public class OptionsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OptionsExample() {
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

        public Criteria andOptionIdIsNull() {
            addCriterion("option_id is null");
            return (Criteria) this;
        }

        public Criteria andOptionIdIsNotNull() {
            addCriterion("option_id is not null");
            return (Criteria) this;
        }

        public Criteria andOptionIdEqualTo(Integer value) {
            addCriterion("option_id =", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdNotEqualTo(Integer value) {
            addCriterion("option_id <>", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdGreaterThan(Integer value) {
            addCriterion("option_id >", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("option_id >=", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdLessThan(Integer value) {
            addCriterion("option_id <", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdLessThanOrEqualTo(Integer value) {
            addCriterion("option_id <=", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdIn(List<Integer> values) {
            addCriterion("option_id in", values, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdNotIn(List<Integer> values) {
            addCriterion("option_id not in", values, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdBetween(Integer value1, Integer value2) {
            addCriterion("option_id between", value1, value2, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("option_id not between", value1, value2, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionSiteTitleIsNull() {
            addCriterion("option_site_title is null");
            return (Criteria) this;
        }

        public Criteria andOptionSiteTitleIsNotNull() {
            addCriterion("option_site_title is not null");
            return (Criteria) this;
        }

        public Criteria andOptionSiteTitleEqualTo(String value) {
            addCriterion("option_site_title =", value, "optionSiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionSiteTitleNotEqualTo(String value) {
            addCriterion("option_site_title <>", value, "optionSiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionSiteTitleGreaterThan(String value) {
            addCriterion("option_site_title >", value, "optionSiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionSiteTitleGreaterThanOrEqualTo(String value) {
            addCriterion("option_site_title >=", value, "optionSiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionSiteTitleLessThan(String value) {
            addCriterion("option_site_title <", value, "optionSiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionSiteTitleLessThanOrEqualTo(String value) {
            addCriterion("option_site_title <=", value, "optionSiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionSiteTitleLike(String value) {
            addCriterion("option_site_title like", value, "optionSiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionSiteTitleNotLike(String value) {
            addCriterion("option_site_title not like", value, "optionSiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionSiteTitleIn(List<String> values) {
            addCriterion("option_site_title in", values, "optionSiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionSiteTitleNotIn(List<String> values) {
            addCriterion("option_site_title not in", values, "optionSiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionSiteTitleBetween(String value1, String value2) {
            addCriterion("option_site_title between", value1, value2, "optionSiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionSiteTitleNotBetween(String value1, String value2) {
            addCriterion("option_site_title not between", value1, value2, "optionSiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionIsNull() {
            addCriterion("option_site_descrption is null");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionIsNotNull() {
            addCriterion("option_site_descrption is not null");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionEqualTo(String value) {
            addCriterion("option_site_descrption =", value, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionNotEqualTo(String value) {
            addCriterion("option_site_descrption <>", value, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionGreaterThan(String value) {
            addCriterion("option_site_descrption >", value, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionGreaterThanOrEqualTo(String value) {
            addCriterion("option_site_descrption >=", value, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionLessThan(String value) {
            addCriterion("option_site_descrption <", value, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionLessThanOrEqualTo(String value) {
            addCriterion("option_site_descrption <=", value, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionLike(String value) {
            addCriterion("option_site_descrption like", value, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionNotLike(String value) {
            addCriterion("option_site_descrption not like", value, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionIn(List<String> values) {
            addCriterion("option_site_descrption in", values, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionNotIn(List<String> values) {
            addCriterion("option_site_descrption not in", values, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionBetween(String value1, String value2) {
            addCriterion("option_site_descrption between", value1, value2, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionSiteDescrptionNotBetween(String value1, String value2) {
            addCriterion("option_site_descrption not between", value1, value2, "optionSiteDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionMetaDescrptionIsNull() {
            addCriterion("option_meta_descrption is null");
            return (Criteria) this;
        }

        public Criteria andOptionMetaDescrptionIsNotNull() {
            addCriterion("option_meta_descrption is not null");
            return (Criteria) this;
        }

        public Criteria andOptionMetaDescrptionEqualTo(String value) {
            addCriterion("option_meta_descrption =", value, "optionMetaDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionMetaDescrptionNotEqualTo(String value) {
            addCriterion("option_meta_descrption <>", value, "optionMetaDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionMetaDescrptionGreaterThan(String value) {
            addCriterion("option_meta_descrption >", value, "optionMetaDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionMetaDescrptionGreaterThanOrEqualTo(String value) {
            addCriterion("option_meta_descrption >=", value, "optionMetaDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionMetaDescrptionLessThan(String value) {
            addCriterion("option_meta_descrption <", value, "optionMetaDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionMetaDescrptionLessThanOrEqualTo(String value) {
            addCriterion("option_meta_descrption <=", value, "optionMetaDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionMetaDescrptionLike(String value) {
            addCriterion("option_meta_descrption like", value, "optionMetaDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionMetaDescrptionNotLike(String value) {
            addCriterion("option_meta_descrption not like", value, "optionMetaDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionMetaDescrptionIn(List<String> values) {
            addCriterion("option_meta_descrption in", values, "optionMetaDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionMetaDescrptionNotIn(List<String> values) {
            addCriterion("option_meta_descrption not in", values, "optionMetaDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionMetaDescrptionBetween(String value1, String value2) {
            addCriterion("option_meta_descrption between", value1, value2, "optionMetaDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionMetaDescrptionNotBetween(String value1, String value2) {
            addCriterion("option_meta_descrption not between", value1, value2, "optionMetaDescrption");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordIsNull() {
            addCriterion("option_meta_keyword is null");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordIsNotNull() {
            addCriterion("option_meta_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordEqualTo(String value) {
            addCriterion("option_meta_keyword =", value, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordNotEqualTo(String value) {
            addCriterion("option_meta_keyword <>", value, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordGreaterThan(String value) {
            addCriterion("option_meta_keyword >", value, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("option_meta_keyword >=", value, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordLessThan(String value) {
            addCriterion("option_meta_keyword <", value, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordLessThanOrEqualTo(String value) {
            addCriterion("option_meta_keyword <=", value, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordLike(String value) {
            addCriterion("option_meta_keyword like", value, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordNotLike(String value) {
            addCriterion("option_meta_keyword not like", value, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordIn(List<String> values) {
            addCriterion("option_meta_keyword in", values, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordNotIn(List<String> values) {
            addCriterion("option_meta_keyword not in", values, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordBetween(String value1, String value2) {
            addCriterion("option_meta_keyword between", value1, value2, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionMetaKeywordNotBetween(String value1, String value2) {
            addCriterion("option_meta_keyword not between", value1, value2, "optionMetaKeyword");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteAvatarIsNull() {
            addCriterion("option_aboutsite_avatar is null");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteAvatarIsNotNull() {
            addCriterion("option_aboutsite_avatar is not null");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteAvatarEqualTo(String value) {
            addCriterion("option_aboutsite_avatar =", value, "optionAboutsiteAvatar");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteAvatarNotEqualTo(String value) {
            addCriterion("option_aboutsite_avatar <>", value, "optionAboutsiteAvatar");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteAvatarGreaterThan(String value) {
            addCriterion("option_aboutsite_avatar >", value, "optionAboutsiteAvatar");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("option_aboutsite_avatar >=", value, "optionAboutsiteAvatar");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteAvatarLessThan(String value) {
            addCriterion("option_aboutsite_avatar <", value, "optionAboutsiteAvatar");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteAvatarLessThanOrEqualTo(String value) {
            addCriterion("option_aboutsite_avatar <=", value, "optionAboutsiteAvatar");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteAvatarLike(String value) {
            addCriterion("option_aboutsite_avatar like", value, "optionAboutsiteAvatar");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteAvatarNotLike(String value) {
            addCriterion("option_aboutsite_avatar not like", value, "optionAboutsiteAvatar");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteAvatarIn(List<String> values) {
            addCriterion("option_aboutsite_avatar in", values, "optionAboutsiteAvatar");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteAvatarNotIn(List<String> values) {
            addCriterion("option_aboutsite_avatar not in", values, "optionAboutsiteAvatar");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteAvatarBetween(String value1, String value2) {
            addCriterion("option_aboutsite_avatar between", value1, value2, "optionAboutsiteAvatar");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteAvatarNotBetween(String value1, String value2) {
            addCriterion("option_aboutsite_avatar not between", value1, value2, "optionAboutsiteAvatar");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteTitleIsNull() {
            addCriterion("option_aboutsite_title is null");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteTitleIsNotNull() {
            addCriterion("option_aboutsite_title is not null");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteTitleEqualTo(String value) {
            addCriterion("option_aboutsite_title =", value, "optionAboutsiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteTitleNotEqualTo(String value) {
            addCriterion("option_aboutsite_title <>", value, "optionAboutsiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteTitleGreaterThan(String value) {
            addCriterion("option_aboutsite_title >", value, "optionAboutsiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteTitleGreaterThanOrEqualTo(String value) {
            addCriterion("option_aboutsite_title >=", value, "optionAboutsiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteTitleLessThan(String value) {
            addCriterion("option_aboutsite_title <", value, "optionAboutsiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteTitleLessThanOrEqualTo(String value) {
            addCriterion("option_aboutsite_title <=", value, "optionAboutsiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteTitleLike(String value) {
            addCriterion("option_aboutsite_title like", value, "optionAboutsiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteTitleNotLike(String value) {
            addCriterion("option_aboutsite_title not like", value, "optionAboutsiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteTitleIn(List<String> values) {
            addCriterion("option_aboutsite_title in", values, "optionAboutsiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteTitleNotIn(List<String> values) {
            addCriterion("option_aboutsite_title not in", values, "optionAboutsiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteTitleBetween(String value1, String value2) {
            addCriterion("option_aboutsite_title between", value1, value2, "optionAboutsiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteTitleNotBetween(String value1, String value2) {
            addCriterion("option_aboutsite_title not between", value1, value2, "optionAboutsiteTitle");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteContentIsNull() {
            addCriterion("option_aboutsite_content is null");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteContentIsNotNull() {
            addCriterion("option_aboutsite_content is not null");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteContentEqualTo(String value) {
            addCriterion("option_aboutsite_content =", value, "optionAboutsiteContent");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteContentNotEqualTo(String value) {
            addCriterion("option_aboutsite_content <>", value, "optionAboutsiteContent");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteContentGreaterThan(String value) {
            addCriterion("option_aboutsite_content >", value, "optionAboutsiteContent");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteContentGreaterThanOrEqualTo(String value) {
            addCriterion("option_aboutsite_content >=", value, "optionAboutsiteContent");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteContentLessThan(String value) {
            addCriterion("option_aboutsite_content <", value, "optionAboutsiteContent");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteContentLessThanOrEqualTo(String value) {
            addCriterion("option_aboutsite_content <=", value, "optionAboutsiteContent");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteContentLike(String value) {
            addCriterion("option_aboutsite_content like", value, "optionAboutsiteContent");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteContentNotLike(String value) {
            addCriterion("option_aboutsite_content not like", value, "optionAboutsiteContent");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteContentIn(List<String> values) {
            addCriterion("option_aboutsite_content in", values, "optionAboutsiteContent");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteContentNotIn(List<String> values) {
            addCriterion("option_aboutsite_content not in", values, "optionAboutsiteContent");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteContentBetween(String value1, String value2) {
            addCriterion("option_aboutsite_content between", value1, value2, "optionAboutsiteContent");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteContentNotBetween(String value1, String value2) {
            addCriterion("option_aboutsite_content not between", value1, value2, "optionAboutsiteContent");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWechatIsNull() {
            addCriterion("option_aboutsite_wechat is null");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWechatIsNotNull() {
            addCriterion("option_aboutsite_wechat is not null");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWechatEqualTo(String value) {
            addCriterion("option_aboutsite_wechat =", value, "optionAboutsiteWechat");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWechatNotEqualTo(String value) {
            addCriterion("option_aboutsite_wechat <>", value, "optionAboutsiteWechat");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWechatGreaterThan(String value) {
            addCriterion("option_aboutsite_wechat >", value, "optionAboutsiteWechat");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWechatGreaterThanOrEqualTo(String value) {
            addCriterion("option_aboutsite_wechat >=", value, "optionAboutsiteWechat");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWechatLessThan(String value) {
            addCriterion("option_aboutsite_wechat <", value, "optionAboutsiteWechat");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWechatLessThanOrEqualTo(String value) {
            addCriterion("option_aboutsite_wechat <=", value, "optionAboutsiteWechat");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWechatLike(String value) {
            addCriterion("option_aboutsite_wechat like", value, "optionAboutsiteWechat");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWechatNotLike(String value) {
            addCriterion("option_aboutsite_wechat not like", value, "optionAboutsiteWechat");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWechatIn(List<String> values) {
            addCriterion("option_aboutsite_wechat in", values, "optionAboutsiteWechat");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWechatNotIn(List<String> values) {
            addCriterion("option_aboutsite_wechat not in", values, "optionAboutsiteWechat");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWechatBetween(String value1, String value2) {
            addCriterion("option_aboutsite_wechat between", value1, value2, "optionAboutsiteWechat");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWechatNotBetween(String value1, String value2) {
            addCriterion("option_aboutsite_wechat not between", value1, value2, "optionAboutsiteWechat");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteQqIsNull() {
            addCriterion("option_aboutsite_qq is null");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteQqIsNotNull() {
            addCriterion("option_aboutsite_qq is not null");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteQqEqualTo(String value) {
            addCriterion("option_aboutsite_qq =", value, "optionAboutsiteQq");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteQqNotEqualTo(String value) {
            addCriterion("option_aboutsite_qq <>", value, "optionAboutsiteQq");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteQqGreaterThan(String value) {
            addCriterion("option_aboutsite_qq >", value, "optionAboutsiteQq");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteQqGreaterThanOrEqualTo(String value) {
            addCriterion("option_aboutsite_qq >=", value, "optionAboutsiteQq");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteQqLessThan(String value) {
            addCriterion("option_aboutsite_qq <", value, "optionAboutsiteQq");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteQqLessThanOrEqualTo(String value) {
            addCriterion("option_aboutsite_qq <=", value, "optionAboutsiteQq");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteQqLike(String value) {
            addCriterion("option_aboutsite_qq like", value, "optionAboutsiteQq");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteQqNotLike(String value) {
            addCriterion("option_aboutsite_qq not like", value, "optionAboutsiteQq");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteQqIn(List<String> values) {
            addCriterion("option_aboutsite_qq in", values, "optionAboutsiteQq");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteQqNotIn(List<String> values) {
            addCriterion("option_aboutsite_qq not in", values, "optionAboutsiteQq");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteQqBetween(String value1, String value2) {
            addCriterion("option_aboutsite_qq between", value1, value2, "optionAboutsiteQq");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteQqNotBetween(String value1, String value2) {
            addCriterion("option_aboutsite_qq not between", value1, value2, "optionAboutsiteQq");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteGithubIsNull() {
            addCriterion("option_aboutsite_github is null");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteGithubIsNotNull() {
            addCriterion("option_aboutsite_github is not null");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteGithubEqualTo(String value) {
            addCriterion("option_aboutsite_github =", value, "optionAboutsiteGithub");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteGithubNotEqualTo(String value) {
            addCriterion("option_aboutsite_github <>", value, "optionAboutsiteGithub");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteGithubGreaterThan(String value) {
            addCriterion("option_aboutsite_github >", value, "optionAboutsiteGithub");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteGithubGreaterThanOrEqualTo(String value) {
            addCriterion("option_aboutsite_github >=", value, "optionAboutsiteGithub");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteGithubLessThan(String value) {
            addCriterion("option_aboutsite_github <", value, "optionAboutsiteGithub");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteGithubLessThanOrEqualTo(String value) {
            addCriterion("option_aboutsite_github <=", value, "optionAboutsiteGithub");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteGithubLike(String value) {
            addCriterion("option_aboutsite_github like", value, "optionAboutsiteGithub");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteGithubNotLike(String value) {
            addCriterion("option_aboutsite_github not like", value, "optionAboutsiteGithub");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteGithubIn(List<String> values) {
            addCriterion("option_aboutsite_github in", values, "optionAboutsiteGithub");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteGithubNotIn(List<String> values) {
            addCriterion("option_aboutsite_github not in", values, "optionAboutsiteGithub");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteGithubBetween(String value1, String value2) {
            addCriterion("option_aboutsite_github between", value1, value2, "optionAboutsiteGithub");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteGithubNotBetween(String value1, String value2) {
            addCriterion("option_aboutsite_github not between", value1, value2, "optionAboutsiteGithub");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWeiboIsNull() {
            addCriterion("option_aboutsite_weibo is null");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWeiboIsNotNull() {
            addCriterion("option_aboutsite_weibo is not null");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWeiboEqualTo(String value) {
            addCriterion("option_aboutsite_weibo =", value, "optionAboutsiteWeibo");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWeiboNotEqualTo(String value) {
            addCriterion("option_aboutsite_weibo <>", value, "optionAboutsiteWeibo");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWeiboGreaterThan(String value) {
            addCriterion("option_aboutsite_weibo >", value, "optionAboutsiteWeibo");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWeiboGreaterThanOrEqualTo(String value) {
            addCriterion("option_aboutsite_weibo >=", value, "optionAboutsiteWeibo");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWeiboLessThan(String value) {
            addCriterion("option_aboutsite_weibo <", value, "optionAboutsiteWeibo");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWeiboLessThanOrEqualTo(String value) {
            addCriterion("option_aboutsite_weibo <=", value, "optionAboutsiteWeibo");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWeiboLike(String value) {
            addCriterion("option_aboutsite_weibo like", value, "optionAboutsiteWeibo");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWeiboNotLike(String value) {
            addCriterion("option_aboutsite_weibo not like", value, "optionAboutsiteWeibo");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWeiboIn(List<String> values) {
            addCriterion("option_aboutsite_weibo in", values, "optionAboutsiteWeibo");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWeiboNotIn(List<String> values) {
            addCriterion("option_aboutsite_weibo not in", values, "optionAboutsiteWeibo");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWeiboBetween(String value1, String value2) {
            addCriterion("option_aboutsite_weibo between", value1, value2, "optionAboutsiteWeibo");
            return (Criteria) this;
        }

        public Criteria andOptionAboutsiteWeiboNotBetween(String value1, String value2) {
            addCriterion("option_aboutsite_weibo not between", value1, value2, "optionAboutsiteWeibo");
            return (Criteria) this;
        }

        public Criteria andOptionTongjiIsNull() {
            addCriterion("option_tongji is null");
            return (Criteria) this;
        }

        public Criteria andOptionTongjiIsNotNull() {
            addCriterion("option_tongji is not null");
            return (Criteria) this;
        }

        public Criteria andOptionTongjiEqualTo(String value) {
            addCriterion("option_tongji =", value, "optionTongji");
            return (Criteria) this;
        }

        public Criteria andOptionTongjiNotEqualTo(String value) {
            addCriterion("option_tongji <>", value, "optionTongji");
            return (Criteria) this;
        }

        public Criteria andOptionTongjiGreaterThan(String value) {
            addCriterion("option_tongji >", value, "optionTongji");
            return (Criteria) this;
        }

        public Criteria andOptionTongjiGreaterThanOrEqualTo(String value) {
            addCriterion("option_tongji >=", value, "optionTongji");
            return (Criteria) this;
        }

        public Criteria andOptionTongjiLessThan(String value) {
            addCriterion("option_tongji <", value, "optionTongji");
            return (Criteria) this;
        }

        public Criteria andOptionTongjiLessThanOrEqualTo(String value) {
            addCriterion("option_tongji <=", value, "optionTongji");
            return (Criteria) this;
        }

        public Criteria andOptionTongjiLike(String value) {
            addCriterion("option_tongji like", value, "optionTongji");
            return (Criteria) this;
        }

        public Criteria andOptionTongjiNotLike(String value) {
            addCriterion("option_tongji not like", value, "optionTongji");
            return (Criteria) this;
        }

        public Criteria andOptionTongjiIn(List<String> values) {
            addCriterion("option_tongji in", values, "optionTongji");
            return (Criteria) this;
        }

        public Criteria andOptionTongjiNotIn(List<String> values) {
            addCriterion("option_tongji not in", values, "optionTongji");
            return (Criteria) this;
        }

        public Criteria andOptionTongjiBetween(String value1, String value2) {
            addCriterion("option_tongji between", value1, value2, "optionTongji");
            return (Criteria) this;
        }

        public Criteria andOptionTongjiNotBetween(String value1, String value2) {
            addCriterion("option_tongji not between", value1, value2, "optionTongji");
            return (Criteria) this;
        }

        public Criteria andOptionStatusIsNull() {
            addCriterion("option_status is null");
            return (Criteria) this;
        }

        public Criteria andOptionStatusIsNotNull() {
            addCriterion("option_status is not null");
            return (Criteria) this;
        }

        public Criteria andOptionStatusEqualTo(Integer value) {
            addCriterion("option_status =", value, "optionStatus");
            return (Criteria) this;
        }

        public Criteria andOptionStatusNotEqualTo(Integer value) {
            addCriterion("option_status <>", value, "optionStatus");
            return (Criteria) this;
        }

        public Criteria andOptionStatusGreaterThan(Integer value) {
            addCriterion("option_status >", value, "optionStatus");
            return (Criteria) this;
        }

        public Criteria andOptionStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("option_status >=", value, "optionStatus");
            return (Criteria) this;
        }

        public Criteria andOptionStatusLessThan(Integer value) {
            addCriterion("option_status <", value, "optionStatus");
            return (Criteria) this;
        }

        public Criteria andOptionStatusLessThanOrEqualTo(Integer value) {
            addCriterion("option_status <=", value, "optionStatus");
            return (Criteria) this;
        }

        public Criteria andOptionStatusIn(List<Integer> values) {
            addCriterion("option_status in", values, "optionStatus");
            return (Criteria) this;
        }

        public Criteria andOptionStatusNotIn(List<Integer> values) {
            addCriterion("option_status not in", values, "optionStatus");
            return (Criteria) this;
        }

        public Criteria andOptionStatusBetween(Integer value1, Integer value2) {
            addCriterion("option_status between", value1, value2, "optionStatus");
            return (Criteria) this;
        }

        public Criteria andOptionStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("option_status not between", value1, value2, "optionStatus");
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