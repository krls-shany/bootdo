package com.bootdo.common.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shany")
public class ShanyController extends BaseController{

    public static Logger log=Logger.getLogger(ShanyController.class);
    @RequestMapping("/festival")
    public String getInfo(@RequestParam Map<String, Object> params){
        log.debug("[INFO]:"+(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))+"有访问festival操作");
        return null;
    }

    @RequestMapping("/hide")
    public String getHide(@RequestParam Map<String, Object> params){
        log.debug("[INFO]:"+(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))+"有访问hide操作");
        return null;
    }



}