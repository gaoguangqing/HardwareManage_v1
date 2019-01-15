package com.hd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.hd.pojo.Mainframe;
import com.hd.service.MainframeService;
import com.hd.vo.PageData;

@Controller
public class IndexController {
	@Autowired
	MainframeService mainframeService;

	@RequestMapping("/index")
	public String findAll() {
		return "index";
	}

	@RequestMapping("mainframe/service/page")
	@ResponseBody
	public PageData<Mainframe> findByPage(HttpServletRequest request) {
		String start=request.getParameter("start");
		String length=request.getParameter("length");
		if(StringUtils.isEmpty(length)&&null==length)
		{
			length="10";
		}
		if(StringUtils.isEmpty(start)&&null==start)
		{
			start="1";
		}else{
			start=Integer.parseInt(start)/Integer.parseInt(length)+1+"";
		}
		Pagination page = new Pagination();
		page.setCurrent(Integer.parseInt(start));
		page.setSize(Integer.parseInt(length));
		return  mainframeService.findByPage(page, null);
	}
}
