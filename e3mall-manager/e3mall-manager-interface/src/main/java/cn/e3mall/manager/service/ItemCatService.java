package cn.e3mall.manager.service;

import java.util.List;

import cn.e3mall.utils.EasyUITreeNode;

public interface ItemCatService {
	
	/**
	 * 根据父id查询子节点,按需加载.
	 * @param parentId
	 * @return
	 */
	public List<EasyUITreeNode> findItemCatWithParentId(Long parentId);
}
