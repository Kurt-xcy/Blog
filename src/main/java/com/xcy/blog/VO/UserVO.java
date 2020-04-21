package com.xcy.blog.VO;

import com.xcy.blog.pojo.User;

import java.util.Date;

public class UserVO extends User {
    private Integer userId;

    private String userName;

    private String userPass;

    private String userNickname;

    private String userEmail;

    private String userUrl;

    private String userAvatar;

    private String userLastLoginIp;

    private Date userRegisterTime;

    private Date userLastLoginTime;

    private Integer userStatus;

    /**
     * 文章数量（不是数据库字段）
     */
    private Integer articleCount;

    public UserVO(User user) {
        super();
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.userPass = user.getUserPass();
        this.userNickname = user.getUserNickname();
        this.userEmail = user.getUserEmail();
        this.userUrl = user.getUserUrl();
        this.userAvatar = user.getUserAvatar();
        this.userLastLoginIp = user.getUserLastLoginIp();
        this.userRegisterTime = user.getUserRegisterTime();
        this.userLastLoginTime = user.getUserLastLoginTime();
        this.userStatus = user.getUserStatus();
    }

    @Override
    public Integer getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getUserPass() {
        return userPass;
    }

    @Override
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public String getUserNickname() {
        return userNickname;
    }

    @Override
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    @Override
    public String getUserEmail() {
        return userEmail;
    }

    @Override
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String getUserUrl() {
        return userUrl;
    }

    @Override
    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    @Override
    public String getUserAvatar() {
        return userAvatar;
    }

    @Override
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    @Override
    public String getUserLastLoginIp() {
        return userLastLoginIp;
    }

    @Override
    public void setUserLastLoginIp(String userLastLoginIp) {
        this.userLastLoginIp = userLastLoginIp;
    }

    @Override
    public Date getUserRegisterTime() {
        return userRegisterTime;
    }

    @Override
    public void setUserRegisterTime(Date userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    @Override
    public Date getUserLastLoginTime() {
        return userLastLoginTime;
    }

    @Override
    public void setUserLastLoginTime(Date userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

    @Override
    public Integer getUserStatus() {
        return userStatus;
    }

    @Override
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }
}
