package cn.e3mall.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.manager.service.ItemCatService;
import cn.e3mall.utils.EasyUITreeNode;

@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	/**
	 * 根据父id查询子节点,按需加载.
	 * 既然是按需加载,也就是我们一开始不是按照我们之前使用zTree那样全部加载.
	 * 我们设置默认值,加载哪些没有父节点的节点,也就是顶节点.
	 */
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<EasyUITreeNode> findItemCatWithParentId(@RequestParam(value="id", defaultValue="0") Long parentId){
		
		//调用服务provider提供的方法.
		List<EasyUITreeNode> list = itemCatService.findItemCatWithParentId(parentId);
		return list;
	}
}
