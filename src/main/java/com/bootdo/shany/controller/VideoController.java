/**
 * @author shany
 * @date 2019年1月4日 上午10:08:39 
 * @version V1.0  
 */
package com.bootdo.shany.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.shany.domain.VideoDO;
import com.bootdo.shany.service.VideoService;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/shany/video")
@Controller
@RequiresPermissions("shany")
public class VideoController {
	
	@Autowired
	private VideoService service;
	
	
	//默认索引
	@GetMapping()
	String video(){
		return "/index";
	}
	
	@ResponseBody
	@GetMapping(params={"/list","/index"})
	public PageUtils list(@RequestParam Map<String, Object> params) {
//		Query query = new Query(params);
		List<VideoDO>list=service.list();
		return  new PageUtils(list,list.size());
	}

	@PostMapping("/remove")
	public void remove (Long id, HttpServletRequest request){

	}

	@PostMapping("/save")
	public void save(HttpServletRequest request ,VideoDO video){

	}


}
