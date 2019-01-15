## 硬件管理系统-ssm-mybatis-plus-adminLte-datatable实现查询

![效果图](/indexshow.png)

先出配置讲起,因为小编使用了baomidou的mybatisplus，所以有一些mybatis的配置不需要在pom.xml里面写(mybatisplus已经进行了管理)，多写会报错

使用mybatisplus下面的配置必须写
```
		<dependency>
			<groupId>com.baomidou</groupId>
			<artifactId>mybatis-plus</artifactId>
			<version>2.1.9</version>
		</dependency>
    <dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context-support</artifactId>
			<version>4.3.9.RELEASE</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
```
下面是完整的pom.xml
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.hardware</groupId>
	<artifactId>hardwaremanage</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.tomcat.maven</groupId>
				<artifactId>tomcat7-maven-plugin</artifactId>
				<version>2.2</version>
				<configuration>
					<port>8105</port>
					<path>/</path>
				</configuration>
			</plugin>
		</plugins>
	</build>
	<dependencies>
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-log4j12</artifactId>
			<version>1.6.4</version>
		</dependency>
		<!-- MP 核心库 -->
		<dependency>
			<groupId>com.baomidou</groupId>
			<artifactId>mybatis-plus</artifactId>
			<version>2.1.9</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>4.3.9.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context-support</artifactId>
			<version>4.3.9.RELEASE</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
			<version>1.2</version>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.40</version>
		</dependency>
		<dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>druid</artifactId>
			<version>1.0.29</version>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.8.5</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>4.3.9.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
		</dependency>
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>servlet-api</artifactId>
			<version>2.5</version>
			<scope>provided</scope>
		</dependency>
	</dependencies>
</project>
```
Mapper方面要继承BaseMapper<T>,要分页的话最好重写selectList
```
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
```
为了适应adminLte(bootstrap)的datatable插件，小编准备了如下工具类，
其中T为泛型
```
package com.hd.vo;

import java.io.Serializable;
import java.util.List;

public class PageData<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<T> data;
	private long iTotalDisplayRecords; //过滤后记录数
	private long iTotalRecords; //返回总记录数
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public long getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(long iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
	public long getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(long iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
}
```
最关键的是这块ajax
```"serverSide" : true```表示服务器控制分页，这里要打开，这样后端才能收到```start```(当前页)和```length```(页大小)两个分页参数
```
		<script type="text/javascript">
			$(function() {

				var dataTable = $('#dataTable').DataTable({
					"ajax" : {
						"url" : "mainframe/service/page",
						"type" : "get",
						"dataType" : "json"
					},
					"serverSide" : true,
					"destroy" : true,//消除重定义出错
					"bPaginate" : true,//是否使用分页
					"bFilter" : false, //是否使用搜索
					"bLengthChange" : true, //支持变更页面显示数据行数
					"bPaginate" : true, //显示翻页按钮
					"oLanguage" : { // 语言设置
						"sLengthMenu" : "每页显示 _MENU_ 条记录",
						"sZeroRecords" : "抱歉， 没有找到",
						"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
						"sInfoEmpty" : "没有数据",
						"sInfoFiltered" : "(从 _MAX_ 条数据中检索)",
						"sZeroRecords" : "没有检索到数据",
						"sSearch" : "检索:",
						"oPaginate" : {
							"sFirst" : "首页",
							"sPrevious" : "前一页",
							"sNext" : "后一页",
							"sLast" : "尾页"
						}
					},
					"columns" : [ {
						data : 'brand'
					}, {
						data : 'name'
					}, {
						data : 'price'
					}, {
						data : 'amount'
					} ]
				});
			});
		</script>
    ```
    注意起始页与页大小的运算，如果不是第一页,那么进行如下计算
    ```
    if(StringUtils.isEmpty(start)&&null==start)
		{
			start="1";
		}else{
			start=Integer.parseInt(start)/Integer.parseInt(length)+1+"";
		}
    ```
    这个是完整的Controller代码
    ```
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
 ```
 业务实现类，注意把记录总数```int total=mainframeMapper.selectCount(null);```封装给Pagination分页对象
 ```
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

```
