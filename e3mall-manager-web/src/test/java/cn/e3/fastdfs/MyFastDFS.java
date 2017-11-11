package cn.e3.fastdfs;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.e3mall.utils.FastDFSClient;

/**
 * 使用fastDFS client测试文件的上传.
 * @author Tirisfaler
 *2017年11月10日16:21:22
 */
public class MyFastDFS {

	//未使用工具类,全手写.
	@Test
	public void uploadPicWithFastDFSClient() throws FileNotFoundException, IOException, MyException {
		
		//指定客户端配置文件的地址.
		String conf = "E:\\DataSource\\WorkSpace\\GitRepository\\e3mall\\e3mall_version02\\e3mall-manager-web\\src\\main\\resources\\client.conf";
		String pic = "E:\\DataSource\\Picture\\ChMkJlbKz3GIH3h-AAM-CL1eSEAAALJVQF86E0AAz4g666.jpg";
		
		ClientGlobal.init(conf);      //加载客户端配置文件,连接远程fastDFS图片服务器.
		
		//创建跟踪调度服务器tracker客户端对象.
		TrackerClient tClient = new TrackerClient();
		TrackerServer trackerServer = tClient.getConnection();
		
		StorageServer storageServer = null;
		StorageClient sClient = new StorageClient(trackerServer, storageServer);
		
		String[] urls = sClient.upload_file(pic, "jpg", null);
		for (String url : urls) {
			System.out.println(url);
		}
		
	}
	
	//封装的工具类在commons工程中:使用该封装的工具类来上传图片.
	@Test
	public void uploadPicWithFastClient() throws Exception {
		
		//指定客户端配置文件的地址.
		String conf = "E:\\DataSource\\WorkSpace\\GitRepository\\e3mall\\e3mall_version02\\e3mall-manager-web\\src\\main\\resources\\client.conf";
		String pic = "E:\\DataSource\\Picture\\ChMkJ1XWlAuIdbEgAC-DVZ9IN4kAAAXeQFk4XcAL4Nt822.jpg";
		
		FastDFSClient fs = new FastDFSClient(conf);
		String url = fs.uploadFile(pic);		//使用工具类中的方法直接上传图片.
		System.out.println(url);
		
		
		
		
	}
	
	
	
	
	
}
