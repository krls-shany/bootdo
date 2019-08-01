package com.bootdo.common.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.bootdo.common.service.ShanyService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shany")
public class ShanyController extends BaseController{

    @Autowired
    ShanyService service;

    public static Logger log=Logger.getLogger(ShanyController.class);
    @RequestMapping("/festival")
    public String getInfo(@RequestParam Map<String, Object> params){
        log.debug("[INFO]:"+(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))+"有访问festival操作");
        return "shany/default";
    }

    @RequestMapping("/hide")
    public String getHide(@RequestParam Map<String, Object> params){
        log.debug("[INFO]:"+(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))+"有访问hide操作");
        return "shany/hide";
    }

    @GetMapping()
	String init() {
		return "shany/index";
	}
    


}