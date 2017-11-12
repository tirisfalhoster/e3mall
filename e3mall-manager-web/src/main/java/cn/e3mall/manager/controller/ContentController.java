package cn.e3mall.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.content.service.ContentService;
import cn.e3mall.pojo.TbContent;
import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.PageBeanResult;

@Controller
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	//根据category的id查询到content的list集合.并分页显示.
	@RequestMapping("/content/query/list")
	@ResponseBody
	public PageBeanResult findContentByCategoryId(Long categoryId,
													@RequestParam(defaultValue="1") Integer page,
													@RequestParam(defaultValue="10") Integer rows) {
		PageBeanResult result = contentService.findContentByCategoryId(categoryId, page, rows);
		return result;
	}
	
	//保存添加的内容数据.
	@RequestMapping("/content/save")
	@ResponseBody
	public E3mallResult saveContent(TbContent content) {
		E3mallResult result = contentService.saveContent(content);
		return result;
	}
	
}
