package com.shop.biz;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class FileUploadMgr {
	public String saveFolder = "D:/kim3/jsp1/web03/src/main/webapp/upload";
	public String encType = "utf-8";
	public int maxSize = 10 * 1024 * 1024;
	
	public boolean fileUpload(HttpServletRequest req) {
		boolean flag = false;
		
		try{
			MultipartRequest multi = 
					new MultipartRequest(req, saveFolder,maxSize,encType,
							new DefaultFileRenamePolicy());
			flag = true;
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("~~~~~~~~~~~~~~~~~~~~");
		}
		return flag;
	} 
	
	public String[] fileList() {
		File dir = new File(saveFolder);
		String[] lists = dir.list();
		return lists;
	}
}
