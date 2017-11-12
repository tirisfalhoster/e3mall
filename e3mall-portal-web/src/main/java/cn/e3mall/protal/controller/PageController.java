package cn.e3mall.protal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	//跳转到门户系统首页.
	@RequestMapping("/index")
	public String showIndex() {
		return "index";
	}
}
