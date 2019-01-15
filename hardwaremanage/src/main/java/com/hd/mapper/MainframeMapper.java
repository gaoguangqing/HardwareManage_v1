package com.hd.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.hd.pojo.Mainframe;

public interface MainframeMapper extends BaseMapper<Mainframe>{
	List<Mainframe> selectList(@Param("page")Pagination page,@Param("ew")Wrapper<Mainframe> wrapper);
}