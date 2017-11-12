package cn.e3mall.content.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.content.service.ContentService;
import cn.e3mall.mapper.TbContentMapper;
import cn.e3mall.pojo.TbContent;
import cn.e3mall.pojo.TbContentExample;
import cn.e3mall.pojo.TbContentExample.Criteria;
import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.PageBeanResult;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	
	//根据id查找对应的Content记录.
	@Override
	public PageBeanResult findContentByCategoryId(Long categoryId, Integer page, Integer rows) {
		TbContentExample example = new TbContentExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andCategoryIdEqualTo(categoryId);
		
		//查询之前设置分页.
		PageHelper.startPage(page, rows);
		
		//执行分页查询.
		List<TbContent> list = contentMapper.selectByExample(example);
		PageInfo<TbContent> pageInfo = new PageInfo<TbContent>(list);
		
		PageBeanResult result = new PageBeanResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		
		return result;
	}

	//对新增的某个内容进行保存.
	@Override
	public E3mallResult saveContent(TbContent content) {
		Date date = new Date();
		content.setUpdated(date);
		content.setCreated(date);
		
		contentMapper.insert(content);
		
		return E3mallResult.ok();
	}
	
}
