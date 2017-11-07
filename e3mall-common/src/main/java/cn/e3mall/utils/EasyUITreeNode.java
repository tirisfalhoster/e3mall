package cn.e3mall.utils;

import java.io.Serializable;

public class EasyUITreeNode implements Serializable{
	
	private Long id;	//树形节点id.
	private String text;	//树形节点名称.
	
	/**
	 * 树形节点状态,如果有子节点,那么state=closed,表示当前是关闭状态,可进行展开操作.
	 * 			    如果此节点没有子节点,state=open,表示当已经是打开状态.
	 */
	private String state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
