package cn.e3mall.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.content.service.ContentCategoryService;
import cn.e3mall.mapper.TbContentCategoryMapper;
import cn.e3mall.pojo.TbContentCategory;
import cn.e3mall.pojo.TbContentCategoryExample;
import cn.e3mall.pojo.TbContentCategoryExample.Criteria;
import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.EasyUITreeNode;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService{
	
	@Autowired
	private TbContentCategoryMapper categoryMapper;

	//根据父id查询树形子节点.
	@Override
	public List<EasyUITreeNode> findContentCategoryByParentId(Long parentId) {
		
		List<EasyUITreeNode> treeNodeList = new ArrayList<EasyUITreeNode>();
		
		//创建内容分类表example对象.
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andParentIdEqualTo(parentId);
		
		List<TbContentCategory> list = categoryMapper.selectByExample(example);
		
		//遍历,把内容分类数据封装到树形节点集合中.
		for (TbContentCategory tbContentCategory : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbContentCategory.getId());
			node.setState(tbContentCategory.getIsParent()?"closed" : "open");
			node.setText(tbContentCategory.getName());
			
			treeNodeList.add(node);
		}
		return treeNodeList;
	}

	//新建树形分类节点.
	/**
	 * 业务:
	 * 	1. 如果新建节点的父节点是子节点,那么更新父节点状态.
	 * 	2. 如果新建节点的父节点是父节点,那么不需要其他操作直接添加即可.
	 */
	@Override
	public E3mallResult createNode(Long parentId, String name) {
		
		Date date = new Date();
		
		//新建内容分类节点,用来封装新节点的数据.
		TbContentCategory category = new TbContentCategory();
		category.setParentId(parentId);
		category.setName(name);
		category.setStatus(1);
		category.setSortOrder(1);		//排列序号.表示同级目录的展现次序,如数值相等则按照次序排序.
		category.setIsParent(false);    //我们新建的节点必定不是父节点,因为在页面上是无法创建父节点的,只有依附于某个节点创建它的子节点.
		category.setCreated(date);
		category.setUpdated(date);
		
		categoryMapper.insert(category);	//保存节点.
		
		//如果有必要,我们还需要更新当前创建的节点的父节点的isParent属性.
		TbContentCategory contentCategory = categoryMapper.selectByPrimaryKey(parentId);	//根据parentId找到该parentId对应的节点对象.
		if(!contentCategory.getIsParent()) {	//如果该contentCategory不是父节点.进入此if语句块.如果是父节点,我们就不需要更新它的isParent属性而来.
			contentCategory.setIsParent(true);
			categoryMapper.updateByPrimaryKey(contentCategory);	//更新该contentCategory.
		}
		return E3mallResult.ok(category);	//返回新建的节点.
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
