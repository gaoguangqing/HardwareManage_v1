package com.hd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.hd.pojo.Mainframe;
import com.hd.vo.PageData;


public interface MainframeService {

	List<Mainframe> findAll();
	PageData<Mainframe> findByPage(@Param("page")Pagination page,Mainframe mainframe);
	Integer selectCount();
}
