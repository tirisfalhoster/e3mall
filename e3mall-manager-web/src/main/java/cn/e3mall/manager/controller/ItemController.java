package cn.e3mall.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.manager.service.ItemService;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.utils.PageBeanResult;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("item/findItem/{itemId}")
	@ResponseBody
	public TbItem findItemById(@PathVariable Long itemId) {
		TbItem item = itemService.findItemById(itemId);
		return item;
	}
	
	//分页查询商品列表.
	@RequestMapping("/item/list")
	@ResponseBody
	public PageBeanResult itemList(@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="20") Integer rows) {
		PageBeanResult result = itemService.findItemByPage(page, rows);
		return result;
	}
	
	
}
