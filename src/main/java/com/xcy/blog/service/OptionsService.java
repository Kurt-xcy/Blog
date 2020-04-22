package com.xcy.blog.service;

import com.xcy.blog.pojo.Options;

public interface OptionsService {
    /**
     * 查询选项
     * @return
     */
    public Options getOptions();

    /**
     * 新增选项
     * @param option
     * @return
     */
    public Integer insertOptions(Options option);

    /**
     * 更新选项
     * @param option
     * @return
     */
    public Integer updateOptions(Options option);
}
