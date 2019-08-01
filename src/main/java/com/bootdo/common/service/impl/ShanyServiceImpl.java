package com.bootdo.common.service.impl;

import java.util.Map;

import com.bootdo.common.service.ShanyService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ShanyServiceImpl implements ShanyService {

    public static final Logger log=Logger.getLogger(ShanyServiceImpl.class);
    @Override
    public String getHide(Map < String, Object > map) {
        //判断请求的账号类型：QQ，生日，真实姓名
        String requestType=map.get("type").toString();
        log.debug("[INFO]:requestType="+requestType);
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