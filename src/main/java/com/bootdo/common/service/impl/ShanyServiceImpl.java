package com.bootdo.common.service.impl;

import java.util.Map;

import com.bootdo.common.service.ShanyService;

import org.springframework.stereotype.Service;

@Service
public class ShanyServiceImpl implements ShanyService {


    @Override
    public String getHide(Map < String, Object > map) {
        //判断请求的账号类型：QQ，生日，真实姓名
        String requestType=map.get("type").toString();
        if(requestType.equals("qq"))
            ;
        if(requestType.equals("birth"))
            ;
        if(requestType.equals("idCard"))
            ;
        return null;
    }

    @Override
    public String getInfo(Map<String, Object> map) {
        return null;
    }
}