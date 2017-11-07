package cn.e3mall.manager.service;

import cn.e3mall.pojo.TbItem;
import cn.e3mall.utils.PageBeanResult;

public interface ItemService {
	
	public TbItem findItemById(Long itemId);
	
	/**
	 * 分页查询商品列表.
	 */
	public PageBeanResult findItemByPage(Integer page, Integer rows);
}
