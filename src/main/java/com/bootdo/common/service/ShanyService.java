package com.bootdo.common.service;

import java.util.Map;

public interface ShanyService{

    /**
     * 获得普通信息
     * @param map
     * @return
     */
    String getInfo(Map<String, Object> map);

    /**
     * 获得隐藏信息
     * @param map
     * @return
     */
    String getHide(Map<String, Object> map);

    /**
     * kg测试
     * @param map
     * @return
     * @author shany
     */
    String kgTest(Map<String, Object> map);

}