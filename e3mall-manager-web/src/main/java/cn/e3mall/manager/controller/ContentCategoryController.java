package cn.e3mall.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.content.service.ContentCategoryService;
import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.EasyUITreeNode;

@Controller
public class ContentCategoryController {

	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<EasyUITreeNode> findContentCategoryByParentId(@RequestParam(value="id", defaultValue="0") Long parentId){
		List<EasyUITreeNode> list = contentCategoryService.findContentCategoryByParentId(parentId);
		return list;
	}
	
	//新建树形分类节点.
	@RequestMapping("/content/category/create")
	@ResponseBody
	public E3mallResult createNode(Long parentId, String name) {
		E3mallResult result = contentCategoryService.createNode(parentId, name);
		return result;
	}
}
