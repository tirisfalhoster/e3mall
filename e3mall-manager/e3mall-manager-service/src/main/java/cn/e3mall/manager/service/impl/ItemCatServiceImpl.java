package cn.e3mall.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.manager.service.ItemCatService;
import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.pojo.TbItemCatExample.Criteria;
import cn.e3mall.utils.EasyUITreeNode;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	
	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	/**
	 * 根据父id查询子节点,按需加载.
	 * 记得发布服务.
	 */
	@Override
	public List<EasyUITreeNode> findItemCatWithParentId(Long parentId) {
		
		List<EasyUITreeNode> treeNodeList = new ArrayList<EasyUITreeNode>();
		
		//创建example对象.
		TbItemCatExample example = new TbItemCatExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andParentIdEqualTo(parentId);
		
		//执行查询:
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		for (TbItemCat tbItemCat : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			
			//将tbItemCat中的内容封装到EasyUITreeNode对象中.
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()?"closed" : "open");
			
			treeNodeList.add(node);
		}
		return treeNodeList;	//最后return treeNodeList.
		
		
	}

}
