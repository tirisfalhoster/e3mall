package cn.e3mall.manager.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.e3mall.utils.FastDFSClient;
import cn.e3mall.utils.PicResult;

/**
 * 图片上传的Controller.
 * 
 * /**
	 * 需求:上传图片
	 * 请求:/pic/upload
	 * 参数:uploadFile
	 * 返回值:
	 * //成功时
		{
        "error" : 0,
        "url" : "http://www.example.com/path/to/file.ext",
        "message":null
		}
		//失败时
		{
        "error" : 1,
        "url":null,
        "message" : "错误信息"
		}
 * @author Tirisfaler
 *2017年11月10日23:12:50
 */
@Controller
public class UploadController {

	//注入图片服务器地址常量信息.常量信息定义在resource.properties中.
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
	//地址是根据页面KindEditor的KingEditorParam配置来规定的.可不是乱写的.
	@RequestMapping("/pic/upload")
	@ResponseBody
	public PicResult uploadPic(MultipartFile uploadFile) {
		
		//
		
		try {
			//生成后缀名.
			String originalFilename = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);	//从文件名中"."后面一位开始截取.一直到末尾.
			
			FastDFSClient fs = new FastDFSClient("classpath:client.conf");	//FastDFSClient是工具类中提前制定好的.
			String url = fs.uploadFile(uploadFile.getBytes(), extName);	//extName表示后缀名.
			
			//回显需要url.拼接url,绝对路径.
			url = IMAGE_SERVER_URL + url;
			
			//封装数据.使用PicResult封装数据.
			PicResult result = new PicResult();
			result.setError(0);             //在try中成功执行, 表示上传图片成功.error为0.
			result.setUrl(url);
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			
			//如果上传失败.
			PicResult result = new PicResult();
			result.setError(1);
			result.setMessage("上传失败");
			return result;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
