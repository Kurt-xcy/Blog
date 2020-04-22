package com.xcy.blog.service.impl;

import com.xcy.blog.mapper.OptionsMapper;
import com.xcy.blog.pojo.Options;
import com.xcy.blog.pojo.OptionsExample;
import com.xcy.blog.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionsServiceImpl implements OptionsService {
    @Autowired
    private OptionsMapper optionsMapper;
    @Override
    public Options getOptions() {
        List<Options> optionsList = optionsMapper.selectByExample(new OptionsExample());
        if (optionsList.size()>0){
            return optionsList.get(0);
        }
        return null;
    }

    @Override
    public Integer insertOptions(Options option) {
        return optionsMapper.insert(option);
    }

    @Override
    public Integer updateOptions(Options option) {
        return optionsMapper.updateByPrimaryKey(option);
    }
}
