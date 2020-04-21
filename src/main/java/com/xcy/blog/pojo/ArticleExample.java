package com.xcy.blog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(Integer value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(Integer value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(Integer value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(Integer value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(Integer value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<Integer> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<Integer> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(Integer value1, Integer value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdIsNull() {
            addCriterion("article_user_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdIsNotNull() {
            addCriterion("article_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdEqualTo(Integer value) {
            addCriterion("article_user_id =", value, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdNotEqualTo(Integer value) {
            addCriterion("article_user_id <>", value, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdGreaterThan(Integer value) {
            addCriterion("article_user_id >", value, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_user_id >=", value, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdLessThan(Integer value) {
            addCriterion("article_user_id <", value, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("article_user_id <=", value, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdIn(List<Integer> values) {
            addCriterion("article_user_id in", values, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdNotIn(List<Integer> values) {
            addCriterion("article_user_id not in", values, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdBetween(Integer value1, Integer value2) {
            addCriterion("article_user_id between", value1, value2, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("article_user_id not between", value1, value2, "articleUserId");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNull() {
            addCriterion("article_title is null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNotNull() {
            addCriterion("article_title is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleEqualTo(String value) {
            addCriterion("article_title =", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotEqualTo(String value) {
            addCriterion("article_title <>", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThan(String value) {
            addCriterion("article_title >", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThanOrEqualTo(String value) {
            addCriterion("article_title >=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThan(String value) {
            addCriterion("article_title <", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThanOrEqualTo(String value) {
            addCriterion("article_title <=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLike(String value) {
            addCriterion("article_title like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotLike(String value) {
            addCriterion("article_title not like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIn(List<String> values) {
            addCriterion("article_title in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotIn(List<String> values) {
            addCriterion("article_title not in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleBetween(String value1, String value2) {
            addCriterion("article_title between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotBetween(String value1, String value2) {
            addCriterion("article_title not between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleViewCountIsNull() {
            addCriterion("article_view_count is null");
            return (Criteria) this;
        }

        public Criteria andArticleViewCountIsNotNull() {
            addCriterion("article_view_count is not null");
            return (Criteria) this;
        }

        public Criteria andArticleViewCountEqualTo(Integer value) {
            addCriterion("article_view_count =", value, "articleViewCount");
            return (Criteria) this;
        }

        public Criteria andArticleViewCountNotEqualTo(Integer value) {
            addCriterion("article_view_count <>", value, "articleViewCount");
            return (Criteria) this;
        }

        public Criteria andArticleViewCountGreaterThan(Integer value) {
            addCriterion("article_view_count >", value, "articleViewCount");
            return (Criteria) this;
        }

        public Criteria andArticleViewCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_view_count >=", value, "articleViewCount");
            return (Criteria) this;
        }

        public Criteria andArticleViewCountLessThan(Integer value) {
            addCriterion("article_view_count <", value, "articleViewCount");
            return (Criteria) this;
        }

        public Criteria andArticleViewCountLessThanOrEqualTo(Integer value) {
            addCriterion("article_view_count <=", value, "articleViewCount");
            return (Criteria) this;
        }

        public Criteria andArticleViewCountIn(List<Integer> values) {
            addCriterion("article_view_count in", values, "articleViewCount");
            return (Criteria) this;
        }

        public Criteria andArticleViewCountNotIn(List<Integer> values) {
            addCriterion("article_view_count not in", values, "articleViewCount");
            return (Criteria) this;
        }

        public Criteria andArticleViewCountBetween(Integer value1, Integer value2) {
            addCriterion("article_view_count between", value1, value2, "articleViewCount");
            return (Criteria) this;
        }

        public Criteria andArticleViewCountNotBetween(Integer value1, Integer value2) {
            addCriterion("article_view_count not between", value1, value2, "articleViewCount");
            return (Criteria) this;
        }

        public Criteria andArticleCommentCountIsNull() {
            addCriterion("article_comment_count is null");
            return (Criteria) this;
        }

        public Criteria andArticleCommentCountIsNotNull() {
            addCriterion("article_comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCommentCountEqualTo(Integer value) {
            addCriterion("article_comment_count =", value, "articleCommentCount");
            return (Criteria) this;
        }

        public Criteria andArticleCommentCountNotEqualTo(Integer value) {
            addCriterion("article_comment_count <>", value, "articleCommentCount");
            return (Criteria) this;
        }

        public Criteria andArticleCommentCountGreaterThan(Integer value) {
            addCriterion("article_comment_count >", value, "articleCommentCount");
            return (Criteria) this;
        }

        public Criteria andArticleCommentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_comment_count >=", value, "articleCommentCount");
            return (Criteria) this;
        }

        public Criteria andArticleCommentCountLessThan(Integer value) {
            addCriterion("article_comment_count <", value, "articleCommentCount");
            return (Criteria) this;
        }

        public Criteria andArticleCommentCountLessThanOrEqualTo(Integer value) {
            addCriterion("article_comment_count <=", value, "articleCommentCount");
            return (Criteria) this;
        }

        public Criteria andArticleCommentCountIn(List<Integer> values) {
            addCriterion("article_comment_count in", values, "articleCommentCount");
            return (Criteria) this;
        }

        public Criteria andArticleCommentCountNotIn(List<Integer> values) {
            addCriterion("article_comment_count not in", values, "articleCommentCount");
            return (Criteria) this;
        }

        public Criteria andArticleCommentCountBetween(Integer value1, Integer value2) {
            addCriterion("article_comment_count between", value1, value2, "articleCommentCount");
            return (Criteria) this;
        }

        public Criteria andArticleCommentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("article_comment_count not between", value1, value2, "articleCommentCount");
            return (Criteria) this;
        }

        public Criteria andArticleLikeCountIsNull() {
            addCriterion("article_like_count is null");
            return (Criteria) this;
        }

        public Criteria andArticleLikeCountIsNotNull() {
            addCriterion("article_like_count is not null");
            return (Criteria) this;
        }

        public Criteria andArticleLikeCountEqualTo(Integer value) {
            addCriterion("article_like_count =", value, "articleLikeCount");
            return (Criteria) this;
        }

        public Criteria andArticleLikeCountNotEqualTo(Integer value) {
            addCriterion("article_like_count <>", value, "articleLikeCount");
            return (Criteria) this;
        }

        public Criteria andArticleLikeCountGreaterThan(Integer value) {
            addCriterion("article_like_count >", value, "articleLikeCount");
            return (Criteria) this;
        }

        public Criteria andArticleLikeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_like_count >=", value, "articleLikeCount");
            return (Criteria) this;
        }

        public Criteria andArticleLikeCountLessThan(Integer value) {
            addCriterion("article_like_count <", value, "articleLikeCount");
            return (Criteria) this;
        }

        public Criteria andArticleLikeCountLessThanOrEqualTo(Integer value) {
            addCriterion("article_like_count <=", value, "articleLikeCount");
            return (Criteria) this;
        }

        public Criteria andArticleLikeCountIn(List<Integer> values) {
            addCriterion("article_like_count in", values, "articleLikeCount");
            return (Criteria) this;
        }

        public Criteria andArticleLikeCountNotIn(List<Integer> values) {
            addCriterion("article_like_count not in", values, "articleLikeCount");
            return (Criteria) this;
        }

        public Criteria andArticleLikeCountBetween(Integer value1, Integer value2) {
            addCriterion("article_like_count between", value1, value2, "articleLikeCount");
            return (Criteria) this;
        }

        public Criteria andArticleLikeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("article_like_count not between", value1, value2, "articleLikeCount");
            return (Criteria) this;
        }

        public Criteria andArticleIsCommentIsNull() {
            addCriterion("article_is_comment is null");
            return (Criteria) this;
        }

        public Criteria andArticleIsCommentIsNotNull() {
            addCriterion("article_is_comment is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIsCommentEqualTo(Integer value) {
            addCriterion("article_is_comment =", value, "articleIsComment");
            return (Criteria) this;
        }

        public Criteria andArticleIsCommentNotEqualTo(Integer value) {
            addCriterion("article_is_comment <>", value, "articleIsComment");
            return (Criteria) this;
        }

        public Criteria andArticleIsCommentGreaterThan(Integer value) {
            addCriterion("article_is_comment >", value, "articleIsComment");
            return (Criteria) this;
        }

        public Criteria andArticleIsCommentGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_is_comment >=", value, "articleIsComment");
            return (Criteria) this;
        }

        public Criteria andArticleIsCommentLessThan(Integer value) {
            addCriterion("article_is_comment <", value, "articleIsComment");
            return (Criteria) this;
        }

        public Criteria andArticleIsCommentLessThanOrEqualTo(Integer value) {
            addCriterion("article_is_comment <=", value, "articleIsComment");
            return (Criteria) this;
        }

        public Criteria andArticleIsCommentIn(List<Integer> values) {
            addCriterion("article_is_comment in", values, "articleIsComment");
            return (Criteria) this;
        }

        public Criteria andArticleIsCommentNotIn(List<Integer> values) {
            addCriterion("article_is_comment not in", values, "articleIsComment");
            return (Criteria) this;
        }

        public Criteria andArticleIsCommentBetween(Integer value1, Integer value2) {
            addCriterion("article_is_comment between", value1, value2, "articleIsComment");
            return (Criteria) this;
        }

        public Criteria andArticleIsCommentNotBetween(Integer value1, Integer value2) {
            addCriterion("article_is_comment not between", value1, value2, "articleIsComment");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIsNull() {
            addCriterion("article_status is null");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIsNotNull() {
            addCriterion("article_status is not null");
            return (Criteria) this;
        }

        public Criteria andArticleStatusEqualTo(Integer value) {
            addCriterion("article_status =", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotEqualTo(Integer value) {
            addCriterion("article_status <>", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusGreaterThan(Integer value) {
            addCriterion("article_status >", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_status >=", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusLessThan(Integer value) {
            addCriterion("article_status <", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusLessThanOrEqualTo(Integer value) {
            addCriterion("article_status <=", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIn(List<Integer> values) {
            addCriterion("article_status in", values, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotIn(List<Integer> values) {
            addCriterion("article_status not in", values, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusBetween(Integer value1, Integer value2) {
            addCriterion("article_status between", value1, value2, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("article_status not between", value1, value2, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleOrderIsNull() {
            addCriterion("article_order is null");
            return (Criteria) this;
        }

        public Criteria andArticleOrderIsNotNull() {
            addCriterion("article_order is not null");
            return (Criteria) this;
        }

        public Criteria andArticleOrderEqualTo(Integer value) {
            addCriterion("article_order =", value, "articleOrder");
            return (Criteria) this;
        }

        public Criteria andArticleOrderNotEqualTo(Integer value) {
            addCriterion("article_order <>", value, "articleOrder");
            return (Criteria) this;
        }

        public Criteria andArticleOrderGreaterThan(Integer value) {
            addCriterion("article_order >", value, "articleOrder");
            return (Criteria) this;
        }

        public Criteria andArticleOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_order >=", value, "articleOrder");
            return (Criteria) this;
        }

        public Criteria andArticleOrderLessThan(Integer value) {
            addCriterion("article_order <", value, "articleOrder");
            return (Criteria) this;
        }

        public Criteria andArticleOrderLessThanOrEqualTo(Integer value) {
            addCriterion("article_order <=", value, "articleOrder");
            return (Criteria) this;
        }

        public Criteria andArticleOrderIn(List<Integer> values) {
            addCriterion("article_order in", values, "articleOrder");
            return (Criteria) this;
        }

        public Criteria andArticleOrderNotIn(List<Integer> values) {
            addCriterion("article_order not in", values, "articleOrder");
            return (Criteria) this;
        }

        public Criteria andArticleOrderBetween(Integer value1, Integer value2) {
            addCriterion("article_order between", value1, value2, "articleOrder");
            return (Criteria) this;
        }

        public Criteria andArticleOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("article_order not between", value1, value2, "articleOrder");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeIsNull() {
            addCriterion("article_update_time is null");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeIsNotNull() {
            addCriterion("article_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeEqualTo(Date value) {
            addCriterion("article_update_time =", value, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeNotEqualTo(Date value) {
            addCriterion("article_update_time <>", value, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeGreaterThan(Date value) {
            addCriterion("article_update_time >", value, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("article_update_time >=", value, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeLessThan(Date value) {
            addCriterion("article_update_time <", value, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("article_update_time <=", value, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeIn(List<Date> values) {
            addCriterion("article_update_time in", values, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeNotIn(List<Date> values) {
            addCriterion("article_update_time not in", values, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("article_update_time between", value1, value2, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("article_update_time not between", value1, value2, "articleUpdateTime");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeIsNull() {
            addCriterion("article_create_time is null");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeIsNotNull() {
            addCriterion("article_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeEqualTo(Date value) {
            addCriterion("article_create_time =", value, "articleCreateTime");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeNotEqualTo(Date value) {
            addCriterion("article_create_time <>", value, "articleCreateTime");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeGreaterThan(Date value) {
            addCriterion("article_create_time >", value, "articleCreateTime");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("article_create_time >=", value, "articleCreateTime");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeLessThan(Date value) {
            addCriterion("article_create_time <", value, "articleCreateTime");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("article_create_time <=", value, "articleCreateTime");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeIn(List<Date> values) {
            addCriterion("article_create_time in", values, "articleCreateTime");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeNotIn(List<Date> values) {
            addCriterion("article_create_time not in", values, "articleCreateTime");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeBetween(Date value1, Date value2) {
            addCriterion("article_create_time between", value1, value2, "articleCreateTime");
            return (Criteria) this;
        }

        public Criteria andArticleCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("article_create_time not between", value1, value2, "articleCreateTime");
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