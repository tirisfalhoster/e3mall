package cn.e3mall.utils;

/**
 * 封装图片上传之后的返回值.
 * @author Tirisfaler
 *2017年11月10日23:07:59
 */
public class PicResult {
	
	/**
	 * //成功时
		{
		        "error" : 0,
		        "url" : "http://www.example.com/path/to/file.ext"
		}
		//失败时
		{
		        "error" : 1,
		        "message" : "错误信息"
		}
		既然成功时和失败时返回的json都不全相同,那么为了统一,我们规定每个返回值都有3个字段,
		字段有值就写值,没有值就不用写了.
	 */
	private int error;
	private String url;
	private String message;
	
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
