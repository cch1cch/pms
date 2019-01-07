package com.zs.pms.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@RequestMapping("/commupload.do")
	/**
	 * ajax返回
	 * 如果返回字符串则返回字符串
	 * 如果返回对象或对象的集合则返回json串
	 * 要求导入json包
	 * @return
	 */
	@ResponseBody
	public String commonUploadFile(MultipartFile file,HttpServletRequest req) {
		//解决重名问题 利用算法
		//生成前缀
		String prefix=UUID.randomUUID().toString();
		//生成的目标文件名
		String dfilename=prefix+file.getOriginalFilename();
		//获得物理路径
		String path=req.getRealPath("/upload");
		//创建目标文件
		//File.separator  : 文件分隔符 \  可用//代替 
		File dfile=new File(path+File.separator+dfilename);
		//将源文件拷贝到目标文件
		try {
			file.transferTo(dfile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//不返回页面，应为是异步 ajax
		//返回目标文件名
		return dfilename;
	}
}
