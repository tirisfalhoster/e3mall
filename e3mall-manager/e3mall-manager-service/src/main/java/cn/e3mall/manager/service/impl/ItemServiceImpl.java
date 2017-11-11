package cn.e3mall.manager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.manager.service.ItemService;
import cn.e3mall.mapper.TbItemDescMapper;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.IDUtils;
import cn.e3mall.utils.PageBeanResult;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	@Override
	public TbItem findItemById(Long itemId) {
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		return item;
	}

	//分页查询商品列表:使用PageHelper插件分页.
	@Override
	public PageBeanResult findItemByPage(Integer page, Integer rows) {
		
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		PageBeanResult result = new PageBeanResult();
		
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		
		return result;
	}

	//保存商品数据.
	@Override
	public E3mallResult saveItem(TbItem item, TbItemDesc itemDesc) {
		long itemId = IDUtils.genItemId();
		item.setId(itemId);
		item.setStatus((byte)1);	//1-正常,2-下架, 3-删除,我们这是一个B2C商城,商品实际上是不需要审核的.都是我们自己上架的.
		Date date = new Date();
		item.setCreated(date);
		item.setUpdated(date);
		
		itemMapper.insert(item);	//保存商品对象.
		
		itemDesc.setItemId(itemId);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		
		itemDescMapper.insert(itemDesc);	//保存商品描述对象.
		
		return E3mallResult.ok();	//会自动调用那个E3mallResult的构造函数,构造函数中有定义值.
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
