package cn.e3mall.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	/**
	 * 实现页面的跳转:
	 * 	首页:localhost:8083/index
	 * 	商品添加:localhost:8083/item-add
	 * 	商品列表:localhost:8083/item-list
	 */
	@RequestMapping("{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	
	
}
