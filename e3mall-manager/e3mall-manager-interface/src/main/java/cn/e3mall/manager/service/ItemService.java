package cn.e3mall.manager.service;

import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.PageBeanResult;

public interface ItemService {
	
	/**
	 * 根据id查询商品数据.
	 * @param itemId
	 * @return
	 */
	public TbItem findItemById(Long itemId);
	
	/**
	 * 分页查询商品列表.
	 */
	public PageBeanResult findItemByPage(Integer page, Integer rows);
	
	/**
	 * 保存商品数据.
	 * 参数TbItem item, TbItemDesc itemDesc
	 */
	public E3mallResult saveItem(TbItem item, TbItemDesc itemDesc);
}
