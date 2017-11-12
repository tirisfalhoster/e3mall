package cn.e3mall.content.service;

import cn.e3mall.pojo.TbContent;
import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.PageBeanResult;

public interface ContentService {

	//当点击某个category的时候,查询这个category对应的所有的记录:根据分类id查询内容数据.
	public PageBeanResult findContentByCategoryId(Long categoryId, Integer page, Integer rows);
	
	//在某个category中添加广告信息:保存内容数据.
	public E3mallResult saveContent(TbContent content);
}
