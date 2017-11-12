package cn.e3mall.content.service;

import java.util.List;

import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.EasyUITreeNode;

/**
 * 内容目录.
 * @author Tirisfaler
 *2017年11月11日23:18:01
 */
public interface ContentCategoryService {
	
	/**
	 * 根据父id查询树形子节点.
	 */
	public List<EasyUITreeNode> findContentCategoryByParentId(Long parentId);
	
	//新建树形分类节点.
	public E3mallResult createNode(Long parentId, String name);
	
}
