package com.xcy.blog.VO;

/**
 * 返回页面结果类
 */
public class Result {
    private Integer code;
    private String msg;
    /**
     * 返回结果正确
     */
    public static  Integer RESULT_OK = 0;

    /**
     * 返回结果错误
     */
    public static  Integer RESULT_WRONG = 1;
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
