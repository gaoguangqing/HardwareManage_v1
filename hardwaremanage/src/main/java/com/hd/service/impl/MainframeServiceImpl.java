package com.hd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.hd.mapper.MainframeMapper;
import com.hd.pojo.Mainframe;
import com.hd.service.MainframeService;
import com.hd.vo.PageData;
@Service
public class MainframeServiceImpl implements MainframeService {

	@Autowired
	MainframeMapper mainframeMapper;
	@Override
	public List<Mainframe> findAll() {
		
		return mainframeMapper.selectList(null);
	}
	@Override
	public PageData<Mainframe> findByPage(Pagination page, Mainframe mainframe) {
		int total=mainframeMapper.selectCount(null);
		page.setTotal(total);
		EntityWrapper<Mainframe> wrapper=new EntityWrapper<>();
		wrapper.setEntity(mainframe);
		List<Mainframe> list=mainframeMapper.selectList(page, wrapper);
		PageData<Mainframe> pageData=new PageData<>();
		pageData.setData(list);
		pageData.setiTotalDisplayRecords(total);
		pageData.setiTotalRecords(total);
		return pageData;
	}
	@Override
	public Integer selectCount() {
		
		return mainframeMapper.selectCount(null);
	}
	

}
